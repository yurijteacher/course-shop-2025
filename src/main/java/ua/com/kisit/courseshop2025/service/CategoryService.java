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

    public Categories saveNewCategory(Categories category) {
        return categoryRepository.save(category);
    }

    public Categories updateCategory(Categories category) {
        return categoryRepository.save(category);
    }

    public Categories findCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public List<Categories> findAllCategories() {
        return categoryRepository.findAll();
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    public void deleteAllCategories() {
        categoryRepository.deleteAll();
    }

    public Categories findCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

}
