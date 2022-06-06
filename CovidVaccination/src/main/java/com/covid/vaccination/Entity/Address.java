package com.covid.vaccination.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
@Entity
@Data
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer address_id;
    @NonNull
    private String city;
    @NonNull
    private String state;
    @NonNull
    private String pinCode;

   @OneToOne(mappedBy = "address")
   @JsonBackReference
    private User user;

    public Address() {

    }
}
