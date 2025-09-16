package com.example.banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoApplication.class, args);
	}



    // Testar com Postman
    // http://localhost:8080/clientes
    // http://localhost:8080/clientes/1
    // http://localhost:8080/clientes (POST)
    // http://localhost:8080/clientes/1 (PUT)
    // http://localhost:8080/clientes/1 (DELETE)
    // Usar JSON para criar e atualizar clientes


}
