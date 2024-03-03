package com.gestion.web.controller;

import com.gestion.domain.service.empleado.EmpleadoService;
import com.gestion.pesistence.entity.Empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = Ruta.RUTA_EMPLEADO)
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService ;

    @GetMapping
    public List<Empleado> listarTodo() {
        return empleadoService.listarEmpleado();
    }



}
