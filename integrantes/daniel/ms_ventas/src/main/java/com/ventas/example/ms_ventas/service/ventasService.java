package main.java.com.ventas.example.ms_ventas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ventas.example.ms_ventas.repository.VentasRepositorio;
import com.ventas.example.ms_ventas.model.VentasModelo;

@Service
public class VentasService {

    @Autowired
    private VentasRepositorio ventasRepositorio;

    public List<VentasModelo> obtenerVentas() {
        return ventasRepositorio.findAll(); 
    }

    public VentasModelo save(VentasModelo ventas){
        return ventasRepositorio.save(ventas);
    }

    public VentasModelo findByIdCarrito(Integer id){
        return ventasRepositorio.findByIdCarrito(id)
        .orElseThrow(() -> new RuntimeException("Id no encontrado"));
    }

    public VentasModelo findByIdUsuario(Integer id){
        return ventasRepositorio.findByIdUsuario(id)
        .orElseThrow(() -> new RuntimeException("Id no encontrado"));
    }

    public VentasModelo esFacturaById(int id){
        return ventasRepositorio.equals(esFactura(venta)==true)
        .orElseThrow(() -> new RuntimeException("Venta no es con factura"));
    }

}