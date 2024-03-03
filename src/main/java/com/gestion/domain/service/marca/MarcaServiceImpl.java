package com.gestion.domain.service.marca;

import com.gestion.domain.repository.MarcaRepository;
import com.gestion.pesistence.entity.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarcaServiceImpl implements MarcaService{
    @Autowired
    private MarcaRepository marcaRepository ;
    @Override
    public List<Marca> listarMarca() {
        return marcaRepository.findAll();
    }
}
