package com.ms_carrito.example.ms_carrito20.model.DTO;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {

    private Integer id;
    private String tipoProducto;
    private String marcaProducto;
    private String nombreProducto;
    private Integer precio;
    private Date fechaIngreso;

}
