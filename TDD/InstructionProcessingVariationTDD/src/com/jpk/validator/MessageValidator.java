package com.jpk.validator;

public class MessageValidator
{
    private static final int INSTRICTION_TYPE = 0;
    private static final String MESSAGE_SPLIT_MARKER = " ";
    private static final String INSTRUCTION_TYPE_VALIDATION_RANGE_REGEX = "[A-D]";


    public boolean isValid( String message )
    {
        String[] messageParts = message.split( MESSAGE_SPLIT_MARKER );
        return isInstructionTypeValid( messageParts[INSTRICTION_TYPE] );
    }


    private boolean isInstructionTypeValid( String instructionType )
    {
        return instructionType.matches( INSTRUCTION_TYPE_VALIDATION_RANGE_REGEX );
    }
}
