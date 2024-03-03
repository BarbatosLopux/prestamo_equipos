package com.gestion.web.controller;

import com.gestion.domain.service.acta.ActaService;
import com.gestion.pesistence.entity.Acta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = Ruta.RUTA_ACTA)
public class ActaController  {

    @Autowired
    private ActaService actaService ;

    @GetMapping
    public List<Acta> listarTodo(){
        return actaService.listarActa();
    };
}
