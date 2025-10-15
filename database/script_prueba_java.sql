CREATE DATABASE IF NOT EXISTS PRUEBA_JAVA
CHARACTER SET utf8mb4
COLLATE utf8mb4_general_ci;

USE PRUEBA_JAVA;

-- ================================================
-- TABLA: USUARIOS
-- ================================================
CREATE TABLE IF NOT EXISTS USUARIOS (
    ID_USUARIO VARCHAR(30) PRIMARY KEY,
    NOMBRE_USUARIO VARCHAR(255) NOT NULL UNIQUE,
    CONTRASENA VARCHAR(255) NOT NULL
);

-- ================================================
-- TABLA: PRODUCTOS_FAMILIAS
-- ================================================
CREATE TABLE IF NOT EXISTS PRODUCTOS_FAMILIAS (
    ID_FAMILIA INT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE_FAMILIA VARCHAR(255) NOT NULL
);

-- ================================================
-- TABLA: PRODUCTOS
-- ================================================
CREATE TABLE IF NOT EXISTS PRODUCTOS (
    ID_PRODUCTO INT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE_PRODUCTO VARCHAR(255) NOT NULL,
    ID_FAMILIA INT NOT NULL,
    PRECIO DECIMAL(10,2) NOT NULL,
    CONSTRAINT FK_PRODUCTO_FAMILIA FOREIGN KEY (ID_FAMILIA)
        REFERENCES PRODUCTOS_FAMILIAS(ID_FAMILIA)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- ================================================
-- DATOS INICIALES
-- ================================================
-- Usuarios de prueba
INSERT INTO USUARIOS (ID_USUARIO, NOMBRE_USUARIO, CONTRASENA)
VALUES
('U001', 'admin', '12345'),
('U002', 'usuario1', 'abc123');

-- Familias de productos de ejemplo
INSERT INTO PRODUCTOS_FAMILIAS (NOMBRE_FAMILIA)
VALUES
('Electrónica'),
('Ropa'),
('Alimentos');

-- Productos de ejemplo
INSERT INTO PRODUCTOS (NOMBRE_PRODUCTO, ID_FAMILIA, PRECIO)
VALUES
('Televisor 50"', 1, 750.00),
('Camiseta deportiva', 2, 25.50),
('Caja de cereal', 3, 4.75);