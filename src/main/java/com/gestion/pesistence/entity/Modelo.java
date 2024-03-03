package com.gestion.pesistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "modelo")
@Getter @Setter
public class Modelo {

    @Id
    @Column(name = "id_modelo" ,nullable = false,columnDefinition = "varchar(20)")
    private String idModelo ;


    @ManyToOne
    @JoinColumn(name = "fk_id_marca")
    private Marca marca;

    @OneToMany(mappedBy = "modelo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Computador> computador ;


}
