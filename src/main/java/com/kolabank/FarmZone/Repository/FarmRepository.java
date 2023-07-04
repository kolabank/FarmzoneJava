package com.kolabank.FarmZone.Repository;

import com.kolabank.FarmZone.Model.Farm;
import com.kolabank.FarmZone.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {
    Optional<Farm> findFarmByName(String farmName);

    List<Farm> findByFarmOwner(User user);




}
