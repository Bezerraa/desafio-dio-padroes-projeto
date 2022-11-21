package com.desafio.projetodio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
//O CERTO
@EnableFeignClients
@SpringBootApplication
public class ProjetoDioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoDioApplication.class, args);
	}

}
