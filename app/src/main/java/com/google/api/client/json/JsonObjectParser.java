package com.google.api.client.json;

import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sets;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class JsonObjectParser
  implements ObjectParser
{
  private final JsonFactory jsonFactory;
  private final Set<String> wrapperKeys;

  protected JsonObjectParser(Builder paramBuilder)
  {
    jsonFactory = paramBuilder.jsonFactory;
    wrapperKeys = new HashSet(paramBuilder.wrapperKeys);
  }

  private void initializeParser(JsonParser paramJsonParser)
    throws IOException
  {
    boolean bool = true;
    if (wrapperKeys.isEmpty());
    while (true)
    {
      return;
      try
      {
        if ((paramJsonParser.skipToKey(wrapperKeys) != null) && (paramJsonParser.getCurrentToken() != JsonToken.END_OBJECT));
        while (true)
        {
          Preconditions.checkArgument(bool, "wrapper key(s) not found: %s", new Object[] { wrapperKeys });
          if (0 == 0)
            break;
          paramJsonParser.close();
          return;
          bool = false;
        }
      }
      finally
      {
        if (1 != 0)
          paramJsonParser.close();
      }
    }
  }

  public final JsonFactory getJsonFactory()
  {
    return jsonFactory;
  }

  public Set<String> getWrapperKeys()
  {
    return Collections.unmodifiableSet(wrapperKeys);
  }

  public <T> T parseAndClose(InputStream paramInputStream, Charset paramCharset, Class<T> paramClass)
    throws IOException
  {
    return parseAndClose(paramInputStream, paramCharset, paramClass);
  }

  public Object parseAndClose(InputStream paramInputStream, Charset paramCharset, Type paramType)
    throws IOException
  {
    paramInputStream = jsonFactory.createJsonParser(paramInputStream, paramCharset);
    initializeParser(paramInputStream);
    return paramInputStream.parse(paramType, true);
  }

  public static class Builder
  {
    final JsonFactory jsonFactory;
    Collection<String> wrapperKeys = Sets.newHashSet();

    public Builder(JsonFactory paramJsonFactory)
    {
      jsonFactory = ((JsonFactory)Preconditions.checkNotNull(paramJsonFactory));
    }

    public JsonObjectParser build()
    {
      return new JsonObjectParser(this);
    }

    public Builder setWrapperKeys(Collection<String> paramCollection)
    {
      wrapperKeys = paramCollection;
      return this;
    }
  }
}