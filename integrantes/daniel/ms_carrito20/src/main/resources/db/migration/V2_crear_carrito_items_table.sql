CREATE TABLE carritos_items (
    id INT PRIMARY KEY AUTO_INCREMENT,
    carritoId INT NOT NULL,
    productoNombre VARCHAR(255),
    marca VARCHAR(255),
    tipo VARCHAR(255),
    cantidad INT NOT NULL DEFAULT 1,
    precioUnidad INT NOT NULL
)