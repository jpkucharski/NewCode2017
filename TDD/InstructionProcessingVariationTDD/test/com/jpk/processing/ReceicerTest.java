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
    private static final String EXAMPLE_OF_INVALID_MESSAGE = "E MZ89 5678 50 20150305T10:04:56.012Z";
    private static final int LENGTH_OF_QUEUE_WITH_ONE_MESSAGE = 1;
    private static final int LENGTH_OF_EMPTY_QUEUE = 0;


    @Before
    public void setUp()
    {
        reciver = new Receiver( new InstructionQueue() );
        simpleInstructionMessageObject = new InstructionMessage( EXAMPLE_OF_MESSAGE );
    }


    @Test
    public void testingSendingMessageToReceiver_ShouldCreateInstructionQueue()
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE );
        assertNotNull( reciver.getInstructionQueue() );
    }


    @Test
    public void testingMethodReceiveSendingMessage_ShouldReturnNewPriorityQueueObject()
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE );
        assertNotNull( reciver.getInstructionQueue().getPriorityQueue() );
    }


    @Test
    public void testingReceiveMethodSendingMessage_ShouldAddMessageIntoPriorityQueue()
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE );
        assertEquals( EXAMPLE_OF_MESSAGE, reciver.getInstructionQueue().getPriorityQueue().peek().getMessage() );
    }


    @Test
    public void testingReceiveMethodSendingMessag_ShouldReceiveMessageFromPriorityQueue()
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE );
        assertEquals( EXAMPLE_OF_MESSAGE, reciver.getInstructionQueue().dequeue().getMessage() );
    }


    @Test
    public void testingReceiveMethodSendingMessag_ShouldReturnMessageFromQueueWithoutRemovingItFromQueue()
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE );
        assertEquals( EXAMPLE_OF_MESSAGE, reciver.getInstructionQueue().peek().getMessage() );
        assertEquals( LENGTH_OF_QUEUE_WITH_ONE_MESSAGE, reciver.getInstructionQueue().getPriorityQueue().size() );
    }


    @Test
    public void testingReceiveMethodSendingMessag_ShouldReturnSizeOfPriorityQueueEquals1()
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE );
        assertEquals( LENGTH_OF_QUEUE_WITH_ONE_MESSAGE, reciver.getInstructionQueue().count() );
    }


    @Test
    public void testingReceiveMethodSendingMessag_ShouldCreatedInstructionMessageObjectFromTheMessageString()
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE );
        assertNotNull( reciver.getInstructionMessage() );
    }


    @Test
    public void testingReceiveMethodSendingMessag_ShouldCreatedMessageValidatorObject()
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE );
        assertNotNull( reciver.getMessageValidator() );
    }


    @Test
    public void testingReceiveMethodSendingMessagWithTrueValidator_ShouldReturnQueueWithOneMessage()
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE );
        assertEquals( LENGTH_OF_QUEUE_WITH_ONE_MESSAGE, reciver.getInstructionQueue().count() );
    }


    @Test
    public void testingReceiveMethodSendingMessagWithTrueValidator_ShouldCreateInstructionMessageObject()
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE );
        assertEquals( simpleInstructionMessageObject.getClass(), reciver.getInstructionQueue().peek().getClass() );
    }


    @Test
    public void testingReceiveMethodSendingMessagWithTrueValidator_ShouldValidateFirstSymbolOfMessageInstructionTypeAndNotAddItToTheQueue()
    {
        sendSimpleMessage( EXAMPLE_OF_INVALID_MESSAGE );
        assertEquals( LENGTH_OF_EMPTY_QUEUE, reciver.getInstructionQueue().count() );
    }


    private void sendSimpleMessage( String message )
    {
        reciver.receive( message );
    }

}
