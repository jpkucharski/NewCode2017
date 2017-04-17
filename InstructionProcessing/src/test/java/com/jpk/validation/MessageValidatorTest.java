package com.jpk.validation;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import com.jpk.customExceptions.InvalidMessageException;
import com.jpk.validation.MessageValidator;

public class MessageValidatorTest
{
    private static final String MESSAGE = "A MD89 5678 50 20150305T10:04:56.012Z";
    
    @Test
    public void chackingIfMessageValidationForMesageTypeIsCorrect_WillReturnTrueIfOK()
    {

        MessageValidator messageValidator = new MessageValidator();

        assertTrue( messageValidator.messageCorrectType( MESSAGE.split( " " )[0] ) );

    }


    @Test
    public void chackingIfMessageValidationForMesageProductCodeIsCorrect_ShouldReturnTrueIfOK()
    {

        MessageValidator messageValidator = new MessageValidator();

        assertTrue( messageValidator.messageCorrectProductCode( MESSAGE.split( " " )[1] ) );
    }


    @Test
    public void chackingIfMessageValidationForMesageQuantityIsCorrect_ShouldReturnTrueIfQuantityIsBiggerThen0() throws InvalidMessageException
    {

        MessageValidator messageValidator = new MessageValidator();

        assertTrue( messageValidator.messageCorrectQuantity( MESSAGE.split( " " )[2] ) );
    }


    @Test
    public void chackingIfMessageValidationForMesageUonIsCorrect_ShouldReturnTrueIfValueIsBetween0And256()
    {

        MessageValidator messageValidator = new MessageValidator();

        assertTrue( messageValidator.messageCorrectUom( MESSAGE.split( " " )[3] ) );

    }

    @Test
    public void chackingIfMessageValidationForMesageTimestampIsCorrect_ShouldReturnTrueIfTimePaternIsCorrect() throws ParseException 
    {
        MessageValidator messageValidator = new MessageValidator();
        assertTrue( messageValidator.chackingMessageCorrectTimestamp( MESSAGE.split( " " )[4] ) );
    }

}
