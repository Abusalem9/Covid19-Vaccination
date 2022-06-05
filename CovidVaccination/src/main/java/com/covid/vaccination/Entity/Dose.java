package com.covid.vaccination.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Data
public class Dose {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long doseRefId;
    private Integer user_id;
    private boolean dose1;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer doseFirstId;
    @Value("${my.date}")
    private LocalDateTime dose1Date=LocalDateTime.now();
    private boolean dose2;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer doseSecondId;
    @Value("${my.date}")
    private LocalDateTime dose2Date=LocalDateTime.now();

}
