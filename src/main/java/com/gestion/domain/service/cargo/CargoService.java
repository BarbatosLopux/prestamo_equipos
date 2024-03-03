package com.gestion.domain.service.cargo;

import com.gestion.pesistence.entity.Cargo;

import java.util.List;
import java.util.Optional;

public interface CargoService {

    Optional<Cargo> buscarCargo(long idCargo);

    Cargo listarCargoId(long idCargo);
    List<Cargo> listarCargo();
    void  crearCargo(Cargo cargo);

    void modificarCargo(Cargo cargo);

}
