package com.covid.vaccination.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Data
public class Dose {
    @Id
    private Long doseRefId;
    private boolean dose1;
    private Date dose1Date;
    private boolean dose2;
    private Date dose2Date;
}
