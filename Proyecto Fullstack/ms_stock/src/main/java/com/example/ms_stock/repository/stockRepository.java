package main.java.com.example.ms_stock.repository;

import com.example.ms_stock.model.*;

import main.java.com.example.ms_stock.model.Stock;

import java.util.ArrayList;
import java.util.List;

public class stockRepository {

    private List<Stock> stockProductos = new ArrayList<>();


    public List<Stock> obtenerStockProductos(){
        return stockProductos;
    }

    public stockRepository(){
        stockProductos.add(new Stock(1, 1, 1, 1));
    }

    public Stock buscarPorIdProducto (int id){
        for (Stock produ : stockProductos){
            if (produ.getProducto_id() == id){
                return produ;
            }
        }
        return null;
    }

    public Stock guardar(Stock stockprodu){
        stockProductos.add(stockprodu);
        return stockprodu;
    }

    public int stockTotal(){
        return stockProductos.size();
    }

}
