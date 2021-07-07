package com.example.countryservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CountryDTO {
    private String countryId;
    @Min(2)
    @NotEmpty(message = "please provide code")
    private String code;
    @NotEmpty(message = "please provide name")
    private String name;
}
