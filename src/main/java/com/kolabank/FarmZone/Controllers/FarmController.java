package com.kolabank.FarmZone.Controllers;

import com.kolabank.FarmZone.Model.Crop;
import com.kolabank.FarmZone.Model.Farm;
import com.kolabank.FarmZone.Model.PlantDetails;
import com.kolabank.FarmZone.Model.User;
import com.kolabank.FarmZone.Service.Crop.CropService;
import com.kolabank.FarmZone.Service.Farm.FarmService;
import com.kolabank.FarmZone.Service.Farm.PlantDetailsService;
import com.kolabank.FarmZone.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FarmController {

    @Autowired
    FarmService farmService;

    @Autowired
    UserService userService;



   @GetMapping("/farms")
   public String showFarms(Authentication authentication, Model model, Farm farm){
       String username=authentication.getName();
       User farmUser=userService.findByUsername(username);
       List<Farm> farms = farmService.getFarmsByUser(farmUser);
       model.addAttribute("farms", farms);
       model.addAttribute("authenticated", authentication.isAuthenticated());

       return "farms";
   }


    @GetMapping("/newfarm")
public String newFarm (Farm farm, Model model){
//        model.addAttribute("farm", new Farm());
        System.out.println("Got into new farm get route");
        return "newfarm";
    }

    @PostMapping("/newfarm")

    public String postNewFarm(@ModelAttribute ("farm") Farm farm, Authentication authentication){

        User farmOwner = userService.findByUsername(authentication.getName());
          System.out.println("User is " + authentication.getName() +" with id " + farmOwner.getId());
        farm.setFarmOwner(farmOwner);
        farmService.addFarm(farm);
        return "redirect:farms";

    }

    @GetMapping("/deleteFarm/{farm_id}")
public String deleteFarm(@PathVariable("farm_id") Long farm_id, Model model, Authentication authentication){
        farmService.deleteFarm(farm_id);
        return "redirect:/farms";
    }



}
