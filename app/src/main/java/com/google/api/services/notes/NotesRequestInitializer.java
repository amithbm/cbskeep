package com.google.api.services.notes;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer;
import java.io.IOException;

public class NotesRequestInitializer extends CommonGoogleJsonClientRequestInitializer
{
  public final void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> paramAbstractGoogleJsonClientRequest)
    throws IOException
  {
    super.initializeJsonRequest(paramAbstractGoogleJsonClientRequest);
    initializeNotesRequest((NotesRequest)paramAbstractGoogleJsonClientRequest);
  }

  protected void initializeNotesRequest(NotesRequest<?> paramNotesRequest)
    throws IOException
  {
  }
}