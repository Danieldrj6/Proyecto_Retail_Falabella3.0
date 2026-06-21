package com.ventas.example.ms_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ventas.example.ms_ventas.model.VentasModelo;
import java.util.List;

@Repository
public interface VentasRepositorio extends JpaRepository<VentasModelo, Integer> {

    List<VentasModelo> findByCarritoId(Integer carritoId);

    List<VentasModelo> findByUserId(Integer userId);

    List<VentasModelo> findByEsFactura(boolean esFactura);

    List<VentasModelo> findAll();

}
