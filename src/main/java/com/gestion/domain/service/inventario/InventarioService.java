package com.gestion.domain.service.inventario;

import java.util.List;
import java.util.Optional;
import com.gestion.pesistence.entity.Inventario;

public interface InventarioService {
    Optional<Inventario> buscarInventario(String codInventario);
    Inventario listarInventarioId(String codInventario);
    List<Inventario> listarTodosLosInventario();
    void  crearInventario(Inventario inventario);
    void modificarInventario(Inventario inventario);
}
