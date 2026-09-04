package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Simple Student Management System
 * Supports: Add Student, View Students, Update Student, Delete Student
 */
public class First {

    private List<Student> students = new ArrayList<>();

    // ---------- Inner Student model ----------
    public static class Student {
        private int id;
        private String name;
        private int age;
        private String course;

        public Student(int id, String name, int age, String course) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.course = course;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
        public String getCourse() { return course; }
        public void setCourse(String course) { this.course = course; }

        @Override
        public String toString() {
            return "ID: " + id + " | Name: " + name + " | Age: " + age + " | Course: " + course;
        }
    }

    // ---------- Core operations ----------
    public Student addStudent(int id, String name, int age, String course) {
        Student s = new Student(id, name, age, course);
        students.add(s);
        return s;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public boolean updateStudent(int id, String name, int age, String course) {
        Student s = findStudentById(id);
        if (s == null) {
            return false;
        }
        s.setName(name);
        s.setAge(age);
        s.setCourse(course);
        return true;
    }

    public boolean deleteStudent(int id) {
        Student s = findStudentById(id);
        if (s == null) {
            return false;
        }
        students.remove(s);
        return true;
    }

    public int countStudents() {
        return students.size();
    }

    // ---------- Console menu (entry point) ----------
    public static void main(String[] args) {
        First sms = new First();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine().trim();
                    sms.addStudent(id, name, age, course);
                    System.out.println("Student added successfully.");
                    break;

                case "2":
                    System.out.println("---- Student List ----");
                    if (sms.getAllStudents().isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : sms.getAllStudents()) {
                            System.out.println(s);
                        }
                    }
                    break;

                case "3":
                    System.out.print("Enter ID to update: ");
                    int updateId = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Enter new Name: ");
                    String newName = sc.nextLine().trim();
                    System.out.print("Enter new Age: ");
                    int newAge = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Enter new Course: ");
                    String newCourse = sc.nextLine().trim();
                    boolean updated = sms.updateStudent(updateId, newName, newAge, newCourse);
                    System.out.println(updated ? "Student updated." : "Student not found.");
                    break;

                case "4":
                    System.out.print("Enter ID to delete: ");
                    int deleteId = Integer.parseInt(sc.nextLine().trim());
                    boolean deleted = sms.deleteStudent(deleteId);
                    System.out.println(deleted ? "Student deleted." : "Student not found.");
                    break;

                case "5":
                    running = false;
                    System.out.println("Exiting Student Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        sc.close();
    }
}
