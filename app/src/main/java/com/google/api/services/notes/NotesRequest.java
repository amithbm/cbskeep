package com.google.api.services.notes;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;

public abstract class NotesRequest<T> extends AbstractGoogleJsonClientRequest<T>
{
  public NotesRequest(Notes paramNotes, String paramString1, String paramString2, Object paramObject, Class<T> paramClass)
  {
    super(paramNotes, paramString1, paramString2, paramObject, paramClass);
  }

  public final Notes getAbstractGoogleClient()
  {
    return (Notes)super.getAbstractGoogleClient();
  }

  public NotesRequest<T> set(String paramString, Object paramObject)
  {
    return (NotesRequest)super.set(paramString, paramObject);
  }
}