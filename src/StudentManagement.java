// Importing all classes from java.util package.
import java.util.*;
public class StudentManagement {
    private final Map<String, Student> studentList;
    private int totalStudents;

    public StudentManagement() {
        studentList = new HashMap<>();
        totalStudents = 0;
    }

    public void addStudent(String id, String name, int age, String grade) {
        if (!studentList.containsKey(id)) {
            studentList.put(id, new Student(id, name, age, grade));
            totalStudents++;
            System.out.println("You have added a student successfully!");
        } else {
            System.out.println("Student ID already exists!");
        }
    }

    public int getNumOfStudents() {
        return totalStudents;
    }

    public void updateInfo(String id, String name, Integer age, String grade) {
        Student existingStudent = studentList.get(id);
        if (existingStudent != null) {
            String newName = (name != null && !name.isEmpty()) ? name : existingStudent.getName();
            int newAge = (age != null) ? age : existingStudent.getAge();
            String newGrade = (grade != null && !grade.isEmpty()) ? grade : existingStudent.getGrade();
            studentList.put(id, new Student(id, newName, newAge, newGrade));
            System.out.println("Student information updated successfully!");
        } else {
            System.out.println("The student is not in the list. Please add the student first!");
        }
    }

    public void studentDetail(String id) {
        Student existingStudent = studentList.get(id);
        if (existingStudent != null) {
            System.out.println("The student ID is " + existingStudent.getId());
            System.out.println("The student name is " + existingStudent.getName());
            System.out.println("The student age is " + existingStudent.getAge());
            System.out.println("The student grade is " + existingStudent.getGrade());
        } else {
            System.out.println("The student is not in the list. Please type the correct ID!");
        }
    }

    public boolean restart(Scanner scanner) {
        while (true) {
            System.out.println("Do you want to restart the program? Please type yes or no!");
            String restartOption = scanner.nextLine().trim().toLowerCase();
            if (restartOption.equals("yes")) {
                return true;
            } else if (restartOption.equals("no")) {
                System.out.println("Exiting Student Management System. Goodbye!");
                return false;
            } else {
                System.out.println("Invalid input. Please type yes or no.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement manageStudent = new StudentManagement();
        while (true) {
            System.out.println("Welcome to Student Management System!");
            System.out.println("Please Choose the option 1-4!");
            System.out.println("1. Add Student");
            System.out.println("2. Update information of Student");
            System.out.println("3. Get detail information of a student");
            System.out.println("4. Exit the program");
            System.out.print("Enter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Enter student ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter the name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter the grade: ");
                        String grade = scanner.nextLine();
                        manageStudent.addStudent(id, name, age, grade);
                        if (manageStudent.restart(scanner)) {
                            break;
                        } else {
                            scanner.close();
                            return;
                        }

                    case 2:
                        System.out.println("Please enter the ID of the student you want to update. You can skip parts you don't want to update by pressing enter.");
                        System.out.print("Enter student ID: ");
                        String update_id = scanner.nextLine();
                        System.out.print("Enter the name: ");
                        String update_name = scanner.nextLine();
                        System.out.print("Enter age (or leave blank to skip): ");
                        String ageInput = scanner.nextLine();
                        Integer update_age = ageInput.isEmpty() ? null : Integer.parseInt(ageInput);
                        System.out.print("Enter the grade: ");
                        String update_grade = scanner.nextLine();
                        manageStudent.updateInfo(update_id, update_name, update_age, update_grade);
                        if (manageStudent.restart(scanner)) {
                            break;
                        } else {
                            scanner.close();
                            return;
                        }
                    case 3:
                        System.out.print("Enter student ID: ");
                        String student_id = scanner.nextLine();
                        manageStudent.studentDetail(student_id);
                        if (manageStudent.restart(scanner)) {
                            break;
                        } else {
                            scanner.close();
                            return;
                        }
                    case 4:
                        System.out.println("Exiting Student Management System. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.nextLine();
            }
        }
    }}