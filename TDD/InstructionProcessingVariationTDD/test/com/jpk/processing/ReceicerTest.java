package com.jpk.processing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jpk.entitys.InstructionMessage;


public class ReceicerTest
{

    private Receiver reciver;
    private InstructionMessage simpleInstructionMessageObject;

    private static final String EXAMPLE_OF_MESSAGE = "A MZ89 5678 50 20150305T10:04:56.012Z";
    private static final int LENGTH_OF_QUEUE_WITH_ONE_MESSAGE = 1;



    @Before
    public void setUp()
    {
        reciver = new Receiver( new InstructionQueue() );
        simpleInstructionMessageObject = new InstructionMessage( EXAMPLE_OF_MESSAGE );
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
        assertEquals( EXAMPLE_OF_MESSAGE, reciver.getInstructionQueue().getPriorityQueue().peek().getMessage() );
    }


    @Test
    public void testingReceiveMethodSendingMessag_ShouldReceiveMessageFromPriorityQueue()
    {
        sendSimpleMessage();
        assertEquals( EXAMPLE_OF_MESSAGE, reciver.getInstructionQueue().dequeue().getMessage() );
    }

    @Test
    public void testingReceiveMethodSendingMessag_ShouldReturnMessageFromQueueWithoutRemovingItFromQueue(){
        sendSimpleMessage();
        assertEquals( EXAMPLE_OF_MESSAGE, reciver.getInstructionQueue().peek().getMessage());
        assertEquals( LENGTH_OF_QUEUE_WITH_ONE_MESSAGE, reciver.getInstructionQueue().getPriorityQueue().size());
    }
    
    
    @Test
    public void testingReceiveMethodSendingMessag_ShouldReturnSizeOfPriorityQueueEquals1(){
        sendSimpleMessage();
        assertEquals( LENGTH_OF_QUEUE_WITH_ONE_MESSAGE, reciver.getInstructionQueue().count());
    }
    
    @Test
    public void testingReceiveMethodSendingMessag_ShouldCreatedInstructionMessageObjectFromTheMessageString(){
        sendSimpleMessage();
        assertNotNull( reciver.getInstructionMessage() );
    }
    
    
    @Test
    public void testingReceiveMethodSendingMessag_ShouldCreatedMessageValidatorObject(){
        sendSimpleMessage();
        assertNotNull(reciver.getMessageValidator());
    }
    
    @Test
    public void testingReceiveMethodSendingMessagWithTrueValidator_ShouldReturnQueueWithOneMessage(){
        sendSimpleMessage();
        assertEquals( LENGTH_OF_QUEUE_WITH_ONE_MESSAGE, reciver.getInstructionQueue().count() );
    }
    
    @Test
    public void testingReceiveMethodSendingMessagWithTrueValidator_ShouldCreateInstructionMessageObject(){
        sendSimpleMessage();
        assertEquals( simpleInstructionMessageObject.getClass(), reciver.getInstructionQueue().peek().getClass() );
    }
    
    
    private void sendSimpleMessage()
    {
        reciver.receive( EXAMPLE_OF_MESSAGE );
    }

}
