package com.wsjia.jta.service;

import com.wsjia.jta.domain.customer.Customer;
import com.wsjia.jta.domain.order.Order;
import com.wsjia.jta.exception.NoRollbackException;
import com.wsjia.jta.exception.StoreException;
/**
 * @description
 *
 * @author kayson Yang
 * @create 2016-09-22 19:22
 */
public interface StoreService {
	
	void store(Customer customer, Order order) throws Exception;
	
	void storeWithStoreException(Customer customer, Order order) throws StoreException;
	
	void storeWithNoRollbackException(Customer customer, Order order) throws NoRollbackException;

}
