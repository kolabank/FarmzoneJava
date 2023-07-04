package com.kolabank.FarmZone.Repository;

import com.kolabank.FarmZone.Model.Farm;
import com.kolabank.FarmZone.Model.PlantDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantingRepository extends JpaRepository<PlantDetails, Long> {


    List<PlantDetails> findByFarm(Farm farm);
}
