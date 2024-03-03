package com.gestion.domain.service.computador;

import com.gestion.domain.repository.ComputadorRepository;
import com.gestion.pesistence.entity.Computador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputadorServiceImpl implements ComputadorService{

    @Autowired
    private ComputadorRepository computadorRepository ;

    @Override
    public List<Computador> getComputador() {
        return computadorRepository.findAll();
    }
}
