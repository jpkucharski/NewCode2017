package com.jpk.main;

public class Main
{
    static final String PALINDROME = "kajak";

    public static void main( String[] args )
    {
        System.out.println( isPalindrome( PALINDROME ));
    }

    private static boolean isPalindrome( String string )
    {
        return string.equals( new StringBuffer(string).reverse().toString() );
    }
}
