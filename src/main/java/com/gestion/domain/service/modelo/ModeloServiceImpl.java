package com.gestion.domain.service.modelo;

import com.gestion.domain.repository.MarcaRepository;
import com.gestion.domain.repository.ModeloRepository;
import com.gestion.pesistence.dto.ModeloDto;
import com.gestion.pesistence.entity.Marca;
import com.gestion.pesistence.entity.Modelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  ModeloServiceImpl implements ModeloService{

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public Optional<Modelo> buscarModelo(String idModelo) {
        return modeloRepository.findById(idModelo);
    }

    @Override
    public Modelo listarModeloId(String idModelo) {
        Optional<Modelo> modelo = modeloRepository.findById(idModelo);
        return modelo.orElse(null);
    }

    @Override
    public List<Modelo> listarTodosLosModelo() {
        return modeloRepository.findAll();
    }
    @Override
    public void crearModelo(ModeloDto modeloDto) {
        if(modeloRepository.existsById(modeloDto.getIdModelo())){
            throw new RuntimeException("Ya existe un modelo con el ID proporcionado.");   
        } else {
            if (modeloDto.getMarcaId() == null) {
                throw new RuntimeException("El ID de la marca no puede ser nulo.");
            }
            Long marcaId = Long.parseLong(modeloDto.getMarcaId());
            Optional<Marca> marcaOptional = marcaRepository.findById(marcaId);
            Marca marca = marcaOptional.orElseThrow(() -> new RuntimeException("Marca no encontrada con el ID proporcionado."));
            Modelo modelo = new Modelo();
            modelo.setIdModelo(modeloDto.getIdModelo());
            modelo.setMarca(marca);
            modeloRepository.save(modelo);
        }
    }

   
}
