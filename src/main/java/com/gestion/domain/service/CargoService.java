package com.gestion.domain.service;

import com.gestion.pesistence.entity.Cargo;

import java.util.List;

public interface CargoService {
    List<Cargo> listarCargo();
    void crearCargo(Cargo cargo);
    void actualizarCargo(Cargo cargo);
    void eliminarCargo(Long cargoId);
}
