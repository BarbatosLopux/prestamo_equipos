package com.gestion.domain.service.modelo;

import com.gestion.pesistence.entity.Marca;
import com.gestion.pesistence.entity.Modelo;
import com.gestion.pesistence.dto.ModeloDto;

import java.util.List;
import java.util.Optional;

public interface ModeloService {
    Optional<Modelo> buscarModelo(String idModelo);
    Modelo listarModeloId(String idModelo);
    List<Modelo> listarTodosLosModelo();
    void  crearModelo(ModeloDto modeloDto);

}
