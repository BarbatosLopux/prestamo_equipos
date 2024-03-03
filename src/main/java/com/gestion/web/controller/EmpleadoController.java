package com.gestion.web.controller;

import com.gestion.domain.service.empleado.EmpleadoService;
import com.gestion.pesistence.entity.Empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService ;

    @RequestMapping(value = Ruta.RUTA_EMPLEADO,method = RequestMethod.GET)
    public List<Empleado> listarTodo() {
        return empleadoService.listarEmpleado();
    }

    @RequestMapping(value = Ruta.RUTA_EMPLEADO_BUSQUEDA,method = RequestMethod.GET)
    public Empleado listarEmpleado(@PathVariable long dniEmpleado) {
        return empleadoService.listarEmpleadoId(dniEmpleado);
    }

     @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

}
