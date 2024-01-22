// Import statements
package com.project.demo.entitis;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// Entity annotation indicates this class is an entity mapped to a database table
@Entity
// Table annotation specifies the table name in the database
@Table(name = "tbl_students")
public class Student {
    
    // Id annotation marks this field as the primary key in the table
    @Id
    @Column(name = "student_id") // Column annotation defines the column name in the table
    private Integer sid; // Student ID
    
    // Fields representing student information
    private String sname; // Student name
    private String email; // Student email
    private Integer number; // Student contact number
    private String address; // Student address
    private Integer age; // Student age
    
    // Many-to-One relationship with Course entity using JoinColumn
    @ManyToOne // Many-to-One association
    @JoinColumn(name = "course_id") // Defines the foreign key column in the table
    private Course courses; // Course associated with the student
    
    // Default constructor
    public Student() {
        
    }
    
    // Parameterized constructor with all fields
    public Student(Integer sid, String sname, String email, Integer number, String address, Integer age, Course courses) {
        this.sid = sid;
        this.sname = sname;
        this.email = email;
        this.number = number;
        this.address = address;
        this.age = age;
        this.courses = courses;
    }
    
    // Getters and setters for the fields
    
    public Integer getSid() {
        return sid;
    }
    
    public void setSid(Integer sid) {
        this.sid = sid;
    }
    
    public String getSname() {
        return sname;
    }
    
    public void setSname(String sname) {
        this.sname = sname;
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
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Course getCourses() {
        return courses;
    }
    
    public void setCourses(Course courses) {
        this.courses = courses;
    }
    
    // toString method to represent object information as a string
    
    @Override
    public String toString() {
        return "Student [sid=" + sid + ", sname=" + sname + ", email=" + email + ", number=" + number + ", address="
                + address + ", age=" + age + ", courses=" + courses + "]";
    }
}
