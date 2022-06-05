package com.covid.vaccination.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer user_id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String mobile;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dob;
    private String password;
    private String gender;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    private IdProof idProof;

}
