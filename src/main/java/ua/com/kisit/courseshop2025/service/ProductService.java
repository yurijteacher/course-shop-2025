package ua.com.kisit.courseshop2025.service;

import org.springframework.stereotype.Service;
import ua.com.kisit.courseshop2025.entity.Categories;
import ua.com.kisit.courseshop2025.entity.Products;
import ua.com.kisit.courseshop2025.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Products> getListProductsByCategory(Categories category){
        return productRepository.findByCategories(category);
    }

}
