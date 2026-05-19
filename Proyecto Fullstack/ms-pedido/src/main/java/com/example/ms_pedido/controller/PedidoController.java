package com.example.ms_pedido.controller;

import com.example.ms_pedido.model.Pedido;
import com.example.ms_pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping
    public List<Pedido> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Pedido findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Pedido> findByUsuarioId(@PathVariable Integer usuarioId) {
        return service.findByUsuarioId(usuarioId);
    }

    @GetMapping("/estado/{estado}")
    public List<Pedido> findByEstado(@PathVariable String estado) {
        return service.findByEstado(estado);
    }

    @PostMapping
    public Pedido save(@RequestBody Pedido pedido) {
        return service.save(pedido);
    }

    @PutMapping("/{id}")
    public Pedido update(@PathVariable Integer id,
                         @RequestBody Pedido pedido) {
        return service.update(id, pedido);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }
}