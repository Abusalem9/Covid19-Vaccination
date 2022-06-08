package com.covid.vaccination.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class DoctorDoseGeneration {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer doseGenerationId;
    private Integer doctorId;
    private Integer user_id;
    private String d_password;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Dose1 dose1;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Dose2 dose2;
}
