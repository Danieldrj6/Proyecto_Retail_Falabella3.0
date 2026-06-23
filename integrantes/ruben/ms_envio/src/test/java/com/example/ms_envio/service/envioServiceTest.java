package com.example.ms_envio.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.ms_envio.model.Envio;
import com.example.ms_envio.repository.envioRepository;

class envioServiceTest {

    @Mock
    private envioRepository envioRepositoryMock;

    @InjectMocks
    private envioService envioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEnvios() {
        Envio envio1 = new Envio();
        Envio envio2 = new Envio();
        List<Envio> envios = Arrays.asList(envio1, envio2);

        when(envioRepositoryMock.obtenerEnvios()).thenReturn(envios);

        List<Envio> result = envioService.getEnvios();

        assertEquals(2, result.size());
        verify(envioRepositoryMock, times(1)).obtenerEnvios();
    }

    @Test
    void testSaveEnvio() {
        Envio envio = new Envio();
        when(envioRepositoryMock.guardar(any(Envio.class))).thenReturn(envio);

        Envio result = envioService.saveEnvio(envio);

        assertNotNull(result);
        verify(envioRepositoryMock, times(1)).guardar(envio);
    }

    @Test
    void testGetEnvioId() {
        int id = 1;
        Envio envio = new Envio();
        when(envioRepositoryMock.buscarPorIdEnvio(id)).thenReturn(envio);

        Envio result = envioService.getEnvioId(id);

        assertNotNull(result);
        verify(envioRepositoryMock, times(1)).buscarPorIdEnvio(id);
    }

    @Test
    void testGetEnvioIdCompra() {
        int idCompra = 100;
        Envio envio = new Envio();
        when(envioRepositoryMock.buscarPorIdCompra(idCompra)).thenReturn(envio);

        Envio result = envioService.getEnvioIdCompra(idCompra);

        assertNotNull(result);
        verify(envioRepositoryMock, times(1)).buscarPorIdCompra(idCompra);
    }

    @Test
    void testUpdateEnvio() {
        Envio envio = new Envio();
        when(envioRepositoryMock.actualizar(any(Envio.class))).thenReturn(envio);

        Envio result = envioService.updateEnvio(envio);

        assertNotNull(result);
        verify(envioRepositoryMock, times(1)).actualizar(envio);
    }

    @Test
    void testTotalEnvios() {
        int expectedTotal = 5;
        when(envioRepositoryMock.totalEnvios()).thenReturn(expectedTotal);

        int result = envioService.totalEnvios();

        assertEquals(expectedTotal, result);
        verify(envioRepositoryMock, times(1)).totalEnvios();
    }
}
