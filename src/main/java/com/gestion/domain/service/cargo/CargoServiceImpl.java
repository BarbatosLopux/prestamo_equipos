package com.gestion.domain.service.cargo;

import com.gestion.domain.repository.CargoRepository;
import com.gestion.pesistence.entity.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CargoServiceImpl implements CargoService{

    @Autowired
    private CargoRepository CargoRepository;
    @Override
    public List<Cargo> listarCargo() {
        return CargoRepository.findAll();
    }
}
