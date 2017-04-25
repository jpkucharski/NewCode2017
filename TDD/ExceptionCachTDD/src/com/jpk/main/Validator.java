package com.jpk.main;

import com.jpk.exceptions.ValidationException;
import com.jpk.interfaces.validable;


public class Validator implements validable
{
    @Override  
    public void validation( String stringMessage ) throws ValidationException
    {

        if( stringMessage.matches( "[A-Z]{4}" ) )
        {
            System.out.print( "Message is Valid" );
        }
        else
        {
            throw new ValidationException( "Error Message" );
        }
    }
}
