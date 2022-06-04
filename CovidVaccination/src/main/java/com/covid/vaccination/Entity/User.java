package com.covid.vaccination.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@ToString
@Entity
@Table(name = "users")
@JsonIgnoreProperties
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private Integer age;
    @NotBlank
    @Size(min=10,max=10,message = "{mobile.invalid}")
    private String mobile;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @NotBlank
    private Date dob;
    @NotBlank
    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,12}$",message = "{password.invalid}")
    private String password;
    @NotBlank
    @Email(message = "{email.invalid}")
    private String email;
    @NotBlank
    private String gender;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private IdProof idProof;
}
