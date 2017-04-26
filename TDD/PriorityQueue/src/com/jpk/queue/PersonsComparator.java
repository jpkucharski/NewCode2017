package com.jpk.queue;

import java.util.Comparator;


public class PersonsComparator
    implements Comparator<Person>
{
    private final static int POSITION_OF_FIRST_LETTER = 0;


    @Override
    public int compare( Person person1, Person person2 )
    {
        if( getFirstLetterOfName( person1 ) == 'C' && getFirstLetterOfName( person2 ) == 'D' )
        {
            return 0;
        }
        if( getFirstLetterOfName( person1 ) == 'D' && getFirstLetterOfName( person2 ) == 'C' )
        {
            return 0;
        }
        if( person1.getName() != null && person2.getName() != null )
        {
            return person1.getName().compareTo( person2.getName() );
        }
        return 0;
    }


    private char getFirstLetterOfName( Person person )
    {
        return person.getName().charAt( POSITION_OF_FIRST_LETTER );
    }

}
