package com.covid.vaccination.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "idproof")
public class IdProof {
    @Id
    private Integer refId;
    private String aadharNo;
    @OneToOne
    @MapsId
    @JoinColumn(name = "refid")
    private User user;


}
