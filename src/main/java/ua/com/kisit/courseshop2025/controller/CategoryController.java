package ua.com.kisit.courseshop2025.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.com.kisit.courseshop2025.entity.Categories;
import ua.com.kisit.courseshop2025.service.CategoryService;
import ua.com.kisit.courseshop2025.service.ProductService;

@Controller
public class CategoryController {

    private final CategoryService categoryService;
    private final ProductService productService;



    public CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/category/{id}")
    public String category(@PathVariable(name = "id") Categories category, Model model) {

        model.addAttribute("category", category.getName());
        model.addAttribute("products", productService.getListProductsByCategory(category));

        return "category";
    }



}
