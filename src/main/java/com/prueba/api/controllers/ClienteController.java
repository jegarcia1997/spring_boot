package com.prueba.api.controllers;

import com.prueba.api.dtos.ClienteResultadoDTO;
import com.prueba.api.dtos.ClientesResultadoDTO;
import com.prueba.api.dtos.EmailsResultadoDTO;
import com.prueba.api.dtos.ResultadoDTO;
import com.prueba.api.entities.Cliente;
import com.prueba.api.services.impl.ClienteService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    
    @GetMapping()
    public ResponseEntity<ClientesResultadoDTO> listarClientes() {
        ClientesResultadoDTO resultado = clienteService.listar();
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/emails")
    public ResponseEntity<EmailsResultadoDTO> listarEmails() {
        EmailsResultadoDTO resultado = clienteService.listarEmails();
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/crear")
    public ResponseEntity<ResultadoDTO> crearCliente(@RequestBody Cliente cliente) {
        ResultadoDTO resultado = clienteService.crear(cliente);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResultadoDTO> consultarCliente(HttpServletRequest request) {
        Cliente cliente = (Cliente) request.getAttribute("cliente");
        return ResponseEntity.ok(clienteService.consultar(cliente));
    }
    
    @PostMapping("/{id}/editar")
    public ResponseEntity<ResultadoDTO> editarCliente(@RequestBody Cliente clienteActualizado, HttpServletRequest request) {
        Cliente cliente = (Cliente) request.getAttribute("cliente");
        ResultadoDTO resultado = clienteService.editar(cliente, clienteActualizado);
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/{id}/eliminar")
    public ResponseEntity<ResultadoDTO> eliminarCliente(HttpServletRequest request) {
        Cliente cliente = (Cliente) request.getAttribute("cliente");
        ResultadoDTO resultado = clienteService.eliminar(cliente);
        return ResponseEntity.ok(resultado);
    } 
}
