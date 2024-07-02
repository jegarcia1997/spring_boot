package com.prueba.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "historial_seguimientos")
public class HistorialSeguimiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_envio_fk", nullable = false)
    private Envio envio;

    @Column(name = "fecha_hora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    @Column(name = "ubicacion_historial", nullable = false, length = 255)
    private String ubicacion;

    @Column(name = "estado_historial", nullable = false, length = 50)
    private String estado;
}
