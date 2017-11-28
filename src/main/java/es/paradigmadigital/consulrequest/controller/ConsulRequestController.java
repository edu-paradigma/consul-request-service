package es.paradigmadigital.consulrequest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consul-request-service")
public class ConsulRequestController {

	@Autowired
	RestTemplate rest;

	@Autowired
	DiscoveryClient discoveryClient;

	@GetMapping()
	public ResponseEntity<ResponseDTO> getResponse(String name) {
		
		Optional<ServiceInstance> optionalServiceInstance = discoveryClient.getInstances("consul-response-service")
				.stream().findFirst();
		
		String uri = optionalServiceInstance.get().getUri().toString();

		System.out.println(String.format("consul-response-service microservice URI obtained from Consul: %s", uri));
		
		ResponseEntity<ResponseDTO> response = rest.getForEntity("http://consul-response-service/consul-response",
				ResponseDTO.class);

		return response;
	}
}
