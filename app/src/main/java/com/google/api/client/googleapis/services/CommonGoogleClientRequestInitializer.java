package com.google.api.client.googleapis.services;

import java.io.IOException;

public class CommonGoogleClientRequestInitializer
  implements GoogleClientRequestInitializer
{
  private final String key;
  private final String userIp;

  public CommonGoogleClientRequestInitializer()
  {
    this(null);
  }

  public CommonGoogleClientRequestInitializer(String paramString)
  {
    this(paramString, null);
  }

  public CommonGoogleClientRequestInitializer(String paramString1, String paramString2)
  {
    key = paramString1;
    userIp = paramString2;
  }

  public void initialize(AbstractGoogleClientRequest<?> paramAbstractGoogleClientRequest)
    throws IOException
  {
    if (key != null)
      paramAbstractGoogleClientRequest.put("key", key);
    if (userIp != null)
      paramAbstractGoogleClientRequest.put("userIp", userIp);
  }
}