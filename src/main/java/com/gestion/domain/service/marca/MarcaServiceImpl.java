package com.gestion.domain.service.marca;

import com.gestion.domain.repository.MarcaRepository;
import com.gestion.pesistence.entity.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MarcaServiceImpl implements MarcaService{
    @Autowired
    private MarcaRepository marcaRepository ;

    @Override
    public Optional<Marca> buscarMarca(long idMarca) {
        return marcaRepository.findById(idMarca);
    }

    
    @Override
    public List<Marca> listarTodasLasMarca() {
        return marcaRepository.findAll();
    }


    @Override
    public Marca listarMarcaId(long idMarca) {
        var cargoOptional = buscarMarca(idMarca);
        if (!cargoOptional.isPresent()) {
            throw new RuntimeException("la marca que intentas listar no se encuentra en la base de datos.");    
        }else{
            return cargoOptional.get();
        }
    }

  
    @Override
    public void crearMarca(Marca marca) {
        if(!marcaRepository.mapeoNombreMarca(marca.getNombreMarca()).isEmpty()){
            throw new RuntimeException("El nombre de la marca que se desea crear ya lo tiene otra marca.");   
        }else{
            marcaRepository.save(marca);
        }
    }


    @Override
    public void modificarMarca(Marca marca) {
        if (marca.getNombreMarca() == null || marca.getNombreMarca().trim().isEmpty()) {
            return;
        }
        if (marca.getIdMarca() == null || !buscarMarca(marca.getIdMarca()).isPresent()) {
            throw new RuntimeException("La marca que intentas modificar no se encuentra en la base de datos.");
        } else {
            Marca marcaExistente = buscarMarca(marca.getIdMarca()).get();
            marcaExistente.setNombreMarca(marca.getNombreMarca());
            marcaRepository.save(marcaExistente);
        }
    }

 
   

   
}
