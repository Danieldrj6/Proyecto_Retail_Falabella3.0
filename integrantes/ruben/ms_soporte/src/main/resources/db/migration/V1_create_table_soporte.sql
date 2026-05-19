Create table CREATE TABLE IF NOT EXISTS db_comprobante (
    id_ticket INT PRIMARY KEY AUTO_INCREMENT,
    id_pedido int NOT NULL,
    id_usuario INT NOT NULL,
    fecha_inicio_ticket DATE,
    fecha_cierre_ticket DATE
);