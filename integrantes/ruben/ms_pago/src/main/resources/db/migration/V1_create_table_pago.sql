Create table CREATE TABLE IF NOT EXISTS db_pago (
    id INT PRIMARY KEY AUTO_INCREMENT,
    monto_pago INT NOT NULL,
    tipo_pago STRING,
    tipo_comprobante STRING,
    id_pedido INT
);