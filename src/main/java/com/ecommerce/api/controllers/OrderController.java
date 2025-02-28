//package com.ecommerce.api.controllers;
//
//
//import com.ecommerce.api.dto.OrderDTO;
//import com.ecommerce.api.services.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/orders")
//public class OrderController {
//
//    @Autowired
//    private OrderService orderService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
//        OrderDTO dto = orderService.findById(id);
//        return ResponseEntity.ok(dto);
//    }
//    @GetMapping
//    public ResponseEntity<List<OrderDTO>> getAllOrders() {
//        List<OrderDTO> list = orderService.getAllOrders();
//        return ResponseEntity.ok(list);
//    }
//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/cadastrar")
//    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
//        OrderDTO dto = orderService.createOrder(orderDTO);
//        return ResponseEntity.ok(dto);
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
//        OrderDTO dto = orderService.updateOrder(id, orderDTO);
//        return ResponseEntity.ok(dto);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
//        OrderDTO dto = orderService.deleteOrder(id);
//        return ResponseEntity.noContent().build();
//    }
//}
