package ua.com.kisit.courseshop2025.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.courseshop2025.entity.Categories;
import ua.com.kisit.courseshop2025.entity.Products;
import ua.com.kisit.courseshop2025.service.CategoryService;
import ua.com.kisit.courseshop2025.service.ProductService;

import java.math.BigDecimal;

@Controller
public class ProductManagerController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductManagerController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }


    @GetMapping("/products")
    public String productsPage(Model model) {

        model.addAttribute("products", productService.findAll());
        model.addAttribute("categories", categoryService.getAllCategories());

        return "products";
    }

    @PostMapping("/saveNewProducts")
    public String saveNewProducts(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "image") String image,
            @RequestParam(name = "price") double price,
            @RequestParam(name = "category")Categories categories
    ){

        Products product = new Products();
        product.setName(name);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(new BigDecimal(price));
        product.setCategories(categories);

        productService.save(product);

        return "redirect:/products";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(
            @RequestParam(name = "id1") Products product,
            @RequestParam(name = "name1") String name,
            @RequestParam(name = "description1") String description,
            @RequestParam(name = "image1") String image,
            @RequestParam(name = "price1") double price,
            @RequestParam(name = "categories") Categories category
    ){


        product.setName(name);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(new BigDecimal(price));
        product.setCategories(category);

        productService.save(product);

        return "redirect:/products";
    }


    @PostMapping("/deleteProduct")
    public String deleteProduct(
            @RequestParam(name = "id2") Products product
    ) {

        productService.delete(product);

        return "redirect:/products";
    }


}