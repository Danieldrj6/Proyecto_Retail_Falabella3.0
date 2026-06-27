package com.example.ms_pedido.client;

import com.example.ms_pedido.model.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-usuario")
public interface UsuarioClient {

    @GetMapping("/api/v1/usuarios/{id}")
    Usuario findById(@PathVariable Integer id);
}