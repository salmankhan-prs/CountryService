package com.example.countryservice.controller;

import com.example.countryservice.DTO.CountryDTO;
import com.example.countryservice.service.CountryService;
import com.example.countryservice.ui.RequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CountryController {
    @Autowired
    private CountryService service;
    @PostMapping("/countries")
    public ResponseEntity<CountryDTO>createCountry(@RequestBody RequestModel requestModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createCountry(requestModel));
    }


    @GetMapping("/countries/{id}")
    public ResponseEntity<CountryDTO>findByCountryId(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findByCountryId(id));
    }
    @GetMapping("/countries")
    public ResponseEntity<List<CountryDTO>> findAllCountries(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllCountries());
    }

}
