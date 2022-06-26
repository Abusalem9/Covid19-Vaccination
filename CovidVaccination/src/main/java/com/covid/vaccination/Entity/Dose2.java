package com.covid.vaccination.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dose2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer countId;
    @Column(unique = true,columnDefinition = "integer default 0")
    private Integer user_id;
    @JsonIgnore
    private LocalDateTime date= LocalDateTime.now();
    private Integer doctor_id;
    @OneToOne(mappedBy = "dose2")
    @JsonBackReference
    private DoctorDoseGeneration doctorDoseGeneration;
}
