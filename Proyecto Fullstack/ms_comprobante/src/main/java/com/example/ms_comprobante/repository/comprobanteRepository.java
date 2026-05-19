package com.example.ms_comprobante.repository;

import com.example.ms_comprobante.model.*;
import java.util.*;
import org.springframework.stereotype.Repository;

@Repository

public class comprobanteRepository {

    private List<Comprobante> listaComprobantes = new ArrayList<>();

    public List<Comprobante> obtenerComprobantes(){
        return listaComprobantes;
    }

    public Comprobante buscarPorIdComprobante (int id){
        for (Comprobante comprobante : listaComprobantes){
            if (comprobante.getId() == id){
                return comprobante;
            }
        }
        return null;
    }

    public Comprobante buscarPorIdPedido(int id_pedi){
        for (Comprobante comprobante : listaComprobantes){
            if (comprobante.getId_pedido() == id_pedi){
                return comprobante;
            }
        }
        return null;
    }

    public Comprobante guardar(Comprobante comprobante){
        listaComprobantes.add(comprobante);
        return comprobante;
    }

    public int totalComprobantes(){
        return listaComprobantes.size();
    }

}
