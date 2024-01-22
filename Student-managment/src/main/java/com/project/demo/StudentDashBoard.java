package com.project.demo;

import java.util.Scanner;

import com.project.demo.dao.CourseDao;
import com.project.demo.dao.StudentDao;
import com.project.demo.dao.TeacherDao;
import com.project.demo.dao.impl.CourseDaoImpl;
import com.project.demo.dao.impl.StudentDaoImpl;
import com.project.demo.dao.impl.TeacherDaoImpl;
import com.project.demo.entitis.Course;
import com.project.demo.entitis.Student;
import com.project.demo.entitis.Teacher;

public class StudentDashBoard {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int option = 0, optionUser = 0, optionProduct = 0, optionCart = 0, optionOrder = 0;
		boolean isAdminLoggedIn = false;
		String adminEmail = "admin@example.com";
		String adminPassword = "admin123";

		do {
			System.out.println("Welcome to Student Management Dashboard\n=====================================");

			// Admin Login
			if (!isAdminLoggedIn) {
				// Admin login authentication
				System.out.println("Admin Login:");
				System.out.println("Enter Admin Email:");
				String email = s.next();
				System.out.println("Enter Admin Password:");
				String password = s.next();

				if (email.equals(adminEmail) && password.equals(adminPassword)) {
					isAdminLoggedIn = true;
					System.out.println("Admin logged in successfully!");
				} else {
					System.out.println("Incorrect email or password. Try again.");
				}
			} else {
				// Menu options for course, teacher, and student management
				System.out.println(
						"1. Select 1 for Courses\n2. Select 2 for Teacher\n3. Select 3 for Students\n4. Select 4 for Exit");
				option = s.nextInt();

				switch (option) {
				case 1:
					// Course management options (Add, Delete, Update, Show)
					do {
						System.out.println(
								"1. Select 1 Add Courses\n2. Select 2 Delete Courses\n3. Select 3 Update Courses"
										+ "\n4. Select 4 to Show All Courses\n5. Select 5 to Show Any Courses\n6. Select 6 for Exit");
						optionProduct = s.nextInt();
						// Different actions for courses
						switch (optionProduct) {
						case 1:
							// Add a course
							CourseDao courseDao = new CourseDaoImpl();

							// Course information input from the user
							// Insert into the database using CourseDaoImpl
							System.out.println("Add Courses...");
							Scanner scanner = new Scanner(System.in);

							Course course = new Course();

							System.out.println("Enter 1st course Id: ");
							Integer courseId = scanner.nextInt();
							course.setCid(courseId);

							System.out.println("Enter 1st course name: ");
							String courseName = scanner.next();
							course.setCname(courseName);

							System.out.println("Enter 1st course Fees: ");
							Double courseFees = scanner.nextDouble();
							course.setFees(courseFees);

							System.out.println("Enter 1st course Duration: ");
							int courseDuration = scanner.nextInt();
							course.setDuration(courseDuration);

							courseDao.insertCourse(course);

							break;
						case 2:
							// Delete a course
							System.out.println("Delete Courses...");
							CourseDao courseDao2 = new CourseDaoImpl();
							// Delete a course from the database by ID
							Scanner sc1 = new Scanner(System.in);
							System.out.println("Enter course id");
							Integer id = sc1.nextInt();
							courseDao2.deleteCourses(id);
							break;
						case 3:
							// Update a course
							CourseDao courseDao1 = new CourseDaoImpl();
							// Update course details in the database
							System.out.println("Update Courses...");
							Scanner scanner1 = new Scanner(System.in);

							Course course1 = new Course();

							System.out.println("Enter course Id: ");
							Integer courseId1 = scanner1.nextInt();
							course1.setCid(courseId1);

							System.out.println("Enter course name: ");
							String courseName1 = scanner1.next();
							course1.setCname(courseName1);

							System.out.println("Enter course Fees: ");
							Double courseFees1 = scanner1.nextDouble();
							course1.setFees(courseFees1);

							System.out.println("Enter course Duration: ");
							int courseDuration1 = scanner1.nextInt();
							course1.setDuration(courseDuration1);
							courseDao1.updateCourse(course1);

							break;
						case 4:
							// Show all courses
							System.out.println("Show All Courses...");
							// Retrieve and display all courses from the database
							CourseDao courseDao3 = new CourseDaoImpl();
							courseDao3.showAllCourses();
							break;
						case 5:
							// Show specific course details
							System.out.println("Show Any Courses...");
							CourseDao courseDao4 = new CourseDaoImpl();
							// Retrieve and display a specific course from the database by ID
							Scanner sc4 = new Scanner(System.in);
							System.out.println("Enter course id");
							Integer id1 = sc4.nextInt();
							Course details = courseDao4.showOnlyOneCourseDetails(id1);
							System.out.println(details);
							break;
						case 6:
							// Exit course management
							System.out.println("Exited from Courses Section Successfully...");
							break;
						}
					} while (optionProduct != 6);
					break;
				case 2:
					do {
						System.out.println(
								"1. Select 1 Add Teacher\n2. Select 2 Delete Teacher\n3. Select 3 Update Teacher"
										+ "\n4. Select 4 to Show All Teacher\n5. Select 5 to Show Any Teacher\n6. Select 6 for Exit");
						optionCart = s.nextInt();
						switch (optionCart) {
						case 1:
							System.out.println("Add Teachers...");
							TeacherDao teacherDao = new TeacherDaoImpl();
							System.out.println("Enter Course Id: ");
							Scanner scanner = new Scanner(System.in);
							Integer courseId = scanner.nextInt();

							Teacher teacher = new Teacher();

							System.out.println("Enter Teacher Id: ");
							int teacherId = scanner.nextInt();
							teacher.setTid(teacherId);

							System.out.println("Enter Teacher Name: ");
							String teacherName = scanner.next();
							teacher.setTname(teacherName);

							System.out.println("Enter Teacher Email: ");
							String teacherEmail = scanner.next();
							teacher.setEmail(teacherEmail);

							System.out.println("Enter Teacher Contact Number: ");
							int teacherNumber = scanner.nextInt();
							teacher.setNumber(teacherNumber);

							teacherDao.insertTeacher(teacher, courseId);
							break;
						case 2:
							System.out.println("Delete Teachers...");
							TeacherDao teacherDao2 = new TeacherDaoImpl();
							Scanner sc1 = new Scanner(System.in);
							System.out.println("Enter teacher id");
							Integer teacherIdToDelete = sc1.nextInt();
							teacherDao2.deleteTeacher(teacherIdToDelete);
							break;
						case 3:
							TeacherDao teacherDao1 = new TeacherDaoImpl();
							System.out.println("Update Teachers...");
							Scanner scanner1 = new Scanner(System.in);
							System.out.println("Enter Course Id: ");
							Integer courseIdToUpdate = scanner1.nextInt();
							Scanner scanner11 = new Scanner(System.in);

							Teacher teacherToUpdate = new Teacher();

							System.out.println("Enter Teacher Id: ");
							int teacherIdToUpdate = scanner11.nextInt();
							teacherToUpdate.setTid(teacherIdToUpdate);

							System.out.println("Enter Teacher Name: ");
							String teacherNameToUpdate = scanner11.next();
							teacherToUpdate.setTname(teacherNameToUpdate);

							System.out.println("Enter Teacher Email: ");
							String teacherEmailToUpdate = scanner11.next();
							teacherToUpdate.setEmail(teacherEmailToUpdate);

							System.out.println("Enter Teacher Contact Number: ");
							int teacherNumberToUpdate = scanner11.nextInt();
							teacherToUpdate.setNumber(teacherNumberToUpdate);

							teacherDao1.updateTeacher(teacherToUpdate, courseIdToUpdate);
							break;
						case 4:
							System.out.println("Show All Teachers...");
							TeacherDao teacherDao7 = new TeacherDaoImpl();
							teacherDao7.showAllTeachers();
							break;
						case 5:
							System.out.println("Show Any Teacher...");
							TeacherDao teacherDao4 = new TeacherDaoImpl();
							Scanner sc4 = new Scanner(System.in);
							System.out.println("Enter teacher id");
							Integer teacherIdToShow = sc4.nextInt();
							Teacher teacherDetails = teacherDao4.showOnlyOneTeacherDetails(teacherIdToShow);
							System.out.println(teacherDetails);
							break;
						case 6:
							System.out.println("Exited from Teacher Section Successfully...");
							break;
						}
					} while (optionCart != 6);
					break;

				case 3:
					do {
						System.out.println(
								"1. Select 1 Add Students\n2. Select 2 Delete Students\n3. Select 3 Update Students"
										+ "\n4. Select 4 to Show All Students\n5. Select 5 to Show Any Students\n6. Select 6 for Exit");
						optionOrder = s.nextInt();
						switch (optionOrder) {
						case 1:
							System.out.println("Add Students...");
							StudentDao studentDao = new StudentDaoImpl();
							System.out.println("Enter Course Id: ");
							Scanner scanner = new Scanner(System.in);
							Integer cid = scanner.nextInt();

							Student student = new Student();

							System.out.println("Enter 1st Student Id: ");
							int stdId = scanner.nextInt();
							student.setSid(stdId);

							System.out.println("Enter 1st Student  Name: ");
							String stdName = scanner.next();
							student.setSname(stdName);

							System.out.println("Enter 1st Student Email: ");
							String stdEmail = scanner.next();
							student.setEmail(stdEmail);

							System.out.println("Enter 1st student number: ");
							int stdNumber = scanner.nextInt();
							student.setNumber(stdNumber);

							System.out.println("Enter 1st Student Address: ");
							String stdAddress = scanner.next();
							student.setAddress(stdAddress);

							System.out.println("Enter 1st Student age: ");
							int stdAge = scanner.nextInt();
							student.setAge(stdAge);

							studentDao.insertStudent(student, cid);
							break;
						case 2:
							System.out.println("Delete Students...");
							StudentDao studentDao2 = new StudentDaoImpl();
							Scanner sc1 = new Scanner(System.in);
							System.out.println("Enter student id");
							Integer studentIdToDelete = sc1.nextInt();
							studentDao2.deleteStudent(studentIdToDelete);
							break;
						case 3:
							StudentDao studentDao1 = new StudentDaoImpl();
							System.out.println("Update Students...");
							Scanner scanner1 = new Scanner(System.in);
							System.out.println("Enter Course Id: ");
							Integer cid7 = scanner1.nextInt();
							Scanner scanner11 = new Scanner(System.in);

							Student studentToUpdate = new Student();

							System.out.println("Enter 1st Student Id: ");
							int stdId1 = scanner11.nextInt();
							studentToUpdate.setSid(stdId1);

							System.out.println("Enter 1st Student  Name: ");
							String stdName1 = scanner11.next();
							studentToUpdate.setSname(stdName1);

							System.out.println("Enter 1st Student Email: ");
							String stdEmail1 = scanner11.next();
							studentToUpdate.setEmail(stdEmail1);

							System.out.println("Enter 1st student number: ");
							int stdNumber1 = scanner11.nextInt();
							studentToUpdate.setNumber(stdNumber1);

							System.out.println("Enter 1st Student Address: ");
							String stdAddress1 = scanner11.next();
							studentToUpdate.setAddress(stdAddress1);

							System.out.println("Enter 1st Student age: ");
							int stdAge1 = scanner11.nextInt();
							studentToUpdate.setAge(stdAge1);

							studentDao1.updateStudent(studentToUpdate, cid7);
							break;
						case 4:
							System.out.println("Show All Students...");
							StudentDao studentDao7 = new StudentDaoImpl();
							studentDao7.showAllStudents();
							break;
						case 5:
							System.out.println("Show Any Student...");
							StudentDao studentDao4 = new StudentDaoImpl();
							Scanner sc4 = new Scanner(System.in);
							System.out.println("Enter student id");
							Integer studentIdToShow = sc4.nextInt();
							Student studentDetails = studentDao4.showOnlyOneStudentDetails(studentIdToShow);
							System.out.println(studentDetails);
							break;
						case 6:
							System.out.println("Exited from Courses Section Successfully...");
							break;
						}
					} while (optionOrder != 6);
					break;

				case 4:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid option. Please choose a valid option.");
					break;
				}
			}
		} while (option != 4);

		s.close();
	}
}
