package com.gestion.domain.service.inventario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.domain.repository.InventarioRepository;
import com.gestion.pesistence.entity.Inventario;

@Service
public class InventarioServiceImpl implements InventarioService{

     @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    public Optional<Inventario> buscarInventario(String codInventario) {
        return inventarioRepository.findById(codInventario);
    }

    @Override
    public Inventario listarInventarioId(String codInventario) {

        var inventarioBusqueda = buscarInventario(codInventario);
        if (!inventarioBusqueda.isPresent()) {
            throw new RuntimeException("El inventario que intentas listar no se encuentra en la base de datos.");    
        }else{
            return inventarioBusqueda.get();
        } 

        
    }

    @Override
    public List<Inventario> listarTodosLosInventario() {
        return inventarioRepository.findAll();
    }

    @Override
    public void crearInventario(Inventario inventario) {
        if (inventario.getCodInventario() == null) {
            throw new IllegalArgumentException("El código de inventario no puede ser nulo.");
        }
        Optional<Inventario> existingInventario = buscarInventario(inventario.getCodInventario());
        if (existingInventario.isPresent()) {
            throw new RuntimeException("El inventario ya existe con el código proporcionado.");
        } else {
            inventarioRepository.save(inventario);
        }
    }
        
    @Override
    public void modificarInventario(Inventario inventario) {
        Optional<Inventario> buscarInventario = inventarioRepository.findById(inventario.getCodInventario());
        if (!buscarInventario.isPresent()) {
            throw new RuntimeException("El inventario que desea modificar no se encuentra en la base de datos.");
        }
        Inventario inventarioExistente = buscarInventario.get();
        if (inventario.getNombreInventario() != null && !inventario.getNombreInventario().equals("")) {
            inventarioExistente.setNombreInventario(inventario.getNombreInventario());
        }

        inventarioRepository.save(inventarioExistente);
    }
    
}
