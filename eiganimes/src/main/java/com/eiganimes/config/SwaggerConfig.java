package com.eiganimes.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI() {
        Contact contact = new Contact();
        contact.name("Arthur");
        contact.email("passamaniarthur@gmail.com");

        Info info = new Info();
        info.title("Eiganimes");
        info.version("v1");
        info.description("Aplicação para gerenciamento de catálogo de Animes");
        info.contact(contact);

        return new OpenAPI().info(info);
    }
}
