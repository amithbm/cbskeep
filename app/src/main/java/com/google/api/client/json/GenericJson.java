package com.google.api.client.json;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.Throwables;
import java.io.IOException;

public class GenericJson extends GenericData
  implements Cloneable
{
  private JsonFactory jsonFactory;

  public GenericJson clone()
  {
    return (GenericJson)super.clone();
  }

  public GenericJson set(String paramString, Object paramObject)
  {
    return (GenericJson)super.set(paramString, paramObject);
  }

  public final void setFactory(JsonFactory paramJsonFactory)
  {
    jsonFactory = paramJsonFactory;
  }

  public String toPrettyString()
    throws IOException
  {
    if (jsonFactory != null)
      return jsonFactory.toPrettyString(this);
    return super.toString();
  }

  public String toString()
  {
    if (jsonFactory != null)
      try
      {
        String str = jsonFactory.toString(this);
        return str;
      }
      catch (IOException localIOException)
      {
        throw Throwables.propagate(localIOException);
      }
    return super.toString();
  }
}