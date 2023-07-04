package com.kolabank.FarmZone.Repository;

import com.kolabank.FarmZone.Model.Expense;
import com.kolabank.FarmZone.Model.Farm;
import com.kolabank.FarmZone.Model.PlantDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByFarm(Farm farm);

}
