/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.restapi;

import com.google.gson.Gson;
import com.web.restapi.model.Course;
import com.web.restapi.model.Review;
import com.web.restapi.dao.CourseDao;
import com.web.restapi.dao.ReviewDao;
import com.web.restapi.dao.Sql2oCourseDao;
import com.web.restapi.dao.Sql2oReviewDao;
import com.web.restapi.db.DbConfiguration;
import com.web.restapi.exc.ApiError;
import com.web.restapi.exc.DaoException;
import java.util.HashMap;
import java.util.Map;
import org.sql2o.Sql2o;
import static spark.Spark.*;

/**
 *
 * @author Regan Shakya <regan@moco.com.np>
 */
public class Api {

    public static void main(String[] args) {

        ReviewDao reviewDao = new Sql2oReviewDao(DbConfiguration.getConnetion());
        CourseDao courseDao = new Sql2oCourseDao(DbConfiguration.getConnetion());
        Gson gson = new Gson();

        get("/hello", (req, res) -> "Hello World");
        post("/courses", "application/json", (req, res) -> {
            Course course = gson.fromJson(req.body(), Course.class);
            courseDao.add(course);
            res.status(201);
            return course;
        }, gson::toJson);

        get("/courses", "application/json",
                (req, res) -> courseDao.findAll(), gson::toJson);

        get("/courses/:id", "application/json", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Course course = courseDao.findById(id);
            if (course == null) {
                throw new ApiError(404, "Could not find course with id " + id);
            }
            return course;
        }, gson::toJson);

        post("/courses/:courseId/reviews", "application/json", (req, res) -> {
            int courseId = Integer.parseInt(req.params("courseId"));
            Review review = gson.fromJson(req.body(), Review.class);
            review.setCourseId(courseId);
            try {
                reviewDao.add(review);
            } catch (DaoException ex) {
                throw new ApiError(500, ex.getMessage());
            }
            res.status(201);
            return review;
        }, gson::toJson);

        get("/reviews", "application/json",
                (req, res) -> reviewDao.findAll(), gson::toJson);
        
        get("/courses/:courseId/reviews", "application/json", (req, res) -> {
            int courseId = Integer.parseInt(req.params("courseId"));
            return reviewDao.findByCourseId(courseId);
        }, gson::toJson);

        exception(ApiError.class, (exc, req, res) -> {
            ApiError err = (ApiError) exc;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatus());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatus());
            res.body(gson.toJson(jsonMap));
        });

        after((req, res) -> {
            res.type("application/json");
        });
    }
}
