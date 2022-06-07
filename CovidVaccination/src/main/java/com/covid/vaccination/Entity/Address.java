package com.covid.vaccination.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer address_id;
    @NotNull
    @Column(unique = true,columnDefinition = "integer default 0")
    private Integer user_id;
    @NonNull
    private String city;
    @NonNull
    private String state;
    @NonNull
    private String pinCode;
}
