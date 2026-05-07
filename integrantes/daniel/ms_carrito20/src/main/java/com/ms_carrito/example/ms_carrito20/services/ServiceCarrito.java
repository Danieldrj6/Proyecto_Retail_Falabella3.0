package com.ms_carrito.example.ms_carrito20.services;

import java.util.*;

import com.ms_carrito.example.ms_carrito20.model.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms_carrito.example.ms_carrito20.repository.RepositorioCarrito;

@Service
public class ServiceCarrito {

    @Autowired
    private RepositorioCarrito repositorioCarrito;


    public List<Carrito> findByUserId(String userId){
        return repositorioCarrito.findByUserId(userId);
    }

    

}
