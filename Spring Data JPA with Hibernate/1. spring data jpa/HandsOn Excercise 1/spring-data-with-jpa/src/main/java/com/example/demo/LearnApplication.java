package com.example.demo;

import com.example.demo.service.CountryService;
import com.example.demo.model.Country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class LearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(LearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LearnApplication.class, args);
        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);

        testGetAllCountries();
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start");

        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);

        LOGGER.info("End");
    }
}
