package com.kolabank.FarmZone.Controllers;

import com.kolabank.FarmZone.Model.Crop;
import com.kolabank.FarmZone.Model.Farm;
import com.kolabank.FarmZone.Model.PlantDetails;
import com.kolabank.FarmZone.Service.Crop.CropService;
import com.kolabank.FarmZone.Service.Farm.FarmService;
import com.kolabank.FarmZone.Service.Farm.PlantDetailsService;
import com.kolabank.FarmZone.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.List;
import java.util.Date;

@Controller
public class FarmDetailsController {


    @Autowired
    FarmService farmService;


    @Autowired
    PlantDetailsService plantDetailsService;

    @Autowired
    CropService cropService;

    Long farmId;

    @GetMapping("/farmDetails/{farm_id}")
    public String farmDetails(@PathVariable("farm_id") Long farm_id, Model model, PlantDetails plantDetails, Crop crop, Authentication authentication){
        farmId = farm_id;
        Farm farm = farmService.getFarmById(farm_id);
        model.addAttribute("farm", farm);
        List<PlantDetails> plantDetailsList = plantDetailsService.getPlantDetailsByFarm(farm);
        model.addAttribute("plants", plantDetailsList);
        model.addAttribute("crops", cropService.cropList());
        model.addAttribute("authenticated", authentication.isAuthenticated());

        return "farmdetails";
    }

    @PostMapping("/addPlanting")

        public String addPlanting(@ModelAttribute PlantDetails plantDetails, Model model, RedirectAttributes redirectAttributes){
        plantDetails.setFarm(farmService.getFarmById(farmId));
        plantDetailsService.addPlanting(plantDetails);
        return "redirect:" + UriComponentsBuilder.fromPath("/farmDetails/{farmId}").buildAndExpand(farmId).toUriString();
    }

}
