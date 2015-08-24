package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.drive.realtime.Model;
import com.google.android.gms.drive.realtime.RealtimeConfiguration;
import com.google.android.gms.drive.realtime.RealtimeDocument;

public abstract interface DriveFile
{
  public abstract PendingResult<RealtimeLoadResult> loadRealtimeDocument(GoogleApiClient paramGoogleApiClient, InitializeRealtimeDocumentListener paramInitializeRealtimeDocumentListener, RealtimeConfiguration paramRealtimeConfiguration);

  public static abstract interface InitializeRealtimeDocumentListener
  {
    public abstract void onInitialize(Model paramModel);
  }

  public static abstract interface RealtimeLoadResult extends Result
  {
    public abstract RealtimeDocument getRealtimeDocument();
  }
}