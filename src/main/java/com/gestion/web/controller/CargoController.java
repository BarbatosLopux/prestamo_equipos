package com.gestion.web.controller;

import com.gestion.domain.service.cargo.CargoService;
import com.gestion.pesistence.entity.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CargoController {
    @Autowired
    private CargoService cargoService ;
    @RequestMapping(value = Ruta.RUTA_CARGO,method = RequestMethod.GET )
    public List<Cargo> listarTodo (){
        return cargoService.listarCargo();
    }


    @RequestMapping(value = Ruta.RUTA_CARGO_BUSQUEDA,method = RequestMethod.GET)
    public Cargo listarCargo(@PathVariable  long idCargo){
        return cargoService.listarCargoId(idCargo);
    }

    @RequestMapping(value = Ruta.RUTA_CARGO_MODIFICACION,method = RequestMethod.POST)
    public void crearCargo(@RequestBody Cargo cargo) {
        cargoService.crearCargo(cargo);
    }


    @RequestMapping(value = Ruta.RUTA_CARGO_MODIFICACION,method = RequestMethod.PUT)
    public void modificarCargo(@RequestBody Cargo cargo) {
        cargoService.modificarCargo(cargo);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
