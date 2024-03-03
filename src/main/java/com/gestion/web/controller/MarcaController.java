package com.gestion.web.controller;

import com.gestion.domain.service.marca.MarcaServiceImpl;
import com.gestion.pesistence.entity.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/marca/all")
public class MarcaController {
    @Autowired
    private MarcaServiceImpl MarcaServiceImpl ;

    @GetMapping
    public List<Marca> listarMarca(){
        return  MarcaServiceImpl.listarMarca();
    }
}
