package com.wecp.medicalequipmentandtrackingsystem.service;
 
 
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Equipment;
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Order;
import com.wecp.medicalequipmentandtrackingsystem.repository.EquipmentRepository;
import com.wecp.medicalequipmentandtrackingsystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import javax.persistence.EntityNotFoundException;
 
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
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
    }
}