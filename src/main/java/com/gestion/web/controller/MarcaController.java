package com.gestion.web.controller;

import com.gestion.domain.service.marca.MarcaService;
import com.gestion.pesistence.entity.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarcaController {
    @Autowired
    private MarcaService marcaService ;

   
    @RequestMapping(value = Ruta.RUTA_MARCA, method = RequestMethod.GET)
    public List<Marca> listarTodasLasMarcas() {
        return marcaService.listarTodasLasMarca();
    }

    @RequestMapping(value = Ruta.RUTA_MARCA_BUSQUEDA, method = RequestMethod.GET)
    public Marca listarMarca(@PathVariable long idMarca) {
        return marcaService.listarMarcaId(idMarca);
    }

    @RequestMapping(value = Ruta.RUTA_MARCA_MODIFICACION  , method = RequestMethod.POST)
    public void crearMarca(@RequestBody Marca marca) {
        marcaService.crearMarca(marca);
    }

    @RequestMapping(value = Ruta.RUTA_MARCA_MODIFICACION, method = RequestMethod.PUT)
    public void modificarMarca(@RequestBody Marca marca) {
        marcaService.modificarMarca(marca);
    }
}
