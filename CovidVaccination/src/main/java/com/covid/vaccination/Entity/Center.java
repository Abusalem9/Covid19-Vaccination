package com.covid.vaccination.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@Entity
public class Center {

    @Id
    private Integer centerID;
    private Integer user_Id;
    private String pinCode;
    @Enumerated(EnumType.STRING)
    private Slot slot;

}
