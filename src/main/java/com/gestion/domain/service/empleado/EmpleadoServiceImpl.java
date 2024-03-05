package com.gestion.domain.service.empleado;

import com.gestion.domain.repository.CargoRepository;
import com.gestion.domain.repository.EmpleadoRepository;
import com.gestion.pesistence.dto.EmpleadoDto;
import com.gestion.pesistence.entity.Cargo;
import com.gestion.pesistence.entity.Empleado;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestion.domain.repository.CargoRepository;
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
    public List<Empleado> listarTodoslosEmpleado() {
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


    @Override
    public void crearEmpleado(EmpleadoDto empleadoDto) {
        if(empleadoRepository.existsById(empleadoDto.getDniEmpleado())){
            throw new RuntimeException("Ya existe un empleado con el DNI proporcionado.");   
        } else {
            System.out.println(empleadoDto.getCargoId());
            Optional<Cargo> cargoOptional = cargoRepository.findById(empleadoDto.getCargoId());
            Cargo cargo = cargoOptional.orElseThrow(() -> new RuntimeException("Cargo no encontrado con el ID proporcionado."));
            Empleado empleado = new Empleado();
            empleado.setDniEmpleado(empleadoDto.getDniEmpleado());
            empleado.setNombre(empleadoDto.getNombre());
            empleado.setApellido(empleadoDto.getApellido());
            empleado.setFechaNacimiento(empleadoDto.getFechaNacimiento());
            empleado.setEstadoEmpleado(empleadoDto.getEstadoEmpleado());
            empleado.setTelefono(empleadoDto.getTelefono());
            empleado.setEmail(empleadoDto.getEmail());
            empleado.setSexo(empleadoDto.getSexo());
            empleado.setCargo(cargo);
            empleadoRepository.save(empleado);
        }
    }


    @Override
    public void modificarEmpleado(Empleado empleado) {
        Optional<Empleado> empleadoExistenteOpt = empleadoRepository.findById(empleado.getDniEmpleado());

        if (!empleadoExistenteOpt.isPresent()) {
            throw new RuntimeException("Empleado no encontrado con el DNI proporcionado.");
        }

        Empleado empleadoExistente = empleadoExistenteOpt.get();

        if (empleado.getEmail() != null && !empleado.getEmail().equals("")) {
            empleadoExistente.setEmail(empleado.getEmail());
        }

        if (empleado.getTelefono() != null && !empleado.getTelefono().equals("")) {
            empleadoExistente.setTelefono(empleado.getTelefono());
        }

        empleadoRepository.save(empleadoExistente);
    }

    @Override
    public void desactivarEmpleado(long dniEmpleado) {
        var empleadoOptional = buscarEmpleado(dniEmpleado);
        if (!empleadoOptional.isPresent()) {
            throw new RuntimeException("El empleado que deseas modificar desactivar no se encuentra en la base datos");    
        }else{
            //desactivo al usuario
            empleadoRepository.modificarEstadoEmpleado(dniEmpleado,0);
        } 
    }



   
}
