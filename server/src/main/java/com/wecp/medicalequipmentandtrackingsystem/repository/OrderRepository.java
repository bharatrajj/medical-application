package com.wecp.medicalequipmentandtrackingsystem.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Order;
 
@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
   
}