package com.covid.vaccination.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicUserDetails {

    private Integer id;
    private String firstName;
    private String lastName;
    private String mobileNo;
    private Date Dob;
    private String Gender;
}
