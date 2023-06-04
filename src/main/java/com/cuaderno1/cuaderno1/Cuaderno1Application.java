package com.cuaderno1.cuaderno1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Cuaderno1Application {

	public static void main(String[] args) {
		SpringApplication.run(Cuaderno1Application.class, args);
	}

	@Bean
	public RestTemplate getresttemplate(){
	  return new RestTemplate();
	}

}
