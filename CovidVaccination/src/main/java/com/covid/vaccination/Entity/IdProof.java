package com.covid.vaccination.Entity;

import javax.persistence.*;

@Entity
@Table(name = "idproof")
public class IdProof {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer refId;
    private String aadharNo;
    @OneToOne(mappedBy = "refIdOfProof")
    private User user;
}
