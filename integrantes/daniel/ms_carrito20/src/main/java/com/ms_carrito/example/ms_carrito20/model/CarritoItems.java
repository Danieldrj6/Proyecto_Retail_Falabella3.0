package com.ms_carrito.example.ms_carrito20.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Table(name = "db_itemscarrito")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class CarritoItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carritoId;

    @Column(name = "producto_id", nullable = false)
    private Integer productoId;

    @Column(name = "cantidad")
    private Integer cantidad = 1;

}
