package com.covid.vaccination.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class CurrentUserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer id;

    private String uuid;

    private LocalDateTime localDateTime;

    public CurrentUserSession(Integer id, String uuid, LocalDateTime localDateTime) {
        super();
        this.id = id;
        this.uuid = uuid;
        this.localDateTime = localDateTime;
    }
}
