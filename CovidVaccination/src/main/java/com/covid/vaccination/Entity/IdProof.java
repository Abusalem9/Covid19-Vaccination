package com.covid.vaccination.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "idproof")
public class IdProof {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Integer refId;
    private String aadharNo;
    @OneToOne(mappedBy = "refIdOfProof")
    private User user;


}
