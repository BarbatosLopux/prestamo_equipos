package com.gestion.web.controller;

public interface Ruta {

    
    String RUTA_PRINCIPAL = "/api";

    
    String RUTA_CARGO = "/api/cargo/all";
    String RUTA_CARGO_BUSQUEDA = "api/cargo/{idCargo}";
    String RUTA_CARGO_MODIFICACION = "api/cargo";
    
    String RUTA_EMPLEADO = "/api/empleado/all";
    String RUTA_EMPLEADO_BUSQUEDA = "/api/empleado/{dniEmpleado}";
    String RUTA_EMPLEADO_MODIFICACION = "/api/empleado";

    String RUTA_ACTA = "/api/acta/all";
   

    String RUTA_MARCA = "/api/marca/all";
    String RUTA_MARCA_BUSQUEDA = "/api/marca/{idMarca}";
    String RUTA_MARCA_MODIFICACION = "/api/marca";

    String RUTA_MODELO = "/api/modelo/all";
    String RUTA_MODELO_BUSQUEDA = "/api/modelo/{idModelo}";
    String RUTA_MODELO_MODIFICACION = "/api/modelo";

    String RUTA_INVENTARIO = "/api/inventario/all";
    String RUTA_INVENTARIO_BUSQUEDA = "/api/inventario/{codInventario}";
    String RUTA_INVENTARIO_MODIFICACION = "/api/inventario";

    String RUTA_COMPUTADOR = "/api/computador/all";
    String RUTA_COMPUTADOR_BUSQUEDA = "/api/computador/{serialComputador}";
    String RUTA_COMPUTADOR_MODIFICACION = "/api/computador";




}

