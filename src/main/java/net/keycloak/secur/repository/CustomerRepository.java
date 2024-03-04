package net.keycloak.secur.repository;

import net.keycloak.secur.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer,Long> {
}
