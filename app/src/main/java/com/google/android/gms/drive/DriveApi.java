package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.realtime.RealtimeConfiguration;

public abstract interface DriveApi
{
  public abstract PendingResult<DriveFile.RealtimeLoadResult> loadRealtimeDocumentFromResourceId(GoogleApiClient paramGoogleApiClient, String paramString, DriveFile.InitializeRealtimeDocumentListener paramInitializeRealtimeDocumentListener, RealtimeConfiguration paramRealtimeConfiguration);
}