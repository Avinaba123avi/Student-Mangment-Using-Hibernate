// Import statements
package com.project.demo.entitis;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// Entity annotation indicates this class is an entity mapped to a database table
@Entity
// Table annotation specifies the table name in the database
@Table(name = "tbl_admins")
public class Admin {
    
    // Id annotation marks this field as the primary key in the table
    @Id
    @Column(name = "admin_id") // Column annotation defines the column name in the table
    private Integer aid; // Admin ID
    
    private String name; // Admin name
    private String password; // Admin password
    private String email; // Admin email
    
    // One-to-Many relationship with Course entity using List
    @OneToMany(cascade = CascadeType.ALL) // CascadeType.ALL allows cascading operations to associated entities
    // @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private List<Course> courses; // List of courses associated with the admin
    
    // Default constructor
    public Admin() {
        
    }
    
    // Parameterized constructor
    public Admin(Integer aid, String name, String password, String email, List<Course> courses) {
        this.aid = aid;
        this.name = name;
        this.password = password;
        this.email = email;
        this.courses = courses;
    }
    
    // Protected constructor (accessible within the package)
    protected Admin(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
    
    // Getters and setters for the fields
    
    public Integer getAid() {
        return aid;
    }
    
    public void setAid(Integer aid) {
        this.aid = aid;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<Course> getCourses() {
        return courses;
    }
    
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    
    // toString method to represent object information as a string
    
    @Override
    public String toString() {
        return "Admin [aid=" + aid + ", name=" + name + ", password=" + password + ", email=" + email + ", courses="
                + courses + "]";
    }
}
