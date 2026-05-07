package com.ms_carrito.example.ms_carrito20.client;

import lombok.Data;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "ms_producto", url = "${product.service.url}")
public interface productoClient {

    @GetMapping("/api/v1/producto/{id}")
    ProductResponse getProductById(@PathVariable("id") Integer id);

    @Data
    class ProductResponse {
        private Integer id;
        private String tipoProducto;
        private String marcaProducto;
        private String nombreProducto;
        private Integer precio;
    }

}
