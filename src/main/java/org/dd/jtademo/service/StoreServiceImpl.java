package org.dd.jtademo.service;

import org.dd.jtademo.domain.customer.Customer;
import org.dd.jtademo.domain.order.Order;
import org.dd.jtademo.exception.NoRollbackException;
import org.dd.jtademo.exception.StoreException;
import org.dd.jtademo.repository.customer.CustomerRepository;
import org.dd.jtademo.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
