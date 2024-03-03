package com.gestion.web.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = Ruta.RUTA_PRINCIPAL)
public class PrincipalController  {

    @GetMapping
    public Map<String, String> rutaPrincipal() {
        Map<String, String> misRutas = new HashMap<>();
        misRutas.put("cargo", Ruta.RUTA_CARGO);
        misRutas.put("empleado", Ruta.RUTA_EMPLEADO);
        misRutas.put("acta", Ruta.RUTA_ACTA);
        misRutas.put("inventario", Ruta.RUTA_INVENTARIO);
        misRutas.put("marca", Ruta.RUTA_MARCA);
        misRutas.put("modelo", Ruta.RUTA_MODELO);
        misRutas.put("computador", Ruta.RUTA_COMPUTADOR);

        return misRutas;
    }

}