package com.yaazfei.cadastrodeveiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class CadastroDeVeiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroDeVeiculosApplication.class, args);
	}

}
