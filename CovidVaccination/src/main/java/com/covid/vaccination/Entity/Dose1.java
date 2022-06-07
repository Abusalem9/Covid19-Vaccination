package com.covid.vaccination.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dose1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer countId;
    @Column(unique = true,columnDefinition = "integer default 0")
    private Integer user_id;
    private LocalDateTime date= LocalDateTime.now();
    private Integer doctor_id;
    @OneToOne(mappedBy = "dose1")
    @JsonBackReference
    private DoctorDoseGeneration doctorDoseGeneration;
}
