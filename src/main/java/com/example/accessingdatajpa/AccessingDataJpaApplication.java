package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));
            repository.save(new Customer("Flavio", "Scardino"));
            repository.save(new Customer("Gianmarco", "Bisanti"));
            repository.save(new Customer("Pierluigi", "Buongiorno"));


            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findById(6L);
            log.info("Customer found with findById(6L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            Customer customerDue = repository.findById(7L);
            log.info("Customer found with findById(7L):");
            log.info("--------------------------------");
            log.info(customerDue.toString());
            log.info("");


            // fetch customers by last name
            log.info("Customer found with findByLastName('Buongiorno'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Buongiorno").forEach(bauer -> {
                log.info(bauer.toString());
            });

            log.info("");
        };
    }

}
