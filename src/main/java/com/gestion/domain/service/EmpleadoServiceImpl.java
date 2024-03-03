package com.gestion.domain.service;

import com.gestion.domain.repository.EmpleadoRepository;
import com.gestion.pesistence.entity.Empleado;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;


    @Override
    public List<Empleado> listarEmpleado() {
        return empleadoRepository.findAll();
    }

    @Override
    public void crearEmpleado(Empleado empleado) {

    }

    @Override
    public void actualizarEmpleado(Empleado empleado) {
        //falta implementacion
    }

    @Override
    public void eliminarEmpleado(String dni_empleado) {
    }
}
