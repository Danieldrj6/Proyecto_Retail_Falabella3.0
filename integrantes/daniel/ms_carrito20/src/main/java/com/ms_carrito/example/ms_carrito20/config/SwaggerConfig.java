package com.ms_carrito.example.ms_carrito20.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
        .info(new Info()
                    .title("API CARRITO")
                    .version("1.0")
                    .description("documentacion de APIs del microservicio de carrito"));
    }

}
