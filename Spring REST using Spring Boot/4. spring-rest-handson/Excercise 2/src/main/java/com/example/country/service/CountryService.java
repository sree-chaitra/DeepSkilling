package com.example.country.service;

import com.example.country.model.Country;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {
    private List<Country> countryList = new ArrayList<>();

    public List<Country> getAllCountries() {
        return countryList;
    }

    public void addCountry(Country country) {
        countryList.add(country);
    }
}