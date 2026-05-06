package com.example.ms_producto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ms_producto.model.Producto;
import com.example.ms_producto.service.ProductoService;

import java.util.*;

@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {
    @Autowired
    private ProductoService service;

    @GetMapping
    public List<Producto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Producto findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Producto save(@RequestBody Producto producto) {
        return service.save(producto);
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable Integer id,
            @RequestBody Producto producto) {
        return service.update(id, producto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @GetMapping("/tipo/{tipo}")
    public List<Producto> findByTipo(@PathVariable String tipo) {
        return service.findByTipo(tipo);
    }

    @GetMapping("/marca/{marca}")
    public List<Producto> findByMarca(@PathVariable String marca) {
        return service.findByMarca(marca);
    }

    @GetMapping("/search")
    public List<Producto> findByNombre(@RequestParam String nombre) {
        return service.findByNombre(nombre);
    }

}
