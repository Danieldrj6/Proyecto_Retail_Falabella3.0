package com.example.ms_envio.controller;

import com.example.ms_envio.service.*;
import com.example.ms_envio.model.*;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/envio")
@Tag(name = "Envios", description = "API de gestion de envios en el retail")
public class envioController {

    @Autowired
    private envioService EnvioService;

    @GetMapping
    @Operation(summary = "Listar envios", description = "Retorna la lista de todos los envios registrados")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con exito")
    public List<Envio> listarEnvios(){
        return EnvioService.getEnvios();
    }

    @PostMapping
    @Operation(summary = "Guardar envio", description = "Registra un nuevo envio en el sistema")
    @ApiResponse(responseCode = "200", description = "Envio guardado con exito")
    public Envio guardarEnvio(@RequestBody Envio envio){
        return EnvioService.saveEnvio(envio);
    }
    

    @GetMapping("/{id}")
    @Operation(summary = "Obtener envio por ID", description = "Retorna un envio especifico segun su ID")
    @ApiResponse(responseCode = "200", description = "Envio encontrado con exito")
    public Envio obtenerEnvioPorId(
            @Parameter(description = "ID del envio", required = true) @PathVariable int id) {
        return EnvioService.getEnvioId(id);
    }
    
    @PostMapping("/pedido/{id}")
    @Operation(summary = "Obtener envio por ID de compra", description = "Retorna el envio asociado a una compra especifica")
    @ApiResponse(responseCode = "200", description = "Envio encontrado con exito")
    public Envio obtenerEnvioPorIdCompra(
            @Parameter(description = "ID de la compra", required = true) @PathVariable int id) {
        return EnvioService.getEnvioIdCompra(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar envio", description = "Actualiza la informacion de un envio existente")
    @ApiResponse(responseCode = "200", description = "Envio actualizado con exito")
    public Envio actualizarEnvio(
            @Parameter(description = "ID del envio a actualizar", required = true) @PathVariable int id,
            @RequestBody Envio envio) {
        envio.setId(id);
        return EnvioService.getEnvioId(id);
    }
    
}
