package com.kolabank.FarmZone.Repository;

import com.kolabank.FarmZone.Model.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<Crop, Long> {

    public Crop findByCropname(String cropname);

}
