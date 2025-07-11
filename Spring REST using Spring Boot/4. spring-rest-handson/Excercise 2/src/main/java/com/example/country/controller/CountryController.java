package com.example.country.controller;

import com.example.country.model.Country;
import com.example.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = Logger.getLogger(CountryController.class.getName());

    @Autowired
    private CountryService service;

    @PostMapping
    public void addCountry(@RequestBody(required = false) Country country) {
        LOGGER.info("Start");
        if (country != null) {
            service.addCountry(country);
        }
    }
}