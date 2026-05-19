package main.java.com.example.ms_pago.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_pago.model.*;
import com.example.ms_pago.repository.pagoRepository;

@Service
public class pagoService {

    private main.java.com.example.ms_pago.repository.pagoRepository PagoRepository;

    public List<Pago> getPagos(){
        return PagoRepository.obtenerPagos();
    }

    public Pago savePago(Pago pago){
        return PagoRepository.guardarPago(pago);
    }

    public Pago getPagoById(int id){
        return PagoRepository.buscarPorIdPago(id);
    }

    public Pago getPagoByIdPedido(int id_ped){
        return PagoRepository.buscarPorIdPedido(id_ped);
    }

    public Pago updatePago(Pago pago){
        return PagoRepository.actualizarPago(pago);
    }

    public int countPagos(){
        return PagoRepository.totalPagos();
    }

}
