
package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @RequestMapping("/country")
    public Country getCountryIndia() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        return (Country) context.getBean("in");
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        return (List<Country>) context.getBean("countryList");
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("START getCountry with code {}", code);
        Country country = countryService.getCountry(code);
        LOGGER.info("END getCountry");
        return country;
    }
}
