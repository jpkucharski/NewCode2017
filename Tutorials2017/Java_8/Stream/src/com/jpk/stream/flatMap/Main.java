package com.jpk.stream.flatMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import javax.print.attribute.standard.MediaSize.Other;


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
     
     Outher outher = new Outher();
     outher.nested.inner.foo = "foo";
     
     
     
     
     
     
//     outher.nested = new Nested();                                                                            
//     outher.nested.inner = new Inner();
//     outher.nested.inner.foo = "foo";
//     
     if(outher != null && outher.nested != null && outher.nested.inner != null){                                        
         System.out.println( outher.nested.inner.foo );
     }
     
     System.out.println( "----------------------------------------------------------------" );
     
     Optional.of( new Outher())
     .flatMap(outherElement -> Optional.ofNullable(outherElement.nested))
     .flatMap(nestedElement -> Optional.ofNullable(nestedElement.inner))
     .flatMap(innerElement -> Optional.ofNullable(innerElement.foo))
     .ifPresent(System.out::println);
     
     System.out.println( "----------------------------------------------------------------" );
     
     
     
     
     
     
    }
}





























