package br.jus.stm.localizacao.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI springOpenAPI() {
        final String securitySchemeName = "bearerAuth";
        return new OpenAPI()
                .info(new Info()
                        .title("STM Localização IBGE")
                        .description("Documentação da API STM Localização IBGE")
                        .version("1.0.0")
                        .license(
                                new License()
                                        .name("CDESC - Coordenação de Desenvolvimento de Software")
                                        .url("https://stm.jus.br")))
                /*
                .externalDocs(
                        new ExternalDocumentation().description("Documentação Externa").url("https://stm.jus.br")
                )*/
                .addSecurityItem(
                        new SecurityRequirement().addList(securitySchemeName))
                            .components(
                                    new Components()
                                            .addSecuritySchemes(securitySchemeName,
                                                    new SecurityScheme()
                                                            .name(securitySchemeName)
                                                            .type(SecurityScheme.Type.HTTP)
                                                            .scheme("bearer")
                                                            .bearerFormat("JWT")
                                            )
                );
    }

}
