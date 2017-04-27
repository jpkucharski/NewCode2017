package com.jpk.processing;

import com.jpk.entitys.InstructionMessage;
import com.jpk.interfaces.MessageReceiver;


public class Receiver
    implements MessageReceiver
{

    private InstructionQueue instructionQueue;
    private InstructionMessage instructionMessage;


    public Receiver( InstructionQueue instructionQueue )
    {
        this.instructionQueue = instructionQueue;
    }


    @Override
    public void receive( String message )
    {
        instructionQueue.enqueue( message );
        this.instructionMessage = new InstructionMessage();
    }


    public InstructionQueue getInstructionQueue()
    {
        return instructionQueue;
    }


    public InstructionMessage getInstructionMessage()
    {
        return instructionMessage;
    }

    
    
    
}
