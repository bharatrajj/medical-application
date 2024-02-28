package com.wecp.medicalequipmentandtrackingsystem.controller;
 
 
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Equipment;
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Hospital;
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Maintenance;
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Orders;
import com.wecp.medicalequipmentandtrackingsystem.service.EquipmentService;
import com.wecp.medicalequipmentandtrackingsystem.service.HospitalService;
import com.wecp.medicalequipmentandtrackingsystem.service.MaintenanceService;
import com.wecp.medicalequipmentandtrackingsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.sql.SQLException;
import java.util.List;
<<<<<<< HEAD
 
@RestController
public class HospitalController {
 
    @Autowired
    private HospitalService hospitalService;
 
    @Autowired
    private EquipmentService equipmentService;
 
    @Autowired
    private MaintenanceService maintenanceService;
 
    @Autowired
    private OrderService orderService;
 
    @PostMapping("/api/hospital/create")
    public ResponseEntity<Hospital> createHospital(@RequestBody Hospital hospital) {
        // create hospital and return the created hospital with status code 201 = CREATED;
        return new  ResponseEntity<Hospital>(hospitalService.createHospital(hospital),HttpStatus.CREATED);
=======

@RestController
public class HospitalController {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private MaintenanceService maintenanceService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private HospitalService hospitalService;

    @PostMapping("/api/hospital/create")
    public ResponseEntity<Hospital> createHospital(@RequestBody Hospital hospital) {
        Hospital createdHospital = hospitalService.createHospital(hospital);
        return new ResponseEntity<>(createdHospital, HttpStatus.CREATED);
>>>>>>> Pratik
    }
 
    @GetMapping("/api/hospitals")
    public ResponseEntity<List<Hospital>> getAllHospitals() {
<<<<<<< HEAD
        // return all hospitals with response code = 200 ok
        try{
            List<Hospital> hospital=hospitalService.getAllHospitals();
         
            return new ResponseEntity<>(hospital,HttpStatus.OK);
 
        }catch(SQLException e)
        {
              return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
 
=======
        List<Hospital> hospitals = hospitalService.getAllHospitals();
        return new ResponseEntity<>(hospitals, HttpStatus.OK);
>>>>>>> Pratik
    }
 
    @PostMapping("/api/hospital/equipment")
    public ResponseEntity<Equipment> addEquipment(@RequestParam Long hospitalId, @RequestBody Equipment equipment) {
<<<<<<< HEAD
        // add equipment to the hospital and return the added equipment with status code 201 = CREATED;
        return new ResponseEntity<Equipment>(equipmentService.addEquipment(hospitalId, equipment),HttpStatus.CREATED);
 
=======
        Equipment addedEquipment = equipmentService.addEquipment(hospitalId, equipment);
        return new ResponseEntity<>(addedEquipment, HttpStatus.CREATED);
>>>>>>> Pratik
    }
 
    @GetMapping("/api/hospital/equipment/{hospitalId}")
    public ResponseEntity<List<Equipment>> getAllEquipmentsOfHospital(@PathVariable Long hospitalId) {
<<<<<<< HEAD
        // return all equipments of hospital with response code = 200 OK
        try{
            List<Equipment> equipments=equipmentService.getAllEquipmentOfHospital(hospitalId);  
            return new ResponseEntity<>(equipments,HttpStatus.OK);
        }catch(SQLException e)
        {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
=======
        List<Equipment> equipments = equipmentService.getAllEquipmentOfHospital(hospitalId);
        return new ResponseEntity<>(equipments, HttpStatus.OK);
>>>>>>> Pratik
    }
 
    @PostMapping("/api/hospital/maintenance/schedule")
<<<<<<< HEAD
    public ResponseEntity<Maintenance> scheduleMaintenance(@RequestParam Long equipmentId, @RequestBody Maintenance maintenance) {
        // schedule maintenance for the equipment and return the scheduled maintenance with status code 201 = CREATED;
        try {
            return new ResponseEntity<Maintenance>(maintenanceService.scheduleMaintenance(equipmentId, maintenance), HttpStatus.CREATED);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
=======
    public ResponseEntity<Maintenance> scheduleMaintenance
            (@RequestParam Long equipmentId, @RequestBody Maintenance maintenance) {
        Maintenance scheduledMaintenance = maintenanceService.scheduleMaintenance(equipmentId, maintenance);
        return new ResponseEntity<>(scheduledMaintenance, HttpStatus.CREATED);
>>>>>>> Pratik
    }
 
    @PostMapping("/api/hospital/order")
<<<<<<< HEAD
    public ResponseEntity<Order> placeOrder(@RequestParam Long equipmentId, @RequestBody Order order) {
        // place order for the equipment and return the placed order with status code 201 = CREATED;
        try {
            return new ResponseEntity<Order>(orderService.placeOrder(equipmentId, order),HttpStatus.CREATED);
        } catch (SQLException e) {
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
=======
    public ResponseEntity<Orders> placeOrder(@RequestParam Long equipmentId, @RequestBody Orders order) {
        Orders placedOrder = orderService.placeOrder(equipmentId, order);
        return new ResponseEntity<>(placedOrder, HttpStatus.CREATED);
>>>>>>> Pratik
    }
}