package com.example.pago2.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_pago2.model.*;
import com.example.ms_pago2.repository.pagoRepository;

@Service
public class pagoService {

    private main.java.com.example.ms_pago2.repository.pagoRepository PagoRepository;

    public List<Pago> getPagos(){
        return PagoRepository.getPagos();
    }

    public Pago savePago(Pago pago){
        return PagoRepository.savePago(pago);
    }

    public Pago getPagoById(int id){
        return PagoRepository.findbyId(id);
    }

    public Pago getPagoByIdPedido(int id_ped){
        return PagoRepository.findByIdPedido(id_ped);
    }

    public Pago updatePago(Pago pago){
        return PagoRepository.updatePago(pago);
    }
}
