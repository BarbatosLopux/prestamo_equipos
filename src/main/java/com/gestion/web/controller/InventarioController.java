package com.gestion.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.domain.service.inventario.InventarioService;
import com.gestion.pesistence.entity.Inventario;

@RestController
public class InventarioController {
    
    @Autowired
    private  InventarioService inventarioService ;

    @RequestMapping(value = Ruta.RUTA_INVENTARIO,method = RequestMethod.GET)
    public List<Inventario> listarTodo() {
        return inventarioService.listarTodosLosInventario();
    }

    @RequestMapping(value = Ruta.RUTA_INVENTARIO_BUSQUEDA,method = RequestMethod.GET)
    public Inventario listarInventario(@PathVariable String codInventario) {
        return inventarioService.listarInventarioId(codInventario);
    }

    @RequestMapping(value = Ruta.RUTA_INVENTARIO_MODIFICACION, method = RequestMethod.POST)
    public void crearInventario(@RequestBody Inventario inventario) {
        inventarioService.crearInventario(inventario);
    }

    
    @RequestMapping(value = Ruta.RUTA_INVENTARIO_MODIFICACION,method = RequestMethod.PUT)
    public  void modificarInventario(@RequestBody Inventario inventario){
        inventarioService.modificarInventario(inventario);
    }
    

}
