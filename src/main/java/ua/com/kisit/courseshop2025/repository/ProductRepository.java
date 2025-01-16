package ua.com.kisit.courseshop2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.courseshop2025.entity.Categories;
import ua.com.kisit.courseshop2025.entity.Products;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Long> {

    List<Products> findByCategories(Categories category);


}
