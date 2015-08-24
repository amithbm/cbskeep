package com.google.api.client.http;

import java.io.IOException;

public abstract interface HttpRequestInitializer
{
  public abstract void initialize(HttpRequest paramHttpRequest)
    throws IOException;
}