/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.restapi.dao;

import com.web.restapi.model.Review;
import com.web.restapi.exc.DaoException;
import java.util.List;

/**
 *
 * @author Regan Shakya <regan@moco.com.np>
 */
public interface ReviewDao {
    void add(Review review) throws DaoException;
    List<Review> findAll();
    List<Review> findByCourseId(int courseId);
}
