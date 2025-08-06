import java.util.*;

public class StudentDBMS {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Record Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        studentList.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        boolean found = false;

        for (Student s : studentList) {
            if (s.getId() == id) {
                scanner.nextLine();
                System.out.print("Enter New Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter New Marks: ");
                double marks = scanner.nextDouble();
                s.setName(name);
                s.setMarks(marks);
                System.out.println("Student updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found with ID: " + id);
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        boolean removed = studentList.removeIf(s -> s.getId() == id);
        if (removed) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }
}