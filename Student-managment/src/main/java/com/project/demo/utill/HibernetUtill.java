package com.project.demo.utill;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class responsible for providing a singleton instance of
 * Hibernate SessionFactory, configured based on the "hibernate.cfg.xml" file.
 */
public class HibernetUtill {
    
    // Singleton instance of the Hibernate SessionFactory
    private static SessionFactory sessionFactory;
    
    /**
     * Retrieves or initializes the Hibernate SessionFactory.
     * 
     * @return The singleton instance of Hibernate SessionFactory.
     */
    public static SessionFactory getSessionFactory() {
        // Check if the SessionFactory is already initialized
        if (sessionFactory == null) {
            try {
                // Create a new Configuration instance
                Configuration configuration = new Configuration();
                
                // Load Hibernate configuration from "hibernate.cfg.xml" file
                configuration.configure("hibernate.cfg.xml");
                
                // Build the SessionFactory using the configuration
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                // Handle any exceptions that might occur during initialization
                e.printStackTrace();
                throw new RuntimeException("Error initializing Hibernate SessionFactory: " + e.getMessage(), e);
            }
        }
        // Return the singleton instance of Hibernate SessionFactory
        return sessionFactory;
    }
}
