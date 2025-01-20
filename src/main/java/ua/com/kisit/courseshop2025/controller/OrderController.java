package ua.com.kisit.courseshop2025.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.kisit.courseshop2025.bl.Cart;
import ua.com.kisit.courseshop2025.service.ClientsService;
import ua.com.kisit.courseshop2025.service.OrderService;

@Controller
public class OrderController {

    private final ClientsService clientsService;

    public OrderController(ClientsService clientsService, OrderService orderService) {
        this.clientsService = clientsService;
        this.orderService = orderService;
    }

    private final OrderService orderService;

    @GetMapping("/order")
    public String getOrder(Model model,
                           HttpServletRequest request
                           ) {


        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            return "redirect:/";
        }

        model.addAttribute("cart", cart.getCart());
        model.addAttribute("totalValue", cart.getTotalValue());
        model.addAttribute("el", cart.getSumElInCart());
        model.addAttribute("client", clientsService.findById((Long) user));

        return "order";
    }





}
