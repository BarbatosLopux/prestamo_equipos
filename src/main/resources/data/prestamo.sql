
DROP DATABASE IF EXISTS prestamoDb ;

CREATE  database  prestamoDb ;


USE prestamoDb ;

CREATE TABLE IF NOT EXISTS empleado(
     dni_empleado BIGINT NOT NULL,
     nombre VARCHAR(50) NOT NULL,
     apellido VARCHAR(50) NOT NULL,
     fk_id_cargo BIGINT NOT NULL,
     fecha_nacimiento DATE NOT NULL,
     estado_empleado TINYINT NOT NULL,
     telefono VARCHAR(50) NOT NULL,
     email VARCHAR(255) NULL,
    sexo ENUM('HOMBRE','MUJER') NOT NULL,
     PRIMARY KEY(dni_empleado)
);




CREATE TABLE IF NOT EXISTS  modelo(
    id_modelo VARCHAR(20) NOT NULL,
    fk_id_marca BIGINT NOT NULL,
    PRIMARY KEY(id_modelo)
);
CREATE TABLE IF NOT EXISTS  acta(
     numero_acta BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     fecha_entrega DATE NOT NULL,
     fecha_recibido DATE NOT NULL,
     fk_serial_computador VARCHAR(150) NOT NULL,
     fk_dni_empleado BIGINT NOT NULL,
     estado_acta ENUM('ENTREGA','RECIBO') NOT NULL
);
CREATE TABLE IF NOT EXISTS  marca(
  id_marca BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre_marca VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS  cargo(
  id_cargo BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre_cargo VARCHAR(50) NOT NULL,
  descripcion VARCHAR(100) NULL
);

CREATE TABLE IF NOT EXISTS  computador(
   serial_computador VARCHAR(150) NOT NULL,
   fk_cod_inventario VARCHAR(4) NOT NULL,
   fecha_adquisicion DATE NOT NULL,
   estado_equipo ENUM('BUENO','REGULAR','MALO') NOT NULL,
   observaciones_equipo VARCHAR(100) NULL,
   color VARCHAR(10) NOT NULL,
   cantidad_memoria_ram INT NOT NULL,
   procesador VARCHAR(255) NOT NULL,
   tipo ENUM('MESA','PORTATIL') NOT NULL,
   id_modelo_fk VARCHAR(20) NOT NULL,
   PRIMARY KEY(serial_computador) ,
   equipo_activo tinyint(1) NOT  NULL
);

-- llaves unicas
ALTER TABLE
    marca ADD UNIQUE marca_nombre_marca_unique(nombre_marca);

ALTER TABLE
    cargo ADD UNIQUE cargo_nombre_cargo_unique(nombre_cargo);


-- llaves foraneas
ALTER TABLE
    computador ADD CONSTRAINT computador_id_modelo_fk_foreign FOREIGN KEY(id_modelo_fk) REFERENCES modelo(id_modelo);
ALTER TABLE
    modelo ADD CONSTRAINT modelo_fk_id_marca_foreign FOREIGN KEY(fk_id_marca) REFERENCES marca(id_marca);
ALTER TABLE
    computador ADD CONSTRAINT computador_fk_cod_inventario_foreign FOREIGN KEY(fk_cod_inventario) REFERENCES inventario(cod_inventario);
ALTER TABLE
    empleado ADD CONSTRAINT empleado_fk_id_cargo_foreign FOREIGN KEY(fk_id_cargo) REFERENCES cargo(id_cargo);
ALTER TABLE
    acta ADD CONSTRAINT acta_fk_dni_empleado_foreign FOREIGN KEY(fk_dni_empleado) REFERENCES empleado(dni_empleado);
ALTER TABLE
    acta ADD CONSTRAINT acta_fk_serial_computador_foreign FOREIGN KEY(fk_serial_computador) REFERENCES computador(serial_computador);