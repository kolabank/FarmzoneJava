package com.kolabank.FarmZone.Controllers.User;

import com.kolabank.FarmZone.Model.User;
import com.kolabank.FarmZone.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegisterController {

    @Autowired
    UserService userService;


    @GetMapping("/register")
    public String registerRoute(Model model){
        model.addAttribute("user", new User());
       System.out.println("I got into the register route");
        return "register";
    }

    @PostMapping("/register")
        public String registerUser( @ModelAttribute ("user") User user){
            System.out.println("Got in into post");
            userService.addUser(user);
            return "redirect:/login";
        }

    }

