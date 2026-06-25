package com.ms_carrito.example.ms_carrito20;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaServer
@EnableFeignClients
@SpringBootApplication
public class MsCarrito20Application {

	public static void main(String[] args) {
		SpringApplication.run(MsCarrito20Application.class, args);
	}

}
