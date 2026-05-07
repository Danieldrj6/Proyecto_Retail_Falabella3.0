package com.example.ms_envio.repository;

import com.example.ms_envio.model.*;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class envioRepository {

    private List<Envio> listaEnvios = new ArrayList<>();

    public List<Envio> obtenerEnvios(){
        return listaEnvios;
    }

    public envioRepository(){
        listaEnvios.add(new Envio(0, 0, "0"));
    }

    public Envio buscarPorIdEnvio (int id){
        for (Envio envio : listaEnvios){
            if (envio.getId() == id){
                return envio;
            }
        }
        return null;
    }
    
    public Envio buscarPorIdCompra(int id_compra){
        for (Envio envio : listaEnvios){
            if (envio.getId_compra() == id_compra){
                return envio;
            }
        }
        return null;
    }

    public Envio guardar(Envio envio){
        listaEnvios.add(envio);
        return envio;
    }

    public Envio actualizar(Envio envi){
        int id=0;
        int id_posicion=0;

        for (int i = 0; i < listaEnvios.size(); i++){
            if (listaEnvios.get(i).getId() == envi.getId()){
                id = envi.getId();
                id_posicion = i;
            }
        }
        Envio envio1 = new Envio();
        envio1.setId(id);
        envio1.setId_compra(envi.getId_compra());
        envio1.setTipoEnvio(envi.getTipoEnvio());
        listaEnvios.set(id_posicion, envio1);
        return envio1;
    }

    public int totalEnvios(){
        return listaEnvios.size();
    }

}
