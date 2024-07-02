package com.prueba.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nombre_cliente", nullable = false, length = 100)
    private String nombre;

    @Column(name = "direccion_cliente", nullable = false, length = 255)
    private String direccion;

    @Column(name = "telefono_cliente", length = 15)
    private String telefono;

    @Column(name = "email_cliente", nullable = false, length = 100)
    private String email;
}
