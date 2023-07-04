package com.kolabank.FarmZone.Controllers;

import com.kolabank.FarmZone.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/home")
    public String getHome(Authentication authentication){

        System.out.println(authentication.getPrincipal());
        return "home";
    }


}
