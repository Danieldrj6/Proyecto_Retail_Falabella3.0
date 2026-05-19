package com.ms_carrito.example.ms_carrito20.controller;

import com.ms_carrito.example.ms_carrito20.model.Carrito;
import com.ms_carrito.example.ms_carrito20.model.CarritoItems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms_carrito.example.ms_carrito20.services.ServicesCarrito;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/carrito")
public class ControllerCarrito {

    @Autowired
    private ServicesCarrito servicesCarrito;

    @GetMapping()
    public List<Carrito> findAll(){
        return servicesCarrito.findAll();
    }

    @PostMapping()
    public Carrito save(@RequestBody Carrito carrito){
        return servicesCarrito.save(carrito);
    }

    @DeleteMapping("/{id}")
    public List<Carrito> deleteById(@PathVariable Integer id){
        servicesCarrito.deleteById(id);
        return servicesCarrito.findAll();
    }

    @GetMapping("/{id}")
    public Carrito findById(@PathVariable Integer id) {
        return servicesCarrito.findById(id);
    }
    

    @PostMapping("/items/{producto_id}/{carrito_id}/{cantidad}")
    public CarritoItems agregarItem(@PathVariable Integer producto_id, Integer carrito_id, Integer cantidad) {     
        return servicesCarrito.agregarItem(producto_id, carrito_id, cantidad);
    }
    

}