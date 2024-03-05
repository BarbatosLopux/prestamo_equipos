package com.gestion.web.controller;

import com.gestion.domain.service.computador.ComputadorService;
import com.gestion.domain.service.computador.ComputadorServiceImpl;
import com.gestion.pesistence.dto.ComputadorDto;
import com.gestion.pesistence.entity.Computador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComputadorController {
    @Autowired
    private ComputadorService computadorService ;

    @RequestMapping(value = Ruta.RUTA_COMPUTADOR,method = RequestMethod.GET) 
     public List<Computador> listarTodo() {
        return computadorService.listarTodoslosComputador();
    }

    @RequestMapping(value = Ruta.RUTA_COMPUTADOR_MODIFICACION, method = RequestMethod.POST)
    public void creoComputador(@RequestBody ComputadorDto computadorDto) {
        computadorService.crearComputador(computadorDto);
    }

    
    
    @RequestMapping(value = Ruta.RUTA_COMPUTADOR_MODIFICACION, method = RequestMethod.PUT)
    public void modificarComputador(@RequestBody Computador computador) {
        computadorService.modificarComputador(computador);
    }

     
     @RequestMapping(value = Ruta.RUTA_COMPUTADOR_MODIFICACION, method = RequestMethod.DELETE)
     public void desactivarCompu(@RequestBody Computador computador) {
        computadorService.desactivarComputador(computador.getSerialComputador());
     }

}
