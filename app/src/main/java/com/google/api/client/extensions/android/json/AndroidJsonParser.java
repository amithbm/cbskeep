package com.google.api.client.extensions.android.json;

import android.annotation.TargetApi;
import android.util.JsonReader;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.util.Preconditions;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
class AndroidJsonParser extends JsonParser
{
  private List<String> currentNameStack = new ArrayList();
  private String currentText;
  private com.google.api.client.json.JsonToken currentToken;
  private final AndroidJsonFactory factory;
  private final JsonReader reader;

  AndroidJsonParser(AndroidJsonFactory paramAndroidJsonFactory, JsonReader paramJsonReader)
  {
    factory = paramAndroidJsonFactory;
    reader = paramJsonReader;
    paramJsonReader.setLenient(true);
  }

  private void checkNumber()
  {
    if ((currentToken == com.google.api.client.json.JsonToken.VALUE_NUMBER_INT) || (currentToken == com.google.api.client.json.JsonToken.VALUE_NUMBER_FLOAT));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      return;
    }
  }

  public void close()
    throws IOException
  {
    reader.close();
  }

  public BigInteger getBigIntegerValue()
  {
    checkNumber();
    return new BigInteger(currentText);
  }

  public byte getByteValue()
  {
    checkNumber();
    return Byte.valueOf(currentText).byteValue();
  }

  public String getCurrentName()
  {
    if (currentNameStack.isEmpty())
      return null;
    return (String)currentNameStack.get(currentNameStack.size() - 1);
  }

  public com.google.api.client.json.JsonToken getCurrentToken()
  {
    return currentToken;
  }

  public BigDecimal getDecimalValue()
  {
    checkNumber();
    return new BigDecimal(currentText);
  }

  public double getDoubleValue()
  {
    checkNumber();
    return Double.valueOf(currentText).doubleValue();
  }

  public JsonFactory getFactory()
  {
    return factory;
  }

  public float getFloatValue()
  {
    checkNumber();
    return Float.valueOf(currentText).floatValue();
  }

  public int getIntValue()
  {
    checkNumber();
    return Integer.valueOf(currentText).intValue();
  }

  public long getLongValue()
  {
    checkNumber();
    return Long.valueOf(currentText).longValue();
  }

  public short getShortValue()
  {
    checkNumber();
    return Short.valueOf(currentText).shortValue();
  }

  public String getText()
  {
    return currentText;
  }

  public com.google.api.client.json.JsonToken nextToken()
    throws IOException
  {
    if (currentToken != null)
      switch (1.$SwitchMap$com$google$api$client$json$JsonToken[currentToken.ordinal()])
      {
      default:
      case 1:
      case 2:
      }
    try
    {
      while (true)
      {
        android.util.JsonToken localJsonToken = reader.peek();
        switch (1.$SwitchMap$android$util$JsonToken[localJsonToken.ordinal()])
        {
        default:
          currentText = null;
          currentToken = null;
          return currentToken;
          reader.beginArray();
          currentNameStack.add(null);
          continue;
          reader.beginObject();
          currentNameStack.add(null);
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        }
      }
    }
    catch (EOFException localEOFException)
    {
      while (true)
      {
        Object localObject = android.util.JsonToken.END_DOCUMENT;
        continue;
        currentText = "[";
        currentToken = com.google.api.client.json.JsonToken.START_ARRAY;
        continue;
        currentText = "]";
        currentToken = com.google.api.client.json.JsonToken.END_ARRAY;
        currentNameStack.remove(currentNameStack.size() - 1);
        reader.endArray();
        continue;
        currentText = "{";
        currentToken = com.google.api.client.json.JsonToken.START_OBJECT;
        continue;
        currentText = "}";
        currentToken = com.google.api.client.json.JsonToken.END_OBJECT;
        currentNameStack.remove(currentNameStack.size() - 1);
        reader.endObject();
        continue;
        if (reader.nextBoolean())
        {
          currentText = "true";
          currentToken = com.google.api.client.json.JsonToken.VALUE_TRUE;
        }
        else
        {
          currentText = "false";
          currentToken = com.google.api.client.json.JsonToken.VALUE_FALSE;
          continue;
          currentText = "null";
          currentToken = com.google.api.client.json.JsonToken.VALUE_NULL;
          reader.nextNull();
          continue;
          currentText = reader.nextString();
          currentToken = com.google.api.client.json.JsonToken.VALUE_STRING;
          continue;
          currentText = reader.nextString();
          if (currentText.indexOf('.') == -1);
          for (localObject = com.google.api.client.json.JsonToken.VALUE_NUMBER_INT; ; localObject = com.google.api.client.json.JsonToken.VALUE_NUMBER_FLOAT)
          {
            currentToken = ((com.google.api.client.json.JsonToken)localObject);
            break;
          }
          currentText = reader.nextName();
          currentToken = com.google.api.client.json.JsonToken.FIELD_NAME;
          currentNameStack.set(currentNameStack.size() - 1, currentText);
        }
      }
    }
  }

  public JsonParser skipChildren()
    throws IOException
  {
    if (currentToken != null);
    switch (1.$SwitchMap$com$google$api$client$json$JsonToken[currentToken.ordinal()])
    {
    default:
      return this;
    case 1:
      reader.skipValue();
      currentText = "]";
      currentToken = com.google.api.client.json.JsonToken.END_ARRAY;
      return this;
    case 2:
    }
    reader.skipValue();
    currentText = "}";
    currentToken = com.google.api.client.json.JsonToken.END_OBJECT;
    return this;
  }
}