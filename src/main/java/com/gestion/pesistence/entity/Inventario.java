package com.gestion.pesistence.entity;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "inventario")
@Getter @Setter
public class Inventario {
    @Id
    @Column(name = "cod_inventario" ,nullable = false,columnDefinition = "varchar(4)")
    private String codInventario;

    @Column(name = "stock" ,nullable = false,columnDefinition = "int")
    private int stock;

    @Column(name = "nombre_inventario" ,nullable = false,columnDefinition = "varchar(50)")
    private String nombreInventario;

    @Column(name = "precio_equipo" ,nullable = false,columnDefinition = "float")
    private double precioEquipo;


}