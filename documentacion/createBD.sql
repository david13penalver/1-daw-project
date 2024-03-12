-- Creación de las tablas

-- Tabla Pais
CREATE TABLE Pais (
  id_pais INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  PRIMARY KEY (id_pais)
);

-- Tabla Ciudad
CREATE TABLE Ciudad (
  id_ciudad INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  id_pais INT NOT NULL,
  PRIMARY KEY (id_ciudad),
  FOREIGN KEY (id_pais) REFERENCES Pais(id_pais)
);

-- Tabla Calle
CREATE TABLE Calle (
  id_calle INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  id_ciudad INT NOT NULL,
  PRIMARY KEY (id_calle),
  FOREIGN KEY (id_ciudad) REFERENCES Ciudad(id_ciudad)
);

-- Tabla Portal
CREATE TABLE Portal (
  id_portal INT NOT NULL AUTO_INCREMENT,
  numero INT NOT NULL,
  id_calle INT NOT NULL,
  PRIMARY KEY (id_portal),
  FOREIGN KEY (id_calle) REFERENCES Calle(id_calle)
);

-- Tabla Piso
CREATE TABLE Piso (
  id_piso INT NOT NULL AUTO_INCREMENT,
  numero INT NOT NULL,
  id_portal INT NOT NULL,
  PRIMARY KEY (id_piso),
  FOREIGN KEY (id_portal) REFERENCES Portal(id_portal)
);

-- Tabla Puerta
CREATE TABLE Puerta (
  id_puerta INT NOT NULL AUTO_INCREMENT,
  numero INT NOT NULL,
  id_piso INT NOT NULL,
  PRIMARY KEY (id_puerta),
  FOREIGN KEY (id_piso) REFERENCES Piso(id_piso)
);

-- Tabla Cliente
CREATE TABLE Cliente (
  id_cliente INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  apellido1 VARCHAR(255) NOT NULL,
  apellido2 VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  telefono VARCHAR(255) NOT NULL,
  id_puerta INT NOT NULL,
  PRIMARY KEY (id_cliente),
  FOREIGN KEY (id_puerta) REFERENCES Puerta(id_puerta)
);

-- Tabla Producto
CREATE TABLE Producto (
  id_producto INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  descripcion VARCHAR(255) NOT NULL,
  precio DECIMAL(10,2) NOT NULL,
  cantidad_stock INT NOT NULL,
  imagen VARCHAR(255) NOT NULL,
  tipo VARCHAR(255) NOT NULL,
  PRIMARY KEY (id_producto)
);

-- Tabla Carrito
CREATE TABLE Carrito (
  id_carrito INT NOT NULL AUTO_INCREMENT,
  id_cliente INT NOT NULL,
  fecha_creacion DATETIME NOT NULL,
  fecha_cierre DATETIME,
  estado VARCHAR(255) NOT NULL,
  PRIMARY KEY (id_carrito),
  FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

-- Tabla Añade
CREATE TABLE Añade (
  id_carrito INT NOT NULL,
  id_producto INT NOT NULL,
  cantidad_producto INT NOT NULL,
  PRIMARY KEY (id_carrito, id_producto),
  FOREIGN KEY (id_carrito) REFERENCES Carrito(id_carrito),
  FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);

-- Insertar datos de prueba

-- Insertar países
INSERT INTO Pais (nombre) VALUES ('España'), ('Francia'), ('Italia');

-- Insertar ciudades
INSERT INTO Ciudad (nombre, id_pais) VALUES ('Valencia', 1), ('Madrid', 1), ('París', 2), ('Roma', 3);

-- Insertar calles
INSERT INTO Calle (nombre, id_ciudad) VALUES ('Calle Mayor', 1), ('Gran Vía', 1), ('Rue de Rivoli', 2), ('Via del Corso', 3);

-- Insertar portales
INSERT INTO Portal (numero, id_calle) VALUES (1, 1), (2, 1), (3, 2), (4, 3);

-- Insertar pisos
INSERT INTO Piso (numero, id_portal) VALUES (1, 1), (2, 1), (3, 2), (4, 3);

-- Insertar puertas
INSERT INTO Puerta (numero, id_piso) VALUES (1, 1), (2, 1), (3, 1), (4, 1), (1, 2);

-- Insertar clientes
INSERT INTO Cliente (nombre, apellido1, apellido2, email, telefono, id_puerta) 
VALUES 
('Ana', 'García', 'López', 'ana.garcia@email.com', '123456789', 1),
('Juan', 'Pérez', 'Martínez', 'juan.perez@email.com', '987654321', 2),
('María', 'Gómez', 'Fernández', 'maria.gomez@email.com', '123456789', 3);

-- Insertar productos
INSERT INTO Producto (nombre, descripcion, precio, cantidad_stock, imagen, tipo) 
VALUES
('Camiseta', 'Camiseta de algodón talla M', 19.99, 10, 'imagen_camiseta.jpg', 'Ropa'),
('Zapatos', 'Zapatos de piel talla 40', 49.99, 5, 'imagen_zapatos.jpg', 'Calzado'),
('Libro', 'Libro de novela', 15.99, 20, 'imagen_libro.jpg', 'Libros'),
('Teléfono móvil', 'Teléfono móvil de última generación', 699.99, 2, 'imagen_movil.jpg', 'Tecnología');

-- Insertar carritos
INSERT INTO Carrito (id_cliente, fecha_creacion, fecha_cierre, estado) 
VALUES
(1, '2024-03-12', NULL, 'Abierto'),
(2, '2024-03-11', '2024-03-11', 'Cerrado');

-- Insertar productos en carritos
INSERT INTO Añade (id_carrito, id_producto, cantidad_producto) 
VALUES
(1, 1, 1),
(1, 2, 2),
(2, 3, 1);
