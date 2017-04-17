package com.jpk.processing;

import java.util.concurrent.PriorityBlockingQueue;


public class InstructionQueue
    extends PriorityBlockingQueue<InstructionMessage>
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    public void enqueue( InstructionMessage message )
    {
        // Adds a message to the queue

    }


    public InstructionMessage dequeue()
    {
        // Removes the highestpriority
        // message from the queue
        // and returns it
        return null;
    }


    public InstructionMessage peek()
    {
        // Returns the highestpriority
        // message from the queue,
        // without returning it
        return null;
    }


    public int count()
    {
        // Returns the number of messages
        // currently on the queue
        return 0;
    }
}
