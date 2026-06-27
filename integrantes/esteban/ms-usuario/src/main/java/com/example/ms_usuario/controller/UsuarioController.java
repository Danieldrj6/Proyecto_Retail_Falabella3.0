package com.example.ms_usuario.controller;

import com.example.ms_usuario.model.Usuario;
import com.example.ms_usuario.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
@Tag(name = "Usuarios", description = "API de gestión de usuarios en el retail")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    @Operation(summary = "Obtener todos los usuarios", description = "Retorna la lista de todos los usuarios registrados en el sistema")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito")
    public List<Usuario> findAll() {
        return service.findALL();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener usuario por ID", description = "Retorna un usuario específico en base a su ID único")
    @ApiResponse(responseCode = "200", description = "Usuario encontrado con éxito")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public Usuario findById(
            @Parameter(description = "ID único del usuario", required = true) @PathVariable Integer id) {
        return service.findById(id);
    }

    @GetMapping("/correo/{correo}")
    @Operation(summary = "Obtener usuario por Correo", description = "Retorna un usuario específico filtrado por su correo electrónico")
    @ApiResponse(responseCode = "200", description = "Usuario encontrado con éxito")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public Usuario findByCorreo(
            @Parameter(description = "Correo electrónico del usuario", required = true) @PathVariable String correo) {
        return service.findByCorreo(correo);
    }

    @GetMapping("/rol/{rol}")
    @Operation(summary = "Obtener usuarios por Rol", description = "Retorna una lista de usuarios que poseen el rol especificado")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito")
    public List<Usuario> findByRol(
            @Parameter(description = "Nombre del rol (ej: Usuario, Admin)", required = true) @PathVariable String rol){
        return service.findByRol(rol);
    }

    @PostMapping
    @Operation(summary = "Crear nuevo usuario", description = "Registra un nuevo usuario en el sistema asignándole fecha de hoy, estado activo y rol por defecto 'Usuario'")
    @ApiResponse(responseCode = "200", description = "Usuario creado con éxito")
    public Usuario save(
            @RequestBody Usuario usuario) {
        return service.save(usuario);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar usuario existente", description = "Actualiza la información de un usuario registrado en base a su ID")
    @ApiResponse(responseCode = "200", description = "Usuario actualizado con éxito")
    public Usuario update(
            @Parameter(description = "ID del usuario a actualizar", required = true) @PathVariable Integer id,
            @RequestBody Usuario usuario) {
        return service.update(id, usuario);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar usuario", description = "Elimina de forma permanente un usuario del sistema por su ID")
    @ApiResponse(responseCode = "200", description = "Usuario eliminado con éxito")
    public void deleteById(
            @Parameter(description = "ID del usuario a eliminar", required = true) @PathVariable Integer id) {
        service.deleteById(id);
    }
}
