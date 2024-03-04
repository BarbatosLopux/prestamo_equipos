package com.gestion.pesistence.dto;
import  java.util.*;
import com.gestion.pesistence.entity.SexoEmpleado;

import lombok.*;




@Getter @Setter
public class EmpleadoDto {
    private long dniEmpleado;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private int estadoEmpleado;
    private String telefono;
    private String email;
    private SexoEmpleado sexo;
    private int cargoId; 
}
