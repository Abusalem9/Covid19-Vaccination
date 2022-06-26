package com.covid.vaccination.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@ToString
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer user_id;
    private String firstName;
    private String lastName;
    private String mobile;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date dob;
    private String password;
    private Gender gender;
    private String aadharNo;
    private String pinCode;
    private String city;
}
