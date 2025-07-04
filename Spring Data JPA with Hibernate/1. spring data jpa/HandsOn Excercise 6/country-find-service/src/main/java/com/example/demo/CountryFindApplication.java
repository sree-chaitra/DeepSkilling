package com.example.demo;

import com.example.demo.model.Country;
import com.example.demo.service.CountryService;
import com.example.demo.exception.CountryNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CountryFindApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryFindApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CountryFindApplication.class, args);
        countryService = context.getBean(CountryService.class);
        getAllCountriesTest();
    }

    private static void getAllCountriesTest() {
        LOGGER.info("Start");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country:{}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error: {}", e.getMessage());
        }
        LOGGER.info("End");
    }
}
