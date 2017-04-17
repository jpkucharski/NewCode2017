package com.jpk.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.IllegalFormatException;

import com.google.common.annotations.VisibleForTesting;
import com.jpk.customExceptions.InvalidMessageException;


public class MessageValidator
{

    public boolean isValid( String message ) throws InvalidMessageException 
    {
        String[] messageParts = message.split( " " );
        boolean trigger = false;
        try
        {
            if( messageCorrectType( messageParts[0] ) | messageCorrectProductCode( messageParts[1] ) |
                messageCorrectQuantity( messageParts[2] ) | messageCorrectUom( messageParts[3] ) |
                chackingMessageCorrectTimestamp( messageParts[4] ) )
            {
                trigger = true;
            }
        }
        catch( ParseException | IllegalFormatException e )
        {
            throw new InvalidMessageException( "Invalid Message from Message Validator" );
        }
        return trigger;
    }


    @VisibleForTesting
    protected boolean messageCorrectType( String messagePart )
    {
        final String regex = "[A-D]";
        return messagePart.matches( regex );
    }


    @VisibleForTesting
    protected boolean messageCorrectProductCode( String messagePart )
    {
        final String regex = "[A-Z]{2}\\d{2}";
        return messagePart.matches( regex );

    }


    @VisibleForTesting
    protected boolean messageCorrectQuantity( String messagePart )
    {
        boolean isParsable;

        isParsable = Integer.parseInt( messagePart ) > 0;

        return isParsable;
    }


    @VisibleForTesting
    protected boolean messageCorrectUom( String messagePart )
    {
        return Integer.parseInt( messagePart ) >= 0;
    }


    @VisibleForTesting
    protected boolean chackingMessageCorrectTimestamp( String messagePart ) throws ParseException
    {

        Date date = null;
        final String format = "yyyyMMdd'T'HH:mm:ss.SSS'Z'";
        SimpleDateFormat sdf = new SimpleDateFormat( format );

        date = sdf.parse( messagePart );

        if( !messagePart.equals( sdf.format( date ) ) )
        {
            date = null;
        }

        return date != null;
    }
}
