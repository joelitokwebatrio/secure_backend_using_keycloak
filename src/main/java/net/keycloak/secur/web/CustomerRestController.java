package net.keycloak.secur.web;

import lombok.RequiredArgsConstructor;
import net.keycloak.secur.entities.Customer;
import net.keycloak.secur.repository.CustomerRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomerRestController {
    private final CustomerRepository customerRepository;

    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('USER')")
    List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    Customer getCustomerById( @PathVariable Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @GetMapping("/mySession")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }
}
