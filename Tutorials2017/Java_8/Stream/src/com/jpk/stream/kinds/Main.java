package com.jpk.stream.kinds;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class Main
{

    public static void main( String[] args )
    {
        
       System.out.println( "--------------------------------------------------------" );
        
       Arrays.asList( "a1","a2","a3","a4","a5","a6" )   //creating a
               .stream()                                //creating Stream
               .findFirst()                             //finding first element
               .ifPresent( System.out::println );       //printing element if it is present
       
       System.out.println( "--------------------------------------------------------" );
       
       Stream.of( "b1","b2","b3","b4","b5","b6" )       //creating an Stream of Strings
            .findFirst()                                //finding first element 
            .ifPresent( System.out::println );          //printing element if it is present
       
       System.out.println( "--------------------------------------------------------" );
       
       Stream.of( 1,2,3,4,5,6,7,8,9,10 )                 //creating an Stream of integer
           .forEach( System.out::println );              //for each element in stream printing it
       
       System.out.println( "--------------------------------------------------------" );
       
       Stream.of( 1.1,1.2,1.3,1.4,1.5,1.6,1.7 )         //creating an Stream of Double
           .forEach( System.out::println );             //for each element in stream printing it
       
       System.out.println( "--------------------------------------------------------" );
       
       IntStream.range(1,10)                            //creating a for loop from 1 to 9 not including 10
           .forEach( System.out::println );             //for each element in stream printing it
       
       System.out.println( "--------------------------------------------------------" );
       
       Arrays.stream( new int[] {1,2,3} )               //creating a new table of integers
           .map( n -> 2*n+1 )                           //each element of table n = 2*n+1
           .average()                                   //finding the average value 
           .ifPresent( System.out::println );           //if not empty printing the element
       
       System.out.println( "--------------------------------------------------------" );
       
       Stream.of( "a1","a2","a3","a4","a5","a6" )       //creating stream of strings
           .map( element -> element.substring(1) )      //subtracting element in position 1
           .mapToInt( Integer::parseInt )               //parsing element to Integer
           .max()                                       //finding maximum
           .ifPresent( System.out::println );           //if not empty printing the element
           
       System.out.println( "--------------------------------------------------------" );
       
          IntStream.range( 1, 4 )                       //creating string of Integers in range from 1 to 4 except 4
              .mapToObj( i -> "a" + i )                 //mapping each element to object adding "a" character to each one
              .forEach( System.out::println );          //for each element in stream printing it
       
       System.out.println( "--------------------------------------------------------" );
          
       Stream.of( 1.0,2.0,3.0 )                         //creating stream of Double elements
           .mapToInt( Double::intValue )                //mapping each element from Double to Integers
           .mapToObj( i -> "abc" + i )                  //mapping each element from Integer to String adding in the beginning of each element "abc" 
           .forEach( System.out::println );             //for each element in stream printing it
       
       System.out.println( "--------------------PROCESSING ORDER--------------------" );
       
       Stream.of( "d2","a2","b1","b3","c" )                             //creating stream of Strings
           .filter( s -> {                                              //filtering for all elements in stream printing it "filter: " + StringFromStream
               System.out.print( "filter: " + s );                      //!!!!  intermediate operations will only be executed when a terminal operation is present !!!!
               return true;
           })
           .forEach(s -> System.out.println(" forEach: " + s ));        //without terminal operation inner filtering operation will be not resolved

       System.out.println( "--------------------------------------------------------" );
       
       Stream.of( "d2","a2","b1","b3","c" )                             //creating a stream of Strings
           .map(element -> {                                            //for all elements of stream
               System.out.println("map: " + element);                   //maps elements adding in the front of each element "map: " string  
               return element.toUpperCase();                            //all element of stream to upper case
           })
           .anyMatch(element -> {                                       //for all elements until match
               System.out.println("anyMatch: " + element);              //print element and add "anyMach: " in the beginning with "A"
               return element.startsWith("A");
           });
    
       System.out.println( "--------------------------------------------------------" );
       
       Stream.of("d2", "a2", "b1", "b3", "c")                           //creating a stream of Strings
       .map(s -> {                                                      
           System.out.println("map: " + s);
           return s.toUpperCase();
       })
       .filter(s -> {                                                   
           System.out.println("filter: " + s);
           return s.startsWith("A");                                    //if true then jump to next operation
       })
       .forEach(s -> System.out.println("forEach: " + s));              // Thats line causes that the all inner lines will be displayed
                                                                        // without forEach loop that is a terminal operation 
    
    
    System.out.println( "--------------------------------------------------------" );
    
    Stream.of("d2", "a2", "b1", "b3", "c")                           //creating a stream of Strings
   
    .filter(s -> {
        System.out.println("filter: " + s);                          //display s-th element from stream
        return s.startsWith("a");                                    //check if it is starting with "a" character ( true /false ) if true go to next operation
    })
    .map(s -> {                                                      
        System.out.println("map: " + s);
        return s.toUpperCase();
    })
    .forEach(s -> System.out.println("forEach: " + s));             // display s-th element adding in the front of it "forEach: ",
                                                                    // repeat all operations in chain from beginning 
    System.out.println( "--------------------------------------------------------" );
    
    Stream.of("d2", "a2", "b1", "b3", "c")                           //creating a stream of Strings
        .sorted( (s1,s2) -> {                                       //sorting elements in the stream
            System.out.printf("sort: %s; %s;\n", s1 ,s2);
            return s1.compareTo( s2 );
        } )
        .filter(s -> {                                              //filters from all elements
            System.out.println("filter: " + s);                     //printing actual element
            return s.startsWith("a");                               //if its starting with character "a", if returns true proceed to nest steep
        })
        .map(s -> {                                                 //maps actual element          
            System.out.println("map: " + s);                        //displays actual element appending in the front of it "map: " String
            return s.toUpperCase();                                 //element to upper case
              })
        .forEach(s -> System.out.println("forEach: " + s));         //displays each element in actual stream passed through all the filters and processes
    
    System.out.println( "--------------------------------------------------------" );
    
    Stream.of("d2", "a2", "b1", "b3", "c")                          //creating a stream of Strings
        .filter(s -> {                                              //filters from all elements
            System.out.println("filter: " + s);                     //printing actual element
            return s.startsWith("a");                               //if its starting with character "a", if returns true proceed to nest steep
        })
        .sorted((s1, s2) -> {                                       //sorting elements from passed stream but that have right now only one element!
            System.out.printf("sort: %s; %s\n", s1, s2);
            return s1.compareTo(s2);
        })
        .map(s -> {
            System.out.println("map: " + s);                        //displaying actual element  appending it with "map: " String at the beginning
            return s.toUpperCase();                                 //changing actual element to upper case 
        })
        .forEach(s -> System.out.println("forEach: " + s));         //displaying forEach from stream, but it contains only one element
    
    System.out.println( "---------------------REUSING STREAMS--------------------" );
        
    Stream<String> stream = Stream.of( "d2", "a2", "b1", "b3", "c" )
                    .filter( element -> element.startsWith( "a" ) );
   // stream.anyMatch( element -> true );
   // stream.noneMatch( element -> true );                           //iff we will used such a expression on the same stream we will have illegal.state.Exceprion
    
    System.out.println( "--------------------------------------------------------" );
        
    Supplier<Stream<String>> streamSupplier = () -> Stream.of("d2", "a2", "b1", "b3", "c")      //stream supplier like thread poll.  
                    .filter( element -> element.startsWith( "a" ) );                            //But there is need to prepare all the streams inside
    
    streamSupplier.get().anyMatch( element -> true );
    streamSupplier.get().noneMatch( element -> true );
        
    System.out.println( "---------------------ADVANCED OPERATIONS--------------------" );
    
    
    
    
    
    
    
    }
    
}
