/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.restapi.dao;

import com.web.restapi.Course;
import com.web.restapi.Review;
import com.web.restapi.exc.DaoException;
import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

/**
 *
 * @author regan
 */
public class Sql2oReviewDao implements ReviewDao{

    private final Sql2o sql2o;

    public Sql2oReviewDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Review review) throws DaoException {
        String sql = "INSERT INTO reviews(course_id, rating, comment) VALUES (:courseId, :rating, :comment)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql)
                    .bind(review)
                    .executeUpdate()
                    .getKey();
            review.setId(id);
        }catch(Sql2oException ex){
            throw new DaoException(ex,"Problem adding review");
        }
    }

    @Override
    public List<Review> findAll() {
        try(Connection con = sql2o.open()){
            return  con.createQuery("SELECT * FROM reviews")
                        .executeAndFetch(Review.class);
        }
    }

    @Override
    public List<Review> findByCourseId(int courseId) {
        
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM reviews WHERE course_id = :courseId")
                    .addParameter("courseId", courseId)
                    .executeAndFetch(Review.class);
        } 
    }
    
}
