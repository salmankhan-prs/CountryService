package com.example.countryservice.Repo;

import com.example.countryservice.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CountryRepo extends JpaRepository<Country, UUID> {
    Country findByCountryId(String id);

}
