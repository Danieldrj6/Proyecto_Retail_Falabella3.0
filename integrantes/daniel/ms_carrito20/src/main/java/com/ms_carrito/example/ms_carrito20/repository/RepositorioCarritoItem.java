package com.ms_carrito.example.ms_carrito20.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms_carrito.example.ms_carrito20.model.CarritoItems;
import java.util.List;


public interface RepositorioCarritoItem extends JpaRepository<CarritoItems, Long> {

    List<CarritoItems> findByCarritoIdAndProductId(Long carritoId, Integer productId);

}
