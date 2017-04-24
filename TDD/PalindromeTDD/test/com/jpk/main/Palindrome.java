package com.jpk.main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class Palindrome
{

    private static final String RANDOM_STRING = "PALANDROME";
    private static final String MIRRABLE_STRING = "ABCBA";
    private static final String NOT_MIRRABLE_STRING = "AbCBA";
    Palandrome palandrome;


    @Before
    public void setUp()
    {
        palandrome = new Palandrome();
    }


    @Test
    public void ifTheMirrowReflestionOfInsertedStringIsNotTheSameLikeString_ShouldReturnFalse()
    {
        assertFalse( palandrome.isPalandrome( RANDOM_STRING ) );
    }
    @Test
    public void ifTheMirrowReflectionOfInsertedStringIsTheSamehouldReturnThrue(){
        
        assertTrue( palandrome.isPalandrome( MIRRABLE_STRING ) );
    }

    @Test
    public void ifTheInsertedStringLookTheSameInMirrw_ShouldReturnTrue()
    {
        assertTrue( palandrome.isPalandrome( NOT_MIRRABLE_STRING ) );
    }

}
