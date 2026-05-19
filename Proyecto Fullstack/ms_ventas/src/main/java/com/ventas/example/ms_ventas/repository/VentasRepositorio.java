package com.ventas.example.ms_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ventas.example.ms_ventas.model.VentasModelo;

@Repository
public interface VentasRepositorio extends JpaRepository<VentasModelo, Integer> {

}
