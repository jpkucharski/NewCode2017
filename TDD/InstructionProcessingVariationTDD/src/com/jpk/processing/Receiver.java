package com.jpk.processing;

import java.util.Comparator;

import com.jpk.entitys.InstructionMessage;
import com.jpk.interfaces.MessageReceiver;
import com.jpk.validator.MessageValidator;

import comjpk.exceptions.ValidationException;


public class Receiver
    implements MessageReceiver
{

    private InstructionQueue instructionQueue;
    private InstructionMessage instructionMessage;
    private MessageValidator messageValidator;
    private Comparator<InstructionMessage> instructionMessageComparator;


    public Receiver( InstructionQueue instructionQueue )
    {
        this.instructionMessageComparator = new InstructionMessageComparator();
        this.messageValidator = new MessageValidator();
        this.instructionQueue = instructionQueue;
    }


    @Override
    public void receive( String message ) throws ValidationException
    {
            messageValidator.isValid( message );
            this.instructionMessage = new InstructionMessage( message );
            instructionQueue.enqueue( instructionMessage );
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


    public Comparator<InstructionMessage> getInstructionMessageComparator()
    {
        return instructionMessageComparator;
    }

}
