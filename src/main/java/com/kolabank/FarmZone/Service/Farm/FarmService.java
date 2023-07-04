package com.kolabank.FarmZone.Service.Farm;

import com.kolabank.FarmZone.Model.Farm;
import com.kolabank.FarmZone.Model.User;
import com.kolabank.FarmZone.Repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmService {
    @Autowired
    FarmRepository farmRepository;

    public Farm getFarmByName(String farmName){
     return farmRepository.findFarmByName(farmName).get();

    }

    public Farm getFarmById(Long id){
        return farmRepository.findById(id).get();
    }

    public Farm addFarm (Farm farm){
       return farmRepository.save(farm);
    }

    public List<Farm> getFarmsByUser(User user){
        return farmRepository.findByFarmOwner(user);
    }

    public void deleteFarm(Long farmId) {
        farmRepository.deleteById(farmId);
    }
}
