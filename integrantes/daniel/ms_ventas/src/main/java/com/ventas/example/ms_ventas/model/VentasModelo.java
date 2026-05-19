package com.ventas.example.ms_ventas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "db_ventas")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class VentasModelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer user_id;

    @Column(name = "carrito_id", nullable = false)
    private Integer carrito_id;

    @Column(name = "es_factura")
    private boolean es_factura;

}
