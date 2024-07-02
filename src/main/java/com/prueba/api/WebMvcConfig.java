package com.prueba.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.prueba.api.constants.RouteConstants;
import com.prueba.api.middlewares.ClienteMiddleware;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private ClienteMiddleware clienteMiddleware;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registrarClienteInterceptor(registry);
    }

    private void registrarClienteInterceptor(InterceptorRegistry registry) {
        String urlBase = RouteConstants.CLIENTES_BASE + RouteConstants.ID;
        registry.addInterceptor(clienteMiddleware)
                .addPathPatterns(
                        urlBase,
                        urlBase + RouteConstants.EDITAR,
                        urlBase + RouteConstants.ELIMINAR)
                .excludePathPatterns(
                        RouteConstants.CLIENTES_BASE + RouteConstants.EMAILS,
                        RouteConstants.CLIENTES_BASE + RouteConstants.CREAR);
    }
}
