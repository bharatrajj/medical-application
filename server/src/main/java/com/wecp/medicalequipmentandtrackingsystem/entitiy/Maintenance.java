package com.wecp.medicalequipmentandtrackingsystem.entitiy;
 
 
import javax.persistence.*;
 
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
 
import java.util.Date;
<<<<<<< HEAD
 
@Entity
@NoArgsConstructor
@AllArgsConstructor
=======

@Entity
>>>>>>> Pratik
@Table(name = "maintenances")
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private Date scheduledDate;
    private Date completedDate;
    private String description;
<<<<<<< HEAD
 
    private String status;
    @ManyToOne(cascade = CascadeType.ALL)
    private Equipment equipment;
 
=======

    private String status; // status field to track the status of the maintenance task
    // Add other maintenance-related fields as needed

    @ManyToOne
    @JoinColumn(name = "equipmentId")
    private Equipment equipment; // Many maintenance tasks can be associated with one equipment

>>>>>>> Pratik
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