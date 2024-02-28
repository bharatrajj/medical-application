package com.wecp.medicalequipmentandtrackingsystem.entitiy;
 
 
import javax.persistence.*;
 
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
 
import java.util.Date;
 
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "maintenances")
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private Date scheduledDate;
    private Date completedDate;
    private String description;
 
    private String status;
    @ManyToOne(cascade = CascadeType.ALL)
    private Equipment equipment;
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public Date getScheduledDate() {
        return scheduledDate;
    }
 
    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }
 
    public Date getCompletedDate() {
        return completedDate;
    }
 
    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
 
    public Equipment getEquipment() {
        return equipment;
    }
 
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
}