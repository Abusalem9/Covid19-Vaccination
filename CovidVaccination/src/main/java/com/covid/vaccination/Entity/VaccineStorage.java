package com.covid.vaccination.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class VaccineStorage {
//    private Center c;

    @Id
    private Long id;
    private Integer availableStock;
    private Integer centerID;

}
