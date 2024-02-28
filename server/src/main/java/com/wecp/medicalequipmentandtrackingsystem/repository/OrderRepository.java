package com.wecp.medicalequipmentandtrackingsystem.repository;
<<<<<<< HEAD
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Order;
 
@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
   
}
=======


import com.wecp.medicalequipmentandtrackingsystem.entitiy.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByEquipmentId(Long equipmentId);
}
>>>>>>> Pratik
