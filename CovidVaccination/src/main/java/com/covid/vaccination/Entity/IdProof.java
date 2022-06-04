package com.covid.vaccination.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class IdProof {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer refId;
    private String aadharNo;
   @OneToOne(mappedBy = "idProof")
   @JsonBackReference
    private User user;


}
