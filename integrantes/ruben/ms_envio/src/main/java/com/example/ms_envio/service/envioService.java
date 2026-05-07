package com.example.ms_envio.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_envio.model.*;
import com.example.ms_envio.repository.envioRepository;

@Service
public class envioService {
    @Autowired
    private envioRepository EnvioRepository;

    public List<Envio> getEnvios(){
        return EnvioRepository.obtenerEnvios();
    }

    public Envio saveEnvio(Envio envio){
        return EnvioRepository.guardar(envio);
    }

    public Envio getEnvioId(int id){
        return EnvioRepository.buscarPorIdEnvio(id);
    }

    public Envio getEnvioIdCompra(int id_compra){
        return EnvioRepository.buscarPorIdCompra(id_compra);
    }

    public Envio updateEnvio(Envio envio){
        return EnvioRepository.actualizar(envio);
    }

    public int totalEnvios(){
        return EnvioRepository.totalEnvios();
    }

}
