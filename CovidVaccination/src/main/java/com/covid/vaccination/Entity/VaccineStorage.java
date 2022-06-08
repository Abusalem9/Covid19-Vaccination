package com.covid.vaccination.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@ToString
@Entity
@Data
public class VaccineStorage {
    @Id
    @JsonIgnore
    private Integer id;
    private Integer availableStock;
    private Integer centerID;

}
