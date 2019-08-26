package com.shop.Shopaholic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({ "com.shop.Shopaholic.controllers"})
public class ShopaholicApplication {

	public static void main(String[] args) {
		System.out.println("In main");
		SpringApplication.run(ShopaholicApplication.class, args);
	}

}
