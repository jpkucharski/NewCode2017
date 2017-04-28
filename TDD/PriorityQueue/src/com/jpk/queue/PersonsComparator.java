package com.jpk.queue;

import java.util.Comparator;



enum MyEnum
{
    A( 1 ), B( 2 ), C( 3 ), D( 3 );

    int intValue;


    MyEnum( int i )
    {
        this.intValue = i;
    }
    
    public int getIntValye() {
        return intValue;
    }
    
}

public class PersonsComparator
    implements Comparator<Person>
{
    private final static int POSITION_OF_FIRST_LETTER = 0;


    @Override
    public int compare( Person person1, Person person2 )
    {
            return intValueForComparator( person1 ). compareTo(intValueForComparator( person2 ));
    }

    
    private String intValueForComparator(Person person){
        return  Integer.toString( MyEnum.valueOf( String.valueOf( person.getName().charAt( POSITION_OF_FIRST_LETTER )) ).getIntValye());
    }
}
