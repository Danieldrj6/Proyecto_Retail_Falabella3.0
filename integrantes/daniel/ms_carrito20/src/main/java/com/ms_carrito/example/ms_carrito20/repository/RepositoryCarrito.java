package com.ms_carrito.example.ms_carrito20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms_carrito.example.ms_carrito20.model.Carrito;
import java.util.List;

@Repository
public interface RepositoryCarrito extends JpaRepository<Carrito, Integer> {

    List<Carrito>findAll();

    Carrito save(Carrito carrito);

}
