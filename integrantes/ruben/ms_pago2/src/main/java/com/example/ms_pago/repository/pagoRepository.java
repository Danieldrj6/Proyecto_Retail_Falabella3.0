package com.example.ms_pago.repository;

import com.example.ms_pago2.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface pagoRepository extends JpaRepository<Pedido, Integer> {

    List<Pago> findbyId(Integer Id);
    List<Pago> findByIdPedido(int id_pedi);

    
}