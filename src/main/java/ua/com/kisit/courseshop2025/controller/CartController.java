package ua.com.kisit.courseshop2025.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.courseshop2025.bl.Cart;
import ua.com.kisit.courseshop2025.entity.Products;

@Controller
public class CartController {

    @GetMapping("/cart")
    public String cart(
            Model model,
            HttpServletRequest request) {

        HttpSession session = request.getSession();

        // setAttribute("name", obj);
        // getAtrribute("name")

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        model.addAttribute("cart", cart.getCart());
        model.addAttribute("totalValue", cart.getTotalValue());
        model.addAttribute("el", cart.getSumElInCart());

        return "cart";
    }


    @PostMapping("/addToCart")
    public String addNewItemToCart(@RequestParam(name = "id") Products product, @RequestParam(name = "quantity") int quantity,
                                   HttpServletRequest request
    ) {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) cart = new Cart();
        cart.addNewItemToCart(product, quantity);
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


    @PostMapping("/updateItemInCart")
    public String updateItemToCart(@RequestParam(name = "id") Products product, @RequestParam(name = "quantity") int quantity,
                                   HttpServletRequest request
    ) {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) cart = new Cart();

        cart.updateItemInCart(product, quantity);
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


    @PostMapping("/deleteItemFromCart")
    public String deleteItemToCart(@RequestParam(name = "id") Products product,
                                   HttpServletRequest request
    ) {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) cart = new Cart();
        cart.deleteItemFromCart(product);
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


    @PostMapping("deleteAllItems")
    public String deleteAllItems(HttpServletRequest request) {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) cart = new Cart();
        cart.deleteAllItemFromCart();

        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

}