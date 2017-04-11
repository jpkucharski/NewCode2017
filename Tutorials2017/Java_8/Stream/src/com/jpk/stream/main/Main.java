package com.jpk.stream.main;

import java.util.Arrays;
import java.util.List;

public class Main
{

    public static void main( String[] args )
    {
      
        List<String> list1 = Arrays.asList( "a1","a2","b1","c2","c1","c4","c0","c11" );
        
        
        list1
            .stream()                                  //creating a Stream
            .filter( s -> s.startsWith( "c" ))         //creating list starting with "c*"
            .map( String:: toUpperCase)                //all members of the list to upper case
            .sorted()                                  //sorted in alphanumeric order
            .forEach( System.out::println );           //for each member of list printing result
    }
}
