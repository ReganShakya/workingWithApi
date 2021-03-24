/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.restapi.exc;

/**
 *
 * @author regan
 */
public class ApiError extends RuntimeException{
    private final int status;
    
    public ApiError(int status, String msg){
        super(msg);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
    
    
}
