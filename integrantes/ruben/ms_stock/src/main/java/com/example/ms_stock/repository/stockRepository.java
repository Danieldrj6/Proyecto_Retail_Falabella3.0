package com.example.ms_stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.ms_stock.model.Stock;

import java.util.ArrayList;
import java.util.List;


public interface stockRepository  extends JpaRepository<Stock, Integer>{

    List<Stock> findByStockId(int stockId);


    
} 
