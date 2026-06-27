package com.example.ms_stock.controller;

import com.example.ms_stock.model.Stock;
import com.example.ms_stock.service.stockService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/stock")
@Tag(name = "Stock", description = "API de gestion de stock de productos en el retail")
public class stockController {

    @Autowired
    private stockService StockService;

    @GetMapping
    @Operation(summary = "Listar stock", description = "Retorna la lista de todo el stock disponible")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con exito")
    public List<Stock> listarStock(){
        return StockService.getStock();
    }

    @PostMapping
    @Operation(summary = "Guardar stock", description = "Registra un nuevo registro de stock en el sistema")
    @ApiResponse(responseCode = "200", description = "Stock guardado con exito")
    public Stock guardarStock(@RequestBody Stock stock){
        return StockService.saveStock(stock);
    }

    @GetMapping("/producto/{id}")
    @Operation(summary = "Obtener stock por ID de producto", description = "Retorna el stock asociado a un producto especifico")
    @ApiResponse(responseCode = "200", description = "Stock encontrado con exito")
    public Stock obtenerStockbyId(
            @Parameter(description = "ID del producto", required = true) @PathVariable int id) {
        return StockService.findById(null);
    }



}
