package com.prueba.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "envios")
public class Envio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_envio")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_paquete_fk", nullable = false)
    private Paquete paquete;

    @Column(name = "fecha_envio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;

    @Column(name = "fecha_estimada_entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEstimadaEntrega;

    @ManyToOne
    @JoinColumn(name = "id_cliente_remitente_fk")
    private Cliente remitente;

    @ManyToOne
    @JoinColumn(name = "id_cliente_destinatario_fk")
    private Cliente destinatario;

    @OneToMany(mappedBy = "envio")
    private List<HistorialSeguimiento> historialSeguimientos;
}
