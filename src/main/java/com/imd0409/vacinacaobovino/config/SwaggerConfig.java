package com.imd0409.vacinacaobovino.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI vacinacaoBovinoAPI() {
        final String securitySchemeName = "bearerAuth";
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")))         
                .info(new Info().title("Vacinação Bovino API")
                        .description("Aplicação de gestão de vacinação de bovinos")
                        .version("v0.0.1"))
                .externalDocs(new ExternalDocumentation()
                        .description("Vacinação Bovino Wiki Documentation")
                        .url("https://github.com/raixasantos/vacinacao-bovino-backend"));
    }
}
