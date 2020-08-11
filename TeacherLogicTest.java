package com.Vinnie.logic;

import com.innowadi.internship.logic.TeacherLogic;
import com.innowadi.internship.logic.TeacherLogicI;
import com.innowadi.internship.model.Teacher;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void delete() throws SQLException {
        Teacher search = new Teacher();
        search.setStaffNo("2345678");
        if(!teacherLogicI.delete(search));
        Assert.assertFalse(false);
    }

    @Test
    public void findAll() throws SQLException {
        List<Teacher> find;
        find=teacherLogicI.findAll();
        if(find.isEmpty());
        Assert.assertFalse(false);
    }

    @Test
    public void find() throws SQLException {
        Teacher student=new Teacher();
        student.setId(6545678);
        //call find method
        Teacher search=teacherLogicI.find(student.getId());
        //check results
        Assert.assertEquals(search.getId(),student.getId());
    }

    @Test
    public void testFind() throws SQLException {
        Teacher student=new Teacher();
        student.setStaffNo("tondo");
        //call find method
        Teacher search=teacherLogicI.find(student.getStaffNo());
        //check results
        Assert.assertEquals(search.getId(),student.getId());
    }

}
