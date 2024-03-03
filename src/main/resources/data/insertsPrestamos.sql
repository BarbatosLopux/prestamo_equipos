-- Active: 1709346232770@@127.0.0.1@3306@prestamodb



USE prestamoDb ;
INSERT INTO cargo (nombre_cargo, descripcion)
VALUES
    ('Gerente', 'Responsable de la gestión general'),
    ('Técnico', 'Encargado del mantenimiento y reparación'),
    ('Administrativo', 'Encargado de tareas administrativas'),
    ('Vendedor', 'Encargado de la venta de productos'),
    ('Analista', 'Encargado del análisis de datos'),
    ('Diseñador', 'Encargado del diseño gráfico'),
    ('Ingeniero', 'Encargado del desarrollo de software'),
    ('Contador', 'Encargado de la contabilidad y finanzas'),
    ('Recursos Humanos', 'Encargado de la gestión del personal'),
    ('Soporte Técnico', 'Encargado de brindar soporte técnico');

INSERT INTO empleado (dni_empleado, nombre, apellido, fk_id_cargo, fecha_nacimiento, estado_empleado, telefono, email, sexo)
VALUES
    (123456789, 'Juan', 'Perez', 1, '1990-05-15', 1, '1234567890', 'juan.perez@example.com', 'HOMBRE'),
    (987654321, 'Maria', 'Gonzalez', 2, '1988-09-25', 1, '9876543210', 'maria.gonzalez@example.com', 'MUJER'),
    (555555555, 'Carlos', 'Lopez', 1, '1995-02-10', 1, '5555555555', 'carlos.lopez@example.com', 'HOMBRE'),
    (444444444, 'Laura', 'Martinez', 2, '1992-11-20', 1, '4444444444', 'laura.martinez@example.com', 'MUJER'),
    (333333333, 'Pedro', 'Ramirez', 3, '1985-08-12', 1, '3333333333', 'pedro.ramirez@example.com', 'hombre'),
    (222222222, 'Ana', 'Garcia', 3, '1998-04-18', 1, '2222222222', 'ana.garcia@example.com', 'mujer'),
    (666666666, 'Diego', 'Rodriguez', 2, '1993-06-30', 1, '6666666666', 'diego.rodriguez@example.com', 'hombre'),
    (777777777, 'Sofia', 'Hernandez', 1, '1980-12-05', 1, '7777777777', 'sofia.hernandez@example.com', 'mujer'),
    (888888888, 'Marcela', 'Diaz', 3, '1990-07-25', 1, '8888888888', 'marcela.diaz@example.com', 'mujer'),
    (999999999, 'Raul', 'Sanchez', 2, '1987-03-08', 1, '9999999999', 'raul.sanchez@example.com', 'hombre');


INSERT INTO marca (nombre_marca)
VALUES
    ('Lenovo'),
    ('Apple'),
    ('Dell'),
    ('HP'),
    ('Acer'),
    ('Asus'),
    ('Microsoft'),
    ('Samsung'),
    ('Sony'),
    ('Toshiba');

INSERT INTO modelo (id_modelo, fk_id_marca)
VALUES
    ('MOD1', 1),
    ('MOD2', 2),
    ('MOD3', 1),
    ('MOD4', 3),
    ('MOD5', 2),
    ('MOD6', 3),
    ('MOD7', 1),
    ('MOD8', 2),
    ('MOD9', 1),
    ('MO10', 3);

INSERT INTO inventario (cod_inventario, stock, nombre_inventario, precio_equipo)
VALUES
    ('INV1', 50, 'Teclado', 20.00),
    ('INV2', 30, 'Mouse', 15.00),
    ('INV3', 20, 'Monitor', 150.00),
    ('INV4', 10, 'Impresora', 100.00),
    ('INV5', 40, 'Webcam', 30.00),
    ('INV6', 15, 'Auriculares', 25.00),
    ('INV7', 25, 'Disco Duro Externo', 80.00),
    ('INV8', 35, 'Altavoces', 50.00),
    ('INV9', 5, 'Router', 60.00),
    ('IN10', 60, 'Memoria USB', 10.00);


INSERT INTO computador (
serial_computador,
fk_cod_inventario,
fecha_adquisicion,
estado_equipo,
observaciones_equipo,
color,
cantidad_memoria_ram,
procesador,
tipo,
id_modelo_fk)
VALUES
    ('ABC123', 'INV1', '2023-01-15', 'bueno', 'Ninguna', 'Negro', 8, 'Intel Core i5', 'portatil', 'MOD1'),
    ('DEF456', 'INV2', '2023-03-20', 'regular', 'Algunos rasguños', 'Plata', 16, 'AMD Ryzen 7', 'MESA', 'MOD2'),
    ('GHI789', 'INV3', '2023-05-10', 'bueno', 'Nuevo', 'Gris', 16, 'Intel Core i7', 'portatil', 'MOD3'),
    ('JKL012', 'INV4', '2023-07-25', 'regular', 'Leves rayones', 'Blanco', 8, 'HP Ryzen 5', 'MESA', 'MOD4'),
    ('MNO345', 'INV5', '2023-09-18', 'bueno', 'Sin observaciones', 'Negro', 32, 'Apple M1', 'portatil', 'MOD5'),
    ('PQR678', 'INV6', '2023-11-30', 'malo', 'Pantalla rota', 'Negro', 4, 'AMD A6', 'MESA', 'MOD6'),
    ('STU901', 'INV7', '2024-02-15', 'bueno', 'Nuevo', 'Gris', 8, 'Intel Core i5', 'portatil', 'MOD7'),
    ('VWX234', 'INV8', '2024-04-20', 'regular', 'Leves marcas de uso', 'Plata', 16, 'Intel Core i7', 'MESA', 'MOD8'),
    ('YZA567', 'INV9', '2024-06-10', 'bueno', 'Sin observaciones', 'Negro', 8, 'AMD Ryzen 5', 'portatil', 'MOD9'),
    ('BCD890', 'IN10', '2024-08-05', 'regular', 'Algunos rasguños', 'Blanco', 4, 'Intel Core i3', 'MESA', 'MO10');


INSERT INTO acta (numero_acta, fecha_entrega, fecha_recibido, fk_serial_computador, fk_dni_empleado, estado_acta)
VALUES
    (1, '2024-02-28', '2024-03-01', 'ABC123', 123456789, 'entrega'),
    (2, '2024-02-28', '2024-03-01', 'DEF456', 987654321, 'recibo'),
    (3, '2024-02-28', '2024-03-01', 'GHI789', 555555555, 'entrega'),
    (4, '2024-02-28', '2024-03-01', 'JKL012', 444444444, 'recibo'),
    (5, '2024-02-28', '2024-03-01', 'MNO345', 333333333, 'entrega'),
    (6, '2024-02-28', '2024-03-01', 'PQR678', 222222222, 'recibo'),
    (7, '2024-02-28', '2024-03-01', 'STU901', 666666666, 'entrega'),
    (8, '2024-02-28', '2024-03-01', 'VWX234', 777777777, 'recibo'),
    (9, '2024-02-28', '2024-03-01', 'YZA567', 888888888, 'entrega'),
    (10, '2024-02-28', '2024-03-01', 'BCD890', 999999999, 'recibo');



