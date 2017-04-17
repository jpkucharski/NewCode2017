package com.jpk.processing;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import com.jpk.customExceptions.InvalidMessageException;


public class MessageReceiverTest
{

   
    
    private static final String MESSAGE = "A MZ89 5678 50 20150305T10:04:56.012Z";



    @Test
    public void testReceiveMethod_WillCreateNewInstructionQueueObjectIfNotExist()
    {
        try
        {

            Receiver reciever = new Receiver();
            Field privateField = Receiver.class.getDeclaredField( "instructionQueue" );
            privateField.setAccessible( true );

            reciever.receive( MESSAGE );

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

            Receiver reciever = new Receiver();
            Field privateField = Receiver.class.getDeclaredField( "instructionQueue" );
            privateField.setAccessible( true );
            privateField.set( reciever, new InstructionQueue() );

            reciever.receive( MESSAGE );

            InstructionQueue expacted = (InstructionQueue)privateField.get( reciever );
            assertNotNull( expacted );
        }
        catch( NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e )
        {
            e.printStackTrace();
        }
    }
    

    
    


}
