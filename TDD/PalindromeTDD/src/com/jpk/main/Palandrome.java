package com.jpk.main;

public class Palandrome
{

    public boolean isPalandrome( String string )
    {
        if( string.toUpperCase().equals( makeMirrowReflectionOfStringVariable( string ).toUpperCase() ) )
        {
            return true;
        }
        return false;
    }

    private String makeMirrowReflectionOfStringVariable(String string){
        return new StringBuilder(string).reverse().toString();
    }
}
