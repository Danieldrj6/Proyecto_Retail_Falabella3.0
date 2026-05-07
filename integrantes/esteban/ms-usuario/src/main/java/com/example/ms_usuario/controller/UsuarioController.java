package com.example.ms_usuario.controller;

import com.example.ms_usuario.model.Usuario;
import com.example.ms_usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> findAll() {
        return service.findALL();
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @GetMapping("/correo/{correo}")
    public Usuario findByCorreo(@PathVariable String correo) {
        return service.findByCorreo(correo);
    }

    @GetMapping("/rol/{rol}")
    public List<Usuario> findByRol(@PathVariable String rol){
        return service.findByRol(rol);
    }

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) {
        return service.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Integer id,
        @RequestBody Usuario usuario) {
        return service.update(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
