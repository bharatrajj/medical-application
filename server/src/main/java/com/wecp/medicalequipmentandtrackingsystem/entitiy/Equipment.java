package com.wecp.medicalequipmentandtrackingsystem.entitiy;
<<<<<<< HEAD
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String name;

private String description;
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="hospital_id")
private Hospital hospital;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getDescription() {
return description;
}
public void setDescription(String description) {
this.description = description;
}
public Hospital getHospital() {
return hospital;
}
public void setHospital(Hospital hospital) {
this.hospital = hospital;
}
}
=======
 
 
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
<<<<<<< HEAD
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "equipments")
public class Equipment {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
=======
@Table(name = "equipments")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> Pratik
    private Long id;
 
    private String name;
    private String description;
<<<<<<< HEAD
 
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="hospital_id")
    private Hospital hospital;
 
=======
    @ManyToOne
    @JoinColumn(name = "hospitalId")
    private Hospital hospital; // Many equipment can belong to one hospital

>>>>>>> Pratik
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
 
    public Hospital getHospital() {
        return hospital;
    }
 
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
>>>>>>> 353971eb3ca117f2e834180caa08f55a069e4998
