package org.dd.jtademo.repository.customer;

import org.dd.jtademo.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
