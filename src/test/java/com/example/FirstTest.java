package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

import com.example.First.Student;

public class FirstTest {

    @Test
    public void testAddStudent() {
        First sms = new First();
        Student s = sms.addStudent(1, "Alice", 20, "Computer Science");

        assertEquals(1, s.getId());
        assertEquals("Alice", s.getName());
        assertEquals(20, s.getAge());
        assertEquals("Computer Science", s.getCourse());
        assertEquals(1, sms.countStudents());
    }

    @Test
    public void testFindStudentById() {
        First sms = new First();
        sms.addStudent(1, "Bob", 22, "Mathematics");

        Student found = sms.findStudentById(1);
        assertNotNull(found);
        assertEquals("Bob", found.getName());

        Student notFound = sms.findStudentById(99);
        assertNull(notFound);
    }

    @Test
    public void testUpdateStudent() {
        First sms = new First();
        sms.addStudent(1, "Charlie", 21, "Physics");

        boolean result = sms.updateStudent(1, "Charlie Brown", 23, "Chemistry");
        assertTrue(result);

        Student updated = sms.findStudentById(1);
        assertEquals("Charlie Brown", updated.getName());
        assertEquals(23, updated.getAge());
        assertEquals("Chemistry", updated.getCourse());
    }

    @Test
    public void testUpdateStudentNotFound() {
        First sms = new First();
        boolean result = sms.updateStudent(99, "Nobody", 0, "None");
        assertFalse(result);
    }

    @Test
    public void testDeleteStudent() {
        First sms = new First();
        sms.addStudent(1, "David", 24, "Biology");

        boolean deleted = sms.deleteStudent(1);
        assertTrue(deleted);
        assertEquals(0, sms.countStudents());
    }

    @Test
    public void testDeleteStudentNotFound() {
        First sms = new First();
        boolean deleted = sms.deleteStudent(42);
        assertFalse(deleted);
    }

    @Test
    public void testCountStudents() {
        First sms = new First();
        sms.addStudent(1, "Eva", 19, "History");
        sms.addStudent(2, "Frank", 20, "Art");

        assertEquals(2, sms.countStudents());
    }
}
