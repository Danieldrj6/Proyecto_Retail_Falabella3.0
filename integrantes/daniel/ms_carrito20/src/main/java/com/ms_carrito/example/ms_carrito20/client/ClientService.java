package com.ms_carrito.example.ms_carrito20.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.ms_carrito.example.ms_carrito20.model.DTO.ProductoDTO;

@FeignClient(name = "ms-producto")
public interface ClientService {

    @GetMapping("/api/v1/producto/{id}")
    ProductoDTO findById(@PathVariable Integer id);
}