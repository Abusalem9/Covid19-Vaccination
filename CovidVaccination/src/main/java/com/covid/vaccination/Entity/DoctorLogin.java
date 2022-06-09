package com.covid.vaccination.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@Entity
public class DoctorLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer loginRef;
    private String mobile;
    private String password;
}
