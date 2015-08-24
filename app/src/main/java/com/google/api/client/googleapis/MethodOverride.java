package com.google.api.client.googleapis;

import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import java.io.IOException;

public final class MethodOverride
  implements HttpExecuteInterceptor, HttpRequestInitializer
{
  private final boolean overrideAllMethods;

  public MethodOverride()
  {
    this(false);
  }

  MethodOverride(boolean paramBoolean)
  {
    overrideAllMethods = paramBoolean;
  }

  private boolean overrideThisMethod(HttpRequest paramHttpRequest)
    throws IOException
  {
    boolean bool2 = true;
    String str = paramHttpRequest.getRequestMethod();
    boolean bool1;
    if (str.equals("POST"))
      bool1 = false;
    do
    {
      return bool1;
      if (!str.equals("GET"))
        break;
      bool1 = bool2;
    }
    while (paramHttpRequest.getUrl().build().length() > 2048);
    while (!overrideAllMethods)
    {
      bool1 = bool2;
      if (!paramHttpRequest.getTransport().supportsMethod(str))
        break;
      return false;
    }
    return true;
  }

  public void initialize(HttpRequest paramHttpRequest)
  {
    paramHttpRequest.setInterceptor(this);
  }

  public void intercept(HttpRequest paramHttpRequest)
    throws IOException
  {
    if (overrideThisMethod(paramHttpRequest))
    {
      String str = paramHttpRequest.getRequestMethod();
      paramHttpRequest.setRequestMethod("POST");
      paramHttpRequest.getHeaders().set("X-HTTP-Method-Override", str);
      if (!str.equals("GET"))
        break label57;
      paramHttpRequest.setContent(new UrlEncodedContent(paramHttpRequest.getUrl()));
    }
    label57: 
    while (paramHttpRequest.getContent() != null)
      return;
    paramHttpRequest.setContent(new EmptyContent());
  }
}