package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonDaoImpl {

    private static final Logger log = LoggerFactory.getLogger(PersonDaoImpl.class);

    @Bean
    CommandLineRunner initDatabase(PersonRepository personRepository, DepartmentRepository departmentRepository) {

        return args -> {
            Department department = new Department("Design");
            log.info("Preloading " + departmentRepository.save(department));
            log.info("Preloading " + personRepository.save(new Person("Tom", department)));
            log.info("Preloading " + personRepository.save(new Person("Jack", department)));
            // get all from DB
            log.info("Get all Persons " + personRepository.findAll());
            log.info("Get all Departments " + departmentRepository.findAll());

            //get one
            log.info("Get one Person " + personRepository.findById(1L));
            log.info("Get one Department " + departmentRepository.findById(1L));
        };
    }
}
