package com.example.countryservice;

import com.example.countryservice.ui.RequestModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Lists;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CountryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountryServiceApplication.class, args);
    }
  @Bean
    public ModelMapper modelMapper(){return new ModelMapper();}
    @Bean
    public List<RequestModel> requestModelList() {
        return new ArrayList<>();
    }
}
