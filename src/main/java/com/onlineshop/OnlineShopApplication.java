package com.onlineshop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication

public class OnlineShopApplication {

	public static void main(String[] args) {

		SpringApplication.run(OnlineShopApplication.class, args);
	}
	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}

}
