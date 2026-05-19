CREATE TABLE IF NOT EXISTS db_carrito (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    total_precio INT DEFAULT 0
);