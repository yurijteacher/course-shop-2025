package ua.com.kisit.courseshop2025.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.com.kisit.courseshop2025.bl.Cart;
import ua.com.kisit.courseshop2025.entity.Clients;
import ua.com.kisit.courseshop2025.entity.Users;
import ua.com.kisit.courseshop2025.service.ClientsService;
import ua.com.kisit.courseshop2025.service.UserService;

@Controller
public class UserController {

    private final UserService userService;
    private final ClientsService clientsService;

    public UserController(UserService userService, ClientsService clientsService) {
        this.userService = userService;
        this.clientsService = clientsService;
    }


    @GetMapping("/login")
    public String getPageLogin() {
        return "login";
    }

    @GetMapping("/registration")
    public String getPageRegistration(Model model,
                                      @RequestParam(name = "err", defaultValue = " ") String error
                                      ) {
        model.addAttribute("users", new Users());
        model.addAttribute("clients", new Clients());
        model.addAttribute("error", error);

        return "registration";
    }


    @PostMapping("/registration")
    public String registration(@Valid Users users,
                               BindingResult bindingResult1,
                               @Valid Clients clients,
                               BindingResult bindingResult2,
                               RedirectAttributes redirectAttributes
                               ) {

        if (bindingResult1.hasErrors()) {
            redirectAttributes.addAttribute("err","");
            return "registration";
        }

        if (bindingResult2.hasErrors()) {
            redirectAttributes.addAttribute("err","");
            return "registration";
        }

        if(userService.getUserByUsername(users.getUsername())){
            redirectAttributes.addAttribute("err", "Користувач існує у системі!!");
            return "/registration";
        }

        Users user = userService.saveNewUserToDB(users);

        clients.setUser(user);
        clientsService.saveNewClients(clients);

        return "redirect:/login";
    }


    @PostMapping("/login")
    public String authUserInShop(@RequestParam(name = "username") String username,
                                 @RequestParam(name = "password") String password,
                                 HttpServletRequest request
                                 ){
        if(!userService.getUserByUsernameAndPassword(username, password)){
            return "redirect:/registration";
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", userService.findByUsername(username).getId());

        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if(cart != null){ return "redirect:/order"; }

        return "redirect:/";
    }
}