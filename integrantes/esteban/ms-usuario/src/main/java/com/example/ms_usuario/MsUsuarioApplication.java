package com.example.ms_usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MsUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsUsuarioApplication.class, args);
	}

}
