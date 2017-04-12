package com.jpk.stream.flatMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;


class Outher {
    Nested nested;
}

class Nested {
    Inner inner;
}

class Inner {
    String foo;
}

class Foo {
    String name;
    List<Bar> bars = new ArrayList<>();

    Foo(String name) {
        this.name = name;
    }
}

class Bar {
    String name;

    Bar(String name) {
        this.name = name;
    }
}

public class Main
{

    public static void main( String[] args )
    {
      
        
        
     List<Foo> foos = new ArrayList<>();                                                                       //creating a list of Foo Objects

     
     IntStream.range(1, 4)
         .forEach(iElementFromRange -> foos.add(new Foo("Foo" + iElementFromRange)));                          //creating from 1 to 3 Foo Objects

     
     foos
         .forEach(foosElement -> IntStream.range(1, 4)                                                         //for each element of foos List crate from 1 to 3 
             .forEach(iElementFromRange -> foosElement                                                         //Bar Objects and add them to inner Bar List in each 
                 .bars.add(new Bar("Bar" + iElementFromRange + " <- " + foosElement.name))                     //foo Object
             )
          );
        
     foos.stream()                                                                                             //creating stream form foos list
         .flatMap(fooElement -> fooElement.bars.stream())                                                      //from each fooElement create barStream
         .forEach(barElement -> System.out.println(barElement.name));                                          //for each barElement from barStream
        
     System.out.println( "----------------------------------------------------------------" );
     
     IntStream.range( 1, 4 )                                                                                    //from i = 1 to 3
         .mapToObj( i -> new Foo("Foo" + i) )                                                                   //create forEach i Foo Object 
         .peek( f -> IntStream.range( 1, 4 )                                                                    //perform for each element of the FooStream action from i=1 to 3
             .mapToObj( i -> new Bar("Bar" + i + " <- " + f.name)  )                                            //create forEach i Bar Object with name
             .forEach( f.bars::add ))                                                                           //forEach Object Bar in Foo Object add it to Foo List
         .flatMap( f -> f.bars.stream() )                                                                       //creating a stream of all 
         .forEach( b -> System.out.println( b.name) );                                                         //forEach element of stream sysout Element.variable from object
     
     System.out.println( "----------------------------------------------------------------" );
             
     Outher other = new Outher();                                                                                //Create instance Outher
     other.nested = new Nested();
     other.nested.inner = new Inner();
     other.nested.inner.foo = "foo";
     
     if(other != null && other.nested != null && other.nested.inner != null){                                        
         System.out.println( other.nested.inner.foo );
     }
     
     System.out.println( "----------------------------------------------------------------" );
     
     Optional.of( new Outher())
     .flatMap(o -> Optional.ofNullable(o.nested))
     .flatMap(n -> Optional.ofNullable(n.inner))
     .flatMap(i -> Optional.ofNullable(i.foo))
     .ifPresent(System.out::println);
     
     System.out.println( "----------------------------------------------------------------" );
     
     
     
     
     
     
    }
}





























