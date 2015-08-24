package com.google.android.gms.drive.realtime;

import java.util.List;

public class CollaborativeObjectEvent
  implements RealtimeEvent
{
  private final String zzFm;
  private final String zzGc;
  private final boolean zzayA;
  private final List<String> zzayB;
  private final CollaborativeObject zzayx;
  private final boolean zzayy;
  private final boolean zzayz;

  public CollaborativeObjectEvent(CollaborativeObject paramCollaborativeObject, String paramString1, String paramString2, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    zzayx = paramCollaborativeObject;
    zzGc = paramString1;
    zzFm = paramString2;
    zzayy = paramBoolean1;
    zzayz = paramBoolean2;
    zzayA = paramBoolean3;
    zzayB = paramList;
  }

  public CollaborativeObject getTarget()
  {
    return zzayx;
  }

  public boolean isLocal()
  {
    return zzayy;
  }
}