package com.web.restapi.dao;

import com.web.restapi.db.DbConfiguration;
import com.web.restapi.model.Review;
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
public class Sql2oReviewDaoTest {
    
    ReviewDao reviewDao = new Sql2oReviewDao(DbConfiguration.getConnetion());
    CourseDao courseDao = new Sql2oCourseDao(DbConfiguration.getConnetion());
    
    public Sql2oReviewDaoTest() {
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
     * Test of add method, of class Sql2oReviewDao.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add test");
        Review review = new Review();
        review.setCourseId(1);
        review.setRating(4);
        review.setComment("Spring is fun.");
        reviewDao.add(review);
        Review addedReview = null;
        List<Review> addedReviews = reviewDao.findAll();
        for(Review rev:addedReviews) {
            if(rev.getComment().equals("Spring is fun.")){
                addedReview = rev;
                break;
            }
        }
        assertNotNull(addedReview);
        assertEquals(addedReview.getComment(),"Spring is fun.");
    }

    /**
     * Test of findAll method, of class Sql2oReviewDao.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        List<Review> reviews = reviewDao.findAll();
        assertTrue(reviews.size() > 0);
    }

    /**
     * Test of findByCourseId method, of class Sql2oReviewDao.
     */
    @Test
    public void testFindByCourseId() {
        int id = 1;
        List<Review> review = reviewDao.findByCourseId(id);
        assertTrue(review.size() > 0);
        assertEquals(review.get(0).getCourseId(), id);
    }
    
}
