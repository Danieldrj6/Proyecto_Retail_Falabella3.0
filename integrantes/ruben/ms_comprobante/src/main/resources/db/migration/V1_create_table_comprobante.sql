Create table CREATE TABLE IF NOT EXISTS db_comprobante (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo_comprobante STRING NOT NULL,
    id_pago INT,
    id_pedido INT
);