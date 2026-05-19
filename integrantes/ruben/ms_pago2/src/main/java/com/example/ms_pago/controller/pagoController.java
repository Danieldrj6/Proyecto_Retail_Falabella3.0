package com.example.pago2.controller;

import com.example.ms_pago.service.*;

import main.java.com.example.ms_pago.model.Pago;
import main.java.com.example.ms_pago.service.pagoService;

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
        return PagoService.getPagos();
    }

    @PostMapping
    public Envio guardarPago(@RequestBody Pago pago){
        return PagoService.savePago(pago);
    }

    @GetMapping("/{id}")
    public Pago obtenerPagoPorId(@PathVariable int id) {
        return PagoService.getPagoById(id);
    }

    @PostMapping("/pedido/{id}")
    public Pago obtenerPagoPorIdPedido(@PathVariable int id) {
        return PagoService.getPagoByIdPedido(id);
    }

    @PutMapping("/{id}")
    public Envio actualizarPago(@PathVariable int id, @RequestBody Pago pago) {
        pago.setId(id);
        return PagoService.getPagoById(id);
    }

}
