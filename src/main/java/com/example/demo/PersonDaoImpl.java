package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

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
            List<Person> allPersons = this.personRepository.findAll();
            log.info("Get all Persons " + allPersons);
            List<Department> allDepartments = this.departmentRepository.findAll();
            log.info("Get all Departments " + allDepartments);

            //get one
            Person person = this.personRepository.findById(1L).orElseThrow();
            log.info("Get one Person " + person);
            Department department1 = this.departmentRepository.findById(1L).orElseThrow();
            log.info("Get one Department " + department1);
        };
    }
}
