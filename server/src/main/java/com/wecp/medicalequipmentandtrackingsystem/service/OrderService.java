package com.wecp.medicalequipmentandtrackingsystem.service;
<<<<<<< HEAD
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Equipment;
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Orders;
import
com.wecp.medicalequipmentandtrackingsystem.repository.EquipmentRepository;
import com.wecp.medicalequipmentandtrackingsystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
=======
 
 
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Equipment;
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Orders;
import com.wecp.medicalequipmentandtrackingsystem.repository.EquipmentRepository;
import com.wecp.medicalequipmentandtrackingsystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
>>>>>>> 353971eb3ca117f2e834180caa08f55a069e4998
import javax.persistence.EntityNotFoundException;
 
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
<<<<<<< HEAD
@Service
public class OrderService {
@Autowired
private OrderRepository orderRepository;
@Autowired
private EquipmentRepository equipmentRepository;
public Orders placeOrder(Long equipmentId, Orders order) {
// Check if the equipment with the given ID exists
Equipment equipment = equipmentRepository.findById(equipmentId).orElseThrow(() -> new EntityNotFoundException("Equipment not found with ID: " + equipmentId));
order.setEquipment(equipment);
order.setOrderDate(new Date());
order.setStatus("Initiated");
// Save the order
return orderRepository.save(order);
}

public List<Orders> getAllOrders() {
    return orderRepository.findAll();
    }
public Orders updateOrderStatus(Long orderId, String newStatus) 
   {
    // Check if the order with the given ID exists
    Orders existingOrder = orderRepository.findById(orderId)
    .orElseThrow(() -> new EntityNotFoundException("Order not found with ID: " + orderId));
    // Update the order status
    existingOrder.setStatus(newStatus);
    // Save the updated order
    return orderRepository.save(existingOrder);
=======
<<<<<<< HEAD
@Service
public class OrderService {
     
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private OrderRepository orderRepository;
    public Order placeOrder(Long equipmentId, Order order) throws SQLException{
        // Check if the equipment with the given ID exists
        Equipment e=equipmentRepository.findById(equipmentId).orElseThrow(()->new EntityNotFoundException("Equiment with Id "+equipmentId+"is not present"));
        // place order for the equipment
       order.setEquipment(e);
        return orderRepository.save(order);
       // return null;
    }
 
    public List<Order> getAllOrders() {
        // return all orders
        return orderRepository.findAll();
    }
 
    public Order updateOrderStatus(Long orderId, String newStatus) {
       // update order status
       Order o=orderRepository.findById(orderId).orElseThrow(()->new EntityNotFoundException("Order with orderId "+orderId+"Doesn't exists"));
       o.setStatus(newStatus);
       return orderRepository.save(o);
=======

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    public Orders placeOrder(Long equipmentId, Orders order) {
        // Check if the equipment with the given ID exists
        Equipment equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new EntityNotFoundException("Equipment not found with ID: " + equipmentId));

        order.setEquipment(equipment);
        order.setOrderDate(new Date());
        order.setStatus("Initiated");

        // Save the order
        return orderRepository.save(order);
    }

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Orders updateOrderStatus(Long orderId, String newStatus) {
        // Check if the order with the given ID exists
        Orders existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with ID: " + orderId));

        // Update the order status
        existingOrder.setStatus(newStatus);

        // Save the updated order
        return orderRepository.save(existingOrder);
>>>>>>> Pratik
>>>>>>> 353971eb3ca117f2e834180caa08f55a069e4998
    }
}