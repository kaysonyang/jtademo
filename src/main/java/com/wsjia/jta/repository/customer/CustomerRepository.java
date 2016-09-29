package com.wsjia.jta.repository.customer;

import com.wsjia.jta.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
