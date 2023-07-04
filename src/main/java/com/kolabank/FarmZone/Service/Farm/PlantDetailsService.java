package com.kolabank.FarmZone.Service.Farm;

import com.kolabank.FarmZone.Model.Farm;
import com.kolabank.FarmZone.Model.PlantDetails;
import com.kolabank.FarmZone.Repository.PlantingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantDetailsService {
    @Autowired
    PlantingRepository plantingRepository;

    public List<PlantDetails> getPlantDetailsByFarm(Farm farm){
        return plantingRepository.findByFarm(farm);
    }

    public PlantDetails addPlanting(PlantDetails plantDetails) {
        return plantingRepository.save(plantDetails);
    }
}
