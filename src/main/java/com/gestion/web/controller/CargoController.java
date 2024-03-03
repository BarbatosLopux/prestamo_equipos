package com.gestion.web.controller;

import com.gestion.domain.service.cargo.CargoService;
import com.gestion.pesistence.entity.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CargoController {
    @Autowired
    private CargoService cargoService ;

    @RequestMapping(value = "/api/cargo/all")
    public List<Cargo> listaCargo (){
        return cargoService.listarCargo();
    }
}
