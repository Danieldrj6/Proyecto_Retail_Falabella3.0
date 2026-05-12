CREATE TABLE perfil (
    id INT PRIMARY KEY AUTO_INCREMENT,
    telefono VARCHAR(20),
    direccion VARCHAR(200),
    ciudad VARCHAR(100),
    region VARCHAR(100),
    codigo_postal VARCHAR(10)
);

CREATE TABLE usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    correo VARCHAR(150) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    rol VARCHAR(50) NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    fecha_registro DATETIME NOT NULL,
    perfil_id INT DEFAULT NULL,
    FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);