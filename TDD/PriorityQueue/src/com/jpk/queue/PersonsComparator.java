package com.jpk.queue;

import java.util.Comparator;

public class PersonsComparator
    implements Comparator<Person>
{

    @Override
    public int compare( Person o1, Person o2 )
    {
        if (getVowelCount(x) < getVowelCount(y)) {
            return -1;
        }
        return 0;
    }

}
