package com.innowadi.internship.logic;

import com.innowadi.internship.logic.TeacherLogic;
import com.innowadi.internship.logic.TeacherLogicI;
import com.innowadi.internship.model.Teacher;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class TeacherLogicTest {
    TeacherLogicI teacherLogicI;

    public TeacherLogicTest() throws SQLException, ClassNotFoundException {
        teacherLogicI = new TeacherLogic();
    }

    @Test
    public void add() throws SQLException {
        Teacher teacher = new Teacher();
        teacher.setStaffNo("23456");
        teacher.setCourse("Maths");
        teacher.setName("Andrew");
        if (!teacherLogicI.add(teacher))
            Assert.assertFalse(false); // confirmation that it has failed
        Teacher search = teacherLogicI.find(teacher.getStaffNo());
        Assert.assertEquals(teacher.getStaffNo(), search.getStaffNo());
        Assert.assertEquals(teacher.getName(), search.getName());
        Assert.assertEquals(teacher.getCourse(), search.getCourse());
    }

    @Test
    public void update() throws SQLException {
        Teacher search = teacherLogicI.find("2345678");
        search.setName("Evans");
        search.setCourse("English");
        if (!teacherLogicI.update(search))
            Assert.assertFalse(false); // confirmation that it has failed
        // Means the update was successful. We need to test for correctness of the updated data
        Teacher teacher = teacherLogicI.find(search.getStaffNo());
        Assert.assertEquals(teacher.getStaffNo(), search.getStaffNo());
        Assert.assertEquals(teacher.getName(), search.getName());
        Assert.assertEquals(teacher.getCourse(), search.getCourse());
    }

}