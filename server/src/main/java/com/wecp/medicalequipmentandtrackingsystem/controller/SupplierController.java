package com.wecp.medicalequipmentandtrackingsystem.controller;
<<<<<<< HEAD
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Orders;
=======
<<<<<<< HEAD
 
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Order;
=======

import com.wecp.medicalequipmentandtrackingsystem.entitiy.Orders;
>>>>>>> Pratik
>>>>>>> 353971eb3ca117f2e834180caa08f55a069e4998
import com.wecp.medicalequipmentandtrackingsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
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
public ResponseEntity<Orders> updateOrderStatus(@PathVariable Long
orderId, @RequestParam String newStatus) {
Orders b=orderService.updateOrderStatus(orderId, newStatus);
return new ResponseEntity<>(b,HttpStatus.OK);
// update order status and return updated order with status code 200 
}
}
=======
 
import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
 
@RestController
public class SupplierController {
   
    @Autowired
    private OrderService orderService;
 
    @GetMapping("/api/supplier/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> a=orderService.getAllOrders();
        return new ResponseEntity<>(a,HttpStatus.OK);
        // get all order and return it status code 200 OK
=======

@RestController
public class SupplierController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/api/supplier/orders")
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
>>>>>>> Pratik
    }
 
    @PutMapping("/api/supplier/order/update/{orderId}")
<<<<<<< HEAD
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long orderId, @RequestParam String newStatus) {
        Order b=orderService.updateOrderStatus(orderId, newStatus);
        return new  ResponseEntity<>(b,HttpStatus.OK);
 
        // update order status and return updated order with status code 200 OK
=======
    public ResponseEntity<Orders> updateOrderStatus(@PathVariable Long orderId, @RequestParam String newStatus) {
        Orders updatedOrder = orderService.updateOrderStatus(orderId, newStatus);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
>>>>>>> Pratik
    }
}
>>>>>>> 353971eb3ca117f2e834180caa08f55a069e4998
