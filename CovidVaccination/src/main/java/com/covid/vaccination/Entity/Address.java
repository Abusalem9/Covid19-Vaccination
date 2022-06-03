package com.covid.vaccination.Entity;

import lombok.Data;

import javax.persistence.*;
@Entity
@Data
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private String city;
    private String state;
    private String pinCode;

    @OneToOne(mappedBy = "address")
    private User user;
}
