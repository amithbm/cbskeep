package com.google.api.client.googleapis.services.json;

import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.AbstractGoogleClient.Builder;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.JsonObjectParser.Builder;

public abstract class AbstractGoogleJsonClient extends AbstractGoogleClient
{
  protected AbstractGoogleJsonClient(Builder paramBuilder)
  {
    super(paramBuilder);
  }

  public final JsonFactory getJsonFactory()
  {
    return getObjectParser().getJsonFactory();
  }

  public JsonObjectParser getObjectParser()
  {
    return (JsonObjectParser)super.getObjectParser();
  }

  public static abstract class Builder extends AbstractGoogleClient.Builder
  {
    protected Builder(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory, String paramString1, String paramString2, HttpRequestInitializer paramHttpRequestInitializer, boolean paramBoolean)
    {
    }

    public Builder setApplicationName(String paramString)
    {
      return (Builder)super.setApplicationName(paramString);
    }

    public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer paramGoogleClientRequestInitializer)
    {
      return (Builder)super.setGoogleClientRequestInitializer(paramGoogleClientRequestInitializer);
    }

    public Builder setRootUrl(String paramString)
    {
      return (Builder)super.setRootUrl(paramString);
    }

    public Builder setServicePath(String paramString)
    {
      return (Builder)super.setServicePath(paramString);
    }
  }
}