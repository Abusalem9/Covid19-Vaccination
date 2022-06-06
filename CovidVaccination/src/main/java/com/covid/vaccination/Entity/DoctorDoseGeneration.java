package com.covid.vaccination.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DoctorDoseGeneration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer doseGenerationId;

    private Integer doctorId;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Dose1 dose1;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Dose2 dose2;
}
