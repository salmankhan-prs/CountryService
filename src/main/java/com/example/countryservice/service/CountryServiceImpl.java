package com.example.countryservice.service;

import com.example.countryservice.DTO.CountryDTO;
import com.example.countryservice.Model.Country;
import com.example.countryservice.Repo.CountryRepo;
import com.example.countryservice.ui.RequestModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class CountryServiceImpl implements CountryService{
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
        return countryDTO;



    }

    @Override
    public CountryDTO findByCountryId(String id) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Country country=countryRepo.findByCountryId(id);
        CountryDTO countryDTO=modelMapper.map(country,CountryDTO.class);
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
}
