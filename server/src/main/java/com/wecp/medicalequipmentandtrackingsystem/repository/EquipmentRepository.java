package com.wecp.medicalequipmentandtrackingsystem.repository;
import com.wecp.medicalequipmentandtrackingsystem.entitiy.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
<<<<<<< HEAD
@Repository
public interface EquipmentRepository extends JpaRepository<Equipment,Long>{
// extent jpa repository and add custom methods if needed
public List<Equipment> findByHospitalId(Long HospitalId);
}
=======

@Repository
<<<<<<< HEAD
public interface EquipmentRepository extends JpaRepository<Equipment, Long>{
    // extent jpa repository and add custom methods if needed
    public List<Equipment> findByHospitalId(Long HospitalId);
=======
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    List<Equipment> findByHospitalId(Long hospitalId);
>>>>>>> Pratik
}
>>>>>>> 353971eb3ca117f2e834180caa08f55a069e4998
