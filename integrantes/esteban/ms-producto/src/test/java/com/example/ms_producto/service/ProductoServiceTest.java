package com.example.ms_producto.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.ms_producto.model.Producto;
import com.example.ms_producto.repository.ProductoRepository;

class ProductoServiceTest {

    @Mock
    private ProductoRepository repository;

    @InjectMocks
    private ProductoService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenExistingProductos_whenFindAll_thenReturnList() {
        
        Producto p1 = new Producto(1, "Electronica", "Samsung", "TV 55", 500000, new Date());
        Producto p2 = new Producto(2, "Electronica", "LG", "Monitor 27", 350000, new Date());
        when(repository.findAll()).thenReturn(Arrays.asList(p1, p2));

        
        List<Producto> result = service.findAll();

        
        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void givenExistingId_whenFindById_thenReturnProducto() {
        
        Integer id = 1;
        Producto producto = new Producto(id, "Electronica", "Samsung", "TV 55", 500000, new Date());
        when(repository.findById(id)).thenReturn(Optional.of(producto));

        
        Producto result = service.findById(id);

        
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Samsung", result.getMarcaProducto());
        verify(repository, times(1)).findById(id);
    }

    @Test
    void givenNonExistingId_whenFindById_thenReturnNull() {
        
        Integer id = 99;
        when(repository.findById(id)).thenReturn(Optional.empty());

        
        Producto result = service.findById(id);

        
        assertNull(result);
        verify(repository, times(1)).findById(id);
    }

    @Test
    void givenNewProducto_whenSave_thenSetFechaIngresoAndReturn() {
        
        Producto input = new Producto();
        input.setNombreProducto("Laptop Gamer");
        input.setMarcaProducto("ASUS");
        input.setPrecio(1200000);

        when(repository.save(any(Producto.class))).thenAnswer(invocation -> {
            Producto p = invocation.getArgument(0);
            p.setId(1);
            return p;
        });

        
        Producto result = service.save(input);

        
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertNotNull(result.getFechaIngreso(), "La fecha de ingreso debe asignarse automaticamente");
        assertEquals("Laptop Gamer", result.getNombreProducto());
        verify(repository, times(1)).save(any(Producto.class));
    }

    @Test
    void givenExistingProducto_whenUpdate_thenReturnUpdatedProducto() {
        
        Integer id = 1;
        Producto input = new Producto();
        input.setNombreProducto("TV 65 OLED");
        input.setPrecio(900000);

        when(repository.save(any(Producto.class))).thenAnswer(invocation -> invocation.getArgument(0));

        
        Producto result = service.update(id, input);

        
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("TV 65 OLED", result.getNombreProducto());
        verify(repository, times(1)).save(any(Producto.class));
    }

    @Test
    void givenExistingId_whenDeleteById_thenRepositoryDeleteIsCalled() {
        
        Integer id = 1;
        doNothing().when(repository).deleteById(id);

        
        service.deleteById(id);

        
        verify(repository, times(1)).deleteById(id);
    }

    @Test
    void givenMarca_whenFindByMarca_thenReturnFilteredList() {
        
        String marca = "Samsung";
        Producto p1 = new Producto(1, "Electronica", "Samsung", "TV 55", 500000, new Date());
        when(repository.findByMarcaProducto(marca)).thenReturn(Arrays.asList(p1));

        
        List<Producto> result = service.findByMarca(marca);

        
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        verify(repository, times(1)).findByMarcaProducto(marca);
    }

    @Test
    void givenNombre_whenFindByNombre_thenReturnFilteredList() {
        
        String nombre = "TV 55";
        Producto p1 = new Producto(1, "Electronica", "Samsung", "TV 55", 500000, new Date());
        when(repository.findByNombreProducto(nombre)).thenReturn(Arrays.asList(p1));

        
        List<Producto> result = service.findByNombre(nombre);

        
        assertFalse(result.isEmpty());
        assertEquals("TV 55", result.get(0).getNombreProducto());
        verify(repository, times(1)).findByNombreProducto(nombre);
    }
}
