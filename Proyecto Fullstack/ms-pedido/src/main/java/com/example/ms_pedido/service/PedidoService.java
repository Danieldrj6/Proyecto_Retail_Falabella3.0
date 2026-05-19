package com.example.ms_pedido.service;

import com.example.ms_pedido.client.*;
import com.example.ms_pedido.model.*;
import com.example.ms_pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private ProductoClient productoClient;

    public List<Pedido> findAll() {
        return repository.findAll();
    }

    public Pedido findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Pedido> findByUsuarioId(Integer usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public List<Pedido> findByEstado(String estado) {
        return repository.findByEstado(estado);
    }

    public Pedido save(Pedido pedido) {
        Usuario usuario = usuarioClient.findById(pedido.getUsuarioId());
        if (usuario == null) return null;

        if (pedido.getDetalles() != null) {
            Integer total = 0;
            for (DetallePedido detalle : pedido.getDetalles()) {
                Producto producto = productoClient.findById(detalle.getProductoId());
                if (producto == null) return null;
                detalle.setPrecioUnitario(producto.getPrecio());
                total += detalle.getCantidad() * producto.getPrecio();
            }
            pedido.setTotal(total);
        }

        pedido.setFecha(new Date());
        pedido.setEstado("PENDIENTE");
        return repository.save(pedido);
    }

    public Pedido update(Integer id, Pedido pedido) {
        pedido.setId(id);
        return repository.save(pedido);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}