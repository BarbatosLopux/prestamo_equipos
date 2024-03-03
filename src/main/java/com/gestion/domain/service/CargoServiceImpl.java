package com.gestion.domain.service;

import com.gestion.domain.repository.CargoRepository;
import com.gestion.pesistence.entity.Cargo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@Transactional
public class CargoServiceImpl implements CargoService{
    @Autowired
    private CargoRepository cargoRepository ;

    @Override
    public List<Cargo> listarCargo() {
        return cargoRepository.findAll();
    }

    @Override
    public void crearCargo(Cargo cargo) {
        cargoRepository.save(cargo);
    }

    @Override
    public void actualizarCargo(Cargo cargo) {
        //falta implementacion
    }

    @Override
    public void eliminarCargo(Long cargoId) {
        cargoRepository.deleteById(cargoId);
    }
}
