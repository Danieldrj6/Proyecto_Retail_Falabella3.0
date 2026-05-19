package com.ms_carrito.example.ms_carrito20.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms_carrito.example.ms_carrito20.client.ClientService;
import com.ms_carrito.example.ms_carrito20.model.Carrito;
import com.ms_carrito.example.ms_carrito20.repository.RepositoryItemsCarrito;
import com.ms_carrito.example.ms_carrito20.model.DTO.ProductoDTO;
import com.ms_carrito.example.ms_carrito20.repository.RepositoryCarrito;
import com.ms_carrito.example.ms_carrito20.model.CarritoItems;

import java.util.List;

@Service
public class ServicesCarrito {

    @Autowired
    private RepositoryCarrito repositoryCarrito;

    @Autowired 
    private RepositoryItemsCarrito repositoryCarritoItems;

    @Autowired 
    private ClientService clientService;

    public List<Carrito>findAll(){
        return repositoryCarrito.findAll();
    }

    public Carrito save(Carrito carrito){
        return repositoryCarrito.save(carrito);
    }

    public CarritoItems save(CarritoItems carritoItem){
        return repositoryCarritoItems.save(carritoItem);
    }

    public List<Carrito>deleteById(Integer id){
        repositoryCarrito.deleteById(id);
        return repositoryCarrito.findAll();
    }

    public Carrito findById(Integer id){
        return repositoryCarrito.findById(id)
        .orElseThrow(() -> new RuntimeException("Id no encontrado"));
    }

    public CarritoItems agregarItem(Integer productoId, Integer carritoId, Integer cantidad){
        ProductoDTO producto = clientService.findById(productoId);
        if(producto == null){
            throw new IllegalArgumentException("Producto errado");
        }

        CarritoItems item = new CarritoItems();
        item.setCarrito_id(carritoId);
        item.setProducto_id(productoId);
        item.setCantidad(cantidad);
        item.setProducto(producto);
        repositoryCarritoItems.save(item);

        item.setProducto(producto);

        return item;
    }

}
