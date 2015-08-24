package com.google.android.apiary;

import java.io.IOException;

public class AuthenticationException extends IOException
{
  public AuthenticationException()
  {
  }

  public AuthenticationException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}