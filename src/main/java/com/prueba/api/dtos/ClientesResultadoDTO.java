package com.prueba.api.dtos;


import java.util.List;

import com.prueba.api.entities.Cliente;

public class ClientesResultadoDTO extends ResultadoDTO {
    private List<Cliente> clientes;


    public ClientesResultadoDTO(boolean exitoso, List<Cliente> clientes) {
        super(exitoso);
        this.clientes = clientes;
    }

    public List<Cliente>  getClientes() {
        return clientes;
    }

    public void setCliente(List<Cliente>  clientes) {
        this.clientes = clientes;
    }
}