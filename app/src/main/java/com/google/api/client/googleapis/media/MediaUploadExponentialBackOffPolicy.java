package com.google.api.client.googleapis.media;

import com.google.api.client.http.ExponentialBackOffPolicy;
import java.io.IOException;

@Deprecated
class MediaUploadExponentialBackOffPolicy extends ExponentialBackOffPolicy
{
  private final MediaHttpUploader uploader;

  MediaUploadExponentialBackOffPolicy(MediaHttpUploader paramMediaHttpUploader)
  {
    uploader = paramMediaHttpUploader;
  }

  public long getNextBackOffMillis()
    throws IOException
  {
    uploader.serverErrorCallback();
    return super.getNextBackOffMillis();
  }
}