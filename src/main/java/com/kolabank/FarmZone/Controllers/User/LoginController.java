package com.kolabank.FarmZone.Controllers.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

@GetMapping("/login")
    public String login(){
    System.out.println("Got into the login route");
        return "login";
    }


}
