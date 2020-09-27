/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interra.ead_scheduler_core.response;

import org.aspectj.apache.bcel.Constants;

/**
 *
 * @author d
 */
public class ResponseParams {
        public static class Codes{
        public static Integer
                EXCEPTION = 909,
                UNAUTHORIZED = 401,
                NO_DATA_SENT = 201,
                NOT_FOUND = 404,
                SUCCESS = 200,
                GENERAL_ERROR = 405,
                INVALID_REQUEST = 400,
                INACTIVE = 403,
                UNPROCESSABLE_ENTITY = 422;
    }

    public static class Messages{
        static String
                EXCEPTION = "There was an exception",
                NO_DATA_SENT = "Request Successful but no content",
                NOT_FOUND = "Requested Resource was not found",
                SUCCESS = "Successful",
                SUCCESS_NO_EMAIL = "Successful",
                GENERAL_ERROR = "Method Not Allowed",
                UNAUTHORIZED = "Unauthorized, authentication failed",
                INACTIVE = "The accessed resource is forbidden",
                INVALID_REQUEST = "The sent request is invalid",
                UNPROCESSABLE_ENTITY = "The sent request cannot be processed";
    }

    public static ESResponse buildUnAuthorized(Object message){
        return new ESResponse(Codes.UNAUTHORIZED, Messages.UNAUTHORIZED, message);
    }

    public static ESResponse buildException(Object message){
        return new ESResponse(Codes.EXCEPTION, Messages.EXCEPTION, message);
    }

    
    public static ESResponse buildSuccess(Object... message){
    	return new ESResponse(Codes.SUCCESS, Messages.SUCCESS, message);
    }

    public static ESResponse buildNotFound(Object message){
        return new ESResponse(Codes.NOT_FOUND, Messages.NOT_FOUND, message);
    }

    public static ESResponse buildGeneralError(Object message){
        return new ESResponse(Codes.GENERAL_ERROR, Messages.GENERAL_ERROR, message);
    }

    public static ESResponse buildNoDataSent(Object message){
        return new ESResponse(Codes.NO_DATA_SENT, Messages.NO_DATA_SENT, message);
    }

    public static ESResponse buildInactive(Object message){
        return new ESResponse(Codes.INACTIVE, Messages.INACTIVE, message);
    }

    public static ESResponse buildInvalidRequest(Object message){
        return new ESResponse(Codes.INVALID_REQUEST, Messages.INVALID_REQUEST, message);
    }

    public static ESResponse buildUnprocessableRequest(Object message){
        return new ESResponse(Codes.UNPROCESSABLE_ENTITY, Messages.UNPROCESSABLE_ENTITY, message);
    }
    
}
