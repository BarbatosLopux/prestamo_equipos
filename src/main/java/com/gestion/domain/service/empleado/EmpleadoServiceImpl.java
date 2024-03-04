package com.gestion.domain.service.empleado;

import com.gestion.domain.repository.CargoRepository;
import com.gestion.domain.repository.EmpleadoRepository;
import com.gestion.pesistence.dto.EmpleadoDto;
import com.gestion.pesistence.entity.Cargo;
import com.gestion.pesistence.entity.Empleado;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;


    @Autowired
    private CargoRepository cargoRepository ;

    @Override
    public List<Empleado> listarEmpleado() {
        return empleadoRepository.findAll() ;
    }


    @Override
    public Optional<Empleado> buscarEmpleado(long dniEmpleado) {
        return empleadoRepository.findById(dniEmpleado);
    }


    @Override
    public Empleado listarEmpleadoId(long dniEmpleado) {
       var empleadoOptional = buscarEmpleado(dniEmpleado);
        if (!empleadoOptional.isPresent()) {
            throw new RuntimeException("El cargo que intentas listar no se encuentra en la base de datos.");    
        }else{
            return empleadoOptional.get();
        } 
    }


    
    public void crearEmpleado(EmpleadoDto empleadoDto) {
        if(empleadoRepository.existsById(empleadoDto.getDniEmpleado())){
            throw new RuntimeException("Ya existe un empleado con el DNI proporcionado.");   
        } else {
            Empleado empleado = new Empleado();
            // copia los campos de empleadoDto a empleado
            // ...
            Cargo cargo = cargoRepository.findById(empleadoDto.getCargoId())
                .orElseThrow(() -> new RuntimeException("Cargo no encontrado"));
            empleado.setCargo(cargo);
            empleadoRepository.save(empleado);
        }
    }

    @Override
    public void modificarEmpleado(Empleado empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarEmpleado'");
    }


    @Override
    public void desactivarEmpleado(long dniEmpleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'desactivarEmpleado'");
    }

   
}
