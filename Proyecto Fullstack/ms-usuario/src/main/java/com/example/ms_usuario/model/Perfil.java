package com.example.ms_usuario.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id;
    private String telefono;
    private String direccion;
    private String ciudad;
    private String region;
    private String codigoPostal;

}
