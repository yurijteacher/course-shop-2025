package ua.com.kisit.courseshop2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.courseshop2025.entity.Categories;

public interface CategoryRepository extends JpaRepository<Categories, Long> {

    Categories findByName(String name);

}
