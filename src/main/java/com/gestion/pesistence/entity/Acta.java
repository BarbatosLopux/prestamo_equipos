package com.gestion.pesistence.entity;
import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Entity
@Table(name = "acta")
@Getter @Setter
public class Acta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_acta" ,nullable = false,columnDefinition = "BIGINT ")
    private Long numeroActa;

    @Column(name = "fecha_entrega" ,nullable = false,columnDefinition = "DATE")
    private Date fechaEntrega;

    @Column(name = "fecha_recibido" ,nullable = false,columnDefinition = "DATE")
    private Date fechaRecibido;

    @ManyToOne
    @JoinColumn(name = "fk_serial_computador")
    private Computador computador;

    @ManyToOne
    @JoinColumn(name = "fk_dni_empleado")
    private Empleado empleado;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_acta")
    private EstadoActa estadoActa;

    
}