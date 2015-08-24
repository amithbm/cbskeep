package com.google.api.client.http;

import java.io.IOException;

public abstract interface HttpExecuteInterceptor
{
  public abstract void intercept(HttpRequest paramHttpRequest)
    throws IOException;
}