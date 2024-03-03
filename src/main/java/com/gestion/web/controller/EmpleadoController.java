package com.gestion.web.controller;

import com.gestion.domain.service.EmpleadoService;
import com.gestion.pesistence.entity.Empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/empleado/all")

public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService ;



   @GetMapping
   public List<Empleado> listarEmpleado() {
        return empleadoService.listarEmpleado();
    }
//
//    @GetMapping("/{dni_empleado}") // Suponiendo que el dni_empleado se pasa como parte de la URL
//    public void eliminarEmpleado(@PathVariable String dni_empleado) {
//        empleadoService.eliminarEmpleado(dni_empleado);
//    }

}
