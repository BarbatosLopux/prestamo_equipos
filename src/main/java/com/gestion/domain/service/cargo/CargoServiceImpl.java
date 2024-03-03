package com.gestion.domain.service.cargo;

import com.gestion.domain.repository.CargoRepository;
import com.gestion.pesistence.entity.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoServiceImpl implements CargoService{

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public Optional<Cargo> buscarCargo(long idCargo) {
        return cargoRepository.findById(idCargo);
    }

    @Override
    public List<Cargo> listarCargo() {
        return cargoRepository.findAll();
    }

    @Override
    public Cargo listarCargoId(long idCargo) {

        var cargoOptional = buscarCargo(idCargo);
        if (!cargoOptional.isPresent()) {
            throw new RuntimeException("El cargo que intentas listar no se encuentra en la base de datos.");    
        }else{
            return cargoOptional.get();
        }
        
        
    }

    @Override
    public void crearCargo(Cargo cargo) {  
        if(!cargoRepository.mapeoNombreCargo(cargo.getNombreCargo()).isEmpty()){
            throw new RuntimeException("El nombre del cargo que se desea crear ya lo tiene otro cargo.");   
        }else{
            cargoRepository.save(cargo);
        }
        
    
    }

    @Override
    public void modificarCargo(Cargo cargo) {
        if(!buscarCargo(cargo.getIdCargo()).isPresent()){
            throw new RuntimeException("El cargo que intentas modificar no  se encuentra en la base de datos.");
        }else{
            Cargo cargoExistente = buscarCargo(cargo.getIdCargo()).get();
            cargoExistente.setDescripcion(cargo.getDescripcion());
            cargoRepository.save(cargoExistente);
        }
    } 


}
