package com.covid.vaccination.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class CurrentDoctorSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer id;

    private String uuid;

    private LocalDateTime localDateTime;

    public CurrentDoctorSession(Integer id, String uuid, LocalDateTime localDateTime) {
        this.id = id;
        this.uuid = uuid;
        this.localDateTime = localDateTime;
    }


}
