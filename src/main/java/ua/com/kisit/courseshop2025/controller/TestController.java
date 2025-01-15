package ua.com.kisit.courseshop2025.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.kisit.courseshop2025.service.CategoryService;

@Controller
public class TestController {

    private final CategoryService categoryService;

    public TestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/")
    public String TestController(Model model) {

        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("message", "Hello World!");

        return "hello";
    }

}
