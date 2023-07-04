package com.kolabank.FarmZone.Service.Crop;

import com.kolabank.FarmZone.Model.Crop;
import com.kolabank.FarmZone.Repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropService
{

    @Autowired
    CropRepository cropRepository;

    public List<Crop> cropList(){
        return cropRepository.findAll();
    }

    public Crop addCrop (Crop crop){
        return cropRepository.save(crop);
    }

    public Crop getByCropname(String cropname) {
        return cropRepository.findByCropname(cropname);
    }
}
