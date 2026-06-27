package com.ventas.example.ms_ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ventas.example.ms_ventas.model.VentasModelo;
import com.ventas.example.ms_ventas.service.ventasService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/ventas")
@Tag(name = "Ventas", description = "API de gestion de ventas en el retail")
public class ventasController {

    @Autowired
    private ventasService ventasService;

    @GetMapping()
    @Operation(summary = "Obtener todas las ventas", description = "Retorna la lista de todas las ventas registradas")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con exito")
    public List<VentasModelo> findAll(){
        return ventasService.findAll();
    }

    @PostMapping()
    @Operation(summary = "Registrar nueva venta", description = "Crea un nuevo registro de venta en el sistema")
    @ApiResponse(responseCode = "200", description = "Venta registrada con exito")
    public VentasModelo save(@RequestBody VentasModelo venta){
        return ventasService.save(venta);
    }
    
    @GetMapping("/carrito/{id}")
    @Operation(summary = "Buscar ventas por carrito", description = "Retorna las ventas asociadas a un carrito especifico")
    @ApiResponse(responseCode = "200", description = "Ventas encontradas con exito")
    public List<VentasModelo> findByIdCarrito(
            @Parameter(description = "ID del carrito", required = true) @PathVariable Integer id) {
        return ventasService.findByIdCarrito(id);
    }

    @GetMapping("/usuario/{id}")
    @Operation(summary = "Buscar ventas por usuario", description = "Retorna las ventas realizadas por un usuario especifico")
    @ApiResponse(responseCode = "200", description = "Ventas encontradas con exito")
    public List<VentasModelo> findByIdUsuario(
            @Parameter(description = "ID del usuario", required = true) @PathVariable Integer id) {
        return ventasService.findByIdUsuario(id);
    }

    @GetMapping("/factura/{id}")
    @Operation(summary = "Buscar facturas", description = "Retorna las ventas que son factura segun el ID y flag de venta")
    @ApiResponse(responseCode = "200", description = "Facturas encontradas con exito")
    public List<VentasModelo> esFacturaById(
            @Parameter(description = "ID de la venta", required = true) @PathVariable Integer id, boolean venta) {
        return ventasService.esFacturaById(id, venta);
    }

}
