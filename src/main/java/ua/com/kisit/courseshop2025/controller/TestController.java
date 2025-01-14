package ua.com.kisit.courseshop2025.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {


    @GetMapping("/")
    public String TestController(Model model) {
        model.addAttribute("message", "Hello World!");
        return "hello";
    }


}
