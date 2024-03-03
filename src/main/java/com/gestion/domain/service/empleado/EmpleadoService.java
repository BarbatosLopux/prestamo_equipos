package com.gestion.domain.service.empleado;

import com.gestion.pesistence.entity.Cargo;
import com.gestion.pesistence.entity.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    List<Empleado> listarEmpleado();
    Optional<Empleado> buscarEmpleado(long dniEmpleado);
    Empleado listarEmpleadoId(long dniEmpleado);
    void  crearEmpleado(Empleado empleado);
    void modificarEmpleado(Empleado empleado);
    void desactivarEmpleado(long dniEmpleado);
    
}
