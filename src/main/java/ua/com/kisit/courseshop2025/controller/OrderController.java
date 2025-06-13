package ua.com.kisit.courseshop2025.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.aspectj.weaver.ast.Or;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.com.kisit.courseshop2025.bl.Cart;
import ua.com.kisit.courseshop2025.bl.ItemCart;
import ua.com.kisit.courseshop2025.entity.*;
import ua.com.kisit.courseshop2025.repository.UserRepository;
import ua.com.kisit.courseshop2025.service.ClientsService;
import ua.com.kisit.courseshop2025.service.OrderService;
import ua.com.kisit.courseshop2025.service.ProductHasOrderService;

import java.util.Date;

@Controller
public class OrderController {

    private final ClientsService clientsService;
    private final ProductHasOrderService productHasOrderService;
    private final OrderService orderService;
    private final UserRepository userRepository;

    public OrderController(ClientsService clientsService, ProductHasOrderService productHasOrderService, OrderService orderService, UserRepository userRepository) {
        this.clientsService = clientsService;
        this.productHasOrderService = productHasOrderService;
        this.orderService = orderService;
        this.userRepository = userRepository;
    }

    @GetMapping("/order")
    public String getOrder(Model model,
                           HttpServletRequest request
                           ) {


        HttpSession session = request.getSession();
//        Object user = session.getAttribute("user");

        SecurityContext context = SecurityContextHolder.getContext();
        Users user = (Users) context.getAuthentication().getPrincipal();


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


         Users user1 = userRepository.findByUsername(user.getUsername());

        model.addAttribute("client", clientsService.findById(user1.getId()));

        return "order";
    }


    @PostMapping("/buy")
    public String getPageBuy(
            @RequestParam(name = "delivery") Delivery delivery,
            @RequestParam(name = "payment") Payment payment,
            HttpServletRequest request,
            RedirectAttributes redirectAttributes
    ){

        HttpSession session = request.getSession();

//        Object user = session.getAttribute("user");

        SecurityContext context = SecurityContextHolder.getContext();
        Users user = (Users) context.getAuthentication().getPrincipal();

        if (user == null) {
            return "redirect:/login";
        }

        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            return "redirect:/";
        }
        Users user1 = userRepository.findByUsername(user.getUsername());
        Clients client = clientsService.findById(user1.getId());

        Orders order = new Orders();
        order.setDelivery(delivery);
        order.setPayment(payment);
        order.setClient(client);
        order.setStatusOrder("необроблене замовлення");
        order.setDateCreated(new Date());

        Orders orderId = orderService.save(order);


        for (ItemCart el : cart.getCart()){
            productHasOrderService.saveNewProductHasOrder(orderId, el.getProduct(), el.getQuantity());
        }

        redirectAttributes.addAttribute("total", cart.getTotalValue());

        cart.deleteAllItemFromCart();
        cart.setSumElInCart(0);
        cart.setTotalValue(0);
        session.setAttribute("cart", cart);

        redirectAttributes.addAttribute("orderId", orderId.getId());


        return "redirect:/thank";
    }


    @GetMapping("/thank")
    public String getPageThank( @RequestParam(name = "orderId", defaultValue = "") Long orderId,
                                @RequestParam(name = "total", defaultValue = "") Double total,
                                Model model ){

        model.addAttribute("orderId", orderId);
        model.addAttribute("total", total);

        return "thank";
    }




}
