package com.google.api.client.googleapis.media;

import java.io.IOException;

public abstract interface MediaHttpUploaderProgressListener
{
  public abstract void progressChanged(MediaHttpUploader paramMediaHttpUploader)
    throws IOException;
}