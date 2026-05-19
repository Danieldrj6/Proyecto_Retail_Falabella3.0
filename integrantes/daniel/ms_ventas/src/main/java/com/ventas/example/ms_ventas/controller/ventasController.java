package com.ventas.example.ms_ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ventas.example.ms_ventas.model.VentasModelo;
import com.ventas.example.ms_ventas.service.VentasService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/ventas")
public class ventasController {

    @Autowired
    private VentasService ventasService;

    @GetMapping()
    public List<VentasModelo> findAll(){
        return ventasService.findAll();
    }

    @PostMapping()
    public VentasModelo save(@RequestBody VentasModelo venta){
        return ventasService.save(venta);
    }
    
    @GetMapping("/carrito/{id}")
    public List<VentasModelo> findByIdCarrito(@PathVariable Integer id) {
        return ventasService.findByIdCarrito(id);
    }

    @GetMapping("/usuario/{id}")
    public List<VentasModelo> findByIdUsuario(@PathVariable Integer id) {
        return ventasService.findByIdUsuario(id);
    }

    @GetMapping("/factura/{id}")
    public List<VentasModelo> esFacturaById(@PathVariable Integer id, boolean venta) {
        return ventasService.esFacturaById(id, venta);
    }

}
