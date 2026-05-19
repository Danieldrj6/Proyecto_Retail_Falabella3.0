package com.example.ms_comprobante.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_comprobante.model.*;
import com.example.ms_comprobante.repository.*;

@Service

public class comprobanteService {

    @Autowired
    private comprobanteRepository ComprobanteRepository;

    public List<Comprobante> getComprobantes(){
        return ComprobanteRepository.obtenerComprobantes();
    }

    public Comprobante saveComprobante(Comprobante comprobante){
        return ComprobanteRepository.guardar(comprobante);
    }

    public Comprobante getComprobanteId(int id){
        return ComprobanteRepository.buscarPorIdComprobante(id);
    }

    public Comprobante getComprobanteIdPedido(int id_pedi){
        return ComprobanteRepository.buscarPorIdPedido(id_pedi);
    }

    public int totalComprobantes(){
        return ComprobanteRepository.totalComprobantes();
    }

}
