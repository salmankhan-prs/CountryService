package com.example.countryservice.service;

import com.example.countryservice.DTO.CountryDTO;
import com.example.countryservice.Model.Country;
import com.example.countryservice.Repo.CountryRepo;
import com.example.countryservice.exception.CountryNotFoundException;
import com.example.countryservice.ui.RequestModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
@Validated
public class CountryServiceImpl implements CountryService{
    Logger logger= LoggerFactory.getLogger(CountryServiceImpl.class);
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CountryRepo countryRepo;
    @Override

    public CountryDTO createCountry(RequestModel requestModel) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CountryDTO countryDTO=modelMapper.map(requestModel,CountryDTO.class);
        countryDTO.setCountryId(UUID.randomUUID().toString());
        Country country=modelMapper.map(countryDTO,Country.class);
        countryRepo.save(country);
        logger.info("SAVED THE  "+requestModel.getName());
        return countryDTO;



    }

    @Override
    public CountryDTO findByCountryId(String id) throws CountryNotFoundException {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        if(!countryRepo.existsByCountryId(id)){
            logger.error("CANNOT FIND THE COUNTRY  "+ id);
            throw new CountryNotFoundException("Country not found with id ");
        }
        Country country=countryRepo.findByCountryId(id);

        CountryDTO countryDTO=modelMapper.map(country,CountryDTO.class);
        logger.info("FETCHED THE DETAILS OF COUNTRY WITH ID  "+ id);
        return countryDTO;

    }

    @Override
    public List<CountryDTO> findAllCountries() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<Country> countries=countryRepo.findAll();
        List<CountryDTO>countryDTOList=new ArrayList<>();
        for(Country country:countries){
            countryDTOList.add(modelMapper.map(country,CountryDTO.class));
        }
        return countryDTOList;

    }

    @Override
    public CountryDTO updateCountry(CountryDTO countryDTO) {
        Country countryInDB=countryRepo.findByCountryId(countryDTO.getCountryId());

        countryInDB.setCode(countryDTO.getCode());
        countryInDB.setName(countryDTO.getName());
        countryRepo.save(countryInDB);
        return countryDTO;

    }

    @Override
    public CountryDTO findByCode(String code) throws CountryNotFoundException {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        if(!countryRepo.existsByCode(code)){
            logger.error("CANNOT FIND THE COUNTRY WITH CODE  "+ code);
            throw new CountryNotFoundException("Country not found with name");
        }
       Country country= countryRepo.findByCode(code);
        logger.info("FETCHED  THE COUNTRY WITH CODE  "+ code);
       return  modelMapper.map(country,CountryDTO.class);

    }

    @Override
    public CountryDTO findByName(String name) throws CountryNotFoundException {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        if(!countryRepo.existsByName(name)){
            logger.error("CANNOT FIND THE COUNTRY WITH NAME "+ name);
            throw new CountryNotFoundException("Country not found with name");
        }
        Country country= countryRepo.findByName(name);
        logger.info("FETCHED  THE COUNTRY WITH CODE  "+ name);
        return  modelMapper.map(country,CountryDTO.class);
    }

    @Override
    public String deleteById(String id) throws CountryNotFoundException {
        if(!countryRepo.existsByCountryId(id)){
            throw  new CountryNotFoundException("Country not found with ID");

        }
        Country country=countryRepo.findByCountryId(id);
        countryRepo.delete(country);
        return "Successfully Deleted "+country.getName();
    }
}
