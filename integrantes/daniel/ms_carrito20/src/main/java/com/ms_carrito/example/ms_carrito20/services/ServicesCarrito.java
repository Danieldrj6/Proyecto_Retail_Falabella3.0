package com.ms_carrito.example.ms_carrito20.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms_carrito.example.ms_carrito20.model.Carrito;
import com.ms_carrito.example.ms_carrito20.repository.RepositoryCarrito;

import java.util.List;

@Service
public class ServicesCarrito {

    @Autowired
    private RepositoryCarrito repositoryCarrito;

    public List<Carrito>findAll(){
        return repositoryCarrito.findAll();
    }

    public Carrito save(Carrito carrito){
        return repositoryCarrito.save(carrito);
    }

    public List<Carrito>deleteById(Integer id){
        repositoryCarrito.deleteById(id);
        return repositoryCarrito.findAll();
    }

    public Carrito findById(Integer id){
        return repositoryCarrito.findById(id)
        .orElseThrow(() -> new RuntimeException("Id no encontrado"));
    }

}
