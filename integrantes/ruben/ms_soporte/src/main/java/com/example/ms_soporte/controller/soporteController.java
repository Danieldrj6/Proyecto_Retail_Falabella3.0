package com.example.ms_soporte.controller;

import com.example.ms_soporte.model.*;
import com.example.ms_soporte.service.soporteService;

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
@Tag(name = "Soporte", description = "API de gestion de tickets de soporte en el retail")
public class soporteController {

    @Autowired
    private soporteService SoporteService;

    @GetMapping
    @Operation(summary = "Listar soportes", description = "Retorna la lista de todos los tickets de soporte")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con exito")
    public List<Soporte> listarSoportes(){
        return SoporteService.getSoportes();
    }

    @PostMapping
    @Operation(summary = "Guardar soporte", description = "Registra un nuevo ticket de soporte en el sistema")
    @ApiResponse(responseCode = "200", description = "Soporte guardado con exito")
    public Soporte guardarSoporte(@RequestBody Soporte sopor){
        return SoporteService.saveSoporte(sopor);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener soporte por ID de ticket", description = "Retorna un ticket de soporte especifico segun su ID")
    @ApiResponse(responseCode = "200", description = "Soporte encontrado con exito")
    public Soporte obtenerSoportePorIdTicket(
            @Parameter(description = "ID del ticket de soporte", required = true) @PathVariable int id) {
        return SoporteService.getSoporteTicketID(id);
    }

    @PostMapping("/usuario/{id}")
    @Operation(summary = "Obtener soporte por ID de usuario", description = "Retorna el ticket de soporte asociado a un usuario especifico")
    @ApiResponse(responseCode = "200", description = "Soporte encontrado con exito")
    public Soporte obtenerSoportePorIdUsuario(
            @Parameter(description = "ID del usuario", required = true) @PathVariable int id_usu) {
        return SoporteService.getSoporteUsu(id_usu);
    }


}
