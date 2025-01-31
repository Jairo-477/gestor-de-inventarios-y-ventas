package gestorDeInventariosYVentas.example.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "API Gestor De Inventarios y Ventas",
                description = "An inventory and sales manager that implements Spring Boot, Spring Data JPA, Spring " +
                        "Security for authentication and authorization, among other technologies.",
                version = "1.0.0",
                contact = @Contact(
                        name = "Jairo Alejandro",
                        url = "https://github.com/Jairo-477",
                        email = "jadev@yahoo.com"
                )
        )
)
public class SwaggerConfig {
}
