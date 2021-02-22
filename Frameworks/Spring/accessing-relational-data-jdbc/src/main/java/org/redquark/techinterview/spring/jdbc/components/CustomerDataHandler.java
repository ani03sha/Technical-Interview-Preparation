package org.redquark.techinterview.spring.jdbc.components;

import org.redquark.techinterview.spring.jdbc.domains.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CustomerDataHandler implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDataHandler.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) {
        LOGGER.info("Creating tables...");
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers (id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
        // Split the array of full names into first and last name
        List<Object[]> splitNames = Stream.of("Clarke Kent", "Bruce Wayne", "Diana Prince", "Barry Allen")
                .map(name -> name.split(" "))
                .collect(Collectors.toList());
        // Print the records to be inserted
        splitNames.forEach(name -> LOGGER.info(String.format("Inserting customer record for %s %s", name[0], name[1])));
        // Bulk upload data to the DB
        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitNames);
        // Querying the DB for the first_name
        LOGGER.info("Querying customer records for first_name = 'Bruce':");
        jdbcTemplate.query("SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[]{"Bruce"},
                (resultSet, rowNumber) -> new Customer(resultSet.getLong("id"), resultSet.getString("first_name"),
                        resultSet.getString("last_name")))
                .forEach(customer -> LOGGER.info(customer.toString()));
    }
}
