package com.google.api.client.googleapis.json;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;

public class GoogleJsonError extends GenericJson
{
  static
  {
    Data.nullOf(ErrorInfo.class);
  }

  public GoogleJsonError clone()
  {
    return (GoogleJsonError)super.clone();
  }

  public GoogleJsonError set(String paramString, Object paramObject)
  {
    return (GoogleJsonError)super.set(paramString, paramObject);
  }

  public static class ErrorInfo extends GenericJson
  {
    public ErrorInfo clone()
    {
      return (ErrorInfo)super.clone();
    }

    public ErrorInfo set(String paramString, Object paramObject)
    {
      return (ErrorInfo)super.set(paramString, paramObject);
    }
  }
}