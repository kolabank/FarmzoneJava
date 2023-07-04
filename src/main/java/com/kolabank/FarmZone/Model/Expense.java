package com.kolabank.FarmZone.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Farm farm;
    private String date;
    private double amount;
    private String purpose;

    private String type;

    private ExpenseType expenseType;

    public enum ExpenseType {
        SEEDS, FERTILIZER, PESTICIDES, LABOUR, OTHERS
    }



}
