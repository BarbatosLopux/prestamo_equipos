package com.gestion.pesistence.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;



@Entity
@Table(name = "empleado")
@Getter @Setter
public class Empleado {
    @Id
    @Column(name = "dni_empleado" ,nullable = false,columnDefinition = "BIGINT ")
    private Long dniEmpleado;

    @Column(name = "nombre" ,nullable = false,columnDefinition = "varchar(50) ")
    private String nombre;

    @Column(name = "apellido" ,nullable = false,columnDefinition = "varchar(50) ")
    private String apellido;


    @Column(name = "fecha_nacimiento" ,nullable = false,columnDefinition = "date ")
    private Date fechaNacimiento;

    @Column(name = "estado_empleado" ,nullable = false,columnDefinition = "tinyint(1)")
    private int estadoEmpleado;

    @Column(name = "telefono" ,nullable = false,columnDefinition = "varchar(50) ")
    private String telefono;

    @Column(name = "email" ,nullable = true,columnDefinition = "varchar(255) ")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private SexoEmpleado sexo;

    @ManyToOne
    @JoinColumn(name = "fk_id_cargo")
    private Cargo cargo;
}
