package com.wecp.medicalequipmentandtrackingsystem.service;


import com.wecp.medicalequipmentandtrackingsystem.entitiy.Equipment;
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Maintenance;
import com.wecp.medicalequipmentandtrackingsystem.repository.EquipmentRepository;
import com.wecp.medicalequipmentandtrackingsystem.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.sql.SQLException;
import java.util.List;

@Service
public class MaintenanceService {
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private MaintenanceRepository maintenanceRepository;

    public List<Maintenance> getAllMaintenance() throws SQLException{
        // get all maintenance records
        return maintenanceRepository.findAll();
        
    }

    public Maintenance scheduleMaintenance(Long equipmentId, Maintenance maintenance) throws SQLException{
        // Check if the equipment with the given ID exists
        // schedule maintenance for the equipment
        Equipment e=equipmentRepository.findById(equipmentId).orElseThrow(()->new EntityNotFoundException("Equipment does not"+equipmentId+"exists"));
        maintenance.setEquipment(e);
        return maintenanceRepository.save(maintenance);
    }


    public Maintenance updateMaintenance(Long maintenanceId, Maintenance updatedMaintenance) throws SQLException{
     
        
        return maintenanceRepository.save(updatedMaintenance);

    }
}