package com.ms_carrito.example.ms_carrito20.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "db_carrito")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "total_precio")
    private Integer totalPrecio = 0;

}
