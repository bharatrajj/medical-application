package com.wecp.medicalequipmentandtrackingsystem.entitiy;
 
 
import com.fasterxml.jackson.annotation.JsonIgnore;
 
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
 
import javax.persistence.*;
import java.util.List;
 
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospital")
    @JsonIgnore
    private List<Equipment> equipmentList;
 
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
 
    public String getLocation() {
        return location;
    }
 
    public void setLocation(String location) {
        this.location = location;
    }
 
    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }
 
    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }
}
