package com.example.countryservice.controller;

import com.example.countryservice.DTO.CountryDTO;
import com.example.countryservice.Model.Country;
import com.example.countryservice.Model.CountryWrapper;
import com.example.countryservice.exception.CountryNotFoundException;
import com.example.countryservice.service.CountryService;
import com.example.countryservice.ui.RequestModel;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
@RequestMapping("api/v1")
public class CountryController {
    Logger logger= LoggerFactory.getLogger(CountryController.class);
    @Autowired
    private CountryService service;
    /**
    * for saving countries in bulk
    * */

    @PostMapping("/bulk")

    public void createCountryInBulk(@RequestBody CountryWrapper countryWrapper){
        System.out.println("countryWrapper = " + countryWrapper);
        service.createCountryInBulk(countryWrapper);


        }
    /**
     * for saving  a single country
     * */
    @PostMapping("/countries")
    public ResponseEntity<CountryDTO>createCountry(@Valid @RequestBody RequestModel requestModel){
      logger.info("STARTED THE PROCESS OF SAVING "+requestModel.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createCountry(requestModel));

    }

    /**
     * All the Get Methods implemented
     *
     * 1.for fetching country with countryId
     *
     * 2.for fetching country with country code
     *
     * 3.for fetching country with country name
     *
     * 4.for fetching All Countries present in Database
     *
     * */
    @GetMapping("/countries/{id}")
    public ResponseEntity<CountryDTO>findByCountryId(@PathVariable @Length(min = 16,max = 132 ) String id) throws CountryNotFoundException {
        logger.info("STARTED THE PROCESS OF GETTING  COUNTRY WITH ID "+id);
        return ResponseEntity.status(HttpStatus.OK).body(service.findByCountryId(id));
    }

    @GetMapping("/countries/searchCode/{id}")
    public ResponseEntity<CountryDTO>searchByCode(@PathVariable @Length(min = 2,max = 132 ) String id) throws CountryNotFoundException {
        logger.info("STARTED THE PROCESS OF GETTING  COUNTRY WITH CODE "+id);
        return ResponseEntity.status(HttpStatus.OK).body(service.findByCode(id));
    }
    @GetMapping("/countries/searchName/{id}")
    public ResponseEntity<CountryDTO>searchByName(@PathVariable @Length(min = 4,max = 132 ) String id) throws CountryNotFoundException {
        logger.info("STARTED THE PROCESS OF GETTING  COUNTRY WITH NAME "+id);
        return ResponseEntity.status(HttpStatus.OK).body(service.findByName(id));
    }
    @GetMapping("/countries")
    public ResponseEntity<List<CountryDTO>> findAllCountries(){
        logger.info("STARTED TO FETCHING ALL COUNTRIES ");
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllCountries());
    }
    /**
     *       put method  for updating countries
     *
     * */
    @PutMapping("/countries")
    public ResponseEntity<CountryDTO>updateCountry(@Valid @RequestBody CountryDTO countryDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.updateCountry(countryDTO));
    }
    /**
     *       Delete method  for deleting countries
     *
     * */
    @DeleteMapping("/countries/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) throws CountryNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteById(id));
    }


}
