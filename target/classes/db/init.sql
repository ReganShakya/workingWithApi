/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Regan Shakya <regan@moco.com.np>
 * Created: Aug 3, 2020
 */

CREATE TABLE IF NOT EXISTS courses(
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
    url  VARCHAR
);

CREATE TABLE IF NOT EXISTS  reviews(
    id INTEGER PRIMARY KEY auto_increment,
    course_id INTEGER,
    rating INTEGER,
    comment VARCHAR,
    FOREIGN KEY(course_id) REFERENCES courses(id)
);