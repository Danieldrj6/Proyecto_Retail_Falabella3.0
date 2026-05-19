package com.example.ms_stock.controller;

import com.example.ms_stock.service.*;

import com.example.ms_stock.model.Stock;
import com.example.ms_stock.service.stockService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/stock")
public class stockController {

    @Autowired
    private stockService StockService;

    @GetMapping
    public List<Stock> listarStock(){
        return StockService.getStock();
    }

    @PostMapping
    public Stock guardarStock(@RequestBody Stock stock){
        return StockService.saveStock(stock);
    }

    @GetMapping("/producto/{id}")
    public Stock obtenerStockbyId(@PathVariable int id) {
        return StockService.findById(null);
    }



}
