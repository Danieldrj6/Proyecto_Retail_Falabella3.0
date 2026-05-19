package main.java.com.ventas.example.ms_ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ventas.model.*;
import com.ventas.example.ms_ventas.model.VentasModelo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/ventas")
public class ventasController {

    @Autowired
    private ventasService VentasService;

    @GetMapping()
    public List<VentasModelo> findAll(){
        return ventasService.findAll();
    }

    @PostMapping()
    public VentasModelo save(@RequestBody VentasModelo venta){
        return ventasService.save(venta);
    }

    @GetMapping("/{id}")
    public VentasModelo findById(@PathVariable Integer id) {
        return ventasService.findById(id);
    }
    
    @GetMapping("/carrito/{id}")
    public VentasModelo findByIdCarrito(@PathVariable Integer id) {
        return ventasService.findByIdCarrito(id);
    }

    @GetMapping("/usuario/{id}")
    public VentasModelo findByIdUsuario(@PathVariable Integer id) {
        return ventasService.findByIdUsuario(id);
    }

    @GetMapping("/factura/{id}")
    public VentasModelo esFacturaById(@PathVariable Integer id) {
        return ventasService.esFacturaById(id);
    }

}
