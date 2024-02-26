package com.wecp.medicalequipmentandtrackingsystem.service;


import com.wecp.medicalequipmentandtrackingsystem.entitiy.Equipment;
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Order;
import com.wecp.medicalequipmentandtrackingsystem.repository.EquipmentRepository;
import com.wecp.medicalequipmentandtrackingsystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

public class OrderService {

    public Order placeOrder(Long equipmentId, Order order) {
        // Check if the equipment with the given ID exists
        // place order for the equipment
    }

    public List<Order> getAllOrders() {
        // return all orders
    }

    public Order updateOrderStatus(Long orderId, String newStatus) {
       // update order status
    }
}
