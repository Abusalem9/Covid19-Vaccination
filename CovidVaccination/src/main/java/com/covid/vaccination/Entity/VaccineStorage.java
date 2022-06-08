package com.covid.vaccination.Entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@ToString
@Entity
@Data
public class VaccineStorage {
//    private Center c;

    @Id
    private Integer id;
    private Integer availableStock;
    private Integer centerID;

}
