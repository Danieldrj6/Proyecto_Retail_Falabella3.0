package com.example.ms_usuario.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.ms_usuario.model.Usuario;
import com.example.ms_usuario.repository.UsuarioRepository;

class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenExistingUsuarios_whenFindAll_thenReturnList() {
        
        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario();
        when(repository.findAll()).thenReturn(Arrays.asList(u1, u2));

        
        List<Usuario> result = service.findALL();

        
        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void givenExistingId_whenFindById_thenReturnUsuario() {
        
        Integer id = 1;
        Usuario usuario = new Usuario();
        usuario.setId(id);
        when(repository.findById(id)).thenReturn(Optional.of(usuario));

        
        Usuario result = service.findById(id);

        
        assertNotNull(result);
        assertEquals(id, result.getId());
        verify(repository, times(1)).findById(id);
    }

    @Test
    void givenNonExistingId_whenFindById_thenReturnNull() {
        
        Integer id = 99;
        when(repository.findById(id)).thenReturn(Optional.empty());

        
        Usuario result = service.findById(id);

        
        assertNull(result);
        verify(repository, times(1)).findById(id);
    }

    @Test
    void givenNewUsuario_whenSave_thenReturnSavedUsuarioWithDefaults() {
        
        Usuario input = new Usuario();
        input.setNombre("Esteban");
        input.setCorreo("esteban@gmail.com");

        Usuario saved = new Usuario();
        saved.setId(1);
        saved.setNombre("Esteban");
        saved.setCorreo("esteban@gmail.com");
        
        when(repository.save(any(Usuario.class))).thenAnswer(invocation -> {
            Usuario u = invocation.getArgument(0);
            u.setId(1);
            return u;
        });

        
        Usuario result = service.save(input);

        
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertNotNull(result.getFechaRegistro(), "La fecha de registro no debe ser nula");
        assertEquals("Usuario", result.getRol(), "El rol por defecto debe ser 'Usuario'");
        assertTrue(result.getActivo(), "El usuario debe estar activo por defecto");
        verify(repository, times(1)).save(any(Usuario.class));
    }

    @Test
    void givenExistingUsuario_whenUpdate_thenReturnUpdatedUsuario() {
        
        Integer id = 1;
        Usuario input = new Usuario();
        input.setNombre("Esteban Rojas");

        when(repository.save(any(Usuario.class))).thenAnswer(invocation -> invocation.getArgument(0));

        
        Usuario result = service.update(id, input);

        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Esteban Rojas", result.getNombre());
        verify(repository, times(1)).save(any(Usuario.class));
    }
}
