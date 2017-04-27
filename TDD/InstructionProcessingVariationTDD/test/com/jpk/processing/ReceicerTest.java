package com.jpk.processing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReceicerTest
{

    private Receiver reciver;


    @Before
    public void setUp()
    {
        reciver = new Receiver( new InstructionQueue() );
    }


    private static final String EXAMPLE_OF_MESSAGE = "A MZ89 5678 50 20150305T10:04:56.012Z";


    @Test
    public void testingSendingMessageToReceiver_ShouldCreateInstructionQueue()
    {
        reciver.receive( EXAMPLE_OF_MESSAGE );
        assertNotNull( reciver.getInstructionQueue() );
    }


    @Test
    public void testingMethodReceiveSendingMessage_ShouldReturnNewPriorityQueueObject()
    {

        reciver.receive( EXAMPLE_OF_MESSAGE );
        assertNotNull( reciver.getInstructionQueue().getPriorityQueue() );

    }

}
