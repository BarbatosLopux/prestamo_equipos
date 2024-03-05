package com.gestion.domain.service.marca;
import com.gestion.pesistence.entity.Marca;

import java.util.List;
import java.util.Optional;

public interface MarcaService {
    Optional<Marca> buscarMarca(long idMarca);
    Marca listarMarcaId(long idMarca);
    List<Marca> listarTodasLasMarca();
    void  crearMarca(Marca marca);
    void modificarMarca(Marca marca);
}
