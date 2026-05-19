INSERT INTO perfil (telefono, direccion, ciudad, region, codigo_postal) VALUES
('912345678', 'Las Calas 2455', 'Santiago', 'Metropolitana', '7500000'),
('987654321', 'Camino Los Trapences 4686', 'Santiago', 'Metropolitana', '7550000'),
('911111111', 'Av. Central 789', 'Santiago', 'Metropolitana', '7600000');

INSERT INTO usuario (nombre, apellido, correo, contrasena, rol, activo, fecha_registro, perfil_id) VALUES
('Ruben', 'Catril', 'juan@gmail.com', '1234', 'USER', TRUE, NOW(), 1),
('Daniel', 'DelRio', 'maria@gmail.com', '1234', 'USER', TRUE, NOW(), 2),
('Admin', 'Sistema', 'admin@gmail.com', '1234', 'USER', TRUE, NOW(), 3);