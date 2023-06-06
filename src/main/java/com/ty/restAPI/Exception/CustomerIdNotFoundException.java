package com.ty.restAPI.Exception;

public class CustomerIdNotFoundException extends RuntimeException
{
    public  CustomerIdNotFoundException (String message)
    {
    	super(message);
    }
}
