package com.google.api.client.http;

import java.io.IOException;

public abstract interface HttpResponseInterceptor
{
  public abstract void interceptResponse(HttpResponse paramHttpResponse)
    throws IOException;
}