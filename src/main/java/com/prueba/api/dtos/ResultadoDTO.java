package com.prueba.api.dtos;

public class ResultadoDTO {
    private boolean exitoso;
    private String mensaje;

    public ResultadoDTO() {

    }
    
    public ResultadoDTO(boolean exitoso) {
        this.exitoso = exitoso;
    }

    public ResultadoDTO(boolean exitoso, String mensaje) {
        this.exitoso = exitoso;
        this.mensaje = mensaje;
    }

    public boolean isExitoso() {
        return exitoso;
    }

    public void setExitoso(boolean exitoso) {
        this.exitoso = exitoso;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}