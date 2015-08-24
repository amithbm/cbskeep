package com.google.api.client.http.json;

import com.google.api.client.http.AbstractHttpContent;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.OutputStream;

public class JsonHttpContent extends AbstractHttpContent
{
  private final Object data;
  private final JsonFactory jsonFactory;
  private String wrapperKey;

  public JsonHttpContent(JsonFactory paramJsonFactory, Object paramObject)
  {
    super(Json.MEDIA_TYPE);
    jsonFactory = ((JsonFactory)Preconditions.checkNotNull(paramJsonFactory));
    data = Preconditions.checkNotNull(paramObject);
  }

  public JsonHttpContent setWrapperKey(String paramString)
  {
    wrapperKey = paramString;
    return this;
  }

  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream = jsonFactory.createJsonGenerator(paramOutputStream, getCharset());
    if (wrapperKey != null)
    {
      paramOutputStream.writeStartObject();
      paramOutputStream.writeFieldName(wrapperKey);
    }
    paramOutputStream.serialize(data);
    if (wrapperKey != null)
      paramOutputStream.writeEndObject();
    paramOutputStream.flush();
  }
}