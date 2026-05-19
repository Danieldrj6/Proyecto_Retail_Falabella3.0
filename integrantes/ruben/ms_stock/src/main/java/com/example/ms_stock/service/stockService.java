package main.java.com.example.ms_stock.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_stock.model.*;

import main.java.com.example.ms_stock.model.Stock;
import main.java.com.example.ms_stock.repository.stockRepository;

@Service
public class stockService {

    @Autowired
    private stockRepository StockRepository;
    
    public List<Stock> getStock(){
        return StockRepository.obtenerStockProductos();
    }

    public Stock saveStock(Stock stock){
        return StockRepository.guardar(stock);
    }

    public Stock getStockbyIdProducto(int id){
        return StockRepository.buscarPorIdProducto(id);
    }

    public int getTotalStock(){
        return StockRepository.stockTotal();
    }


}
