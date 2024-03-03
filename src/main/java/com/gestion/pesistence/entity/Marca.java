package com.gestion.pesistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "marca")
@Getter @Setter
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca" ,nullable = false,columnDefinition = "bigint")
    private Long idMarca ;

    @Column(name = "nombre_marca" ,nullable = false,columnDefinition = "varchar(50)" ,unique = true)
    private String nombreMarca ;

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Modelo> modelo ;

}
