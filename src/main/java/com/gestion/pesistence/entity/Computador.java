package com.gestion.pesistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "computador")
@Getter @Setter
public class Computador {

    @Id
    @Column(name = "serial_computador" ,nullable = false,columnDefinition = "varchar(150)")
    private String serialComputador ;
    @Column(name = "fecha_adquisicion" ,nullable = false,columnDefinition = "date")
    private Date fechaAdquisicion ;
    @Column(name = "estado_equipo" )
    @Enumerated(EnumType.STRING)
    private EstadoEquipo estadoEquipo ;
    @Column(name = "observaciones_equipo" ,nullable = true,columnDefinition = "varchar(100)")
    private String observacionesEquipo ;
    @Column(name = "color" ,nullable = false,columnDefinition = "varchar(10)")
    private String color ;
    @Column(name = "cantidad_memoria_ram" ,nullable = false,columnDefinition = "int")
    private int cantidadMemoriaRam ;
    @Column(name = "procesador" ,nullable = false,columnDefinition = "varchar(255)")
    private String procesador ;
    @Column(name = "tipo" )
    @Enumerated(EnumType.STRING)
    private TipoComputador tipoComputador ;

    @OneToOne(mappedBy = "computador")
    private Acta acta;

    @ManyToOne
    @JoinColumn(name = "id_modelo_fk")
    private Modelo modelo ;

     @ManyToOne
     @JoinColumn(name = "fk_cod_inventario")
     private Inventario inventario ;
}