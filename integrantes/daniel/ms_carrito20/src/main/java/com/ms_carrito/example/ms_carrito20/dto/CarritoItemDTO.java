package com.ms_carrito.example.ms_carrito20.dto;

import lombok.Data;

@Data
public class CarritoItemDTO {

    private Long id;
    private Integer productId;
    private String productName;
    private String marca;
    private String tipo;
    private Integer quantity;
    private Integer unitPrice;
    private Integer subtotal;

}
