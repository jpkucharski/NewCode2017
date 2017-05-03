package com.jpk.processing;

import java.util.Comparator;

import com.jpk.entitys.InstructionMessage;
import com.jpk.validator.MessagePriorityEnum;


public class InstructionMessageComparator
    implements Comparator<InstructionMessage>
{

    private final static int POSITION_OF_FIRST_CHARACTER_IN_THE_MESSAGE = 0;


    @Override
    public int compare( InstructionMessage instructionMessage1, InstructionMessage instructionMessage2 )
    {
        return intValueForComparator( instructionMessage1 ).compareTo( intValueForComparator( instructionMessage2 ) );

    }


    private String intValueForComparator( InstructionMessage instructionMessage )
    {
        return Integer.toString(
            MessagePriorityEnum
                .valueOf( String.valueOf( instructionMessage.getMessage().charAt( POSITION_OF_FIRST_CHARACTER_IN_THE_MESSAGE ) ) )
                .getPriorityValue() );
    }
}
