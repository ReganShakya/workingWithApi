/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.restapi.dao;

import com.web.restapi.model.Course;
import com.web.restapi.exc.DaoException;
import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

/**
 *
 * @author Regan Shakya <regan@moco.com.np>
 */
public class Sql2oCourseDao implements CourseDao{

    private final Sql2o sql2o;
    
    public Sql2oCourseDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Course course) throws DaoException {
        String sql = "INSERT INTO courses(name, url) VALUES (:name, :url)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql)
                    .bind(course)
                    .executeUpdate()
                    .getKey();
            course.setId(id);
        }catch(Sql2oException ex){
            throw new DaoException(ex,"Problem adding course");
        }
    }

    @Override
    public List<Course> findAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM courses")
                    .executeAndFetch(Course.class);
        }
    }

    @Override
    public Course findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM courses WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Course.class);
        }
    }

    @Override
    public Course findByName(String name) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM courses WHERE name = :name")
                    .addParameter("name", name)
                    .executeAndFetchFirst(Course.class);
        }
    }
    
}
