package com.example.countryservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String flagUrl;
    private String countryId;
    private String code;
    private String name;

    public Country(String countryId,String code, String name) {
        this.code = code;
        this.name = name;
    }
}
