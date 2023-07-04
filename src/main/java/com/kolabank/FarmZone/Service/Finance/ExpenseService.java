package com.kolabank.FarmZone.Service.Finance;

import com.kolabank.FarmZone.Model.Expense;
import com.kolabank.FarmZone.Model.Farm;
import com.kolabank.FarmZone.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    public Expense addExpense(Expense expense){
    return expenseRepository.save(expense);
    }

    public double ExpenseSum(){
        List<Expense> allExpense = expenseRepository.findAll();

        double sum = allExpense.stream().mapToDouble(x->x.getAmount()).sum();
        return sum;
    }

    public List<Expense> getExpenseByFarm(Farm farm){
        return expenseRepository.findByFarm(farm);
    }

}
