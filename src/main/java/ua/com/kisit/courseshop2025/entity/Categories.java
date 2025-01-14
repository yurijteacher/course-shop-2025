package ua.com.kisit.courseshop2025.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String images;

    @OneToMany(mappedBy = "categories")
    private List<Products> products;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Brands> brands;
}
