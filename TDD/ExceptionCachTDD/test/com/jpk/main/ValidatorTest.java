package com.jpk.main;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.jpk.exceptions.ValidationException;
import com.jpk.interfaces.validable;


public class ValidatorTest
{
    private static final String VALID_STRING = "ABCD";
    private static final String INVALID_STRING = "ABC2";
    private static final Object PRINT_OUT_STRING_RESPONCE = "Message is Valid";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private Validator validator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Before
    public void setUpStreams()
    {
        System.setOut( new PrintStream( outContent ) );
    }


    @Before
    public void setUp()
    {
        validator = new Validator();
    }


    @After
    public void cleanUpStreams()
    {
        System.setOut( null );
    }


    @Test( expected = ValidationException.class )
    public void testValidationMethod_ShouldReturnExceptionIfStringIsNotValid() throws ValidationException
    {
        validator.validation( INVALID_STRING );
    }


    @Test
    public void testValidationExceptionMessage_ShouldThrowException() throws ValidationException
    {
        thrown.expect( ValidationException.class );
        thrown.expectMessage( "Error Message" );
        validator.validation( INVALID_STRING );
        thrown.expectMessage( Matchers.containsString( "Error Message" ) );
    }


    @Test
    public void testValidationMethod_ShouldReturnOutPrintfIsValid() throws ValidationException
    {
        validator.validation( VALID_STRING );
        assertEquals( PRINT_OUT_STRING_RESPONCE, outContent.toString() );
    }


    @Test( expected = ValidationException.class )
    public void testOfInterface_ShouldReturnExcepionIfStringIsNotValid() throws ValidationException
    {
        validable valInterface = new Validator();
        valInterface.validation( INVALID_STRING );
    }

}
