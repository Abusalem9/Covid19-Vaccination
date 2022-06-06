package com.covid.vaccination.DTO;

import com.covid.vaccination.Entity.Center;
import lombok.Data;

@Data
public class DoctorDTO {

    private String mobile;
    private Center centerId;
    private String password;

}
