package com.example.ms_pedido.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.ms_pedido.client.ProductoClient;
import com.example.ms_pedido.client.UsuarioClient;
import com.example.ms_pedido.model.DetallePedido;
import com.example.ms_pedido.model.Pedido;
import com.example.ms_pedido.model.Producto;
import com.example.ms_pedido.model.Usuario;
import com.example.ms_pedido.repository.PedidoRepository;

class PedidoServiceTest {

    @Mock
    private PedidoRepository repository;

    @Mock
    private UsuarioClient usuarioClient;

    @Mock
    private ProductoClient productoClient;

    @InjectMocks
    private PedidoService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenNonExistingUsuario_whenSave_thenReturnNull() {
        // Given
        Pedido pedido = new Pedido();
        pedido.setUsuarioId(1);

        when(usuarioClient.findById(1)).thenReturn(null);

        // When
        Pedido result = service.save(pedido);

        // Then
        assertNull(result, "Si el usuario no existe, el pedido no debe guardarse y debe retornar null");
        verify(usuarioClient, times(1)).findById(1);
        verify(repository, never()).save(any(Pedido.class));
    }

    @Test
    void givenNonExistingProductoInDetails_whenSave_thenReturnNull() {
        // Given
        Pedido pedido = new Pedido();
        pedido.setUsuarioId(1);

        DetallePedido detalle = new DetallePedido();
        detalle.setProductoId(10);
        detalle.setCantidad(2);
        pedido.setDetalles(Arrays.asList(detalle));

        Usuario usuario = new Usuario();
        usuario.setId(1);

        when(usuarioClient.findById(1)).thenReturn(usuario);
        when(productoClient.findById(10)).thenReturn(null);

        // When
        Pedido result = service.save(pedido);

        // Then
        assertNull(result, "Si un producto del detalle no existe, el pedido no debe guardarse y debe retornar null");
        verify(usuarioClient, times(1)).findById(1);
        verify(productoClient, times(1)).findById(10);
        verify(repository, never()).save(any(Pedido.class));
    }

    @Test
    void givenValidPedido_whenSave_thenCalculateTotalAndSetDefaultsAndSave() {
        // Given
        Pedido pedido = new Pedido();
        pedido.setUsuarioId(1);

        DetallePedido detalle1 = new DetallePedido();
        detalle1.setProductoId(10);
        detalle1.setCantidad(2);

        DetallePedido detalle2 = new DetallePedido();
        detalle2.setProductoId(20);
        detalle2.setCantidad(1);

        List<DetallePedido> detalles = new ArrayList<>();
        detalles.add(detalle1);
        detalles.add(detalle2);
        pedido.setDetalles(detalles);

        Usuario usuario = new Usuario();
        usuario.setId(1);

        Producto prod1 = new Producto();
        prod1.setId(10);
        prod1.setPrecio(50);

        Producto prod2 = new Producto();
        prod2.setId(20);
        prod2.setPrecio(100);

        when(usuarioClient.findById(1)).thenReturn(usuario);
        when(productoClient.findById(10)).thenReturn(prod1);
        when(productoClient.findById(20)).thenReturn(prod2);
        
        when(repository.save(any(Pedido.class))).thenAnswer(invocation -> {
            Pedido p = invocation.getArgument(0);
            p.setId(99); // Simular asignación de ID por la DB
            return p;
        });

        // When
        Pedido result = service.save(pedido);

        // Then
        assertNotNull(result);
        assertEquals(99, result.getId());
        assertEquals(200, result.getTotal(), "El total calculado debe ser (2 * 50) + (1 * 100) = 200");
        assertEquals("PENDIENTE", result.getEstado(), "El estado inicial debe ser 'PENDIENTE'");
        assertNotNull(result.getFecha(), "La fecha del pedido debe ser establecida");
        
        assertEquals(50, detalle1.getPrecioUnitario(), "El precio unitario del detalle 1 debe ser 50");
        assertEquals(100, detalle2.getPrecioUnitario(), "El precio unitario del detalle 2 debe ser 100");

        verify(usuarioClient, times(1)).findById(1);
        verify(productoClient, times(1)).findById(10);
        verify(productoClient, times(1)).findById(20);
        verify(repository, times(1)).save(any(Pedido.class));
    }
}
