package com.covid.vaccination.Entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Dose {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long doseRefId;
    private Integer user_id;
    private boolean dose1;

    //    User -> Details-> Dose-> Doctor Approval -> Approved -> Doctor DB save ;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer doseFirstId;
    @Value("${my.date}")
    private LocalDateTime dose1Date = LocalDateTime.now();
    private boolean dose2;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer doseSecondId;
    @Value("${my.date}")
    private LocalDateTime dose2Date = LocalDateTime.now();

}
