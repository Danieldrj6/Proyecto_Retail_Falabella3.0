package com.example.ms_soporte.repository;

import com.example.ms_soporte.model.*;



import java.util.*;
import org.springframework.stereotype.Repository;

@Repository

public class soporteRepository {

    private List<Soporte> listaSoportes = new ArrayList<>();

    public List<Soporte> obtenerSoportes(){
        return listaSoportes;
    }

    public Soporte buscarPorIdSoporte (int id){
        for (Soporte soporte : listaSoportes){
            if (soporte.getId_ticket() == id){
                return soporte;
            }
        }
        return null;
    }

    public Soporte buscarPorIdUsuario(int id_usu){
        for (Soporte soporte : listaSoportes){
            if (soporte.getId_usuario() == id_usu){
                return soporte;
            }
        }
        return null;
    }

    public Soporte guardar(Soporte soporte){
        listaSoportes.add(soporte);
        return soporte;
    }

    public int totalSoportes(){
        return listaSoportes.size();
    }

}
