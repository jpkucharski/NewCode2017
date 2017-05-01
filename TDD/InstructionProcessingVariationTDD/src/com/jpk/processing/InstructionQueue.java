package com.jpk.processing;

import java.util.PriorityQueue;

import com.jpk.entitys.InstructionMessage;


public class InstructionQueue
{

    private PriorityQueue<InstructionMessage> priorityQueue;


    public InstructionQueue()
    {

        this.priorityQueue = new PriorityQueue<InstructionMessage>();

    }


    public void enqueue( InstructionMessage message )
    {
        priorityQueue.add( message );
    }


    public InstructionMessage dequeue()
    {
        return priorityQueue.poll();
    }


    public InstructionMessage peek()
    {
        return priorityQueue.peek();
    }


    public int count()
    {
        return priorityQueue.size();
    }


    public PriorityQueue<InstructionMessage> getPriorityQueue()
    {
        return priorityQueue;
    }

}
