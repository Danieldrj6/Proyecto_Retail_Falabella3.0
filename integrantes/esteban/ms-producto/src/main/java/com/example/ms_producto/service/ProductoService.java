package com.example.ms_producto.service;

import com.example.ms_producto.model.Producto;
import com.example.ms_producto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repository;

    public Producto findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Producto> findAll() {
        return repository.findAll();
    }

    public Producto save(Producto producto) {
        producto.setFechaIngreso(new Date());
        return repository.save(producto);
    }

    public Producto update(Integer id, Producto producto){
        producto.setId(id);
        return repository.save(producto);
    }
    
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
    
    public List<Producto> findByTipo(String tipo){
        return repository.findByMarcaProducto(tipo);
    }

    public List<Producto> findByMarca(String marca){
        return repository.findByMarcaProducto(marca);
    }

    public List<Producto> findByNombre(String nombre){
        return repository.findByNombreProducto(nombre);
    }


}

