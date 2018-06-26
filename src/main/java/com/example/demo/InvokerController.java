package com.example.demo;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InvokerController {
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping(value = "/router", method = RequestMethod.GET)
	public String router() {
		RestTemplate restTpl = getRestTemplate();
		String json = restTpl.getForObject("http://FIRST-EUREKA-PROVIDER/person/123456", String.class);
		return json;
	}
}
