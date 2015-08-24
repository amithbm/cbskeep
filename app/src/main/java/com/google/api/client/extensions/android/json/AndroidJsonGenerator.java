package com.google.api.client.extensions.android.json;

import android.annotation.TargetApi;
import android.util.JsonWriter;
import com.google.api.client.json.JsonGenerator;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@TargetApi(11)
class AndroidJsonGenerator extends JsonGenerator
{
  private final AndroidJsonFactory factory;
  private final JsonWriter writer;

  AndroidJsonGenerator(AndroidJsonFactory paramAndroidJsonFactory, JsonWriter paramJsonWriter)
  {
    factory = paramAndroidJsonFactory;
    writer = paramJsonWriter;
    paramJsonWriter.setLenient(true);
  }

  public void enablePrettyPrint()
    throws IOException
  {
    writer.setIndent("  ");
  }

  public void flush()
    throws IOException
  {
    writer.flush();
  }

  public void writeBoolean(boolean paramBoolean)
    throws IOException
  {
    writer.value(paramBoolean);
  }

  public void writeEndArray()
    throws IOException
  {
    writer.endArray();
  }

  public void writeEndObject()
    throws IOException
  {
    writer.endObject();
  }

  public void writeFieldName(String paramString)
    throws IOException
  {
    writer.name(paramString);
  }

  public void writeNull()
    throws IOException
  {
    writer.nullValue();
  }

  public void writeNumber(double paramDouble)
    throws IOException
  {
    writer.value(paramDouble);
  }

  public void writeNumber(float paramFloat)
    throws IOException
  {
    writer.value(paramFloat);
  }

  public void writeNumber(int paramInt)
    throws IOException
  {
    writer.value(paramInt);
  }

  public void writeNumber(long paramLong)
    throws IOException
  {
    writer.value(paramLong);
  }

  public void writeNumber(BigDecimal paramBigDecimal)
    throws IOException
  {
    writer.value(paramBigDecimal);
  }

  public void writeNumber(BigInteger paramBigInteger)
    throws IOException
  {
    writer.value(paramBigInteger);
  }

  public void writeStartArray()
    throws IOException
  {
    writer.beginArray();
  }

  public void writeStartObject()
    throws IOException
  {
    writer.beginObject();
  }

  public void writeString(String paramString)
    throws IOException
  {
    writer.value(paramString);
  }
}