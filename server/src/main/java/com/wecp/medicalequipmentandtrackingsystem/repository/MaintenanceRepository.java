package com.wecp.medicalequipmentandtrackingsystem.repository;
 
 
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import java.util.List;
<<<<<<< HEAD
 
@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance,Long> {
    // extend jpa repository and add custom methods if needed
}
=======

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
    List<Maintenance> findByEquipmentId(Long equipmentId);
}
>>>>>>> Pratik
