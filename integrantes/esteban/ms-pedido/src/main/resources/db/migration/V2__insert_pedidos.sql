INSERT INTO pedido (usuario_id, total, estado, fecha) VALUES
(1, 899000, 'PENDIENTE', NOW()),
(2, 1798000, 'ENVIADO', NOW()),
(3, 89000, 'ENTREGADO', NOW());

INSERT INTO detalle_pedido (pedido_id, producto_id, cantidad, precio_unitario) VALUES
(1, 1, 1, 899000),
(2, 1, 1, 899000),
(2, 2, 1, 899000),
(3, 3, 1, 89000);