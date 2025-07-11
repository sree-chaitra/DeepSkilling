package com.example.country.controller;

import com.example.country.model.Country;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = Logger.getLogger(CountryController.class.getName());

    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        LOGGER.info("Received country: " + country);
        return country;
    }
}