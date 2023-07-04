package com.kolabank.FarmZone.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Date;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlantDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Farm farm;

    @OneToOne
    private Crop crop;

    private String breed;

    private String plantingDate;
    private String harvestDate;

    private Integer stands;

    private Integer area;


}
