package com.google.api.client.http;

import java.io.IOException;

public final class HttpRequestFactory
{
  private final HttpRequestInitializer initializer;
  private final HttpTransport transport;

  HttpRequestFactory(HttpTransport paramHttpTransport, HttpRequestInitializer paramHttpRequestInitializer)
  {
    transport = paramHttpTransport;
    initializer = paramHttpRequestInitializer;
  }

  public HttpRequest buildPutRequest(GenericUrl paramGenericUrl, HttpContent paramHttpContent)
    throws IOException
  {
    return buildRequest("PUT", paramGenericUrl, paramHttpContent);
  }

  public HttpRequest buildRequest(String paramString, GenericUrl paramGenericUrl, HttpContent paramHttpContent)
    throws IOException
  {
    HttpRequest localHttpRequest = transport.buildRequest();
    if (initializer != null)
      initializer.initialize(localHttpRequest);
    localHttpRequest.setRequestMethod(paramString);
    if (paramGenericUrl != null)
      localHttpRequest.setUrl(paramGenericUrl);
    if (paramHttpContent != null)
      localHttpRequest.setContent(paramHttpContent);
    return localHttpRequest;
  }

  public HttpRequestInitializer getInitializer()
  {
    return initializer;
  }

  public HttpTransport getTransport()
  {
    return transport;
  }
}