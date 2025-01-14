package ua.com.kisit.courseshop2025.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "products")
public class Products {

    /*
    byte
    short
    int
    long
    double
    float
    char
    boolean
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;

    @OneToMany(mappedBy = "product")
    private List<ProductsHasOrder> productsHasOrderList;

}