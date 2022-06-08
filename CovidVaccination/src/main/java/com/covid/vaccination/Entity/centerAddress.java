package com.covid.vaccination.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class centerAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer centerID;
    private String city;
    private String state;
    private String pinCode;
}
