package com.google.api.client.googleapis.services;

import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Strings;
import java.io.IOException;
import java.util.logging.Logger;

public abstract class AbstractGoogleClient
{
  static final Logger LOGGER = Logger.getLogger(AbstractGoogleClient.class.getName());
  private final String applicationName;
  private final GoogleClientRequestInitializer googleClientRequestInitializer;
  private final ObjectParser objectParser;
  private final HttpRequestFactory requestFactory;
  private final String rootUrl;
  private final String servicePath;
  private boolean suppressPatternChecks;
  private boolean suppressRequiredParameterChecks;

  protected AbstractGoogleClient(Builder paramBuilder)
  {
    googleClientRequestInitializer = paramBuilder.googleClientRequestInitializer;
    rootUrl = normalizeRootUrl(paramBuilder.rootUrl);
    servicePath = normalizeServicePath(paramBuilder.servicePath);
    if (Strings.isNullOrEmpty(paramBuilder.applicationName))
      LOGGER.warning("Application name is not set. Call Builder#setApplicationName.");
    applicationName = paramBuilder.applicationName;
    if (paramBuilder.httpRequestInitializer == null);
    for (HttpRequestFactory localHttpRequestFactory = paramBuilder.transport.createRequestFactory(); ; localHttpRequestFactory = paramBuilder.transport.createRequestFactory(paramBuilder.httpRequestInitializer))
    {
      requestFactory = localHttpRequestFactory;
      objectParser = paramBuilder.objectParser;
      suppressPatternChecks = paramBuilder.suppressPatternChecks;
      suppressRequiredParameterChecks = paramBuilder.suppressRequiredParameterChecks;
      return;
    }
  }

  static String normalizeRootUrl(String paramString)
  {
    Preconditions.checkNotNull(paramString, "root URL cannot be null.");
    String str = paramString;
    if (!paramString.endsWith("/"))
      str = paramString + "/";
    return str;
  }

  static String normalizeServicePath(String paramString)
  {
    Preconditions.checkNotNull(paramString, "service path cannot be null");
    Object localObject;
    if (paramString.length() == 1)
    {
      Preconditions.checkArgument("/".equals(paramString), "service path must equal \"/\" if it is of length 1.");
      localObject = "";
    }
    String str;
    do
    {
      do
      {
        return localObject;
        localObject = paramString;
      }
      while (paramString.length() <= 0);
      str = paramString;
      if (!paramString.endsWith("/"))
        str = paramString + "/";
      localObject = str;
    }
    while (!str.startsWith("/"));
    return str.substring(1);
  }

  public final String getApplicationName()
  {
    return applicationName;
  }

  public final String getBaseUrl()
  {
    return rootUrl + servicePath;
  }

  public final GoogleClientRequestInitializer getGoogleClientRequestInitializer()
  {
    return googleClientRequestInitializer;
  }

  public ObjectParser getObjectParser()
  {
    return objectParser;
  }

  public final HttpRequestFactory getRequestFactory()
  {
    return requestFactory;
  }

  public final String getServicePath()
  {
    return servicePath;
  }

  protected void initialize(AbstractGoogleClientRequest<?> paramAbstractGoogleClientRequest)
    throws IOException
  {
    if (getGoogleClientRequestInitializer() != null)
      getGoogleClientRequestInitializer().initialize(paramAbstractGoogleClientRequest);
  }

  public static abstract class Builder
  {
    String applicationName;
    GoogleClientRequestInitializer googleClientRequestInitializer;
    HttpRequestInitializer httpRequestInitializer;
    final ObjectParser objectParser;
    String rootUrl;
    String servicePath;
    boolean suppressPatternChecks;
    boolean suppressRequiredParameterChecks;
    final HttpTransport transport;

    protected Builder(HttpTransport paramHttpTransport, String paramString1, String paramString2, ObjectParser paramObjectParser, HttpRequestInitializer paramHttpRequestInitializer)
    {
      transport = ((HttpTransport)Preconditions.checkNotNull(paramHttpTransport));
      objectParser = paramObjectParser;
      setRootUrl(paramString1);
      setServicePath(paramString2);
      httpRequestInitializer = paramHttpRequestInitializer;
    }

    public Builder setApplicationName(String paramString)
    {
      applicationName = paramString;
      return this;
    }

    public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer paramGoogleClientRequestInitializer)
    {
      googleClientRequestInitializer = paramGoogleClientRequestInitializer;
      return this;
    }

    public Builder setRootUrl(String paramString)
    {
      rootUrl = AbstractGoogleClient.normalizeRootUrl(paramString);
      return this;
    }

    public Builder setServicePath(String paramString)
    {
      servicePath = AbstractGoogleClient.normalizeServicePath(paramString);
      return this;
    }
  }
}