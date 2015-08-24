package com.google.api.client.googleapis.services;

import com.google.api.client.googleapis.MethodOverride;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GZipEncoding;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpResponseInterceptor;
import com.google.api.client.http.UriTemplate;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import java.io.IOException;

public abstract class AbstractGoogleClientRequest<T> extends GenericData
{
  private final AbstractGoogleClient abstractGoogleClient;
  private boolean disableGZipContent;
  private final HttpContent httpContent;
  private HttpHeaders lastResponseHeaders;
  private int lastStatusCode = -1;
  private String lastStatusMessage;
  private HttpHeaders requestHeaders = new HttpHeaders();
  private final String requestMethod;
  private Class<T> responseClass;
  private MediaHttpUploader uploader;
  private final String uriTemplate;

  protected AbstractGoogleClientRequest(AbstractGoogleClient paramAbstractGoogleClient, String paramString1, String paramString2, HttpContent paramHttpContent, Class<T> paramClass)
  {
    responseClass = ((Class)Preconditions.checkNotNull(paramClass));
    abstractGoogleClient = ((AbstractGoogleClient)Preconditions.checkNotNull(paramAbstractGoogleClient));
    requestMethod = ((String)Preconditions.checkNotNull(paramString1));
    uriTemplate = ((String)Preconditions.checkNotNull(paramString2));
    httpContent = paramHttpContent;
    paramAbstractGoogleClient = paramAbstractGoogleClient.getApplicationName();
    if (paramAbstractGoogleClient != null)
      requestHeaders.setUserAgent(paramAbstractGoogleClient);
  }

  private HttpRequest buildHttpRequest(boolean paramBoolean)
    throws IOException
  {
    boolean bool2 = false;
    boolean bool1;
    if (uploader == null)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1);
      if (paramBoolean)
      {
        bool1 = bool2;
        if (!requestMethod.equals("GET"));
      }
      else
      {
        bool1 = true;
      }
      Preconditions.checkArgument(bool1);
      if (!paramBoolean)
        break label211;
    }
    label211: for (Object localObject = "HEAD"; ; localObject = requestMethod)
    {
      localObject = getAbstractGoogleClient().getRequestFactory().buildRequest((String)localObject, buildHttpRequestUrl(), httpContent);
      new MethodOverride().intercept((HttpRequest)localObject);
      ((HttpRequest)localObject).setParser(getAbstractGoogleClient().getObjectParser());
      if ((httpContent == null) && ((requestMethod.equals("POST")) || (requestMethod.equals("PUT")) || (requestMethod.equals("PATCH"))))
        ((HttpRequest)localObject).setContent(new EmptyContent());
      ((HttpRequest)localObject).getHeaders().putAll(requestHeaders);
      if (!disableGZipContent)
        ((HttpRequest)localObject).setEncoding(new GZipEncoding());
      ((HttpRequest)localObject).setResponseInterceptor(new HttpResponseInterceptor()
      {
        public void interceptResponse(HttpResponse paramAnonymousHttpResponse)
          throws IOException
        {
          if (val$responseInterceptor != null)
            val$responseInterceptor.interceptResponse(paramAnonymousHttpResponse);
          if ((!paramAnonymousHttpResponse.isSuccessStatusCode()) && (val$httpRequest.getThrowExceptionOnExecuteError()))
            throw newExceptionOnError(paramAnonymousHttpResponse);
        }
      });
      return localObject;
      bool1 = false;
      break;
    }
  }

  private HttpResponse executeUnparsed(boolean paramBoolean)
    throws IOException
  {
    Object localObject;
    if (uploader == null)
      localObject = buildHttpRequest(paramBoolean).execute();
    HttpResponse localHttpResponse;
    do
    {
      do
      {
        lastResponseHeaders = ((HttpResponse)localObject).getHeaders();
        lastStatusCode = ((HttpResponse)localObject).getStatusCode();
        lastStatusMessage = ((HttpResponse)localObject).getStatusMessage();
        return localObject;
        localObject = buildHttpRequestUrl();
        paramBoolean = getAbstractGoogleClient().getRequestFactory().buildRequest(requestMethod, (GenericUrl)localObject, httpContent).getThrowExceptionOnExecuteError();
        localHttpResponse = uploader.setInitiationHeaders(requestHeaders).setDisableGZipContent(disableGZipContent).upload((GenericUrl)localObject);
        localHttpResponse.getRequest().setParser(getAbstractGoogleClient().getObjectParser());
        localObject = localHttpResponse;
      }
      while (!paramBoolean);
      localObject = localHttpResponse;
    }
    while (localHttpResponse.isSuccessStatusCode());
    throw newExceptionOnError(localHttpResponse);
  }

  public GenericUrl buildHttpRequestUrl()
  {
    return new GenericUrl(UriTemplate.expand(abstractGoogleClient.getBaseUrl(), uriTemplate, this, true));
  }

  public T execute()
    throws IOException
  {
    return executeUnparsed().parseAs(responseClass);
  }

  public HttpResponse executeUnparsed()
    throws IOException
  {
    return executeUnparsed(false);
  }

  public AbstractGoogleClient getAbstractGoogleClient()
  {
    return abstractGoogleClient;
  }

  public final MediaHttpUploader getMediaHttpUploader()
  {
    return uploader;
  }

  protected final void initializeMediaUpload(AbstractInputStreamContent paramAbstractInputStreamContent)
  {
    HttpRequestFactory localHttpRequestFactory = abstractGoogleClient.getRequestFactory();
    uploader = new MediaHttpUploader(paramAbstractInputStreamContent, localHttpRequestFactory.getTransport(), localHttpRequestFactory.getInitializer());
    uploader.setInitiationRequestMethod(requestMethod);
    if (httpContent != null)
      uploader.setMetadata(httpContent);
  }

  protected IOException newExceptionOnError(HttpResponse paramHttpResponse)
  {
    return new HttpResponseException(paramHttpResponse);
  }

  public AbstractGoogleClientRequest<T> set(String paramString, Object paramObject)
  {
    return (AbstractGoogleClientRequest)super.set(paramString, paramObject);
  }
}