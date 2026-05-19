package com.ms_carrito.example.ms_carrito20.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.ms_carrito.example.ms_carrito20.model.DTO.ProductoDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "db_itemscarrito")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class CarritoItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carrito_id;

    @Column(name = "producto_id")
    private Integer producto_id;

    @Column(name = "cantidad")
    private Integer cantidad = 1;

    @Transient
    private ProductoDTO producto;
}