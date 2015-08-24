package com.google.api.client.json;

import com.google.api.client.util.Charsets;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public abstract class JsonFactory
{
  private ByteArrayOutputStream toByteStream(Object paramObject, boolean paramBoolean)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    JsonGenerator localJsonGenerator = createJsonGenerator(localByteArrayOutputStream, Charsets.UTF_8);
    if (paramBoolean)
      localJsonGenerator.enablePrettyPrint();
    localJsonGenerator.serialize(paramObject);
    localJsonGenerator.flush();
    return localByteArrayOutputStream;
  }

  private String toString(Object paramObject, boolean paramBoolean)
    throws IOException
  {
    return toByteStream(paramObject, paramBoolean).toString("UTF-8");
  }

  public abstract JsonGenerator createJsonGenerator(OutputStream paramOutputStream, Charset paramCharset)
    throws IOException;

  public abstract JsonParser createJsonParser(InputStream paramInputStream)
    throws IOException;

  public abstract JsonParser createJsonParser(InputStream paramInputStream, Charset paramCharset)
    throws IOException;

  public abstract JsonParser createJsonParser(String paramString)
    throws IOException;

  public final String toPrettyString(Object paramObject)
    throws IOException
  {
    return toString(paramObject, true);
  }

  public final String toString(Object paramObject)
    throws IOException
  {
    return toString(paramObject, false);
  }
}