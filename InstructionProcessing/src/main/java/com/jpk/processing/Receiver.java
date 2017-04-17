package com.jpk.processing;

import com.jpk.validation.MessageValidator;

public class Receiver
    implements MessageReceiver
{

    private InstructionQueue instructionQueue = null;
    private MessageValidator messageValidator;
    
    public Receiver(){
        this.messageValidator = new MessageValidator();
    }
    
    
    public void receive( String message )
    {
        if(messageValidator.isValid(message)){
            if( instructionQueue == null )
            {
                instructionQueue = new InstructionQueue();
            }
            else
            {
            
            }
        }
        else{
            System.out.println( "Message excaption message is not valid" );
        }
        
    }

}
