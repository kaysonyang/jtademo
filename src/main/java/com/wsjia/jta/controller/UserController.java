package com.wsjia.jta.controller;

import com.wsjia.jta.domain.customer.Customer;
import com.wsjia.jta.domain.order.Order;
import com.wsjia.jta.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @description
 *
 * @author kayson Yang
 * @create 2016-09-22 19:22
 */
@Controller
public class UserController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StoreService storeService;

	@RequestMapping("/testa")
	@ResponseBody
	public Customer testa() throws Exception {
		Customer customer = new Customer();
		customer.setName("normal");
		customer.setAge(22);
		Order order = new Order();
		order.setCode(222);
		order.setQuantity(22);
		storeService.store(customer, order);
		return customer;
	}

	@RequestMapping("/testb")
	@ResponseBody
	public Customer testb() throws Exception {
		Customer customer = new Customer();
		customer.setName("StoreException");
		customer.setAge(33);
		Order order = new Order();
		order.setCode(333);
		order.setQuantity(33);
		storeService.storeWithStoreException(customer, order);
		return customer;
	}
	@RequestMapping("/testc")
	@ResponseBody
	public Customer testc() throws Exception {
		Customer customer = new Customer();
		customer.setName("NoRollbackException");
		customer.setAge(44);
		Order order = new Order();
		order.setCode(444);
		order.setQuantity(44);
		storeService.storeWithNoRollbackException(customer, order);
		return customer;
	}

	@RequestMapping("/test.html")
	public String test(){
		return "test";
	}

	@RequestMapping(value = "/upload.json")
	public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletResponse response) throws Exception{
		logger.info("file name: {}", file.getName());
		logger.info("file size: {}", file.getSize()+"");
		logger.info("original file name: {}", file.getOriginalFilename());
		PrintWriter out = response.getWriter();
		out.print("{code: 200, desc: 'success'}");
		out.flush();
		return null;
	}

}
