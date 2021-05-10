/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.restapi.model;

import java.util.Objects;

/**
 *
 * @author Regan Shakya <regan@moco.com.np>
 */
public class Review {
    
    private int id;
    private int course_id;
    private int rating;
    private String comment;
    
    public Review() {        
    }

    public Review(int courseId, int rating, String comment){
        this.course_id = courseId;
        this.rating = rating;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getCourseId() {
        return course_id;
    }

    public void setCourseId(int courseId) {
        this.course_id = courseId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        int hash = id;
        hash = 29 * hash + this.course_id;
        hash = 29 * hash + this.rating;
        hash = 29 * hash + Objects.hashCode(this.comment);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass()!=obj.getClass()) {
            return false;
        }
        Review other = (Review) obj;
        if(id != other.id){
            return false;
        }
        if (this.course_id != other.course_id) {
            return false;
        }
        if (this.rating != other.rating) {
            return false;
        }
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        return true;
    }
    
    
}
