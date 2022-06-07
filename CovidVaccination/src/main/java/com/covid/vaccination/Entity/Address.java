package com.covid.vaccination.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer address_id;
    @NotNull
    private Integer user_id;
    @NonNull
    private String city;
    @NonNull
    private String state;
    @NonNull
    private String pinCode;

    public Address() {

    }
}
