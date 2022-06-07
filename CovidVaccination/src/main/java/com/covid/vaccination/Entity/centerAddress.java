package com.covid.vaccination.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class centerAddress {
    @Id
    @JsonIgnore
    private Integer centerID;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer address_id;
    private String city;
    private String state;
    private String pinCode;
}
