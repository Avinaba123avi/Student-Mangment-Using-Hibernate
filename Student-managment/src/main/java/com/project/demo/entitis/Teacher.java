package com.project.demo.entitis;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// Entity annotation indicates this class is an entity mapped to a database table
@Entity
// Table annotation specifies the table name in the database
@Table(name = "tbl_teachers")
public class Teacher {
    
    // Id annotation marks this field as the primary key in the table
    @Id
    @Column(name = "tech_id") // Column annotation defines the column name in the table
    private Integer tid; // Teacher ID
    
    // Fields representing teacher information
    private String tname; // Teacher name
    private String email; // Teacher email
    private Integer number; // Teacher contact number
    
    // One-to-One relationship with Course entity using JoinColumn
    @OneToOne(cascade = CascadeType.ALL) // One-to-One association with cascading operations
    @JoinColumn(name = "course_id",referencedColumnName = "course_id") // Defines the foreign key column in the table
    private Course course; // Course associated with the teacher
    
    // Default constructor
    public Teacher() {
        
    }
    
    // Parameterized constructor with all fields
    public Teacher(Integer tid, String tname, String email, Integer number, Course course) {
        this.tid = tid;
        this.tname = tname;
        this.email = email;
        this.number = number;
        this.course = course;
    }
    
    // Getters and setters for the fields
    
    public Integer getTid() {
        return tid;
    }
    
    public void setTid(Integer tid) {
        this.tid = tid;
    }
    
    public String getTname() {
        return tname;
    }
    
    public void setTname(String tname) {
        this.tname = tname;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Integer getNumber() {
        return number;
    }
    
    public void setNumber(Integer number) {
        this.number = number;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    
    // toString method to represent object information as a string
    
    @Override
    public String toString() {
        return "Teacher [tid=" + tid + ", tname=" + tname + ", email=" + email + ", number=" + number + ", course="
                + course + "]";
    }
}
