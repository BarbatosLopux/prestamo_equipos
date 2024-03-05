package com.gestion.domain.service.computador;

import com.gestion.domain.repository.ComputadorRepository;
import com.gestion.domain.service.inventario.InventarioService;
import com.gestion.domain.service.modelo.ModeloService;
import com.gestion.pesistence.dto.ComputadorDto;
import com.gestion.pesistence.entity.Computador;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ComputadorServiceImpl implements ComputadorService{

    @Autowired
    private ComputadorRepository computadorRepository ;


    @Autowired 
    private ModeloService modeloService ;

    @Autowired 
    private InventarioService inventarioService ;



    @Override
    public List<Computador> listarTodoslosComputador() {
      return computadorRepository.findAll();
    }

    @Override
    public Optional<Computador> buscarComputadorId(String serialComputador) {
        return computadorRepository.findById(serialComputador);   
    }

    @Override
    public Computador listarComputadorId(String serialComputador) {
        var computadorBusqueda = buscarComputadorId(serialComputador);
        if (!computadorBusqueda.isPresent()) {
            throw new RuntimeException("El cargo que intentas listar no se encuentra en la base de datos.");    
        }else{
            return computadorBusqueda.get();
        } 
    }

    @Override
    public void crearComputador(ComputadorDto computadorDto) {
        var computadorBusqueda = buscarComputadorId(computadorDto.getSerialComputador());
        if(computadorBusqueda.isPresent()){
            throw new RuntimeException("El computador que intentas crear ya se encuentra en la base de datos.");    
        }else {
            // todos los modelos
            var modeloBusqueda = modeloService.buscarModelo(computadorDto.getModeloId());
            var inventarioBusqueda = inventarioService.buscarInventario(computadorDto.getInventarioCodInventario());
            
            if(!modeloBusqueda.isPresent() || !inventarioBusqueda.isPresent()){
                throw new RuntimeException("Modelo o inventario no encontrado en la base de datos");
            }
            else {  
                Computador  computador = new Computador() ;
                computador.setSerialComputador(computadorDto.getSerialComputador());
                computador.setFechaAdquisicion(computadorDto.getFechaAdquisicion());
                computador.setEstadoEquipo(computadorDto.getEstadoEquipo());
                computador.setObservacionesEquipo(computadorDto.getObservacionesEquipo());
                computador.setColor(computadorDto.getColor());
                computador.setCantidadMemoriaRam(computadorDto.getCantidadMemoriaRam());
                computador.setProcesador(computadorDto.getProcesador());
                computador.setTipo(computadorDto.getTipoComputador());
                computador.setInventario(inventarioBusqueda.get());
                computador.setModelo(modeloBusqueda.get());
                computador.setEquipoActivo(computadorDto.getEquipoActivo());

                computadorRepository.save(computador);
            }
        }

    }

    @Override
    public void modificarComputador(Computador computador) {
        var computadorBusqueda = buscarComputadorId(computador.getSerialComputador());
        if (!computadorBusqueda.isPresent()) {
            throw new RuntimeException("Computador no encontrado con el serial proporcionado.");
        }
    
        
    
        if (computador.getObservacionesEquipo() != null && !computador.getObservacionesEquipo().equals("")) {
            computadorBusqueda.get().setObservacionesEquipo(computador.getObservacionesEquipo());
        }
    
        if (computador.getCantidadMemoriaRam() != 0) {
            computadorBusqueda.get().setCantidadMemoriaRam(computador.getCantidadMemoriaRam());
        }
    
        if (computador.getProcesador() != null && !computador.getProcesador().equals("")) {
            computadorBusqueda.get().setProcesador(computador.getProcesador());
        }
    
        computadorRepository.save(computadorBusqueda.get());
    }


    
    @Override
    public void desactivarComputador(String serialComputador) {
        var computadorOptional = buscarComputadorId(serialComputador);
        if (!computadorOptional.isPresent()) {
            throw new RuntimeException("El computador que deseas desactivar  no se encuentra en la base datos");    
        } else {
            computadorRepository.modificarEstadoComputador(serialComputador, false);
        } 

        
    }

    

}

