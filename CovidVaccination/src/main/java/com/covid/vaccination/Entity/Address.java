package com.covid.vaccination.Entity;

import javax.persistence.*;
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @OneToOne(mappedBy = "address")
    private User user;
}
