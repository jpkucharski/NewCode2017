package com.jpk.validator;

import comjpk.exceptions.ValidationException;

public class MessageValidator
{
    private static final int INSTRICTION_TYPE = 0;
    private static final String MESSAGE_SPLIT_MARKER = " ";
    private static final String INSTRUCTION_TYPE_VALIDATION_RANGE_REGEX = "[A-D]";


    public boolean isValid( String message ) throws ValidationException
    {
        String[] messageParts = message.split( MESSAGE_SPLIT_MARKER );
        boolean isValid = false;
        
        if(isInstructionTypeValid( messageParts[INSTRICTION_TYPE])){
            isValid = true;
        }
        else{
            isValid = false;
            throw new ValidationException();
        }
        return isValid;
    }


    private boolean isInstructionTypeValid( String instructionType )
    {
        return instructionType.matches( INSTRUCTION_TYPE_VALIDATION_RANGE_REGEX );
    }
}
