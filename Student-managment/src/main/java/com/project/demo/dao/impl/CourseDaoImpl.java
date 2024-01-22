package com.project.demo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.demo.dao.CourseDao;
import com.project.demo.entitis.Course;
import com.project.demo.userexception.CourseException;
import com.project.demo.utill.HibernetUtill;

// CourseDaoImpl class implementing CourseDao interface
public class CourseDaoImpl implements CourseDao {

    // Method to insert a new Course entity into the database
    @Override
    public void insertCourse(Course course) {
        SessionFactory factory = HibernetUtill.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            session.save(course); // Save the course entity

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            // Throw a custom CourseException if an error occurs during insertion
            throw new CourseException("Error inserting course: " + e.getMessage(), e);
        }
    }

    // Method to update an existing Course entity in the database
    @Override
    public void updateCourse(Course course) {
        SessionFactory factory = HibernetUtill.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            session.merge(course); // Merge and update the course entity

            transaction.commit();
        } catch (Exception e) {
            // Rollback the transaction if an error occurs during update
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    // Method to retrieve and display all Course entities from the database
    @Override
    @SuppressWarnings("unchecked")
    public void showAllCourses() {
        try (Session session = HibernetUtill.getSessionFactory().openSession()) {
            Query q = session.createQuery("from Course");
            List<Course> list = q.list();
            for (Course course : list) {
                System.out.println(course); // Display each course
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve and return details of a specific Course by ID
    @Override
    public Course showOnlyOneCourseDetails(Integer cid) {
        SessionFactory factory = HibernetUtill.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;
        Course course = null;
        try {
            transaction = session.beginTransaction();
            course = session.get(Course.class, cid); // Retrieve the course by ID

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new CourseException("Error inserting course: " + e.getMessage(), e);
        }
        return course; // Return the retrieved course
    }

    // Method to delete a specific Course by ID from the database
    @Override
    public void deleteCourses(Integer cid) {
        SessionFactory factory = HibernetUtill.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;
        Course course = null;
        try {
            transaction = session.beginTransaction();
            course = session.get(Course.class, cid); // Retrieve the course by ID
            session.delete(course); // Delete the course entity

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new CourseException("Error inserting course: " + e.getMessage(), e);
        }
    }
}
