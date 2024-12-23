import java.util.*;
import java.io.*;

// Student class
class Student {
    private int id;
    private String name;
    private List<CourseGrade> grades;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<CourseGrade> getGrades() {
        return grades;
    }

    public void addGrade(CourseGrade grade) {
        this.grades.add(grade);
    }

    public void displayGrades() {
        for (CourseGrade grade : grades) {
            System.out.println("Course: " + grade.getCourseName() + ", Grade: " + grade.getGrade());
        }
    }
}

// Course class
class Course {
    private String courseName;
    private String courseCode;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void displayCourseInfo() {
        System.out.println("Course Name: " + courseName + ", Course Code: " + courseCode);
    }
}

// CourseGrade class to store grades for students in specific courses
class CourseGrade {
    private Course course;
    private double grade;

    public CourseGrade(Course course, double grade) {
        this.course = course;
        this.grade = grade;
    }

    public String getCourseName() {
        return course.getCourseName();
    }

    public double getGrade() {
        return grade;
    }
}

// System Manager class
class SystemManager {
    private Map<Integer, Student> students;
    private Map<String, Course> courses;

    public SystemManager() {
        this.students = new HashMap<>();
        this.courses = new HashMap<>();
    }

    // Add a new student
    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    // Remove a student
    public void removeStudent(int studentId) {
        students.remove(studentId);
    }

    // Get a student by ID
    public Student getStudentById(int studentId) {
        return students.get(studentId);
    }

    // Add a new course
    public void addCourse(Course course) {
        courses.put(course.getCourseCode(), course);
    }

    // Remove a course
    public void removeCourse(String courseCode) {
        courses.remove(courseCode);
    }

    // Get a course by code
    public Course getCourseByCode(String courseCode) {
        return courses.get(courseCode);
    }

    // Assign grade to a student
    public void assignGrade(int studentId, String courseCode, double grade) {
        Student student = students.get(studentId);
        Course course = courses.get(courseCode);
        if (student != null && course != null) {
            student.addGrade(new CourseGrade(course, grade));
        }
    }

    // Display all students
    public void displayAllStudents() {
        for (Student student : students.values()) {
            System.out.println("Student ID: " + student.getId() + ", Name: " + student.getName());
            student.displayGrades();
        }
    }

    // Display all courses
    public void displayAllCourses() {
        for (Course course : courses.values()) {
            course.displayCourseInfo();
        }
    }
}

// Main Class
public class StudentManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static SystemManager systemManager = new SystemManager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Add Course");
            System.out.println("4. Remove Course");
            System.out.println("5. Assign Grade");
            System.out.println("6. View All Students");
            System.out.println("7. View All Courses");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    addCourse();
                    break;
                case 4:
                    removeCourse();
                    break;
                case 5:
                    assignGrade();
                    break;
                case 6:
                    systemManager.displayAllStudents();
                    break;
                case 7:
                    systemManager.displayAllCourses();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        systemManager.addStudent(new Student(id, name));
        System.out.println("Student added successfully.");
    }

    private static void removeStudent() {
        System.out.print("Enter student ID to remove: ");
        int id = scanner.nextInt();
        systemManager.removeStudent(id);
        System.out.println("Student removed successfully.");
    }

    private static void addCourse() {
        scanner.nextLine();  // Consume newline
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        systemManager.addCourse(new Course(courseName, courseCode));
        System.out.println("Course added successfully.");
    }

    private static void removeCourse() {
        scanner.nextLine();  // Consume newline
        System.out.print("Enter course code to remove: ");
        String courseCode = scanner.nextLine();
        systemManager.removeCourse(courseCode);
        System.out.println("Course removed successfully.");
    }

    private static void assignGrade() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();
        systemManager.assignGrade(studentId, courseCode, grade);
        System.out.println("Grade assigned successfully.");
    }
}
