package com.gestion.pesistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @Column(name = "cod_inventario" ,nullable = false,columnDefinition = "varchar(4)")
    private String codInventario ;
    @Column(name = "stock" ,nullable = false,columnDefinition = "int")
    private int stock ;
    @Column(name = "nombre_inventario" ,nullable = false,columnDefinition = "varchar(50)")
    private String nombreInventario ;
    @Column(name = "precio_equipo" ,nullable = false,columnDefinition = "float")
    private float precioEquipo;

    @OneToMany(mappedBy = "inventario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Computador> computador ;
}
