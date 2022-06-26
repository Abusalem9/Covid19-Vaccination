package com.covid.vaccination.Entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer doctorId;
    private String firstName;
    private String lastName;
    @Column(unique = true,columnDefinition = "integer default 0")
    private String mobile;
    private String password;
    private String gender;
    @Email(message = "Please Enter Correct Email Id.")
    private String email;
}
