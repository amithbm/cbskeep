package com.google.api.client.http.javanet;

import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.LowLevelHttpResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class NetHttpResponse extends LowLevelHttpResponse
{
  private final HttpURLConnection connection;
  private final ArrayList<String> headerNames = new ArrayList();
  private final ArrayList<String> headerValues = new ArrayList();
  private final int responseCode;
  private final String responseMessage;

  NetHttpResponse(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    connection = paramHttpURLConnection;
    int j = paramHttpURLConnection.getResponseCode();
    int i = j;
    if (j == -1)
      i = 0;
    responseCode = i;
    responseMessage = paramHttpURLConnection.getResponseMessage();
    ArrayList localArrayList1 = headerNames;
    ArrayList localArrayList2 = headerValues;
    paramHttpURLConnection = paramHttpURLConnection.getHeaderFields().entrySet().iterator();
    while (paramHttpURLConnection.hasNext())
    {
      Object localObject = (Map.Entry)paramHttpURLConnection.next();
      String str1 = (String)((Map.Entry)localObject).getKey();
      if (str1 != null)
      {
        localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          if (str2 != null)
          {
            localArrayList1.add(str1);
            localArrayList2.add(str2);
          }
        }
      }
    }
  }

  public void disconnect()
  {
    connection.disconnect();
  }

  public InputStream getContent()
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = connection;
    if (HttpStatusCodes.isSuccess(responseCode))
      return localHttpURLConnection.getInputStream();
    return localHttpURLConnection.getErrorStream();
  }

  public String getContentEncoding()
  {
    return connection.getContentEncoding();
  }

  public String getContentType()
  {
    return connection.getHeaderField("Content-Type");
  }

  public int getHeaderCount()
  {
    return headerNames.size();
  }

  public String getHeaderName(int paramInt)
  {
    return (String)headerNames.get(paramInt);
  }

  public String getHeaderValue(int paramInt)
  {
    return (String)headerValues.get(paramInt);
  }

  public String getReasonPhrase()
  {
    return responseMessage;
  }

  public int getStatusCode()
  {
    return responseCode;
  }

  public String getStatusLine()
  {
    String str = connection.getHeaderField(0);
    if ((str != null) && (str.startsWith("HTTP/1.")))
      return str;
    return null;
  }
}