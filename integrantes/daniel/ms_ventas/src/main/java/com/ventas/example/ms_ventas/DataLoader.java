package com.ventas.example.ms_ventas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.ventas.example.ms_ventas.model.VentasModelo;
import com.ventas.example.ms_ventas.repository.VentasRepositorio;


import java.util.Random;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private VentasRepositorio ventasRepositorio;

    @Override
    public void run(String... args) throws Exception {
    Random random = new Random();

        for (int i = 0; i <= 5; i++){
            VentasModelo venta = new VentasModelo();
            venta.setCarritoId(i + 1);
            venta.setUserId(i + 1);
            venta.setEsFactura(random.nextBoolean());
            ventasRepositorio.save(venta);
        }


    }



}
