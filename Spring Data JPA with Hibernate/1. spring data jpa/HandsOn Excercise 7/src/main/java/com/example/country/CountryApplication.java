package com.example.country;

import com.example.country.model.Country;
import com.example.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountryApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(CountryApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Country newCountry = new Country();
        newCountry.setCode("XY");
        newCountry.setName("Xylopia");
        countryService.addCountry(newCountry);

        Country found = countryService.findCountryByCode("XY");
        System.out.println("Added Country: " + found.getName());
    }
}