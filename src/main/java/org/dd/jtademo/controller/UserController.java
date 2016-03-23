package org.dd.jtademo.controller;

import org.dd.jtademo.domain.customer.Customer;
import org.dd.jtademo.domain.order.Order;
import org.dd.jtademo.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;


@Controller
public class UserController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StoreService storeService;

	@RequestMapping("/testa")
	@ResponseBody
	public Customer testa() throws Exception {
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
