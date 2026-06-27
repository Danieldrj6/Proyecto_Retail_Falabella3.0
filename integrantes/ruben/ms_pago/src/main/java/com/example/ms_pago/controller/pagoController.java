package com.example.ms_pago.controller;

import com.example.ms_pago.model.Pago;
import com.example.ms_pago.service.pagoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/pago")
@Tag(name = "Pagos", description = "API de gestion de pagos en el retail")
public class pagoController {

    @Autowired
    private pagoService PagoService;

    @GetMapping
    @Operation(summary = "Listar pagos", description = "Retorna la lista de todos los pagos registrados")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con exito")
    public List<Pago> listarEPagos(){
        return PagoService.findAll();
    }

    @PostMapping
    @Operation(summary = "Registrar pago", description = "Registra un nuevo pago en el sistema")
    @ApiResponse(responseCode = "200", description = "Pago registrado con exito")
    public Pago guardarPago(@RequestBody Pago pago){
        return PagoService.save(pago);
    }

    @GetMapping("/pedido/{id}")
    @Operation(summary = "Obtener pagos por ID de pedido", description = "Retorna los pagos asociados a un pedido especifico")
    @ApiResponse(responseCode = "200", description = "Pagos encontrados con exito")
    public List<Pago> obtenerPagoPorIdPedido(
            @Parameter(description = "ID del pedido", required = true) @PathVariable int id) {
        return PagoService.findByPagos(id);
    }

}