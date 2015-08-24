package com.google.api.client.googleapis.services;

import java.io.IOException;

public abstract interface GoogleClientRequestInitializer
{
  public abstract void initialize(AbstractGoogleClientRequest<?> paramAbstractGoogleClientRequest)
    throws IOException;
}