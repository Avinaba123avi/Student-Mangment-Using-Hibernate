package com.project.demo.dao;

import com.project.demo.entitis.Student;

// StudentDao interface defining CRUD operations for Student entity
public interface StudentDao {

	// Method to insert a Student entity into the database with a specific Course ID
	void insertStudent(Student student, Integer cid);

	// Method to update a Student entity in the database with a specific Course ID
	void updateStudent(Student student, Integer cid);

	// Method to retrieve and display all Student entities from the database
	void showAllStudents();

	// Method to retrieve and return details of a specific Student by ID
	Student showOnlyOneStudentDetails(Integer studentId);

	// Method to delete a specific Student by ID from the database
	void deleteStudent(Integer studentId);
}
