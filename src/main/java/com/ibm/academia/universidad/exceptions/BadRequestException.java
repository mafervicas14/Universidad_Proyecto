package com.ibm.academia.universidad.exceptions;

public class BadRequestException extends  RuntimeException
{
    public  BadRequestException(String message){
        super(message);
    }
}
