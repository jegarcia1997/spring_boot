package com.prueba.api.middlewares;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.api.dtos.ResultadoDTO;

import jakarta.servlet.http.HttpServletResponse;

public abstract class AbstractMiddleware implements HandlerInterceptor {
    
    public void enviarRespuestaError(HttpServletResponse response, String mensaje) {
        ResultadoDTO resultadoDTO = new ResultadoDTO(false, mensaje);
        mapearRespuesta(response, resultadoDTO);
    }
    
    private void mapearRespuesta(HttpServletResponse response, ResultadoDTO resultadoDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            response.setStatus(HttpStatus.OK.value());
            response.setContentType("application/json");
            response.getWriter().write(objectMapper.writeValueAsString(resultadoDTO));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}