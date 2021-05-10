/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.restapi.dao;

import com.web.restapi.exc.DaoException;
import com.web.restapi.model.Course;
import java.util.List;

/**
 *
 * @author Regan Shakya <regan@moco.com.np>
 */
public interface CourseDao {
    void add(Course course) throws DaoException;
    List<Course> findAll();

    public Course findById(int id);
    
    public Course findByName(String name);
}
