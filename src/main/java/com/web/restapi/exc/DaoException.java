/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.restapi.exc;

/**
 *
 * @author Regan Shakya <regan@moco.com.np>
 */
public class DaoException extends Exception {
    
    private final Exception originalException;
    
    public DaoException(Exception originaException, String msg){
        super(msg);
        this.originalException = originaException;
    }
}
