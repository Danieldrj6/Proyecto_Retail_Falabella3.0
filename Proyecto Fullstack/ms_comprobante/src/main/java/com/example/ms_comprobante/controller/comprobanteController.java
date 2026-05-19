package com.example.ms_comprobante.controller;

import com.example.ms_comprobante.model.*;
import com.example.ms_comprobante.service.*;

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

public class comprobanteController {
    @Autowired
    private comprobanteService ComprobanteService;

    @GetMapping
    public List<Comprobante> listarComprobantes(){
        return ComprobanteService.getComprobantes();
    }

    @PostMapping
    public Comprobante guardarComprobante(@RequestBody Comprobante comprob){
        return ComprobanteService.saveComprobante(comprob);
    }
    

    @GetMapping("/{id}")
    public Comprobante obtenerComprobantePorId(@PathVariable int id) {
        return ComprobanteService.getComprobanteId(id);
    }
    
    @PostMapping("/pedido/{id}")
    public Comprobante obtenerComprobantePorIdPedido(@PathVariable int id) {
        return ComprobanteService.getComprobanteIdPedido(id);
    }

}
