package com.gestion.pesistence.entity;

import jakarta.persistence.*;
import java.util.Date;


@Entity
@Table(name="acta")
public class Acta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_acta" ,nullable = false,columnDefinition = "BIGINT ")
    private Long numeroActa ;
    @Column(name = "fecha_entrega" ,nullable = false,columnDefinition = "DATE")
    private Date fechaEntrega;
    @Column(name = "fecha_recibo" ,nullable = false,columnDefinition = "DATE")
    private Date fechaRecibo;

    @OneToOne
    @JoinColumn(name = "fk_serial_computador")
    private Computador computador ;

    @ManyToOne
    @JoinColumn(name = "fk_dni_empleado")
    private Empleado empleado ;

    @Column(name = "estado_acta" )
    @Enumerated(EnumType.STRING)
    private EstadoActa estadoActa ;



}
