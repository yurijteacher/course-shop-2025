package ua.com.kisit.courseshop2025.service;

import org.springframework.stereotype.Service;
import ua.com.kisit.courseshop2025.entity.Categories;
import ua.com.kisit.courseshop2025.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Categories> findAllCategories() {
        return categoryRepository.findAll();
    }

    public void saveCategory(Categories category) {
        categoryRepository.save(category);
    }

    public Categories getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public List<Categories> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }


    public void deleteCategories() {
        categoryRepository.deleteAll();
    }


}
