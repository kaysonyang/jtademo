package com.wsjia.jta.service;

import com.wsjia.jta.domain.customer.Customer;
import com.wsjia.jta.domain.order.Order;
import com.wsjia.jta.exception.NoRollbackException;
import com.wsjia.jta.exception.StoreException;
import com.wsjia.jta.repository.customer.CustomerRepository;
import com.wsjia.jta.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @description
 *
 * @author kayson Yang
 * @create 2016-09-22 19:22
 */
@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	@Transactional
	public void store(Customer customer, Order order) {
		orderRepository.save(order);
		customerRepository.save(customer);
	}

	@Transactional(rollbackFor = StoreException.class)
	@Override
	public void storeWithStoreException(Customer customer, Order order) throws StoreException {
		customerRepository.save(customer);
		orderRepository.save(order);
		throw new StoreException();
	}

	@Transactional(noRollbackFor = NoRollbackException.class, rollbackFor = StoreException.class)
	@Override
	public void storeWithNoRollbackException(Customer customer, Order order) throws NoRollbackException {
		customerRepository.save(customer);
		orderRepository.save(order);
		throw new NoRollbackException();
	}

}
