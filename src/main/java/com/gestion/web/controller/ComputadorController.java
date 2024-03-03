package com.gestion.web.controller;

import com.gestion.domain.service.computador.ComputadorServiceImpl;
import com.gestion.pesistence.entity.Computador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComputadorController {
    @Autowired
    private ComputadorServiceImpl computadorServiceImpl ;


    @RequestMapping(value = "/a")
    public List<Computador> listaPc(){
        return  computadorServiceImpl.getComputador();
    }


}
