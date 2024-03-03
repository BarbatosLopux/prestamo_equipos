package com.gestion.domain.service.modelo;

import com.gestion.domain.repository.ModeloRepository;
import com.gestion.pesistence.entity.Modelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  ModeloServiceImpl implements ModeloService{

    @Autowired
    private ModeloRepository modeloRepository;
    @Override
    public List<Modelo> listaModelo() {
        return modeloRepository.findAll();
    }
}
