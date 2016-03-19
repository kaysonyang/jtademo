package org.dd.jtademo.service;

import org.dd.jtademo.domain.customer.Customer;
import org.dd.jtademo.domain.order.Order;
import org.dd.jtademo.exception.NoRollbackException;
import org.dd.jtademo.exception.StoreException;

public interface StoreService {
	
	void store(Customer customer, Order order) throws Exception;
	
	void storeWithStoreException(Customer customer, Order order) throws StoreException;
	
	void storeWithNoRollbackException(Customer customer, Order order) throws NoRollbackException;

}
