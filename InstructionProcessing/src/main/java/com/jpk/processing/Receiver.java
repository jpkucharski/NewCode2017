package com.jpk.processing;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jpk.customExceptions.InvalidMessageException;
import com.jpk.validation.MessageValidator;

public class Receiver
    implements MessageReceiver
{

    private InstructionQueue instructionQueue = null;
  
    
    
    public void receive( String message )
    {
        MessageValidator messageValidator = new MessageValidator();
     
        try{
            System.out.println( "in try: " + message );
            messageValidator.isValid(message);
        }
        catch (InvalidMessageException  e) {
            e.printStackTrace();
        }
        if( instructionQueue == null )
        {
            System.out.println( "ceating new queue" );
            instructionQueue = new InstructionQueue();
        }
        System.out.println( "putting message in to the queue: " + message);
        instructionQueue.enqueue( createMessage(message) );
        System.out.println(  );
    }



    protected InstructionMessage createMessage( String message )
    {
        InstructionMessage instructionMessage = null;
        
        String[] messageParts = message.split( " " );
        
        final String timeStampFormat = "yyyyMMdd'T'HH:mm:ss.SSS'Z'";
        
        
        
        String instructionType = messageParts[0] ;
        String productCode = messageParts[1];
        int quantit = Integer.parseInt( messageParts[2] );
        int uom = Integer.parseInt( messageParts[3] );
        SimpleDateFormat sdf = new SimpleDateFormat( timeStampFormat );
        Timestamp timestamp = null;
       
            try
            {
                Date date = sdf.parse( messageParts[4] );
            }
            catch( ParseException e )
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
//            timestamp = new Timestamp( date.getTime());
        
        
        instructionMessage = new InstructionMessage( instructionType, productCode, quantit, uom, timestamp );
        
        return instructionMessage;
        
    }



  



    public InstructionQueue getInstructionQueue()
    {
        return instructionQueue;
    }
    
    

}
