package com.jpk.validator;

public enum MessagePriorityEnum
{
    
    A( 1 );
    
    private int priorityValue;
    
    MessagePriorityEnum(int i){
        this.priorityValue = i;
    }

    public int getPriorityValue()
    {
        return priorityValue;
    }
    
}
