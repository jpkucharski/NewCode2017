package com.jpk.stream.advanced;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
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
        
        Map<Integer, List<Person>> personsByAge = persons                                           //create Map< Integer, List<persons>> from persons list
                        .stream()                                                                   //make stream of this map
                        .collect(Collectors.groupingBy(p -> p.age));                                //collect all the results grouping them according to the age

                    personsByAge
                        .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));            //forEach element of the stream printing age and list of persons 
                                                                                                    // for this particular age
                         
       Double averageAge = persons                                                                  //creating mediate value from all the age fields of person objects 
                  .stream()                                                                         //in the person list
                  .collect(Collectors.averagingInt(p -> p.age));

                  System.out.println(averageAge);                                                   //printing out result of one value 
            
       System.out.println( "-------------------------------------------------------------------" );       
                  
      IntSummaryStatistics ageSummary = persons                                                     //creating an array of results from list of objects age value
                      .stream().collect( Collectors.summarizingInt( element -> element.age));       
                  
       System.out.println( ageSummary);                                                             //printing statistics array {numberOfValues, sum, average, maximum }
                  
       System.out.println( "-------------------------------------------------------------------" );       
       
       String phrase = persons                                          
                       .stream().
                       filter(element -> element.age >= 18)                                             //filtering each element of list by age 
                       .map( element -> element.name )                                                  //getting String value of name from each object
                       .collect( Collectors.joining( " /delimiter/ ", "/Prefix/ ", " /suffix./" ) );   //joining all the results together    
       
       System.out.println( phrase );
       
       System.out.println( "-------------------------------------------------------------------" );
                      
       Map<Integer, String> map = persons
                                   .stream()
                                   .collect( Collectors.toMap(                                          //creating a Map
                                       element -> element.age,                                          //first element in map will be age
                                       element -> element.name,                                         //second element in map will be a name variable
                                       (name1 , name2) -> name1 + ";" + name2                           //prefix between names will be ";" 
                                    ));
       System.out.println( map );
       
       System.out.println( "-------------------------------------------------------------------" );
       
       Collector<Person, StringJoiner, String> personNameCollector =
                       Collector.of(
                           () -> new StringJoiner(" | "),                              //creating the StringJoiner for final string with | separator
                           (joiner, person) -> joiner.add(person.name.toUpperCase()),  // creating string joiner for each person and up casing the name
                           (joiner1, joiner2) -> joiner1.merge(joiner2),               // joining together one after another next to the previews group 
                           StringJoiner::toString);                                    // changing string joiner to String object

                   String names = persons
                       .stream()
                       .collect(personNameCollector);                                   //Changing Collector in to String object

                   System.out.println(names);    
               
    }

}
