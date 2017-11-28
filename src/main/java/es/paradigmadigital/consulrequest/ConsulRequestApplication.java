package es.paradigmadigital.consulrequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulRequestApplication.class, args);
	}
	
	@LoadBalanced
	@Bean
	public RestTemplate rest(){
		return new RestTemplate();
	}
}
