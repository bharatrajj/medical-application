package com.wecp.medicalequipmentandtrackingsystem.service;
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Equipment;
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Hospital;
import com.wecp.medicalequipmentandtrackingsystem.repository.EquipmentRepository;
import com.wecp.medicalequipmentandtrackingsystem.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
<<<<<<< HEAD
import java.sql.SQLException;
import java.util.List;
@Service
public class EquipmentService {
@Autowired
private EquipmentRepository equipmentRepository;
@Autowired
private HospitalRepository hospitalRepository;
public Equipment addEquipment(Long hospitalId, Equipment equipment) {
// check if hospital exists
Hospital
hospital=hospitalRepository.findById(hospitalId).orElseThrow(()->new
EntityNotFoundException("Hospital with "+hospitalId+" doesnot exists."));
equipment.setHospital(hospital);
return equipmentRepository.save(equipment);
// add equipment to hospital
}
public List<Equipment> getAllEquipmentOfHospital(Long hospitalId) throws
SQLException{
// return all equipments of hospital
return equipmentRepository.findByHospitalId(hospitalId);
}
=======

<<<<<<< HEAD
import java.sql.SQLException;
import java.util.List;

=======
>>>>>>> Pratik
@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;
 
    @Autowired
    private HospitalRepository hospitalRepository;
 
 
    public Equipment addEquipment(Long hospitalId, Equipment equipment) {
<<<<<<< HEAD
 
        // check if hospital exists
        Hospital hospital=hospitalRepository.findById(hospitalId).orElseThrow(()->new EntityNotFoundException("Hospital with "+hospitalId+" doesnot exists."));
        equipment.setHospital(hospital);
        return equipmentRepository.save(equipment);
 
        // add equipment to hospital
    }
 
    public List<Equipment> getAllEquipmentOfHospital(Long hospitalId) throws SQLException{
        // return all equipments of hospital
        return equipmentRepository.findByHospitalId(hospitalId);
        // 
 
    }
    
=======
        // Check if the hospital with the given ID exists
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new EntityNotFoundException("Hospital not found with ID: " + hospitalId));

        // Set the hospital for the equipment
        equipment.setHospital(hospital);
        return equipmentRepository.save(equipment);
    }

    public List<Equipment> getAllEquipmentOfHospital(Long hospitalId) {
        return equipmentRepository.findByHospitalId(hospitalId);
    }
>>>>>>> Pratik
>>>>>>> 353971eb3ca117f2e834180caa08f55a069e4998
}
