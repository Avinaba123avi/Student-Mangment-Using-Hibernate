package com.project.demo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.demo.dao.TeacherDao;
import com.project.demo.entitis.Course;
import com.project.demo.entitis.Teacher;
import com.project.demo.userexception.TeacherException;
import com.project.demo.utill.HibernetUtill;

// TeacherDaoImpl class implementing TeacherDao interface
public class TeacherDaoImpl implements TeacherDao {

    // Method to insert a new Teacher entity into the database with a specific Course ID
    @Override
    public void insertTeacher(Teacher teacher, Integer courseId) {
        SessionFactory factory = HibernetUtill.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Course course = session.get(Course.class, courseId); // Retrieve Course by ID
            teacher.setCourse(course); // Set the Course for the teacher
            session.save(teacher); // Save the teacher entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            // Throw a custom TeacherException if an error occurs during insertion
            throw new TeacherException("Error inserting teacher: " + e.getMessage(), e);
        } finally {
            session.close();
        }
    }

    // Method to update an existing Teacher entity in the database with a specific Course ID
    @Override
    public void updateTeacher(Teacher teacher, Integer courseId) {
        SessionFactory factory = HibernetUtill.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Course course = session.get(Course.class, courseId); // Retrieve Course by ID
            teacher.setCourse(course); // Set the Course for the teacher
            session.merge(teacher); // Merge and update the teacher entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new TeacherException("Error updating teacher: " + e.getMessage(), e);
        } finally {
            session.close();
        }
    }

    // Method to retrieve and display all Teacher entities from the database
    @Override
    @SuppressWarnings("unchecked")
    public void showAllTeachers() {
        try (Session session = HibernetUtill.getSessionFactory().openSession()) {
            Query q = session.createQuery("from Teacher");
            List<Teacher> list = q.list();
            for (Teacher teacher : list) {
                System.out.println(teacher); // Display each teacher
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve and return details of a specific Teacher by ID
    @Override
    public Teacher showOnlyOneTeacherDetails(Integer teacherId) {
        SessionFactory factory = HibernetUtill.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;
        Teacher teacher = null;
        try {
            transaction = session.beginTransaction();
            teacher = session.get(Teacher.class, teacherId); // Retrieve the teacher by ID
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new TeacherException("Error retrieving teacher details: " + e.getMessage(), e);
        } finally {
            session.close();
        }
        return teacher; // Return the retrieved teacher
    }

    // Method to delete a specific Teacher by ID from the database
    @Override
    public void deleteTeacher(Integer teacherId) {
        SessionFactory factory = HibernetUtill.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;
        Teacher teacher = null;
        try {
            transaction = session.beginTransaction();
            teacher = session.get(Teacher.class, teacherId); // Retrieve the teacher by ID
            session.delete(teacher); // Delete the teacher entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new TeacherException("Error deleting teacher: " + e.getMessage(), e);
        } finally {
            session.close();
        }
    }
}
