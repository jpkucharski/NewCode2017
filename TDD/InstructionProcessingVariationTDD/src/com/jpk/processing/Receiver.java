package com.jpk.processing;

import com.jpk.entitys.InstructionMessage;
import com.jpk.interfaces.MessageReceiver;
import com.jpk.validator.MessageValidator;


public class Receiver
    implements MessageReceiver
{

    private InstructionQueue instructionQueue;
    private InstructionMessage instructionMessage;
    private MessageValidator messageValidator;


    public Receiver( InstructionQueue instructionQueue )
    {
        this.messageValidator = new MessageValidator();
        this.instructionQueue = instructionQueue;
    }


    @Override
    public void receive( String message )
    {
        if( messageValidator.isValid( message ) )
        {
            this.instructionMessage = new InstructionMessage( message );
            instructionQueue.enqueue( instructionMessage );
        }
    }


    public InstructionQueue getInstructionQueue()
    {
        return instructionQueue;
    }


    public InstructionMessage getInstructionMessage()
    {
        return instructionMessage;
    }


    public MessageValidator getMessageValidator()
    {
        return messageValidator;
    }

}
