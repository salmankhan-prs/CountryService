package com.example.countryservice.Model;

import com.example.countryservice.ui.RequestModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryWrapper {
    private List<RequestModel> requestModelList;
}
