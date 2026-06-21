package com.ventas.example.ms_ventas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ventas.example.ms_ventas.repository.VentasRepositorio;

import com.ventas.example.ms_ventas.model.VentasModelo;

@Service
public class ventasService {

     @Autowired
    private VentasRepositorio ventasRepositorio;

    public List<VentasModelo> findAll() {
        return ventasRepositorio.findAll();
    }

    public VentasModelo save(VentasModelo ventas) {
        return ventasRepositorio.save(ventas);
    }

    public List<VentasModelo> findByIdCarrito(Integer id) {
        return ventasRepositorio.findByCarritoId(id);
    }

    public List<VentasModelo> findByIdUsuario(Integer id) {
        return ventasRepositorio.findByUserId(id);
    }

    public List<VentasModelo> esFacturaById(int id, boolean venta) {
        if (venta == true) {
            return ventasRepositorio.findByEsFactura(venta);
        }
        return null;
    }
}