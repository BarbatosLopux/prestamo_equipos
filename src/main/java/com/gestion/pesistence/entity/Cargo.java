package com.gestion.pesistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "cargo")
@Getter @Setter
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo" ,nullable = false,columnDefinition = "BIGINT ")
    private Long idCargo;
    @Column(name = "nombre_cargo" ,nullable = false,columnDefinition = "VARCHAR(50)",unique = true)
    private String nombreCargo;
    @Column(name = "descripcion" ,nullable = true,columnDefinition = "VARCHAR(100)",unique = false)
    private String descripcion;

    // Getters and setters
}
