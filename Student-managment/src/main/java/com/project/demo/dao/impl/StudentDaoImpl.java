package com.project.demo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.demo.dao.StudentDao;
import com.project.demo.entitis.Course;
import com.project.demo.entitis.Student;
import com.project.demo.userexception.StudentException;
import com.project.demo.utill.HibernetUtill;

// StudentDaoImpl class implementing StudentDao interface
public class StudentDaoImpl implements StudentDao {

    // Method to insert a new Student entity into the database with a specific Course ID
    @Override
    public void insertStudent(Student student, Integer cid) {
        SessionFactory factory = HibernetUtill.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Course course = session.get(Course.class, cid); // Retrieve Course by ID
            student.setCourses(course); // Set the Course for the student
            session.save(student); // Save the student entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            // Throw a custom StudentException if an error occurs during insertion
            throw new StudentException("Error inserting student: " + e.getMessage(), e);
        } finally {
            session.close();
        }
    }

    // Method to update an existing Student entity in the database with a specific Course ID
    @Override
    public void updateStudent(Student student, Integer cid) {
        SessionFactory factory = HibernetUtill.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Course course = session.get(Course.class, cid); // Retrieve Course by ID
            student.setCourses(course); // Set the Course for the student
            session.merge(student); // Merge and update the student entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new StudentException("Error updating student: " + e.getMessage(), e);
        } finally {
            session.close();
        }
    }

    // Method to retrieve and display all Student entities from the database
    @Override
    @SuppressWarnings("unchecked")
    public void showAllStudents() {
        try (Session session = HibernetUtill.getSessionFactory().openSession()) {
            Query q = session.createQuery("from Student");
            List<Student> list = q.list();
            for (Student student : list) {
                System.out.println(student); // Display each student
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve and return details of a specific Student by ID
    @Override
    public Student showOnlyOneStudentDetails(Integer studentId) {
        SessionFactory factory = HibernetUtill.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;
        Student student = null;
        try {
            transaction = session.beginTransaction();
            student = session.get(Student.class, studentId); // Retrieve the student by ID
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new StudentException("Error retrieving student details: " + e.getMessage(), e);
        } finally {
            session.close();
        }
        return student; // Return the retrieved student
    }

    // Method to delete a specific Student by ID from the database
    @Override
    public void deleteStudent(Integer studentId) {
        SessionFactory factory = HibernetUtill.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;
        Student student = null;
        try {
            transaction = session.beginTransaction();
            student = session.get(Student.class, studentId); // Retrieve the student by ID
            session.delete(student); // Delete the student entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new StudentException("Error deleting student: " + e.getMessage(), e);
        } finally {
            session.close();
        }
    }
}
