package com.jpk.queue;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;


public class MyQueueTest
{
    private static final String NAME_A = "A_PERSON_NAME";
    private static final String NAME_B = "B_PERSON_NAME";
    private static final String NAME_C = "C_PERSON_NAME";
    private static final String NAME_D = "D_PERSON_NAME";
    private static final int VALUES_ARE_THE_SAME = 0;
    private static final int SECOUND_IS_GREATER_THEN_FIRST = -1;


    @Test
    public void testConstructorForPersonComperator_ShouldReturnPersonCompertaor()
    {
        Comparator<Person> comperator = new PersonsComparator();
        assertNotNull( comperator );
    }


    @Test
    public void testConstructor_ShouldReturnObjectOfMyQueueContainingPersonsObjecttsAndComperatorForRersonObjects()
    {
        Comparator<Person> comperator = new PersonsComparator();
        PriorityQueue<Person> queue = new MyQueue<Person>( comperator );
        assertNotNull( queue );
    }


    @Test
    public void testingPersonConstructor_ShuldReturnTheSameNameThatWasSendedInToConstructor()
    {
        Person person = new Person( NAME_A );
        assertEquals( NAME_A, person.getName() );
    }


    @Test
    public void testingPutingPeronInToMyQueue_ShouldPutPersonInToMyQueueObject()
    {
        Comparator<Person> comperator = new PersonsComparator();
        // PriorityQueue<Person> queue = new MyQueue<Person>(comperator); <------ why???
        MyQueue<Person> queue = new MyQueue<Person>( comperator );
        queue.insert( new Person( NAME_A ) );
        assertEquals( NAME_A, queue.poll().getName() );
    }
    
    @Test
    public void testingComperatorCompareMethodPutingTheSameNames_ShouldReturn0(){
        
        Comparator<Person> comperator = new PersonsComparator();
        Person person_a = new Person(NAME_A);
        Person person_b = new Person(NAME_A);
        assertEquals( VALUES_ARE_THE_SAME, comperator.compare( person_a, person_b ));
    }
    
    @Test
    public void testingComperatorCompareMethodPutingFirstASecoundB_ShouldReturnNegative1(){
        
        Comparator<Person> comperator = new PersonsComparator();
        Person person_a = new Person(NAME_A);
        Person person_b = new Person(NAME_B);
        assertEquals( SECOUND_IS_GREATER_THEN_FIRST, comperator.compare( person_a, person_b ));
    }
    

}
