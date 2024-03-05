## Documentacion api



```json
cuerpo inventario put{
    "codInventario": "1233",
    "nombreInventario": "hola xd como van"
    
}

cuerpo inventario post{
    "codInventario": "1233",
    "stock" :12,
    "nombreInventario": "Inventario de pruebita 2 xd",
    "precioEquipo":1.233
    
}

cuerpo marca post{
   "nombreMarca":"esto es una marca"
}

cuerpo modelo post{
    "idModelo" :"sad23",
    "marcaId" : "1"
}
cuerpo cargo post{
    "nombreCargo": "Gerente",
    "descripcion": "Encargado de la gestión y administración de la empresa"
}
cuerpo empleado post{
    "dniEmpleado": 12345678,
    "nombre": "Juan",
    "apellido": "Perez",
    "fechaNacimiento": "1990-01-01",
    "estadoEmpleado": 1,
    "telefono": "1234567890",
    "email": "juan.perez@example.com",
    "sexo": "HOMBRE",
    "cargoId": 1
}

cuerpo computador post{
    "serialComputador": "123456789",
    "fechaAdquisicion": "2022-01-01T00:00:00.000+00:00",
    "estadoEquipo": "BUENO",
    "observacionesEquipo": "Observaciones sobre el equipo",
    "color": "Negro",
    "cantidadMemoriaRam": 8,
    "procesador": "Intel Core i7",
    "tipo": "MESA",
    "inventarioCodInventario": 1233,
    "modeloId": "sad23",
    "equipoActivo": true
}

```