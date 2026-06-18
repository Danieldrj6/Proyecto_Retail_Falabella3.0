package com.ms_carrito.example.ms_carrito20;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.ms_carrito.example.ms_carrito20.model.Carrito;
import com.ms_carrito.example.ms_carrito20.model.CarritoItems;
import com.ms_carrito.example.ms_carrito20.repository.RepositoryCarrito;
import com.ms_carrito.example.ms_carrito20.repository.RepositoryItemsCarrito;

import net.datafaker.Faker;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    private RepositoryCarrito repositoryCarrito;
    @Autowired
    private RepositoryItemsCarrito repositoryItemsCarrito;

    @Override
    public void run(String... args) throws Exception{
        Faker faker = new Faker();
        Random random = new Random();

        // generar carrito
        for (int i = 0; i < 10; i++){
            Carrito carrito = new Carrito();
            carrito.setUserId(i + 1);
            carrito.setTotalPrecio(faker.number().numberBetween(5000, 500000));
            repositoryCarrito.save(carrito); 
        }

        List<Carrito> carritos = repositoryCarrito.findAll();

        // Generar carrito items
        for (int i = 0; i < 3; i++){
            CarritoItems carritoItems = new CarritoItems();
            carritoItems.setCarrito_id(carritos.get(i).getId());
            carritoItems.setProducto_id(i+1);
            carritoItems.setCantidad(faker.number().numberBetween(1, 10));
            repositoryItemsCarrito.save(carritoItems);
        }

    }

}
