package com.example.ms_usuario.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Integer id;
    private String nombre; 
    private String apellido;
    private String correo;
    private String contrasena;
    private String rol;
    private Boolean activo;
    private Date fechaRegistro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;
}
