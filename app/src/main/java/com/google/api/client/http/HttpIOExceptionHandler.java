package com.google.api.client.http;

import java.io.IOException;

public abstract interface HttpIOExceptionHandler
{
  public abstract boolean handleIOException(HttpRequest paramHttpRequest, boolean paramBoolean)
    throws IOException;
}