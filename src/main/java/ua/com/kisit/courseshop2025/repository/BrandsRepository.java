package ua.com.kisit.courseshop2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.courseshop2025.entity.Brands;

import java.util.List;

public interface BrandsRepository extends JpaRepository<Brands, Long> {

    // select * from `brand` where name='sad'
    Brands findByName(String name);

}
