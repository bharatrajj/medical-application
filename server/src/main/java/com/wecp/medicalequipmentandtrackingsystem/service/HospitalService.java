package com.wecp.medicalequipmentandtrackingsystem.service;
<<<<<<< HEAD
 
 
import java.sql.SQLException;
import java.util.List;
 
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Hospital;
import com.wecp.medicalequipmentandtrackingsystem.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class HospitalService {
   
    @Autowired
    private HospitalRepository hospitalRepository;
    public Hospital createHospital(Hospital hospital) {
        // create hospital
        return hospitalRepository.save(hospital);
    }
 
    public List<Hospital> getAllHospitals() throws SQLException{
        // return list of hospitals
        return hospitalRepository.findAll();
    }
 
 
   
=======

import com.wecp.medicalequipmentandtrackingsystem.entitiy.Hospital;
import com.wecp.medicalequipmentandtrackingsystem.repository.HospitalRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {


    @Autowired
    private HospitalRepository hospitalRepository;

    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    public Hospital createHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }
>>>>>>> Pratik
}
 