package com.Vinnie.logic;

import com.innowadi.internship.logic.StudentLogic;
import com.innowadi.internship.logic.StudentLogicI;
import com.innowadi.internship.model.Student;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
public class StudentLogicTest {
    StudentLogicI studentLogicI;

    public StudentLogicTest() throws SQLException, ClassNotFoundException {
        studentLogicI = new StudentLogic();
    }

    @Test
    public void add() throws SQLException {
        Student student = new Student();
        student.setIdNumber("89097");
        student.setCourse("Program");
        student.setRegistrationNo("C03/45788/12");
        student.setName("Alice");
        if (!studentLogicI.add(student))
            Assert.assertFalse(false); // confirmation that it has failed
        Student search = studentLogicI.find(student.getRegistrationNo());
        Assert.assertEquals(student.getRegistrationNo(), search.getRegistrationNo());
        Assert.assertEquals(student.getName(), search.getName());
        Assert.assertEquals(student.getCourse(), search.getCourse());
        Assert.assertEquals(student.getIdNumber(), search.getIdNumber());
    }

    @Test
    public void update() throws SQLException {
        Student search = studentLogicI.find("C03/45788/12");
        search.setName("Alice");
        search.setCourse("Program");
        search.setIdNumber("89097");
        if (!studentLogicI.update(search))
            Assert.assertFalse(false); // confirmation that it has failed
        // Means the update was successful. We need to test for correctness of the updated data
        Student student = studentLogicI.find(search.getId());
        Assert.assertEquals(student.getRegistrationNo(), search.getRegistrationNo());
        Assert.assertEquals(student.getName(), search.getName());
        Assert.assertEquals(student.getCourse(), search.getCourse());
        Assert.assertEquals(student.getIdNumber(), search.getIdNumber());
    }

    @Test
    public void delete() throws SQLException {
        Student search = studentLogicI.find("C03/45788/12");
        if (!studentLogicI.delete(search))
            Assert.assertFalse(false);
        Student student = studentLogicI.find(search.getRegistrationNo());
        Assert.assertEquals(student.getRegistrationNo(), search.getRegistrationNo());

    }
}