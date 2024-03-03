package com.gestion.web.controller;

import com.gestion.domain.service.modelo.ModeloService;
import com.gestion.pesistence.entity.Modelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/modelo/all")
public class ModeloController {

    @Autowired
    private ModeloService modeloService ;

    @GetMapping
    public List<Modelo> modeloListar (){
        return  modeloService.listaModelo();
    }


}
