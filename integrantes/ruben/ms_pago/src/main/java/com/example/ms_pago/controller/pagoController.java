package com.example.ms_pago.controller;


import com.example.ms_pago.service.*;

import com.example.ms_pago.model.Pago;
import com.example.ms_pago.service.pagoService;

import com.example.ms_pago.model.*;
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
@RequestMapping("/api/v1/pago")
public class pagoController {

    @Autowired
    private pagoService PagoService;

    @GetMapping
    public List<Pago> listarEPagos(){
        return PagoService.findAll();
    }

    @PostMapping
    public Pago guardarPago(@RequestBody Pago pago){
        return PagoService.save(pago);
    }

    @GetMapping("/{id}")
    public List<Pago> obtenerPagoPorId(@PathVariable int id) {
        return PagoService.findByid(id);
    }

    @PostMapping("/pedido/{id}")
    public List<Pago> obtenerPagoPorIdPedido(@PathVariable int id) {
        return PagoService.findByPagos(id);
    }

}