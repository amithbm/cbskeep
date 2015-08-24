package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.util.List;

public abstract interface DriveFirstPartyApi
{
  public abstract PendingResult<Status> requestRealtimeDocumentSync(GoogleApiClient paramGoogleApiClient, List<String> paramList1, List<String> paramList2);
}