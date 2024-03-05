package com.gestion.domain.service.computador;

import com.gestion.pesistence.dto.ComputadorDto;
import com.gestion.pesistence.entity.Computador;
import java.util.*;


public interface ComputadorService {
    List<Computador> listarTodoslosComputador();
    Optional<Computador> buscarComputadorId(String serialComputador);
    Computador listarComputadorId(String serialComputador);
    void  crearComputador(ComputadorDto computadorDto);
    void modificarComputador(Computador computador);
    void desactivarComputador(String serialComputador);
}
