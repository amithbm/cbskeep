package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import java.io.IOException;

public class HttpResponseException extends IOException
{
  private static final long serialVersionUID = -1875819453475890043L;
  private final String content;
  private final transient HttpHeaders headers;
  private final int statusCode;
  private final String statusMessage;

  public HttpResponseException(HttpResponse paramHttpResponse)
  {
    this(new Builder(paramHttpResponse));
  }

  protected HttpResponseException(Builder paramBuilder)
  {
    super(paramBuilder.message);
    statusCode = paramBuilder.statusCode;
    statusMessage = paramBuilder.statusMessage;
    headers = paramBuilder.headers;
    content = paramBuilder.content;
  }

  public static StringBuilder computeMessageBuffer(HttpResponse paramHttpResponse)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramHttpResponse.getStatusCode();
    if (i != 0)
      localStringBuilder.append(i);
    paramHttpResponse = paramHttpResponse.getStatusMessage();
    if (paramHttpResponse != null)
    {
      if (i != 0)
        localStringBuilder.append(' ');
      localStringBuilder.append(paramHttpResponse);
    }
    return localStringBuilder;
  }

  public final int getStatusCode()
  {
    return statusCode;
  }

  public static class Builder
  {
    String content;
    HttpHeaders headers;
    String message;
    int statusCode;
    String statusMessage;

    public Builder(int paramInt, String paramString, HttpHeaders paramHttpHeaders)
    {
      setStatusCode(paramInt);
      setStatusMessage(paramString);
      setHeaders(paramHttpHeaders);
    }

    public Builder(HttpResponse paramHttpResponse)
    {
      this(paramHttpResponse.getStatusCode(), paramHttpResponse.getStatusMessage(), paramHttpResponse.getHeaders());
      try
      {
        content = paramHttpResponse.parseAsString();
        if (content.length() == 0)
          content = null;
        paramHttpResponse = HttpResponseException.computeMessageBuffer(paramHttpResponse);
        if (content != null)
          paramHttpResponse.append(StringUtils.LINE_SEPARATOR).append(content);
        message = paramHttpResponse.toString();
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          localIOException.printStackTrace();
      }
    }

    public Builder setContent(String paramString)
    {
      content = paramString;
      return this;
    }

    public Builder setHeaders(HttpHeaders paramHttpHeaders)
    {
      headers = ((HttpHeaders)Preconditions.checkNotNull(paramHttpHeaders));
      return this;
    }

    public Builder setMessage(String paramString)
    {
      message = paramString;
      return this;
    }

    public Builder setStatusCode(int paramInt)
    {
      if (paramInt >= 0);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkArgument(bool);
        statusCode = paramInt;
        return this;
      }
    }

    public Builder setStatusMessage(String paramString)
    {
      statusMessage = paramString;
      return this;
    }
  }
}