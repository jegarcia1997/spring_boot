package com.prueba.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.api.dtos.ClienteResultadoDTO;
import com.prueba.api.dtos.ClientesResultadoDTO;
import com.prueba.api.dtos.EmailsResultadoDTO;
import com.prueba.api.dtos.ResultadoDTO;
import com.prueba.api.entities.Cliente;
import com.prueba.api.repositories.ClienteRepository;
import com.prueba.api.services.IClienteService;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public ClientesResultadoDTO listar() {
        ClientesResultadoDTO resultado = new ClientesResultadoDTO(true, clienteRepository.findAll());
        return resultado;
    }

    @Override
    public ClienteResultadoDTO consultar(Cliente cliente) {
        ClienteResultadoDTO resultado = new ClienteResultadoDTO(true, cliente);
        return resultado;
    }

    @Override
    public ResultadoDTO crear(Cliente cliente) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();

        if (cliente.getEmail() != null && clienteRepository.existsByEmail(cliente.getEmail())) {
            resultadoDTO.setExitoso(false);
            resultadoDTO.setMensaje(
                    "No se puede crear el cliente porque ya existe uno con email: " + cliente.getEmail());
            return resultadoDTO;
        }

        try {
            clienteRepository.save(cliente);
            resultadoDTO.setExitoso(true);
            resultadoDTO.setMensaje("Cliente creado exitosamente");
        } catch (Exception ex) {
            resultadoDTO.setExitoso(false);
            resultadoDTO.setMensaje("Error al crear el cliente: " + ex.getMessage());
        }

        return resultadoDTO;
    }

    @Override
    public ResultadoDTO editar(Cliente cliente, Cliente clienteActualizado) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        
        if (clienteActualizado.getNombre() != null) {
            cliente.setNombre(clienteActualizado.getNombre());
        }
        if (clienteActualizado.getDireccion() != null) {
            cliente.setDireccion(clienteActualizado.getDireccion());
        }
        if (clienteActualizado.getTelefono() != null) {
            cliente.setTelefono(clienteActualizado.getTelefono());
        }
        
        try {
            clienteRepository.save(cliente);
            resultadoDTO.setExitoso(true);
            resultadoDTO.setMensaje("Cliente editado exitosamente");
        } catch (Exception ex) {
            resultadoDTO.setExitoso(false);
            resultadoDTO.setMensaje("Error al editar el cliente: " + ex.getMessage());
        }
        
        return resultadoDTO;
    }
    

    @Override
    public ResultadoDTO eliminar(Cliente cliente) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();

        try {
            clienteRepository.deleteById(cliente.getId());
            resultadoDTO.setExitoso(true);
            resultadoDTO.setMensaje("Cliente eliminado exitosamente");
        } catch (Exception ex) {
            resultadoDTO.setExitoso(false);
            resultadoDTO.setMensaje("Error al eliminar el cliente: " + ex.getMessage());
        }

        return resultadoDTO;
    }

    @Override
    public EmailsResultadoDTO listarEmails() {
        List<String> emails = clienteRepository.findAllEmails();
        
        EmailsResultadoDTO emailsResultadoDTO = new EmailsResultadoDTO(true, emails);

        return emailsResultadoDTO;
    }

    

}
