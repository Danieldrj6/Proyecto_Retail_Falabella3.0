package com.example.ms_comprobante.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comprobante")

public class Comprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo_comprobante", nullable = false)
    private String tipoComprobante;

    @Column(name = "id_pago")
    private int id_pago;

    @Column(name = "id_pedido")
    private int id_pedido;

}
