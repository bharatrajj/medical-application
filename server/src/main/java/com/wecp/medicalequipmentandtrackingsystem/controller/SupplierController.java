package com.wecp.medicalequipmentandtrackingsystem.controller;

import com.wecp.medicalequipmentandtrackingsystem.entitiy.Orders;


import com.wecp.medicalequipmentandtrackingsystem.entitiy.Orders;

import com.wecp.medicalequipmentandtrackingsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class SupplierController {
@Autowired
private OrderService orderService;
@GetMapping("/api/supplier/orders")
public ResponseEntity<List<Orders>> getAllOrders() {
List<Orders> a=orderService.getAllOrders();
return new ResponseEntity<>(a,HttpStatus.OK);
// get all order and return it status code 200 OK
}
@PutMapping("/api/supplier/order/update/{orderId}")
public ResponseEntity<Orders> updateOrderStatus(@PathVariable Long orderId, @RequestParam String newStatus) {
Orders b=orderService.updateOrderStatus(orderId, newStatus);
return new ResponseEntity<>(b,HttpStatus.OK);
// update order status and return updated order with status code 200 
}
}


