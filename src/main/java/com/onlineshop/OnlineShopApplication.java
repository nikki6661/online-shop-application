package com.onlineshop;


import com.onlineshop.config.vaultConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableConfigurationProperties(vaultConfig.class)
public class OnlineShopApplication implements CommandLineRunner {
	private final vaultConfig vaultConfig;
	public OnlineShopApplication(com.onlineshop.config.vaultConfig vaultConfig) {
		this.vaultConfig = vaultConfig;
	}
	@Value("${spring.data.mongodb.password}")
	private String dbPass;

	public static void main(String[] args) {

		SpringApplication.run(OnlineShopApplication.class, args);
	}
	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}

	@Override
	public void run(String... args) throws Exception {
		Logger logger = LoggerFactory.getLogger(vaultConfig.class);

		logger.info("----------------------------------------");
		logger.info("Configuration properties");
		logger.info("  Username", vaultConfig.getUsername());
		logger.info("   password", dbPass);
		logger.info("----------------------------------------");
	}
}
