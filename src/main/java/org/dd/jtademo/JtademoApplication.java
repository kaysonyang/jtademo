package org.dd.jtademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
public class JtademoApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JtademoApplication.class);
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(JtademoApplication.class, args);

		/*UserServiceImpl userService = ctx.getBean(UserServiceImpl.class);
		User su= userService.findUserById(1L);
		BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);
		su.setPassword(bc.encode("111111"));
		userService.update(su);*/

	}
}
