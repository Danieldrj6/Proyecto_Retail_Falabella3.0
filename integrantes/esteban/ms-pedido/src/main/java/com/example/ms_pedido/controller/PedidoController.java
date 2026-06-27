package com.example.ms_pedido.controller;

import com.example.ms_pedido.model.Pedido;
import com.example.ms_pedido.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1/pedidos")
@Tag(name = "Pedidos", description = "API de gestión de pedidos en el retail")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping
    @Operation(summary = "Obtener todos los pedidos", description = "Retorna la lista de todos los pedidos registrados en el sistema")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito")
    public List<Pedido> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener pedido por ID", description = "Retorna un pedido específico en base a su ID único")
    @ApiResponse(responseCode = "200", description = "Pedido encontrado con éxito")
    @ApiResponse(responseCode = "404", description = "Pedido no encontrado")
    public Pedido findById(
            @Parameter(description = "ID único del pedido", required = true) @PathVariable Integer id) {
        return service.findById(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    @Operation(summary = "Obtener pedidos de un usuario", description = "Retorna todos los pedidos realizados por un usuario específico")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito")
    public List<Pedido> findByUsuarioId(
            @Parameter(description = "ID del usuario", required = true) @PathVariable Integer usuarioId) {
        return service.findByUsuarioId(usuarioId);
    }

    @GetMapping("/estado/{estado}")
    @Operation(summary = "Obtener pedidos por Estado", description = "Retorna una lista de pedidos filtrada por su estado (ej: PENDIENTE, ENVIADO, CANCELADO)")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito")
    public List<Pedido> findByEstado(
            @Parameter(description = "Estado del pedido", required = true) @PathVariable String estado) {
        return service.findByEstado(estado);
    }

    @PostMapping
    @Operation(summary = "Crear nuevo pedido", description = "Registra un nuevo pedido. Valida la existencia del usuario y de cada producto de los detalles llamando a otros microservicios mediante Feign. Calcula el total automáticamente y establece el estado en 'PENDIENTE'")
    @ApiResponse(responseCode = "200", description = "Pedido creado con éxito")
    @ApiResponse(responseCode = "400", description = "Usuario o producto no existe, o datos inválidos")
    public Pedido save(
            @RequestBody Pedido pedido) {
        return service.save(pedido);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar pedido existente", description = "Actualiza la información de un pedido registrado en base a su ID")
    @ApiResponse(responseCode = "200", description = "Pedido actualizado con éxito")
    public Pedido update(
            @Parameter(description = "ID del pedido a actualizar", required = true) @PathVariable Integer id,
            @RequestBody Pedido pedido) {
        return service.update(id, pedido);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar pedido", description = "Elimina de forma permanente un pedido del sistema por su ID")
    @ApiResponse(responseCode = "200", description = "Pedido eliminado con éxito")
    public void deleteById(
            @Parameter(description = "ID del pedido a eliminar", required = true) @PathVariable Integer id) {
        service.deleteById(id);
    }
}