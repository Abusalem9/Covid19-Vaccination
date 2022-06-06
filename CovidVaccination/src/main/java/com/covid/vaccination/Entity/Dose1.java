package com.covid.vaccination.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Dose1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer countId;
    private Integer user_id;
    private Boolean dose;
    @OneToOne(mappedBy = "dose1")
    @JsonBackReference
    private DoctorDoseGeneration doctorDoseGeneration;
}
