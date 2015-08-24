package com.google.api.services.notes;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.notes.model.Blob;
import com.google.api.services.notes.model.DownSync;
import com.google.api.services.notes.model.InsertMedia;
import com.google.api.services.notes.model.UpSync;
import java.io.IOException;

public class Notes extends AbstractGoogleJsonClient
{
  static
  {
    if ((GoogleUtils.MAJOR_VERSION.intValue() == 1) && (GoogleUtils.MINOR_VERSION.intValue() >= 15));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.19.1 of the Notes API library.", new Object[] { GoogleUtils.VERSION });
      return;
    }
  }

  Notes(Builder paramBuilder)
  {
    super(paramBuilder);
  }

  public Changes changes()
  {
    return new Changes();
  }

  protected void initialize(AbstractGoogleClientRequest<?> paramAbstractGoogleClientRequest)
    throws IOException
  {
    super.initialize(paramAbstractGoogleClientRequest);
  }

  public static final class Builder extends AbstractGoogleJsonClient.Builder
  {
    public Builder(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory, HttpRequestInitializer paramHttpRequestInitializer)
    {
      super(paramJsonFactory, "https://www.googleapis.com/", "notes/v1/", paramHttpRequestInitializer, false);
    }

    public Notes build()
    {
      return new Notes(this);
    }

    public Builder setApplicationName(String paramString)
    {
      return (Builder)super.setApplicationName(paramString);
    }

    public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer paramGoogleClientRequestInitializer)
    {
      return (Builder)super.setGoogleClientRequestInitializer(paramGoogleClientRequestInitializer);
    }

    public Builder setNotesRequestInitializer(NotesRequestInitializer paramNotesRequestInitializer)
    {
      return (Builder)super.setGoogleClientRequestInitializer(paramNotesRequestInitializer);
    }

    public Builder setRootUrl(String paramString)
    {
      return (Builder)super.setRootUrl(paramString);
    }

    public Builder setServicePath(String paramString)
    {
      return (Builder)super.setServicePath(paramString);
    }
  }

  public class Changes
  {
    public Changes()
    {
    }

    public Insertmedia insertmedia(String paramString, InsertMedia paramInsertMedia, AbstractInputStreamContent paramAbstractInputStreamContent)
      throws IOException
    {
      paramString = new Insertmedia(paramString, paramInsertMedia, paramAbstractInputStreamContent);
      initialize(paramString);
      return paramString;
    }

    public Requestaccess requestaccess(String paramString)
      throws IOException
    {
      paramString = new Requestaccess(paramString);
      initialize(paramString);
      return paramString;
    }

    public Sync sync(UpSync paramUpSync)
      throws IOException
    {
      paramUpSync = new Sync(paramUpSync);
      initialize(paramUpSync);
      return paramUpSync;
    }

    public class Insertmedia extends NotesRequest<Blob>
    {

      @Key
      private String nodeId;

      protected Insertmedia(String paramInsertMedia, InsertMedia paramAbstractInputStreamContent, AbstractInputStreamContent arg4)
      {
        super("POST", "/upload/" + getServicePath() + "media/{nodeId}", paramAbstractInputStreamContent, Blob.class);
        nodeId = ((String)Preconditions.checkNotNull(paramInsertMedia, "Required parameter nodeId must be specified."));
        AbstractInputStreamContent localAbstractInputStreamContent;
        initializeMediaUpload(localAbstractInputStreamContent);
      }

      public Insertmedia set(String paramString, Object paramObject)
      {
        return (Insertmedia)super.set(paramString, paramObject);
      }
    }

    public class Requestaccess extends NotesRequest<Void>
    {

      @Key
      private String serverId;

      protected Requestaccess(String arg2)
      {
        super("POST", "request_access/{serverId}", null, Void.class);
        Object localObject;
        serverId = ((String)Preconditions.checkNotNull(localObject, "Required parameter serverId must be specified."));
      }

      public Requestaccess set(String paramString, Object paramObject)
      {
        return (Requestaccess)super.set(paramString, paramObject);
      }
    }

    public class Sync extends NotesRequest<DownSync>
    {
      protected Sync(UpSync arg2)
      {
        super("POST", "changes", localObject, DownSync.class);
      }

      public Sync set(String paramString, Object paramObject)
      {
        return (Sync)super.set(paramString, paramObject);
      }
    }
  }
}