package com.wecp.medicalequipmentandtrackingsystem.service;
<<<<<<< HEAD
=======

>>>>>>> 353971eb3ca117f2e834180caa08f55a069e4998
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Equipment;
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Maintenance;
import com.wecp.medicalequipmentandtrackingsystem.repository.EquipmentRepository;
import com.wecp.medicalequipmentandtrackingsystem.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
<<<<<<< HEAD
import java.util.List;
@Service
public class MaintenanceService {
@Autowired
private MaintenanceRepository maintenanceRepository;
@Autowired
private EquipmentRepository equipmentRepository;
public List<Maintenance> getAllMaintenance() {
return maintenanceRepository.findAll();
}
public Maintenance scheduleMaintenance(Long equipmentId, Maintenance maintenance) {
Equipment equipment = equipmentRepository.findById(equipmentId)
.orElseThrow(() -> new EntityNotFoundException("Equipment not found with ID: " + equipmentId));
// Set the equipment for the maintenance task
maintenance.setEquipment(equipment);
return maintenanceRepository.save(maintenance);
}
public Maintenance updateMaintenance(Long maintenanceId, Maintenance updatedMaintenance) {
// Check if the maintenance record with the given ID exists
Maintenance existingMaintenance =maintenanceRepository.findById(maintenanceId).orElseThrow(() -> new EntityNotFoundException("Maintenance record not found with ID: " + maintenanceId));
updatedMaintenance.setId(existingMaintenance.getId());
updatedMaintenance.setEquipment(existingMaintenance.getEquipment());
return maintenanceRepository.save(updatedMaintenance);
}
}
=======

<<<<<<< HEAD
import java.sql.SQLException;
import java.util.List;

@Service
public class MaintenanceService {
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private MaintenanceRepository maintenanceRepository;

    public List<Maintenance> getAllMaintenance() throws SQLException {
        // get all maintenance records
        return maintenanceRepository.findAll();

    }

    public Maintenance scheduleMaintenance(Long equipmentId, Maintenance maintenance) throws SQLException {
        // Check if the equipment with the given ID exists
        // schedule maintenance for the equipment
        Equipment e = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new EntityNotFoundException("Equipment does not" + equipmentId + "exists"));
        maintenance.setEquipment(e);
=======
@Service
public class MaintenanceService {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;


    public List<Maintenance> getAllMaintenance() {
        return maintenanceRepository.findAll();
    }

    public Maintenance scheduleMaintenance(Long equipmentId, Maintenance maintenance) {
        Equipment equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new EntityNotFoundException("Equipment not found with ID: " + equipmentId));

        // Set the equipment for the maintenance task
        maintenance.setEquipment(equipment);

>>>>>>> Pratik
        return maintenanceRepository.save(maintenance);
    }

    public Maintenance updateMaintenance(Long maintenanceId, Maintenance updatedMaintenance) throws SQLException {
        // Check if the maintenance record with the given ID exists
<<<<<<< HEAD
        Maintenance m = maintenanceRepository.findById(maintenanceId)
                .orElseThrow(() -> new EntityNotFoundException("Maintainance is" + maintenanceId + "doesnt exists"));
        m.setDescription(updatedMaintenance.getDescription());
        m.setScheduledDate(updatedMaintenance.getScheduledDate());
        m.setCompletedDate(updatedMaintenance.getCompletedDate());
        m.setStatus(updatedMaintenance.getStatus());
        m.setEquipment(updatedMaintenance.getEquipment());

        return maintenanceRepository.save(updatedMaintenance);
        // update maintenance record
=======
        Maintenance existingMaintenance = maintenanceRepository.findById(maintenanceId)
                .orElseThrow(() -> new EntityNotFoundException("Maintenance record not found with ID: " + maintenanceId));

        updatedMaintenance.setId(existingMaintenance.getId());
        updatedMaintenance.setEquipment(existingMaintenance.getEquipment());

        // Save the updated maintenance record
        return maintenanceRepository.save(updatedMaintenance);
>>>>>>> Pratik
    }
}
>>>>>>> 353971eb3ca117f2e834180caa08f55a069e4998
