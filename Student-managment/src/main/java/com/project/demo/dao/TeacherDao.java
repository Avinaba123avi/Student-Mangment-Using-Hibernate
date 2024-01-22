package com.project.demo.dao;

import com.project.demo.entitis.Teacher;

// TeacherDao interface defining CRUD operations for Teacher entity
public interface TeacherDao {

	// Method to insert a Teacher entity into the database with a specific Course ID
	void insertTeacher(Teacher teacher, Integer courseId);

	// Method to update a Teacher entity in the database with a specific Course ID
	void updateTeacher(Teacher teacher, Integer courseId);

	// Method to retrieve and display all Teacher entities from the database
	void showAllTeachers();

	// Method to retrieve and return details of a specific Teacher by ID
	Teacher showOnlyOneTeacherDetails(Integer teacherId);

	// Method to delete a specific Teacher by ID from the database
	void deleteTeacher(Integer teacherId);
}
