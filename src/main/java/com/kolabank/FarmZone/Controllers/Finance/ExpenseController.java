package com.kolabank.FarmZone.Controllers.Finance;

import com.kolabank.FarmZone.Model.Expense;
import com.kolabank.FarmZone.Model.Farm;
import com.kolabank.FarmZone.Model.PlantDetails;
import com.kolabank.FarmZone.Service.Farm.FarmService;
import com.kolabank.FarmZone.Service.Finance.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class ExpenseController {

    @Autowired
    FarmService farmService;
    @Autowired
    ExpenseService expenseService;

    Long farmId;

    @GetMapping("/expense/{farm_id}")
    public String finance(Model model, @PathVariable("farm_id") Long farm_id, Expense expense){
       farmId = farm_id;
        Farm farm = farmService.getFarmById(farmId);
        List<Expense> expenseList = expenseService.getExpenseByFarm(farm);
        model.addAttribute("expenses", expenseList);
        return "finance/expense";
    }

    @PostMapping("/addExpense")
    public String addExpense(Expense expense){
        expense.setFarm(farmService.getFarmById(farmId));
        expenseService.addExpense(expense);
        return "redirect:/expense/" + expense.getFarm().getId();
    }


}
