package com.thrj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class TvodApplication {

	public static void main(String[] args) {
		SpringApplication.run(TvodApplication.class, args);
	}

}
