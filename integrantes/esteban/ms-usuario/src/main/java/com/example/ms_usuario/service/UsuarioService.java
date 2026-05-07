package com.example.ms_usuario.service;

import com.example.ms_usuario.model.Perfil;
import com.example.ms_usuario.model.Usuario;
import com.example.ms_usuario.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findALL(){
        return repository.findAll();
    }

    public Usuario findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    public Usuario findByCorreo(String correo){
        return repository.findByCorreo(correo);
    }

    public List<Usuario> findByRol(String rol){
        return repository.findByRol(rol);
    }

    public Usuario save(Usuario usuario){
        usuario.setFechaRegistro(new Date());
        usuario.setRol("Usuario");
        usuario.setActivo(true);
        return repository.save(usuario);
    }

    public Usuario update(Integer id, Usuario usuario){
        usuario.setId(id);
        return repository.save(usuario);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }

}
