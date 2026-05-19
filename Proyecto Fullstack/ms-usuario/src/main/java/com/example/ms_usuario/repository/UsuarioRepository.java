package com.example.ms_usuario.repository;

import com.example.ms_usuario.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Usuario findByCorreo(String correo);

    List<Usuario> findByRol(String rol);

}
