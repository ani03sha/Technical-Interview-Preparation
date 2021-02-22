package org.redquark.techinterview.spring.consumingrest.configurations;

import org.redquark.techinterview.spring.consumingrest.domains.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Configuration
public class ConsumingRestApplicationConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumingRestApplicationConfig.class);

    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) {
        return args -> {
            ResponseEntity<Todo[]> responseEntity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/",
                    Todo[].class);
            Todo[] todos = responseEntity.getBody();
            LOGGER.info(Arrays.toString(todos));
        };
    }
}
