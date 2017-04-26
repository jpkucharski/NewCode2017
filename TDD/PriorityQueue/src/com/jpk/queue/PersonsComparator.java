package com.jpk.queue;

import java.util.Comparator;

public class PersonsComparator
    implements Comparator<Person>
{

    @Override
    public int compare( Person person1, Person person2 )
    {
        if(person1.getName().charAt( 0 ) == "C".charAt( 0 ) &&  person2.getName().charAt( 0 ) == "D".charAt( 0 )  ){
            return 0;
        }
        if(person1.getName().charAt( 0 ) == "D".charAt( 0 ) &&  person2.getName().charAt( 0 ) == "C".charAt( 0 )  ){
            return 0;
        }
        if(person1.getName() != null && person2.getName() != null){
            return person1.getName().compareTo(person2.getName());
        }
        return 0;
    }
}
