package main.java.com.example.ms_stock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stock")

public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stockId;

    @Column(name = "id_producto")
    private int producto_id;

    @Column(name = "cantidad_producto", nullable = false)
    private int producto_cant;

}
