package com.jpk.validator;

public enum MessagePriorityEnum
{
    
    A( 1 ), B( 2 );
    
    private int priorityValue;
    
    MessagePriorityEnum(int i){
        this.priorityValue = i;
    }

    public int getPriorityValue()
    {
        return priorityValue;
    }
    
}
