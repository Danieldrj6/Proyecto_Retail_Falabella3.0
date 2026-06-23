package com.ms_carrito.example.ms_carrito20;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import com.ms_carrito.example.ms_carrito20.model.Carrito;
import com.ms_carrito.example.ms_carrito20.repository.RepositoryCarrito;
import com.ms_carrito.example.ms_carrito20.services.ServicesCarrito;
import static org.mockito.Mockito.*;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
public class CarritoServicesTest {

    @Autowired
    private ServicesCarrito servicesCarrito;

    @MockitoBean
    private RepositoryCarrito repositoryCarrito;

    @Test
    public void testFindAll(){
        when(repositoryCarrito.findAll()).thenReturn(List.of(new Carrito(1, 1,10000)));

        List<Carrito> carritos = servicesCarrito.findAll();

        assertNotNull(carritos);
        assertEquals(1, carritos.size());
    }

    @Test
    public void testFindByCodigo(){
        Integer id = 1;
        Carrito carrito = new Carrito(1, 1, 10000);

        when(repositoryCarrito.findById(id)).thenReturn(Optional.of(carrito));

        Carrito found = servicesCarrito.findById(id);

        assertNotNull(found);
        assertEquals(id, found.getId());
    }

    @Test
    public void testSave(){
        Carrito carrito = new Carrito(1, 1, 10000);

        when(repositoryCarrito.save(carrito)).thenReturn(carrito);

        Carrito saved = servicesCarrito.save(carrito);

        assertNotNull(saved);
        assertEquals(1, 1, saved.getTotalPrecio());
    }

    @Test
    public void testDeleteById(){
        Integer id = 1;

        doNothing().when(repositoryCarrito).deleteById(id);

        servicesCarrito.deleteById(id);

        verify(repositoryCarrito, times(1)).deleteById(id);
    }

}