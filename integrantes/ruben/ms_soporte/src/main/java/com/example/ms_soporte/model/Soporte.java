package main.java.com.example.ms_soporte.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comprobante")

public class Soporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ticket;

    private int id_pedido;

    private int id_usuario;

    private Date fecha_ini_Ticket;

    private Date fecha_cierre_Ticket;

}
