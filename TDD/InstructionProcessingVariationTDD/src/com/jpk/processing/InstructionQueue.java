package com.jpk.processing;

import java.util.PriorityQueue;


public class InstructionQueue
{

    private PriorityQueue<String> priorityQueue;


    public InstructionQueue()
    {

        this.priorityQueue = new PriorityQueue<String>();

    }


    public void enqueue( String message )
    {
        priorityQueue.add( message );
    }

    public String dequeue(){
        return priorityQueue.poll();
    }
    

    public PriorityQueue<String> getPriorityQueue()
    {
        return priorityQueue;
    }

}
