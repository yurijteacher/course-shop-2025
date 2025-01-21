package ua.com.kisit.courseshop2025.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.courseshop2025.bl.Cart;
import ua.com.kisit.courseshop2025.entity.Products;

import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

@Controller
public class CartCookieController {

    private static final String COOKIE_NAME = "cart";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/cart1")
    public String getPageCart(Model model, HttpServletRequest request) {

        Cart cart = getCartFromCookies(request);
        if (cart == null) {
            cart = new Cart();
        }
        model.addAttribute("cart", cart.getCart());
        model.addAttribute("totalValue", cart.getTotalValue());
        model.addAttribute("el", cart.getSumElInCart());

        return "cart";
    }

    @PostMapping("/addToCart1")
    public String addItemToCart(
            @RequestParam(name = "id") Products product,
            @RequestParam(name = "quantity") int quantity,
            HttpServletRequest request,
            HttpServletResponse response) {

        Cart cart = getCartFromCookies(request);
        if (cart == null) {
            cart = new Cart();
        }
        cart.addNewItemToCart(product, quantity);
        saveCartToCookies(cart, response);

        return "redirect:/cart1";
    }

    private Cart getCartFromCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (cookies == null) { return null; }

        Optional<Cookie> cartCookie = Arrays.stream(cookies)
                .filter(cookie -> COOKIE_NAME.equals(cookie.getName()))
                .findFirst();

        if (cartCookie.isPresent()) {
            try {
                String encodedCartJson = cartCookie.get().getValue();

                String cartJson = new String(Base64
                        .getDecoder()
                        .decode(encodedCartJson)); // розшифрувати у рядок

                return objectMapper.readValue(cartJson, Cart.class); // перетворити рядок у Cart
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void saveCartToCookies(Cart cart, HttpServletResponse response) {
        try {

            // перетворює об'єкт cart у JSON-ряд
            String cartJson = objectMapper.writeValueAsString(cart);

            String encodedCartJson = Base64 // дозволяє уникнути проблем із недопустимими символами
                    .getEncoder()
                    .encodeToString(cartJson.getBytes()); // кодувати

            Cookie cookie = new Cookie(COOKIE_NAME, encodedCartJson); // і'мя  та закодоване значення

            cookie.setPath("/"); //  cookie доступне для всього сайту.
            cookie.setHttpOnly(true); // робить cookie недоступним для JavaScript (захист від XSS-атак)
            cookie.setMaxAge(7 * 24 * 60 * 60); // час життя cookie - 7 днів

            response.addCookie(cookie); // додавання cookie у відповідь
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}