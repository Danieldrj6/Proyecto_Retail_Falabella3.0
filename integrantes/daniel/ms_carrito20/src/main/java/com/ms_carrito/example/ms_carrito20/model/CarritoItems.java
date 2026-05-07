package com.ms_carrito.example.ms_carrito20.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Carrito_items")
@Data
@AllArgsConstructor
public class CarritoItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "carritoId", nullable = false)
    private Carrito carritoId;

    @Column(name = "productId", nullable = false)
    private Integer productId;

    @Column(name = "productoNombre", nullable = false)
    private String productoNombre;

    @Column(name = "marca")
    private String marca;

    @Column(name = "tipo")
    private String tipo;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(name = "precioUnidad", nullable = false)
    private Integer precioUnidad;

    public Integer getSubtotal() {
        return precioUnidad * cantidad;
    }
}


