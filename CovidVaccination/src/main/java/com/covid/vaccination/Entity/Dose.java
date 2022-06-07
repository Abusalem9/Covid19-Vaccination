package com.covid.vaccination.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Dose {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer countId;
    @Column(unique = true,columnDefinition = "integer default 0")
    private Integer user_id;

}
