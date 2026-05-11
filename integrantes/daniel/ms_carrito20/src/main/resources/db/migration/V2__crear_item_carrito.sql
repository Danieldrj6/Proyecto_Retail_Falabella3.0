CREATE TABLE IF NOT EXISTS db_itemscarrito(
    carrito_id INT NOT NULL,
    producto_id INT NOT NULL,
    cantidad INT NOT NULL,
    PRIMARY KEY(carrito_id, producto_id),
    FOREIGN KEY (carrito_id) REFERENCES db_carrito(id)
);