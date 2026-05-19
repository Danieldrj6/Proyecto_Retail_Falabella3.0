package com.example.ms_soporte.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "soporte")

public class Soporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ticket;

    @Column(name = "id_pedido")
    private int id_pedido;

    @Column(name = "id_usuario")
    private int id_usuario;

    @Column(name = "fecha_inicio_ticket", nullable = false)
    private Date fecha_ini_Ticket;

    @Column(name = "fecha_cierre_ticket")
    private Date fecha_cierre_Ticket;

}
