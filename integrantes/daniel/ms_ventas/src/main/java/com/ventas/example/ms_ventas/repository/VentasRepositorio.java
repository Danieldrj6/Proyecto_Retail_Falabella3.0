package com.ventas.example.ms_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ventas.example.ms_ventas.model.VentasModelo;
import java.util.List;

@Repository
public interface VentasRepositorio extends JpaRepository<VentasModelo, Integer> {

    List<VentasModelo> findByCarrito_id(Integer carrito_id);

    List<VentasModelo> findByUser_id(Integer user_id);

    List<VentasModelo> findByEs_factura(boolean es_factura);

    List<VentasModelo> findAll();

}
