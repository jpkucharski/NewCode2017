package com.jpk.processing;

import com.jpk.interfaces.MessageReceiver;

public class Receiver implements MessageReceiver
{

    private InstructionQueue instructionQueue;
    
    
    public Receiver( InstructionQueue instructionQueue )
    {
        this.instructionQueue = instructionQueue;
    }

    @Override
    public void receive( String message )
    {
       
        
    }

    public InstructionQueue getInstructionQueue()
    {
        return instructionQueue;
    }

    
    
    
}
