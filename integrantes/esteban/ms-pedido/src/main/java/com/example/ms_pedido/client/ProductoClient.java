package com.example.ms_pedido.client;

import com.example.ms_pedido.model.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-producto")
public interface ProductoClient {

    @GetMapping("/api/v1/productos/{id}")
    Producto findById(@PathVariable Integer id);
}
