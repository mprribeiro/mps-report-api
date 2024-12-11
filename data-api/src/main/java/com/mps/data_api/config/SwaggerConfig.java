package com.mps.data_api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "Transaction API", version = "1.0",
                description = "APIs for searching and managing transactions"
        )
)
@Configuration
public class SwaggerConfig {

}
