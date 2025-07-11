package com.example.country.service;

import com.example.country.model.Country;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {
    private List<Country> countryList = new ArrayList<>();

    public CountryService() {
        countryList.add(new Country("IN", "India"));
        countryList.add(new Country("US", "United States"));
        countryList.add(new Country("UK", "United Kingdom"));
    }

    public List<Country> getAllCountries() {
        return countryList;
    }

    public Country getCountryByCode(String code) {
        return countryList.stream().filter(c -> c.getCode().equalsIgnoreCase(code)).findFirst().orElse(null);
    }

    public void addCountry(Country country) {
        countryList.add(country);
    }

    public void updateCountry(Country updatedCountry) {
        for (int i = 0; i < countryList.size(); i++) {
            if (countryList.get(i).getCode().equalsIgnoreCase(updatedCountry.getCode())) {
                countryList.set(i, updatedCountry);
                break;
            }
        }
    }

    public void deleteCountry(String code) {
        countryList.removeIf(c -> c.getCode().equalsIgnoreCase(code));
    }
}