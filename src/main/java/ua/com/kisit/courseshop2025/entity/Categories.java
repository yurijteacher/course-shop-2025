package ua.com.kisit.courseshop2025.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "categories")
    private List<Products> products;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Brands> brands;

//    public Categories() {
//    }
//
//    public Categories(Long id, String name, String description, String images, List<Products> products, List<Brands> brands) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.images = images;
//        this.products = products;
//        this.brands = brands;
//    }
//
//    public List<Brands> getBrands() {
//        return brands;
//    }
//
//    public void setBrands(List<Brands> brands) {
//        this.brands = brands;
//    }
//
//    public List<Products> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Products> products) {
//        this.products = products;
//    }
//
//    public String getImages() {
//        return images;
//    }
//
//    public void setImages(String images) {
//        this.images = images;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
}
