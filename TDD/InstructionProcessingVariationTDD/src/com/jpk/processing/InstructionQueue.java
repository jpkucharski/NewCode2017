package com.jpk.processing;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.jpk.entitys.InstructionMessage;


public class InstructionQueue
{

    private PriorityQueue<InstructionMessage> priorityQueue;
    private Comparator<InstructionMessage> instructionMessageComparator;

    public InstructionQueue()
    {
        this.instructionMessageComparator = new InstructionMessageComparator();
        this.priorityQueue = new PriorityQueue<InstructionMessage>(instructionMessageComparator);
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

    public Comparator<InstructionMessage> getInstructionMessageComparator()
    {
        return instructionMessageComparator;
    }
}
