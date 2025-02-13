package com.ecommerce.api.controllers;

import com.ecommerce.api.dto.OrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService service;

    // Endpoint para listar todos os itens de pedido
    @GetMapping
    public ResponseEntity<List<OrderItemDTO>> findAll() {
        List<OrderItemDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    // Endpoint para salvar um novo item de pedido
    @PostMapping
    public ResponseEntity<OrderItemDTO> insert(@RequestBody OrderItemCreateDTO dto) {
        OrderItemDTO orderItemDTO = service.save(dto);
        return ResponseEntity.ok(orderItemDTO);
    }
}