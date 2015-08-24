package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.InitializeRealtimeDocumentListener;
import com.google.android.gms.drive.DriveFile.RealtimeLoadResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.realtime.RealtimeConfiguration;

public class zzq
  implements DriveApi
{
  public PendingResult<DriveFile.RealtimeLoadResult> loadRealtimeDocumentFromResourceId(GoogleApiClient paramGoogleApiClient, String paramString, DriveFile.InitializeRealtimeDocumentListener paramInitializeRealtimeDocumentListener, RealtimeConfiguration paramRealtimeConfiguration)
  {
    return new zzu(DriveId.zzcs(paramString)).loadRealtimeDocument(paramGoogleApiClient, paramInitializeRealtimeDocumentListener, paramRealtimeConfiguration);
  }
}