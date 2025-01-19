package gestorDeInventariosYVentas.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApiVersionInterceptor implements WebMvcConfigurer {

    @Autowired
    private ApiVersionHandlerInterceptor apiVersionHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiVersionHandlerInterceptor)
                .addPathPatterns("/api/**"); // Interceptar solo las rutas que comienzan con /api/
    }
}
