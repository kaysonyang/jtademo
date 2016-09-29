package com.wsjia.jta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description
 *
 * @author kayson Yang
 * @create 2016-09-22 19:22
 */
@SpringBootApplication
@EnableAutoConfiguration
public class JtademoApplication  {

	public static void main(String[] args) {
		SpringApplication.run(JtademoApplication.class);
	}
}
