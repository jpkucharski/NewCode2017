package com.jpk.processing;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;


public class MessageReceiverTest
{

    private static final String MESSAGE = "A MD89 5678 50 20150305T10:04:56.012Z";
  


    @Test
    public void testReceiveMethod_WillCreateNewInstructionQueueObjectIfNotExist()
    {
        try
        {
            // Arrange
            Receiver reciever = new Receiver();
            Field privateField = Receiver.class.getDeclaredField( "instructionQueue" );
            privateField.setAccessible( true );
            // Act
            reciever.receive( MESSAGE );
            // Assert
            InstructionQueue expacted = (InstructionQueue)privateField.get( reciever );
            assertNotNull( expacted );
        }
        catch( NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e )
        {
            e.printStackTrace();
        }
    }


    @Test
    public void testReceiveMethod_WillNotCreateNewInstructionQueueObjectIfAlreadyExist()
    {
        try
        {
            // Arrange
            Receiver reciever = new Receiver();
            Field privateField = Receiver.class.getDeclaredField( "instructionQueue" );
            privateField.setAccessible( true );
            privateField.set( reciever, new InstructionQueue() );
            // Act
            reciever.receive( MESSAGE );
            // Assert
            InstructionQueue expacted = (InstructionQueue)privateField.get( reciever );
            assertNotNull( expacted );
        }
        catch( NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e )
        {
            e.printStackTrace();
        }
    }


  
    
    
    
    
}
