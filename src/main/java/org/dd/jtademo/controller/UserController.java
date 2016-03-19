package org.dd.jtademo.controller;

import org.dd.jtademo.domain.customer.Customer;
import org.dd.jtademo.domain.order.Order;
import org.dd.jtademo.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class UserController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StoreService storeService;

	@RequestMapping("/")
	@ResponseBody
	public Customer index() throws Exception {
		logger.info("访问/页面");
		Customer customer = new Customer();
		customer.setName("SDD");
		customer.setAge(11);
		Order order = new Order();
		order.setCode(111);
		order.setQuantity(11);
		storeService.store(customer, order);
		return customer;
	}

}
