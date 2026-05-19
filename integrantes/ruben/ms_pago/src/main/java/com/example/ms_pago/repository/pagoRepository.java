package com.example.ms_pago.repository;

import com.example.ms_pago.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface pagoRepository extends JpaRepository<Pago, Integer> {

    List<Pago> findbyId(Integer Id);
    List<Pago> findByIdpago(int id_pedido);

}
