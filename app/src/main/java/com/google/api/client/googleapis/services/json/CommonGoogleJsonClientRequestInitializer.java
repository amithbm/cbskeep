package com.google.api.client.googleapis.services.json;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.CommonGoogleClientRequestInitializer;
import java.io.IOException;

public class CommonGoogleJsonClientRequestInitializer extends CommonGoogleClientRequestInitializer
{
  public final void initialize(AbstractGoogleClientRequest<?> paramAbstractGoogleClientRequest)
    throws IOException
  {
    super.initialize(paramAbstractGoogleClientRequest);
    initializeJsonRequest((AbstractGoogleJsonClientRequest)paramAbstractGoogleClientRequest);
  }

  protected void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> paramAbstractGoogleJsonClientRequest)
    throws IOException
  {
  }
}