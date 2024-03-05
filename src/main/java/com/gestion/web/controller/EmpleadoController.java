package com.gestion.web.controller;

import com.gestion.domain.service.empleado.EmpleadoService;
import com.gestion.pesistence.dto.EmpleadoDto;
import com.gestion.pesistence.entity.Empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService ;

    @RequestMapping(value = Ruta.RUTA_EMPLEADO,method = RequestMethod.GET)
    public List<Empleado> listarTodo() {
        return empleadoService.listarTodoslosEmpleado();
    }

    @RequestMapping(value = Ruta.RUTA_EMPLEADO_BUSQUEDA,method = RequestMethod.GET)
    public Empleado listarEmpleado(@PathVariable long dniEmpleado) {
        return empleadoService.listarEmpleadoId(dniEmpleado);
    }

    @RequestMapping(value = Ruta.RUTA_EMPLEADO_MODIFICACION,method = RequestMethod.POST)
    public void  creoEmpleado(@RequestBody EmpleadoDto empleadoDto){
        empleadoService.crearEmpleado(empleadoDto);
    }


    @RequestMapping(value = Ruta.RUTA_EMPLEADO_MODIFICACION, method = RequestMethod.PUT)
    public void modificarEmpleado(@RequestBody Empleado empleado) {
        empleadoService.modificarEmpleado(empleado);
    }
    
    //con este controllador quiero permitir la desactivacion del usuario
    @RequestMapping(value = Ruta.RUTA_EMPLEADO_MODIFICACION, method = RequestMethod.DELETE)
    public void desactivarEmpleado(@RequestBody Empleado empleado) {
        empleadoService.desactivarEmpleado(empleado.getDniEmpleado());
    }
  
}
