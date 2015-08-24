package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class FileContent extends AbstractInputStreamContent
{
  private final File file;

  public FileContent(String paramString, File paramFile)
  {
    super(paramString);
    file = ((File)Preconditions.checkNotNull(paramFile));
  }

  public InputStream getInputStream()
    throws FileNotFoundException
  {
    return new FileInputStream(file);
  }

  public long getLength()
  {
    return file.length();
  }

  public boolean retrySupported()
  {
    return true;
  }

  public FileContent setCloseInputStream(boolean paramBoolean)
  {
    return (FileContent)super.setCloseInputStream(paramBoolean);
  }

  public FileContent setType(String paramString)
  {
    return (FileContent)super.setType(paramString);
  }
}