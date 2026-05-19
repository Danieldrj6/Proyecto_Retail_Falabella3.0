CREATE TABLE pedido (
    id INT PRIMARY KEY AUTO_INCREMENT,
    usuario_id INT NOT NULL,
    total INT NOT NULL,
    estado VARCHAR(50) NOT NULL,
    fecha DATETIME NOT NULL
);

CREATE TABLE detalle_pedido (
    id INT PRIMARY KEY AUTO_INCREMENT,
    pedido_id INT NOT NULL,
    producto_id INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario INT NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id)
);