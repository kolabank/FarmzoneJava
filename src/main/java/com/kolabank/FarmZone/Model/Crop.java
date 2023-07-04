package com.kolabank.FarmZone.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionIdJdbcTypeCode;

import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Crop {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cropname;


    private String breed;


}
