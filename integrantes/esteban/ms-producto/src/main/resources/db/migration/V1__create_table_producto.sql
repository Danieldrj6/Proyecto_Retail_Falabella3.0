CREATE TABLE IF NOT EXISTS producto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo_producto VARCHAR(100) NOT NULL,
    marca_producto VARCHAR(100) NOT NULL,
    nombre_producto VARCHAR(150) NOT NULL,
    precio INT NOT NULL,
    fecha_ingreso DATETIME NOT NULL
);