package com.example.ms_pago.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_pago.model.*;
import com.example.ms_pago.repository.pagoRepository;

@Service
public class pagoService {

    @Autowired
    private pagoRepository repository;

    public List<Pago> findByPagos(Integer idPedido) {
    return repository.findByIdPedido(idPedido);
    }

    public List<Pago> findAll(){
        return repository.findAll();
    } 

    public Pago save(Pago pago){
        return repository.save(pago);
    }

}