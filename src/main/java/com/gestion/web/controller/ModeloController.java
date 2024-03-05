package com.gestion.web.controller;

import com.gestion.domain.service.cargo.CargoService;
import com.gestion.domain.service.modelo.ModeloService;
import com.gestion.pesistence.dto.EmpleadoDto;
import com.gestion.pesistence.dto.ModeloDto;
import com.gestion.pesistence.entity.Cargo;
import com.gestion.pesistence.entity.Modelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ModeloController {

     @Autowired
    private ModeloService modeloService ;


    @RequestMapping(value = Ruta.RUTA_MODELO,method = RequestMethod.GET )
    public List<Modelo> listarTodo (){
        return modeloService.listarTodosLosModelo();
    }


    @RequestMapping(value = Ruta.RUTA_MODELO_BUSQUEDA, method = RequestMethod.GET)
public ResponseEntity<Modelo> listarModelo(@PathVariable String idModelo) {
    Modelo modelo = modeloService.listarModeloId(idModelo);
    if (modelo != null) {
        return ResponseEntity.ok(modelo);
    } else {
        return ResponseEntity.notFound().build();
    }
}

     @RequestMapping(value = Ruta.RUTA_MODELO_MODIFICACION,method = RequestMethod.POST)
    public void  creoEmpleado(@RequestBody ModeloDto Modelodto){
        modeloService.crearModelo(Modelodto);
    }



}
