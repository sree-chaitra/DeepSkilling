package com.example.multids;

import com.example.multids.entity.primary.EmployeePrimary;
import com.example.multids.entity.secondary.EmployeeSecondary;
import com.example.multids.repository.primary.EmployeePrimaryRepository;
import com.example.multids.repository.secondary.EmployeeSecondaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultiDsApplication implements CommandLineRunner {

    @Autowired
    private EmployeePrimaryRepository primaryRepo;

    @Autowired
    private EmployeeSecondaryRepository secondaryRepo;

    public static void main(String[] args) {
        SpringApplication.run(MultiDsApplication.class, args);
    }

    @Override
    public void run(String... args) {
        primaryRepo.save(new EmployeePrimary(1, "Alice", 50000));
        secondaryRepo.save(new EmployeeSecondary(2, "Bob", 60000));

        System.out.println("Primary DB:");
        primaryRepo.findAll().forEach(e -> System.out.println(e.getName()));

        System.out.println("Secondary DB:");
        secondaryRepo.findAll().forEach(e -> System.out.println(e.getName()));
    }
}
