package com.example.countryservice.ui;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestModel {

    @Size(min = 2,max = 3)
    @NotEmpty(message = "please provide code")
    private String code;
    @NotEmpty(message = "please provide name")
    private String name;
}
