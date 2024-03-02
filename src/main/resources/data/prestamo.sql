
DROP DATABASE IF EXISTS prestamoDb ;

CREATE  database  prestamoDb ;


USE prestamoDb ;

CREATE TABLE IF NOT EXISTS empleado  (
 dni_empleado INT NOT NULL PRIMARY KEY,
 nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NULL,
    fk_id_cargo INT NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    estado_empleado TINYINT(1) NOT NULL ,
    telefono VARCHAR(50) NOT NULL,
    email VARCHAR(255) NULL,
    genero ENUM("hombre","mujer") NOT NULL

    );


CREATE TABLE  IF NOT EXISTS  inventario (
    cod_inventario VARCHAR(4) NOT NULL,
    stock INT NOT NULL,
    nombre_inventario VARCHAR(50) NOT NULL,
    precio_equipo DOUBLE(8, 2) NOT NULL,
    PRIMARY KEY(cod_inventario)
    );


CREATE TABLE  IF NOT EXISTS  modelos (
     id_modelo VARCHAR(20) NOT NULL,
    fk_id_marca INT NOT NULL,
    nombre_modelo VARCHAR(50) NOT NULL,
    PRIMARY KEY(id_modelo),
    UNIQUE modelos_nombre_modelo_unique(nombre_modelo)
    );


CREATE TABLE  IF NOT EXISTS   acta (
numero_acta INT NOT NULL,
fecha_entrega DATE NOT NULL,
fecha_recibido DATE NOT NULL,
fk_serial_computador VARCHAR(150) NOT NULL,
    fk_dni_empleado INT NOT NULL,
    estado_acta ENUM('entraga',"recibido") NOT NULL,
    PRIMARY KEY(numero_acta)
    );


CREATE TABLE  IF NOT EXISTS  marca (
    id_marca INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre_marca VARCHAR(50) NOT NULL,
    UNIQUE marca_nombre_marca_unique(nombre_marca)
    );


CREATE TABLE  IF NOT EXISTS  cargo (
    id_cargo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre_cargo VARCHAR(50) NOT NULL,
    descripcion VARCHAR(100) NULL,
    UNIQUE cargo_nombre_cargo_unique(nombre_cargo)
    );


CREATE TABLE  IF NOT EXISTS  computador (
     serial_computador VARCHAR(150) NOT NULL,
    fk_cod_inventario VARCHAR(4) NOT NULL,
    fecha_adquisicion DATE NOT NULL,
    estado_equipo ENUM('bueno',"regular","malo") NOT NULL,
    observaciones_equipo VARCHAR(100) NULL,
    color VARCHAR(10) NOT NULL,
    cantidad_memoria_ram INT NOT NULL,
    procesador VARCHAR(255) NOT NULL,
    tipo ENUM('escritorio',"portatil") NOT NULL,
    id_modelo_fk VARCHAR(20) NOT NULL,
    PRIMARY KEY(serial_computador),
    FOREIGN KEY(id_modelo_fk) REFERENCES modelos(id_modelo),
    FOREIGN KEY(fk_cod_inventario) REFERENCES inventario(cod_inventario)
    );


ALTER TABLE empleado ADD CONSTRAINT empleado_fk_id_cargo_foreign FOREIGN KEY(fk_id_cargo) REFERENCES cargo(id_cargo);


ALTER TABLE acta ADD CONSTRAINT acta_fk_dni_empleado_foreign FOREIGN KEY(fk_dni_empleado) REFERENCES empleado(dni_empleado);
ALTER TABLE acta ADD CONSTRAINT acta_fk_serial_computador_foreign FOREIGN KEY(fk_serial_computador) REFERENCES computador(serial_computador);


ALTER TABLE modelos ADD CONSTRAINT modelos_fk_id_marca_foreign FOREIGN KEY(fk_id_marca) REFERENCES marca(id_marca);
