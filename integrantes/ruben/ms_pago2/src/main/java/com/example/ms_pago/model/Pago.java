package com.example.ms_pago.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pago")

public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "monto_pago", nullable = false)
    private int montoPago;
    
    @Column(name = "tipo_pago", nullable = false)
    private String tipoPago;

    @Column(name = "tipo_comprobante", nullable = false)
    private String tipoComprobante;

    @Column(name = "id_pedido")
    private int id_pedido;
}

