package com.jpk.processing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jpk.entitys.InstructionMessage;
import com.jpk.validator.MessagePriorityEnum;

import comjpk.exceptions.ValidationException;


public class ReceicerTest
{

    private Receiver reciver;
    private InstructionMessage simpleInstructionMessageObject;

    private static final String EXAMPLE_OF_MESSAGE_TYPE_A = "A MZ89 5678 50 20150305T10:04:56.012Z";
    private static final String EXAMPLE_OF_MESSAGE_TYPE_B = "B MZ89 5678 50 20150305T10:04:56.012Z";
    private static final String EXAMPLE_OF_MESSAGE_TYPE_C = "C MZ89 5678 50 20150305T10:04:56.012Z";
    private static final String EXAMPLE_OF_MESSAGE_TYPE_D = "D MZ89 5678 50 20150305T10:04:56.012Z";
    private static final String EXAMPLE_OF_INVALID_MESSAGE = "E MZ89 5678 50 20150305T10:04:56.012Z";
    private static final int LENGTH_OF_QUEUE_WITH_ONE_MESSAGE = 1;
    private static final int LENGTH_OF_EMPTY_QUEUE = 0;
    private static final String VALUE_OF_ENUM_A = "1";
    private static final String VALUE_OF_ENUM_B = "2";
    private static final String VALUE_OF_ENUM_C = "3";
    private static final String VALUE_OF_ENUM_D = "3";
    private static final int POSITION_OF_FIRST_CHARACTER_IN_MESSAGE = 0;


    @Before
    public void setUp()
    {
        reciver = new Receiver( new InstructionQueue() );
        simpleInstructionMessageObject = new InstructionMessage( EXAMPLE_OF_MESSAGE_TYPE_A );
    }


