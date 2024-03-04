package net.keycloak.secur;

import net.keycloak.secur.entities.Customer;
import net.keycloak.secur.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecurApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder().name("joel").email("joel@gmail.com").build());
            customerRepository.save(Customer.builder().name("placide").email("placide@gmail.com").build());
            customerRepository.save(Customer.builder().name("vida").email("vida@gmail.com").build());
            customerRepository.save(Customer.builder().name("landry").email("landry@gmail.com").build());
        };
    }
}
