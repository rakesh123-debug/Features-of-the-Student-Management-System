import java.util.*;

class Student {
    String name;
    int age;
    String rollNumber;

    public Student(String name, int age, String rollNumber) {
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Roll Number: " + rollNumber;
    }
}

public class StudentManagementSystem {
    static Map<String, Student> students = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student\n2. View Student\n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter Name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Age:");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter Roll Number:");
                    String rollNumber = scanner.nextLine();

                    students.put(rollNumber, new Student(name, age, rollNumber));
                    break;

                case 2:
                    System.out.println("Enter Roll Number:");
                    String rollNo = scanner.nextLine();
                    if (students.containsKey(rollNo)) {
                        System.out.println(students.get(rollNo));
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 3:
                    System.exit(0);
            }
        }
    }
}
