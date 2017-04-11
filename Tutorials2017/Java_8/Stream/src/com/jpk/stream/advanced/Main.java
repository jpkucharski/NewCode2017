package com.jpk.stream.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class Person
{
    String name;
    int age;


    public Person( String name, int age )
    {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString()
    {
        return name;
    }
}


public class Main
{
    public static void main( String[] args )
    {

        List<Person> persons =                                                                      //creating a list of persons
            Arrays.asList( new Person( "Max", 18 ),
                new Person( "Peter", 23 ),
                new Person( "Pamela", 23 ),
                new Person( "Kamila", 18 ),
                new Person( "Daniel", 99 ) );

        List<Person> filtered = persons.stream()                                                    //persons list to stream
                            .filter(element -> element.name.startsWith("P"))                        //filter element that will start with character "P"
                            .collect(Collectors.toList());                                          //group them together because it will be only one result
                    
        System.out.println(filtered);                                                               //display list object
        
        System.out.println( "-------------------------------------------------------------------" );
        
        Map<Integer, List<Person>> personsByAge = persons                                           //create Map< Integer, List<persons>>
                        .stream()                                                                   //make stream of this map
                        .collect(Collectors.groupingBy(p -> p.age));

                    personsByAge
                        .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
        
       System.out.println( "-------------------------------------------------------------------" );
                    
       Double averageAge = persons
                  .stream()
                  .collect(Collectors.averagingInt(p -> p.age));

                  System.out.println(averageAge);          
                    
    }

}
