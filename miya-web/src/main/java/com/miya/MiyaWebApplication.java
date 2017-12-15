package com.miya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


//使用jsp必须继承SpringBootServletInitializer类，extends SpringBootServletInitializer
@SpringBootApplication
public class MiyaWebApplication  {

	//@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(this.getClass());
	}

	public static void main(String[] args) {
		SpringApplication.run(MiyaWebApplication.class, args);
	}
}
