package com.gestion.domain.service;

import com.gestion.pesistence.entity.Empleado;

import java.util.List;

public interface EmpleadoService {
    List<Empleado> listarEmpleado();
    void crearEmpleado(Empleado empleado);
    void actualizarEmpleado(Empleado empleado);
    void eliminarEmpleado(String dni_empleado);
}
