package com.kolabank.FarmZone.Controllers;

import com.kolabank.FarmZone.Model.Crop;
import com.kolabank.FarmZone.Service.Crop.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CropController {

    @Autowired
    CropService cropService;

    @GetMapping("/crops")
    public String showAllCrops (Model model){
        model.addAttribute("crops", cropService.cropList());
        return "crops";
    }


    @GetMapping("/newcrop")
    public String newCropForm(Crop crop, Model model){
        return "newcrop";
    }

    @PostMapping("/newcrop")
    public String addNewCrop (@ModelAttribute ("crop") Crop crop, Model model){
        cropService.addCrop(crop);
        return "redirect:/crops";
    }
}
