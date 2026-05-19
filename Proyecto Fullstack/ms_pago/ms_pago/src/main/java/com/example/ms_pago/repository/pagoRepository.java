package main.java.com.example.ms_pago.repository;

import main.java.com.example.ms_pago.model.Pago;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository

public class pagoRepository {
    private List<Pago> listaPagos = new ArrayList<>();

    public List<Pago> obtenerPagos(){
        return listaPagos;
    }

    public PagoRepository(){
        listaPagos.add(new Pago(1, 1000, "Debito","Boleta",1));
    }

    public Pago guardarPago(Pago pago){
        listaPagos.add(pago);
        return pago;

        
    }

    public Pago actualizarPago(Pago pago){
        int id=0;
        int id_posicion=0;

        for (int i = 0; i < listaPagos.size(); i++){
            if (listaPagos.get(i).getId() == pago.getId()){
                id = pago.getId();
                id_posicion = i;
            }
        }
        Pago pago1 = new Pago();
        pago1.setId(id);
        pago1.setMontoPago(pago.getMontoPago());
        pago1.setTipoPago(pago.getTipoPago());
        pago1.setTipoComprobante(pago.getTipoComprobante());
        pago1.setId_pedido(pago.getId_pedido());
        listaPagos.set(id_posicion, pago1);
        return pago1;
    }


    public Envio buscarPorIdPago (int id){
        for (PAgo pago : listaPagos){
            if (pago.getId() == id){
                return pago;
            }
        }
        return null;
    }

    public Pago buscarPorIdPedido(int id_pedi){
        for (Pago pago : listaPagos){
            if (pago.getId_pedido() == id_pedi){
                return pago;
            }
        }
        return null;
    }

    public int totalPagos(){
        return listaPagos.size();
    }

}
