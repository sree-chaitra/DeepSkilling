
package com.example.ormlearn;

import com.example.ormlearn.model.Country;
import com.example.ormlearn.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static CountryRepository countryRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryRepository = context.getBean(CountryRepository.class);

        // Uncomment one at a time to test
        testFindByNameContaining();
        //testFindByNameContainingOrderByNameAsc();
        //testFindByNameStartingWith();
    }

    private static void testFindByNameContaining() {
        LOGGER.info("Start: testFindByNameContaining");
        List<Country> countries = countryRepository.findByNameContainingIgnoreCase("ou");
        countries.forEach(country -> LOGGER.info("Country: {}", country));
        LOGGER.info("End: testFindByNameContaining");
    }

    private static void testFindByNameContainingOrderByNameAsc() {
        LOGGER.info("Start: testFindByNameContainingOrderByNameAsc");
        List<Country> countries = countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc("ou");
        countries.forEach(country -> LOGGER.info("Country: {}", country));
        LOGGER.info("End: testFindByNameContainingOrderByNameAsc");
    }

    private static void testFindByNameStartingWith() {
        LOGGER.info("Start: testFindByNameStartingWith");
        List<Country> countries = countryRepository.findByNameStartingWithIgnoreCase("Z");
        countries.forEach(country -> LOGGER.info("Country: {}", country));
        LOGGER.info("End: testFindByNameStartingWith");
    }
}