    @Test
    public void testingSendingMessageToReceiver_ShouldCreateInstructionQueue() throws ValidationException
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE_TYPE_A );
        assertNotNull( reciver.getInstructionQueue() );
    }


    @Test
    public void testingMethodReceiveSendingMessage_ShouldReturnNewPriorityQueueObject() throws ValidationException
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE_TYPE_A );
        assertNotNull( reciver.getInstructionQueue().getPriorityQueue() );
    }


    @Test
    public void testingReceiveMethodSendingMessage_ShouldAddMessageIntoPriorityQueue() throws ValidationException
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE_TYPE_A );
        assertEquals( EXAMPLE_OF_MESSAGE_TYPE_A, reciver.getInstructionQueue().getPriorityQueue().peek().getMessage() );
    }


    @Test
    public void testingReceiveMethodSendingMessage_ShouldReceiveMessageFromPriorityQueue() throws ValidationException
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE_TYPE_A );
        assertEquals( EXAMPLE_OF_MESSAGE_TYPE_A, reciver.getInstructionQueue().dequeue().getMessage() );
    }


    @Test
    public void testingReceiveMethodSendingMessage_ShouldReturnMessageFromQueueWithoutRemovingItFromQueue() throws ValidationException
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE_TYPE_A );
        assertEquals( EXAMPLE_OF_MESSAGE_TYPE_A, reciver.getInstructionQueue().peek().getMessage() );
        assertEquals( LENGTH_OF_QUEUE_WITH_ONE_MESSAGE, reciver.getInstructionQueue().getPriorityQueue().size() );
    }


    @Test
    public void testingReceiveMethodSendingMessage_ShouldReturnSizeOfPriorityQueueEquals1() throws ValidationException
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE_TYPE_A );
        assertEquals( LENGTH_OF_QUEUE_WITH_ONE_MESSAGE, reciver.getInstructionQueue().count() );
    }


    @Test
    public void testingReceiveMethodSendingMessage_ShouldCreatedInstructionMessageObjectFromTheMessageString() throws ValidationException
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE_TYPE_A );
        assertNotNull( reciver.getInstructionMessage() );
    }


    @Test
    public void testingReceiveMethodSendingMessage_ShouldCreatedMessageValidatorObject() throws ValidationException
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE_TYPE_A );
        assertNotNull( reciver.getMessageValidator() );
    }


    @Test
    public void testingReceiveMethodSendingMessageWithTrueValidator_ShouldReturnQueueWithOneMessage() throws ValidationException
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE_TYPE_A );
        assertEquals( LENGTH_OF_QUEUE_WITH_ONE_MESSAGE, reciver.getInstructionQueue().count() );
    }


    @Test
    public void testingReceiveMethodSendingMessageWithTrueValidator_ShouldCreateInstructionMessageObject() throws ValidationException
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE_TYPE_A );
        assertEquals( simpleInstructionMessageObject.getClass(), reciver.getInstructionQueue().peek().getClass() );
    }


    @Test( expected = ValidationException.class )
    public void testingReceiveMethodSendingInvalidMessage_ShouldValidateFirstSymbolOfMessageInstructionTypeAndNotAddItToTheQueue()
        throws ValidationException
    {
        sendSimpleMessage( EXAMPLE_OF_INVALID_MESSAGE );
        assertEquals( LENGTH_OF_EMPTY_QUEUE, reciver.getInstructionQueue().count() );
    }


    @Test( expected = ValidationException.class )
    public void testingReceiveMethodSendingInvalidMessage_ShouldThrowException() throws ValidationException
    {
        sendSimpleMessage( EXAMPLE_OF_INVALID_MESSAGE );
    }


    @Test
    public void testingReceiveMethodSendingValidMessage_ShouldReturnComparatorObject() throws ValidationException
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE_TYPE_A );
        assertNotNull( reciver.getInstructionQueue().getInstructionMessageComparator() );
    }


    @Test
    public void testingReceiveMethodSendingValidMessage_ShouldReturnEnumValueOf1InString() throws ValidationException
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE_TYPE_A );
        sendSimpleMessage( EXAMPLE_OF_MESSAGE_TYPE_B );
        sendSimpleMessage( EXAMPLE_OF_MESSAGE_TYPE_C );
        sendSimpleMessage( EXAMPLE_OF_MESSAGE_TYPE_D );
        assertEquals( VALUE_OF_ENUM_A, getFirstLetherOfTheInstructuonMessageFromTheQueue() );
        assertEquals( VALUE_OF_ENUM_B, getFirstLetherOfTheInstructuonMessageFromTheQueue() );
        assertEquals( VALUE_OF_ENUM_C, getFirstLetherOfTheInstructuonMessageFromTheQueue() );
        assertEquals( VALUE_OF_ENUM_D, getFirstLetherOfTheInstructuonMessageFromTheQueue() );
    }


    @Test
    public void testingReceiveMethodSendingTwoValidMessagesBAndAUsingComparator_ShouldReturnMessageA() throws ValidationException
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE_TYPE_B );
        sendSimpleMessage( EXAMPLE_OF_MESSAGE_TYPE_A );
        assertEquals( EXAMPLE_OF_MESSAGE_TYPE_A, reciver.getInstructionQueue().peek().getMessage() );
    }


    @Test
    public void testingReceiveMethodSendingTwoValidMessagesCAndBUsingComparator_ShouldReturnMessageB() throws ValidationException
    {
        sendSimpleMessage( EXAMPLE_OF_MESSAGE_TYPE_C );
        sendSimpleMessage( EXAMPLE_OF_MESSAGE_TYPE_B );
        assertEquals( EXAMPLE_OF_MESSAGE_TYPE_B, reciver.getInstructionQueue().peek().getMessage() );
    }


    private void sendSimpleMessage( String message ) throws ValidationException
    {
        reciver.receive( message );
    }


    private String getFirstLetherOfTheInstructuonMessageFromTheQueue()
    {
        return Integer.toString(
            MessagePriorityEnum
                .valueOf(
                    String
                        .valueOf( reciver.getInstructionQueue().dequeue().getMessage().charAt( POSITION_OF_FIRST_CHARACTER_IN_MESSAGE ) ) )
                .getPriorityValue() );
    }

}
