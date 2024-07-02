package com.prueba.api.services;

import com.prueba.api.dtos.ResultadoDTO;
import com.prueba.api.entities.Cliente;

public interface IClienteService extends IOperacionesCrud<Cliente> {
    ResultadoDTO listarEmails();
}
