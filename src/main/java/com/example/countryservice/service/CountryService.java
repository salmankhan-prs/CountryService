package com.example.countryservice.service;

import com.example.countryservice.DTO.CountryDTO;
import com.example.countryservice.exception.CountryNotFoundException;
import com.example.countryservice.ui.RequestModel;

import java.util.List;

public interface CountryService {
     CountryDTO createCountry(RequestModel requestModel);
     CountryDTO findByCountryId(String id) throws CountryNotFoundException;
     List<CountryDTO>findAllCountries();
     CountryDTO updateCountry(CountryDTO countryDTO);
     CountryDTO findByCode(String code) throws CountryNotFoundException;
     CountryDTO findByName(String name) throws CountryNotFoundException;
     String deleteById(String id) throws CountryNotFoundException;
}
