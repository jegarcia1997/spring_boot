package com.prueba.api.dtos;

import com.prueba.api.entities.Cliente;

public class ClienteResultadoDTO extends ResultadoDTO {
    private Cliente cliente;


    public ClienteResultadoDTO() {
        super();
    }

    public ClienteResultadoDTO(boolean exitoso) {
        super(exitoso);
    }

    public ClienteResultadoDTO(boolean exitoso, String mensaje) {
        super(exitoso, mensaje);
    }

    public ClienteResultadoDTO(boolean exitoso, Cliente cliente) {
        super(exitoso);
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}