package com.prueba.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paquetes")
public class Paquete {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paquete")
    private Long id;

    @Column(name = "descripcion_paquete", nullable = false, length = 255)
    private String descripcion;

    @Column(name = "peso_paquete", nullable = false)
    private Double peso;

    @Column(name = "dimensiones_paquete", length = 50)
    private String dimensiones;

    @ManyToOne
    @JoinColumn(name = "id_cliente_fk")
    private Cliente cliente;
}
