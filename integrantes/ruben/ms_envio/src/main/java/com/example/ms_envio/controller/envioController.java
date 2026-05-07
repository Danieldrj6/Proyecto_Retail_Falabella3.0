package com.example.ms_envio.controller;

import com.example.ms_envio.service.*;
import com.example.ms_envio.model.*;
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
@RequestMapping("/api/v1/envio")
public class envioController {

    @Autowired
    private envioService EnvioService;

    @GetMapping
    public List<Envio> listarEnvios(){
        return EnvioService.getEnvios();
    }

    @PostMapping
    public Envio guardarEnvio(@RequestBody Envio envio){
        return EnvioService.saveEnvio(envio);
    }
    

    @GetMapping("/{id}")
    public Envio obtenerEnvioPorId(@PathVariable int id) {
        return EnvioService.getEnvioId(id);
    }
    
    @PostMapping("/compra/{id}")
    public Envio obtenerEnvioPorIdCompra(@PathVariable int id) {
        return EnvioService.getEnvioIdCompra(id);
    }

    @PutMapping("/{id}")
    public Envio actualizarEnvio(@PathVariable int id, @RequestBody Envio envio) {
        envio.setId(id);
        return EnvioService.getEnvioId(id);
    }
    
}
