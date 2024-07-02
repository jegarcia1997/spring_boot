package com.prueba.api.middlewares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.prueba.api.entities.Cliente;
import com.prueba.api.repositories.ClienteRepository;
import com.prueba.api.constants.RouteConstants;

@Component
public class ClienteMiddleware extends AbstractMiddleware {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        Long id = obtenerIdDesdeURI(request.getRequestURI());

        if (id == null) {
            enviarRespuestaError(response, "No se encontró un id valido");
            return false;
        }

        Cliente cliente = clienteRepository.findById(id).orElse(null);

        if (cliente == null) {
            enviarRespuestaError(response, "No se encontró un cliente con id: " + id);
            return false;
        }

        request.setAttribute("cliente", cliente);

        return true;
    }

    private Long obtenerIdDesdeURI(String uri) {
        String regex = obtenerExpresionRegular();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(uri);
        if (matcher.matches()) {
            return Long.parseLong(matcher.group(1));
        }
        return null;
    }

    private String obtenerExpresionRegular() {
        String regex = String.format("%s/(\\d+)(?:%s|%s)?", RouteConstants.CLIENTES_BASE, RouteConstants.EDITAR,
                RouteConstants.ELIMINAR);
        return regex;
    }

}