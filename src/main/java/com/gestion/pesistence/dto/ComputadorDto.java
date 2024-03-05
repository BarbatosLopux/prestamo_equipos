

package com.gestion.pesistence.dto;

import lombok.*;
import java.util.Date;
import com.gestion.pesistence.entity.EstadoEquipo;
import com.gestion.pesistence.entity.TipoComputador;

@Getter @Setter
public class ComputadorDto {

    private String serialComputador;
    private Date fechaAdquisicion;
    private EstadoEquipo estadoEquipo;
    private String observacionesEquipo;
    private String color;
    private int cantidadMemoriaRam;
    private String procesador;
    private TipoComputador tipoComputador;
    private String inventarioCodInventario; 
    private String modeloId; 
    private Boolean equipoActivo;


}