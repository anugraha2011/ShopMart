package com.shopmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ShopMartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopMartApplication.class, args);
	}

}
