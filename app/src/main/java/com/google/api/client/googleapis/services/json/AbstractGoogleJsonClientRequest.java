package com.google.api.client.googleapis.services.json;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.json.JsonHttpContent;

public abstract class AbstractGoogleJsonClientRequest<T> extends AbstractGoogleClientRequest<T>
{
  private final Object jsonContent;

  protected AbstractGoogleJsonClientRequest(AbstractGoogleJsonClient paramAbstractGoogleJsonClient, String paramString1, String paramString2, Object paramObject, Class<T> paramClass)
  {
  }

  public AbstractGoogleJsonClient getAbstractGoogleClient()
  {
    return (AbstractGoogleJsonClient)super.getAbstractGoogleClient();
  }

  protected GoogleJsonResponseException newExceptionOnError(HttpResponse paramHttpResponse)
  {
    return GoogleJsonResponseException.from(getAbstractGoogleClient().getJsonFactory(), paramHttpResponse);
  }

  public AbstractGoogleJsonClientRequest<T> set(String paramString, Object paramObject)
  {
    return (AbstractGoogleJsonClientRequest)super.set(paramString, paramObject);
  }
}