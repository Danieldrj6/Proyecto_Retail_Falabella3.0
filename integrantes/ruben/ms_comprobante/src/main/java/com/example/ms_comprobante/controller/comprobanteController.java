package com.example.ms_comprobante.controller;

import com.example.ms_comprobante.model.*;
import com.example.ms_comprobante.service.*;

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
@RequestMapping("/api/v1/comprobante")
@Tag(name = "Comprobantes", description = "API de gestion de comprobantes en el retail")
public class comprobanteController {
    @Autowired
    private comprobanteService ComprobanteService;

    @GetMapping
    @Operation(summary = "Listar comprobantes", description = "Retorna la lista de todos los comprobantes registrados")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con exito")
    public List<Comprobante> listarComprobantes(){
        return ComprobanteService.getComprobantes();
    }

    @PostMapping
    @Operation(summary = "Guardar comprobante", description = "Registra un nuevo comprobante en el sistema")
    @ApiResponse(responseCode = "200", description = "Comprobante guardado con exito")
    public Comprobante guardarComprobante(@RequestBody Comprobante comprob){
        return ComprobanteService.saveComprobante(comprob);
    }
    

    @GetMapping("/{id}")
    @Operation(summary = "Obtener comprobante por ID", description = "Retorna un comprobante especifico segun su ID")
    @ApiResponse(responseCode = "200", description = "Comprobante encontrado con exito")
    public Comprobante obtenerComprobantePorId(
            @Parameter(description = "ID del comprobante", required = true) @PathVariable int id) {
        return ComprobanteService.getComprobanteId(id);
    }
    
    @PostMapping("/pedido/{id}")
    @Operation(summary = "Obtener comprobante por ID de pedido", description = "Retorna el comprobante asociado a un pedido especifico")
    @ApiResponse(responseCode = "200", description = "Comprobante encontrado con exito")
    public Comprobante obtenerComprobantePorIdPedido(
            @Parameter(description = "ID del pedido", required = true) @PathVariable int id) {
        return ComprobanteService.getComprobanteIdPedido(id);
    }

}
