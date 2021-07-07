package com.example.countryservice.service;

import com.example.countryservice.DTO.CountryDTO;
import com.example.countryservice.ui.RequestModel;

import java.util.List;

public interface CountryService {
     CountryDTO createCountry(RequestModel requestModel);
     CountryDTO findByCountryId(String id);
     List<CountryDTO>findAllCountries();
}
