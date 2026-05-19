package com.example.ms_pedido.model;

import lombok.Data;

@Data
public class Producto {
    private Integer id;
    private String tipoProducto;
    private String marcaProducto;
    private String nombreProducto;
    private Integer precio;
}