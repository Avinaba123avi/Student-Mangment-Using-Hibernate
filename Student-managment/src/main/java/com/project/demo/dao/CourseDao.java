package com.project.demo.dao;

import com.project.demo.entitis.Course;

// CourseDao interface defining CRUD operations for Course entity
public interface CourseDao {
	
	// Method to insert a Course entity into the database
	void insertCourse(Course course);
	
	// Method to update a Course entity in the database
	void updateCourse(Course course);
	
	// Method to retrieve and display all Course entities from the database
	void showAllCourses();
	
	// Method to retrieve and return details of a specific Course by ID
	Course showOnlyOneCourseDetails(Integer cid);
	
	// Method to delete a specific Course by ID from the database
	void deleteCourses(Integer cid);
}
