package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonDaoImpl {

    private static final Logger log = LoggerFactory.getLogger(PersonDaoImpl.class);
    private PersonRepository personRepository;
    private DepartmentRepository departmentRepository;

    @Bean
    CommandLineRunner initDatabase(PersonRepository personRepository, DepartmentRepository departmentRepository) {
        this.personRepository = personRepository;
        this.departmentRepository = departmentRepository;

        return args -> {
            Department department = new Department("Design");
            log.info("Preloading " + this.departmentRepository.save(department));
            log.info("Preloading " + this.personRepository.save(new Person("Tom", department)));
            log.info("Preloading " + this.personRepository.save(new Person("Jack", department)));
            // get all from DB
            log.info("Get all Persons " + this.personRepository.findAll());
            log.info("Get all Departments " + this.departmentRepository.findAll());

            //get one
            log.info("Get one Person " + this.personRepository.findById(1L));
            log.info("Get one Department " + this.departmentRepository.findById(1L));
        };
    }
}
