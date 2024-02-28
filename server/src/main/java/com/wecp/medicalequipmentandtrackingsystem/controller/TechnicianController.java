package com.wecp.medicalequipmentandtrackingsystem.controller;
<<<<<<< HEAD
=======
 
>>>>>>> 353971eb3ca117f2e834180caa08f55a069e4998
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Maintenance;
import com.wecp.medicalequipmentandtrackingsystem.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
import java.util.List;
@RestController
public class TechnicianController {
@Autowired
public MaintenanceService maintenanceService;
@GetMapping("/api/technician/maintenance")
public ResponseEntity<List<Maintenance>> getAllMaintenance() {
List<Maintenance> maintenances =
maintenanceService.getAllMaintenance();
return new ResponseEntity<>(maintenances, HttpStatus.OK);
}
@PutMapping("/api/technician/maintenance/update/{maintenanceId}")
public ResponseEntity<Maintenance> updateMaintenance
(@PathVariable Long maintenanceId, @RequestBody Maintenance
updatedMaintenance) {
Maintenance updatedRecord =
maintenanceService.updateMaintenance(maintenanceId, updatedMaintenance);
return new ResponseEntity<>(updatedRecord, HttpStatus.OK);
}
=======
 
import java.sql.SQLException;
import java.util.List;
<<<<<<< HEAD
 
 
public class TechnicianController {
 
    @Autowired
    private MaintenanceService maintenanceService;
    @GetMapping("/api/technician/maintenance")
    public ResponseEntity<List<Maintenance>> getAllMaintenance() {
        // Get all maintenance records and return them with status code 200 OK;
        try{
            List<Maintenance> maintenances=maintenanceService.getAllMaintenance();
            return new ResponseEntity<List<Maintenance>>(maintenances, HttpStatus.OK);
        }catch(SQLException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
=======

@RestController
public class TechnicianController {

    @Autowired
    public MaintenanceService maintenanceService;

    @GetMapping("/api/technician/maintenance")
    public ResponseEntity<List<Maintenance>> getAllMaintenance() {
        List<Maintenance> maintenances = maintenanceService.getAllMaintenance();
        return new ResponseEntity<>(maintenances, HttpStatus.OK);
>>>>>>> Pratik
    }
 
    @PutMapping("/api/technician/maintenance/update/{maintenanceId}")
    public ResponseEntity<Maintenance> updateMaintenance
            (@PathVariable Long maintenanceId, @RequestBody Maintenance updatedMaintenance) {
<<<<<<< HEAD
        // Update the maintenance record with the given id and return updated record with status code 200 OK;
        try{
            maintenanceService.updateMaintenance(maintenanceId, updatedMaintenance);
            return new ResponseEntity<Maintenance>(updatedMaintenance, HttpStatus.OK);
        }catch(SQLException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
=======
        Maintenance updatedRecord = maintenanceService.updateMaintenance(maintenanceId, updatedMaintenance);
        return new ResponseEntity<>(updatedRecord, HttpStatus.OK);
>>>>>>> Pratik
    }
>>>>>>> 353971eb3ca117f2e834180caa08f55a069e4998
}
 