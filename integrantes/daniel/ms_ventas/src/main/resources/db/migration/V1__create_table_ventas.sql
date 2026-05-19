CREATE TABLE IF NOT EXISTS db_ventas(
    id int primary key AUTO_INCREMENT,
    user_id int not null,
    carrito_id int not null,
    es_factura boolean
)