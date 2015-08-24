package com.google.api.client.extensions.android.json;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonWriter;
import com.google.api.client.extensions.android.AndroidUtils;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.json.JsonParser;
import com.google.api.client.util.Charsets;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;

@TargetApi(11)
public class AndroidJsonFactory extends JsonFactory
{
  public AndroidJsonFactory()
  {
    AndroidUtils.checkMinimumSdkLevel(11);
  }

  public JsonGenerator createJsonGenerator(OutputStream paramOutputStream, Charset paramCharset)
  {
    return createJsonGenerator(new OutputStreamWriter(paramOutputStream, paramCharset));
  }

  public JsonGenerator createJsonGenerator(Writer paramWriter)
  {
    return new AndroidJsonGenerator(this, new JsonWriter(paramWriter));
  }

  public JsonParser createJsonParser(InputStream paramInputStream)
  {
    return createJsonParser(new InputStreamReader(paramInputStream, Charsets.UTF_8));
  }

  public JsonParser createJsonParser(InputStream paramInputStream, Charset paramCharset)
  {
    if (paramCharset == null)
      return createJsonParser(paramInputStream);
    return createJsonParser(new InputStreamReader(paramInputStream, paramCharset));
  }

  public JsonParser createJsonParser(Reader paramReader)
  {
    return new AndroidJsonParser(this, new JsonReader(paramReader));
  }

  public JsonParser createJsonParser(String paramString)
  {
    return createJsonParser(new StringReader(paramString));
  }
}