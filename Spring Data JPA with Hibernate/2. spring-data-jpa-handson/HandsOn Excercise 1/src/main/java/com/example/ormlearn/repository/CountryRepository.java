
package com.example.ormlearn.repository;

import com.example.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    List<Country> findByNameContainingIgnoreCase(String text);

    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String text);

    List<Country> findByNameStartingWithIgnoreCase(String alphabet);
}
