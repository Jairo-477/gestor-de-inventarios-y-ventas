package gestorDeInventariosYVentas.example.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ApiVersionHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();

        // Si la URI no empieza con /api/v1, redirigir a la versión correcta
        if (!uri.startsWith("/api/v1")) {
            String newUri = "/api/v1" + uri;
            request.getRequestDispatcher(newUri).forward(request, response);
            return false; // No continuar con el procesamiento del handler original
        }
        return true; // Continuar con el procesamiento si la URI es válida
    }
}
