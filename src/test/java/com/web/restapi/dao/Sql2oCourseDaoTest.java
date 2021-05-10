package com.web.restapi.dao;

import com.web.restapi.db.DbConfiguration;
import com.web.restapi.model.Course;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author regan
 */
public class Sql2oCourseDaoTest {
    
    ReviewDao reviewDao = new Sql2oReviewDao(DbConfiguration.getConnetion());
    CourseDao courseDao = new Sql2oCourseDao(DbConfiguration.getConnetion());
    
    public Sql2oCourseDaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of add method, of class Sql2oCourseDao.
     */
//    @Test
//    public void testAdd() throws Exception {
//        System.out.println("add test");
//        Course course = new Course();
//        course.setName("Spring");
//        course.setUrl("www.spring.com");
//        courseDao.add(course);
//        Course addedCourse = courseDao.findByName("Spring");
//        
//        assertTrue(addedCourse.getId()>0);
//        assertEquals(addedCourse.getName(), course.getName());
//    }

    /**
     * Test of findAll method, of class Sql2oCourseDao.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll test");
        List<Course> result = courseDao.findAll();
        assertTrue(result.size() > 0);
    }

    /**
     * Test of findById method, of class Sql2oCourseDao.
     */
    @Test
    public void testFindById() {
        System.out.println("findById test");
        int id = 4;
        Course result = courseDao.findById(id);
        assertNotNull(result);
        assertEquals(result.getId(), id);
    }
    
    @Test
    public void testFindByName() {
        System.out.println("findByName test");
        String name = "Spring";
        Course result = courseDao.findByName(name);
        assertNotNull(result);
        assertEquals(result.getName(), name);
    }
    
}
