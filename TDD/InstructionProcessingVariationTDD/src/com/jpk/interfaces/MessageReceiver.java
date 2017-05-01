package com.jpk.interfaces;

import comjpk.exceptions.ValidationException;

public interface MessageReceiver
{
      public void receive(String message) throws ValidationException;
}
