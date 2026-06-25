package com.example.ms_producto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ms_producto.model.Producto;
import com.example.ms_producto.service.ProductoService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.*;

@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {
    @Autowired
    private ProductoService service;

    @GetMapping
    @Operation(summary = "Buscar por producto", description = "Obtener todos los Productos")
    public List<Producto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por ID", description = "Obtener producto por ID")
    public Producto findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    @Operation(summary = "Agregar producto", description = "Publica o crea un nuevo producto")
    public Producto save(@RequestBody Producto producto) {
        return service.save(producto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Producto", description = "Actualiar Producto")
    public Producto update(@PathVariable Integer id,
        @RequestBody Producto producto) {
        return service.update(id, producto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Producto", description = "Eliminar Producto")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @GetMapping("/tipo/{tipo}")
    @Operation(summary = "Buscar por tipo", description = "Obtener producto por tipo")
    public List<Producto> findByTipo(@PathVariable String tipo) {
        return service.findByTipo(tipo);
    }

    @GetMapping("/marca/{marca}")
    @Operation(summary = "Buscar por Marca", description = "Obtener producto por Marca")
    public List<Producto> findByMarca(@PathVariable String marca) {
        return service.findByMarca(marca);
    }

    @GetMapping("/nombre")
    @Operation(summary = "Buscar por nombre", description = "Obtener producto por nombre")
    public List<Producto> findByNombre(@RequestParam String nombre) {
        return service.findByNombre(nombre);
    }

}
