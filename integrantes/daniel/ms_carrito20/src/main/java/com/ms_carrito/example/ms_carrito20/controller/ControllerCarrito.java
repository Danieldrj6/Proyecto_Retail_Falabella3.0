package com.ms_carrito.example.ms_carrito20.controller;

import com.ms_carrito.example.ms_carrito20.model.Carrito;
import com.ms_carrito.example.ms_carrito20.model.CarritoItems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms_carrito.example.ms_carrito20.services.ServicesCarrito;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/v1/carrito")
@Tag(name = "Carritos", description = "Operaciones relacionadas al carrito de los usuarios y sus productos")
public class ControllerCarrito {

    @Autowired
    private ServicesCarrito servicesCarrito;

    @GetMapping()
    @Operation(summary = "Obtiene todos los carritos", description = "Obtiene una lista de todos los carritos creados")
    public List<Carrito> findAll(){
        return servicesCarrito.findAll();
    }

    @PostMapping()
    @Operation(summary = "Publica carrito", description = "Publica o crea un nuevo carrito")
    @ApiResponse(responseCode = "200", description = "Carrito publicado exitosamente")
    public Carrito save(@RequestBody Carrito carrito){
        return servicesCarrito.save(carrito);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar carrito", description = "Eliminar carrito por ID")
    @ApiResponse(responseCode = "200", description = "Carrito eliminado exitosamente")
    @ApiResponse(responseCode = "404", description = "Carrito no encontrado")
    public List<Carrito> deleteById(@PathVariable Integer id){
        servicesCarrito.deleteById(id);
        return servicesCarrito.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener carrito", description = "Obtener carrito por ID")
    @ApiResponse(responseCode = "200", description = "Carrito encontrado")
    @ApiResponse(responseCode = "404", description = "Carrito no encontrado")
    public Carrito findById(@PathVariable Integer id) {
        return servicesCarrito.findById(id);
    }
    

    @PostMapping("/items/{producto_id}/{carrito_id}/{cantidad}")
    @Operation(summary = "Agregar items/productos a carrito")
    @ApiResponse(responseCode = "200", description = "Item agregado exitosamente")
    @ApiResponse(responseCode = "404", description = "Carrito no encontrado o item erroneo")
    public CarritoItems agregarItem(@PathVariable Integer producto_id, Integer carrito_id, Integer cantidad) {     
        return servicesCarrito.agregarItem(producto_id, carrito_id, cantidad);
    }
    

}