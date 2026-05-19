package com.example.ms_stock.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_stock.model.*;
import com.example.ms_stock.repository.stockRepository;

import jakarta.persistence.Id;

import com.example.ms_stock.model.Stock;

@Service
public class stockService {

    @Autowired
    private stockRepository repository;
    
    public List<Stock> getStock(){
        return repository.findAll();
    }

    public Stock saveStock(Stock stock){
        return repository.save(stock);
    }

    public void deleteById(Stock stock){
        repository.deleteById(null);
    }

    public Stock findById(Integer id){
        repository.findByStockId(id);
        return null;
    } 


}
