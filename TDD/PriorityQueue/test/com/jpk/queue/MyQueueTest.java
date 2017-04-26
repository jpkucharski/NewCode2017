package com.jpk.queue;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Before;
import org.junit.Test;


public class MyQueueTest
{
    private static final String NAME_A = "A_PERSON_NAME";
    private static final String NAME_B = "B_PERSON_NAME";
    private static final String NAME_C = "C_PERSON_NAME";
    private static final String NAME_D = "D_PERSON_NAME";
    private static final int VALUES_ARE_THE_SAME = 0;
    private static final int SECOUND_IS_GREATER_THEN_FIRST = -1;
    private static final int FIRST_IS_GREATER_THEN_SECOND = 1;

    private Person person_a, person_b, person_c, person_d;
    private Comparator<Person> comperator;
    private MyQueue<Person> queue;


    @Before
    public void setUp()
    {

        person_a = new Person( NAME_A );
        person_b = new Person( NAME_B );
        person_c = new Person( NAME_C );
        person_d = new Person( NAME_D );
        comperator = new PersonsComparator();
        queue = new MyQueue<Person>( comperator );
    }


    @Test
    public void testConstructorForPersonComparator_ShouldReturnPersonComparator()
    {
        assertNotNull( comperator );
    }


    @Test
    public void testConstructor_ShouldReturnObjectOfMyQueueContainingPersonsObjectsAndComparatorForPersonObjects()
    {
        assertNotNull( queue );
    }


    @Test
    public void testingPersonConstructor_ShouldReturnTheSameNameThatWasPassedIntoConstructor()
    {
        assertEquals( NAME_A, person_a.getName() );
    }


    @Test
    public void testPutingPeronInToMyQueueShouldPutPersonInToMyQueueObject()
    {
        queue.insert( person_a );
        assertEquals( NAME_A, queue.poll().getName() );
    }


    @Test
    public void testComparatorCompareMethodPuttingTheSameNameShouldReturn0()
    {
        assertEquals( VALUES_ARE_THE_SAME, comperator.compare( person_a, person_a ) );
    }


    @Test
    public void testingComparatorCompareMethodPuttingFirstASecondBShouldReturnNegative1()
    {
        assertEquals( SECOUND_IS_GREATER_THEN_FIRST, comperator.compare( person_a, person_b ) );
    }


    @Test
    public void testingComparatorCompareMethodPuttingFirstBSecondAShouldReturn1()
    {
        assertEquals( FIRST_IS_GREATER_THEN_SECOND, comperator.compare( person_b, person_a ) );
    }


    @Test
    public void testingQueueComparatorPuttingThreePersonObjectsInReverseAlphabeticalOrder_ShouldReturnObjectsFromQueueInAlphabeticalOrder()
    {
        queue.insert( person_c );
        queue.insert( person_b );
        queue.insert( person_a );
        assertEquals( person_a.getName(), queue.poll().getName() );
    }


    @Test
    public void testingQueueComparatorPuttingTherePersonObjectsFirstDThenC_ShouldNotSortTheObjectsAndReturnPersonD()
    {
        queue.insert( person_d );
        queue.insert( person_c );
        assertEquals( person_d.getName(), queue.poll().getName() );
    }


    @Test
    public void testingQueueComparatorPuttingTherePersonObjectsInNonAlphabeticalOrderShouldReturnPerdonA()
    {
        queue.insert( person_d );
        queue.insert( person_c );
        queue.insert( person_b );
        queue.insert( person_a );
        assertEquals( person_a.getName(), queue.poll().getName() );
        assertEquals( person_b.getName(), queue.poll().getName() );
        assertEquals( person_d.getName(), queue.poll().getName() );
    }
}
