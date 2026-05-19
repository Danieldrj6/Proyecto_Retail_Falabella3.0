package com.example.ms_soporte.controller;

import com.example.ms_soporte.model.*;
import com.example.ms_soporte.service.*;

import com.example.ms_soporte.service.soporteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/comprobante")

public class soporteController {

    @Autowired
    private soporteService SoporteService;

    @GetMapping
    public List<Soporte> listarSoportes(){
        return SoporteService.getSoportes();
    }

    @PostMapping
    public Soporte guardarSoporte(@RequestBody Soporte sopor){
        return SoporteService.saveSoporte(sopor);
    }

    @GetMapping("/{id}")
    public Soporte obtenerSoportePorIdTicket(@PathVariable int id) {
        return SoporteService.getSoporteTicketID(id);
    }

    @PostMapping("/usuario/{id}")
    public Soporte obtenerSoportePorIdUsuario(@PathVariable int id_usu) {
        return SoporteService.getSoporteUsu(id_usu);
    }


}
