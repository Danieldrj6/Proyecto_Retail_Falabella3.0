package main.java.com.example.ms_soporte.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_comprobante.model.*;
import com.example.ms_comprobante.repository.*;

import main.java.com.example.ms_soporte.model.Soporte;
import main.java.com.example.ms_soporte.repository.soporteRepository;

@Service

public class soporteService {

    @Autowired
    private soporteRepository SoporteRepository;

    public List<Soporte> getSoportes(){
        return SoporteRepository.obtenerSoportes();
    }

    public Soporte saveSoporte(Soporte soporte){
        return SoporteRepository.guardar(soporte);
    }

    public Soporte getSoporteTicketID(int id_ticket){
        return SoporteRepository.buscarPorIdSoporte(id_ticket);
    }

    public Soporte getSoporteUsu(int id_usu){
        return SoporteRepository.buscarPorIdUsuario(id_usu);
    }

    public int totalSoportes(){
        return SoporteRepository.totalSoportes();
    }


}
