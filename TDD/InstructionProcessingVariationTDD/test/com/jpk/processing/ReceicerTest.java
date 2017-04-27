package com.jpk.processing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ReceicerTest
{

    private Receiver reciver;

    private static final String EXAMPLE_OF_MESSAGE = "A MZ89 5678 50 20150305T10:04:56.012Z";
    private static final int LENGTH_OF_QUEUE_WITH_ONE_MESSAGE = 1;


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
    public void testingReceiveMethodSendingMessage_ShouldAddMessageIntoPriorityQueue()
    {
        sendSimpleMessage();
        assertEquals( EXAMPLE_OF_MESSAGE, reciver.getInstructionQueue().getPriorityQueue().peek() );
    }


    @Test
    public void testingReceiveMethodSendingMessag_ShouldReceiveMessageFromPriorityQueue()
    {
        sendSimpleMessage();
        assertEquals( EXAMPLE_OF_MESSAGE, reciver.getInstructionQueue().dequeue() );
    }

    @Test
    public void testingReceiveMethodSendingMessag_ShouldReturnMessageFromQueueWithoutRemovingItFromQueue(){
        sendSimpleMessage();
        assertEquals( EXAMPLE_OF_MESSAGE, reciver.getInstructionQueue().peek());
        assertEquals( LENGTH_OF_QUEUE_WITH_ONE_MESSAGE, reciver.getInstructionQueue().getPriorityQueue().size());
    }
    
    
    @Test
    public void testingReceiveMethodSendingMessag_ShouldReturnSizeOfPriorityQueueEquals1(){
        sendSimpleMessage();
        assertEquals( LENGTH_OF_QUEUE_WITH_ONE_MESSAGE, reciver.getInstructionQueue().count());
    }
    

    private void sendSimpleMessage()
    {
        reciver.receive( EXAMPLE_OF_MESSAGE );
    }

}
