package com.kolabank.FarmZone.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    long id;

    @ManyToOne
    @JoinColumn(name="owner_id")
    User farmOwner;


    private String name;

    private String location;
    private String description;

    private float longitude;
    private float latitude;

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlantDetails> plantDetails = new ArrayList<>();

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Expense> expenses = new ArrayList<>();

}
