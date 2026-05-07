package com.ms_carrito.example.ms_carrito20.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "carritos")
@Data
@AllArgsConstructor
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

}
