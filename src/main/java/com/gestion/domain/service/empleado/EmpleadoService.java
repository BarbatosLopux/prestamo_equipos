package com.gestion.domain.service.empleado;
import com.gestion.pesistence.dto.EmpleadoDto;
import com.gestion.pesistence.entity.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    List<Empleado> listarTodoslosEmpleado();
    Optional<Empleado> buscarEmpleado(long dniEmpleado);
    Empleado listarEmpleadoId(long dniEmpleado);
    void  crearEmpleado(EmpleadoDto empleadoDto);
    void modificarEmpleado(Empleado empleado);
    void desactivarEmpleado(long dniEmpleado);
    
}
