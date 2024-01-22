package com.project.demo.service;

import com.project.demo.entitis.Course;

// CourseService interface defining operations for Course entity
public interface CourseService {
	
	// Method to add a Course entity into the database
	void addCourse(Course course);
	
	// Method to update a Course entity in the database
	void updateCourse(Course course);
	
	// Method to retrieve and display all Course entities from the database
	void displayAllCourses();
	
	// Method to retrieve and return details of a specific Course by ID
	Course displayCourseDetails(Integer courseId);
	
	// Method to delete a specific Course by ID from the database
	void deleteCourse(Integer courseId);
}
