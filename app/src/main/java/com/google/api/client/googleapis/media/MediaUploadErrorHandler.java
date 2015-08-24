package com.google.api.client.googleapis.media;

import com.google.api.client.http.HttpIOExceptionHandler;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class MediaUploadErrorHandler
  implements HttpIOExceptionHandler, HttpUnsuccessfulResponseHandler
{
  static final Logger LOGGER = Logger.getLogger(MediaUploadErrorHandler.class.getName());
  private final HttpIOExceptionHandler originalIOExceptionHandler;
  private final HttpUnsuccessfulResponseHandler originalUnsuccessfulHandler;
  private final MediaHttpUploader uploader;

  public MediaUploadErrorHandler(MediaHttpUploader paramMediaHttpUploader, HttpRequest paramHttpRequest)
  {
    uploader = ((MediaHttpUploader)Preconditions.checkNotNull(paramMediaHttpUploader));
    originalIOExceptionHandler = paramHttpRequest.getIOExceptionHandler();
    originalUnsuccessfulHandler = paramHttpRequest.getUnsuccessfulResponseHandler();
    paramHttpRequest.setIOExceptionHandler(this);
    paramHttpRequest.setUnsuccessfulResponseHandler(this);
  }

  public boolean handleIOException(HttpRequest paramHttpRequest, boolean paramBoolean)
    throws IOException
  {
    if ((originalIOExceptionHandler != null) && (originalIOExceptionHandler.handleIOException(paramHttpRequest, paramBoolean)))
      paramBoolean = true;
    while (true)
    {
      if (paramBoolean);
      try
      {
        uploader.serverErrorCallback();
        return paramBoolean;
        paramBoolean = false;
      }
      catch (IOException paramHttpRequest)
      {
        LOGGER.log(Level.WARNING, "exception thrown while calling server callback", paramHttpRequest);
      }
    }
    return paramBoolean;
  }

  public boolean handleResponse(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, boolean paramBoolean)
    throws IOException
  {
    boolean bool;
    if ((originalUnsuccessfulHandler != null) && (originalUnsuccessfulHandler.handleResponse(paramHttpRequest, paramHttpResponse, paramBoolean)))
      bool = true;
    while (true)
    {
      if ((bool) && (paramBoolean) && (paramHttpResponse.getStatusCode() / 100 == 5));
      try
      {
        uploader.serverErrorCallback();
        return bool;
        bool = false;
      }
      catch (IOException paramHttpRequest)
      {
        LOGGER.log(Level.WARNING, "exception thrown while calling server callback", paramHttpRequest);
      }
    }
    return bool;
  }
}