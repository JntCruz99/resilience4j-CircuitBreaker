package br.com.jntcruz.MicroserviceProduto;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MicroserviceProdutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProdutoApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
