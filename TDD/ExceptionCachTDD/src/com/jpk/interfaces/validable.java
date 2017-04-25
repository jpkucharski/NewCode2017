package com.jpk.interfaces;

import com.jpk.exceptions.ValidationException;

public interface validable
{
    public void validation(String stringMessage) throws ValidationException;
}
