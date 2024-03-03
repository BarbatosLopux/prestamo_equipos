package com.gestion.web.controller;

public interface Ruta {

    //RUTA PRINCIPAL ABSOLUTA
    String RUTA_PRINCIPAL = "/api";

    //RUTAS ABSOLUTA Y RELATICVA DE CARGO
    String RUTA_CARGO = "/api/cargo/all";
    String RUTA_CARGO_BUSQUEDA = "api/cargo/{idCargo}";
    String RUTA_CARGO_MODIFICACION = "api/cargo";
    /////////////////////////////////////

    
    //RUTAS ABSOLUTA Y RELATICVA DE EMPLEADO
    String RUTA_EMPLEADO = "/api/empleado/all";
    String RUTA_EMPLEADO_BUSQUEDA = "api/empleado/{dniEmpleado}";
    String RUTA_EMPLEADO_MODIFICACION = "api/empleado";

    String RUTA_ACTA = "/api/acta/all";
    String RUTA_INVENTARIO = "/api/inventario/all";

    String RUTA_MARCA = "/api/marca/all";
    String RUTA_MODELO = "/api/marca/all";

    String RUTA_COMPUTADOR = "/api/computador/all";




}

