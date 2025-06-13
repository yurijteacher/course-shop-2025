package ua.com.kisit.courseshop2025.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.courseshop2025.entity.Categories;
import ua.com.kisit.courseshop2025.service.CategoryService;

@Controller
public class ManagerCategoryController {

    private final CategoryService categoryService;

    public ManagerCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/saveNewCategory")
    public String saveNewCategory(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "image") String image

    ) {

        Categories category = new Categories();
        category.setName(name);
        category.setDescription(description);
        category.setImages(image);

        categoryService.saveCategory(category);

        return "redirect:/categories";
    }

    @GetMapping("/categories")
    public String getPageCategories(Model model) {

        model.addAttribute("categories", categoryService.getAllCategories());

        return "categories";
    }


    @PostMapping("/updateCategory")
    public String updateCategory(
            @RequestParam(name = "id") Categories category,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "image") String image

    ) {

        category.setName(name);
        category.setDescription(description);
        category.setImages(image);

        categoryService.saveCategory(category);

        return "redirect:/categories";
    }



    @PostMapping("/deleteCategory")
    public String deleteCategory(
            @RequestParam(name = "id") Categories category
    ) {
        categoryService.deleteCategoryById(category.getId());
        return "redirect:/categories";
    }



}
