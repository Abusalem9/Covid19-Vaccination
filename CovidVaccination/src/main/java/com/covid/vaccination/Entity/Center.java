package com.covid.vaccination.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Center {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer centerID;
    private String centerName;
    private Integer count;
    @Enumerated(EnumType.STRING)
    private Slot slot;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private centerAddress centerAddress;

    @OneToOne(mappedBy = "center")
    @JsonBackReference
    private User user;
}
