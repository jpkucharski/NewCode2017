package com.jpk.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MyQueue<Person> extends PriorityQueue<Person>
{

    public MyQueue( Comparator<Person> comperator )
    {
        super(comperator);
    }

    public void insert(Person person){
        super.add( person );
    }
    
    
    
}
