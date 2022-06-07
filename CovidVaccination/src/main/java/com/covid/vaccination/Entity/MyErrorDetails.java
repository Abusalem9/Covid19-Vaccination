package com.covid.vaccination.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MyErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;

}
