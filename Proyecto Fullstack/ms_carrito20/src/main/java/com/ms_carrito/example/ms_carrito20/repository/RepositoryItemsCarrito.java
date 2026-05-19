package com.ms_carrito.example.ms_carrito20.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ms_carrito.example.ms_carrito20.model.CarritoItems;

@Repository
public interface RepositoryItemsCarrito extends JpaRepository <CarritoItems, Integer>{

}
