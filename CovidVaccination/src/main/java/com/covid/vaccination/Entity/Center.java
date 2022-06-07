package com.covid.vaccination.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@Entity
public class Center {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer centerID;
    private Integer user_Id;
    private String pinCode;
    @Enumerated(EnumType.STRING)
    private Slot slot;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private centerAddress centerAddress;
//
//    @OneToOne(mappedBy = "center")
//    @JsonBackReference
//    private User user;
}
