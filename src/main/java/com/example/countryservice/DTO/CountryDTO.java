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
   private String flagUrl;

    private String code;

    private String name;
}
