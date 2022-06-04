package com.covid.vaccination.Entity;

import lombok.Data;

import javax.persistence.*;
@Entity
@Data
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "address_id")
    private Integer address_id;
    private String city;
    private String state;
    private String pinCode;

    @OneToOne
    @MapsId
    @JoinColumn(name = "address_id")
    private User user;
}
