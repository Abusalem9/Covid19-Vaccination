package com.covid.vaccination.Entity;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@ToString
@Entity
public class User {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer mobile;
    private Date Dob;
    private String Gender;
}
