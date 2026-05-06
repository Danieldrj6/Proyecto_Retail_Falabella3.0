package com.example.ms_producto.repository;

import com.example.ms_producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>
{

    List<Producto> findByTipoProducto(String tipoProducto);

    List<Producto> findByMarcaProducto(String marcaProducto);
    
    List<Producto> findByNombreProducto(String nombreProducto);

    List<Producto> findByPrecio(Integer precio);
}
