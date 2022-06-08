package com.covid.vaccination.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
public class Appointment {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer appointId;
    @Enumerated(EnumType.STRING)
    private Slot s;
    @JsonIgnore
    private LocalDateTime appointmentDate=LocalDateTime.now();
    @Column(unique = true,columnDefinition = "integer default 0")
    private Integer user_id;
    private String password;
    private Integer center_id;
}
