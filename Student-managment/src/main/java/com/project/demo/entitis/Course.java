// Import statements
package com.project.demo.entitis;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Entity annotation indicates this class is an entity mapped to a database table
@Entity
// Table annotation specifies the table name in the database
@Table(name = "tbl_courses")
public class Course {
    
    // Id annotation marks this field as the primary key in the table
    @Id
    @Column(name = "course_id") // Column annotation defines the column name in the table
    private Integer cid; // Course ID
    
    // Fields representing course information
    private String cname; // Course name
    private Double fees; // Course fees
    private Integer duration; // Course duration in months
    
    // Default constructor
    public Course() {
        
    }
    
    // Parameterized constructor with all fields
    public Course(Integer cid, String cname, Double fees, Integer duration) {
        this.cid = cid;
        this.cname = cname;
        this.fees = fees;
        this.duration = duration;
    }
    
    // Constructor without the course ID (potentially for creation in the database)
    public Course(String cname, Double fees, Integer duration) {
        this.cname = cname;
        this.fees = fees;
        this.duration = duration;
    }
    
    // Getters and setters for the fields
    
    public Integer getCid() {
        return cid;
    }
    
    public void setCid(Integer cid) {
        this.cid = cid;
    }
    
    public String getCname() {
        return cname;
    }
    
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    public Double getFees() {
        return fees;
    }
    
    public void setFees(Double fees) {
        this.fees = fees;
    }
    
    public Integer getDuration() {
        return duration;
    }
    
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    
    // toString method to represent object information as a string
    
    @Override
    public String toString() {
        return "Course [cid=" + cid + ", cname=" + cname + ", fees=" + fees + ", duration=" + duration + "]";
    }
}
