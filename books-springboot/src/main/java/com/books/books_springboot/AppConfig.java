package com.books.books_springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class AppConfig {

    @Bean
    public OpenAPI customOpenAPI(){

        return new OpenAPI()
                .info(new Info()
                .title("Bookshelf API (2024)")
                .version("1.0")
                .description("APIs relacionadas con el mundo de los libros, autores y géneros literarios." + 
                " El objetivo del proyecto fue facilitar el acceso a información relevante sobre obras literarias,"+ 
                " sus creadores y las diversas categorías literarias.")
                .termsOfService("http://swagger.io/terms/")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
