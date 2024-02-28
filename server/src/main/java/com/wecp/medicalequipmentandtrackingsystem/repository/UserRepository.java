package com.wecp.medicalequipmentandtrackingsystem.repository;

<<<<<<< HEAD
import com.wecp.medicalequipmentandtrackingsystem.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
Optional<User> findByUsername(String username);
}
=======

import com.wecp.medicalequipmentandtrackingsystem.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

<<<<<<< HEAD
    Optional<User> findByUsername(String username);
}
=======
>>>>>>> Pratik
>>>>>>> 353971eb3ca117f2e834180caa08f55a069e4998
