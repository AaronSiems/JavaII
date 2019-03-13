package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Drink;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public Drink drink() {
		Drink bean = new Drink("Generic", "Brown");
		return bean;
	}

}
