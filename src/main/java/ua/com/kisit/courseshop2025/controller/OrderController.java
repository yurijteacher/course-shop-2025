package ua.com.kisit.courseshop2025.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.com.kisit.courseshop2025.bl.Cart;
import ua.com.kisit.courseshop2025.bl.ItemCart;
import ua.com.kisit.courseshop2025.entity.Clients;
import ua.com.kisit.courseshop2025.entity.Delivery;
import ua.com.kisit.courseshop2025.entity.Orders;
import ua.com.kisit.courseshop2025.entity.Payment;
import ua.com.kisit.courseshop2025.service.ClientsService;
import ua.com.kisit.courseshop2025.service.OrderService;
import ua.com.kisit.courseshop2025.service.ProductHasOrderService;

import java.util.Date;

@Controller
public class OrderController {

    private final ClientsService clientsService;
    private final ProductHasOrderService productHasOrderService;
    private final OrderService orderService;

    public OrderController(ClientsService clientsService, ProductHasOrderService productHasOrderService, OrderService orderService) {
        this.clientsService = clientsService;
        this.productHasOrderService = productHasOrderService;
        this.orderService = orderService;
    }

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


    @PostMapping("/buy")
    public String getPageBuy(
            @RequestParam(name = "delivery") Delivery delivery,
            @RequestParam(name = "payment") Payment payment,
            HttpServletRequest request,
            RedirectAttributes redirectAttributes
    ){

        HttpSession session = request.getSession();

        Object user = session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            return "redirect:/";
        }

        Clients client = clientsService.findById((Long) user);

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
