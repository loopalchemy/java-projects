import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private String id;
    private double grade;

    public Student(String name, String id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() { return name; }
    public String getId() { return id; }
    public double getGrade() { return grade; }

    public void setGrade(double grade) { this.grade = grade; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Grade: " + grade;
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\nStudent Management Menu:");
            System.out.println("1. Add student");
            System.out.println("2. View all students");
            System.out.println("3. Update student grade");
            System.out.println("4. Delete student");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student grade: ");
                    double grade = sc.nextDouble();
                    sc.nextLine(); // consume newline
                    students.add(new Student(name, id, grade));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if(students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("All students:");
                        for(Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID to update grade: ");
                    String updateId = sc.nextLine();
                    boolean found = false;
                    for(Student s : students) {
                        if(s.getId().equals(updateId)) {
                            System.out.print("Enter new grade: ");
                            double newGrade = sc.nextDouble();
                            sc.nextLine(); // consume newline
                            s.setGrade(newGrade);
                            System.out.println("Grade updated!");
                            found = true;
                            break;
                        }
                    }
                    if(!found) System.out.println("Student not found!");
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");
                    String deleteId = sc.nextLine();
                    boolean removed = students.removeIf(s -> s.getId().equals(deleteId));
                    if(removed) System.out.println("Student deleted!");
                    else System.out.println("Student not found!");
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
