package com.jpk.processing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReceicerTest
{

    private Receiver reciver;
    
    private static final String EXAMPLE_OF_MESSAGE = "A MZ89 5678 50 20150305T10:04:56.012Z";


    @Before
    public void setUp()
    {
        reciver = new Receiver( new InstructionQueue() );
    }


    @Test
    public void testingSendingMessageToReceiver_ShouldCreateInstructionQueue()
    {
        sendSimpleMessage();
        assertNotNull( reciver.getInstructionQueue() );
    }

    @Test
    public void testingMethodReceiveSendingMessage_ShouldReturnNewPriorityQueueObject()
    {
        sendSimpleMessage();
        assertNotNull( reciver.getInstructionQueue().getPriorityQueue() );
    }
    
    @Test
    public void testingReceiveMethodSendingMessage_ShouldAddMessageIntoPriorityQueue(){
        sendSimpleMessage();
        assertEquals( EXAMPLE_OF_MESSAGE, reciver.getInstructionQueue().getPriorityQueue().peek());
    }
    
    private void sendSimpleMessage(){
        reciver.receive( EXAMPLE_OF_MESSAGE );
    }
    
    

}
