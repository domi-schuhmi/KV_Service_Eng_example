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
    CommandLineRunner initDatabase(PersonRepository repository, DepartmentRepository departmentRepository) {

        return args -> {
            Department department = new Department("Design");
            log.info("Preloading " + departmentRepository.save(department
            ));
            log.info("Preloading " + repository.save(
                    new Person("Tom", department)));
            log.info("Preloading " + repository.save(
                    new Person("Jack", department)));
        };
    }
}
