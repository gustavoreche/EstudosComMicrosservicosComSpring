package br.com.estudoloja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EstudoLojaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EstudoLojaApplication.class, args);
	}

}
