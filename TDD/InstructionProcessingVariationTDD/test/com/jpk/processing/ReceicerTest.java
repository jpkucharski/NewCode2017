package com.jpk.processing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jpk.interfaces.MessageReceiver;

public class ReceicerTest
{

    private static final String EXAMPLE_OF_MESSAGE= "A MZ89 5678 50 20150305T10:04:56.012Z";

    @Test
    public void testingSendingMessageToReceiver_ShouldCreateInstructionQueue()
    {
        Receiver reciver = new Receiver(new InstructionQueue());
        reciver.receive( EXAMPLE_OF_MESSAGE );
        assertNotNull( reciver.getInstructionQueue() );
    }

}
