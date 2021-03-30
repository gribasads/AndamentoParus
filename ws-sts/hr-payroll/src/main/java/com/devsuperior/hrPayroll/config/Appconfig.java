package com.devsuperior.hrPayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Appconfig {
	
	@Bean
	public RestTemplate restTemplate() //serve para registrar uma instancia unica de um obj singleton desse tipo rt
	{
		return new RestTemplate();
		
	}

}
