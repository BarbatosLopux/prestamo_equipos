package com.gestion.web.controller;

import com.gestion.domain.service.empleado.EmpleadoService;
import com.gestion.pesistence.entity.Empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = Ruta.RUTA_EMPLEADO_MODIFICACION,method = RequestMethod.POST)
    public void  creoEmpleado(@RequestBody Empleado empleado){
        empleadoService.crearEmpleado(empleado);
    }


     @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

}
