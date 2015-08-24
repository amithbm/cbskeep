package com.google.android.gms.drive.realtime.internal;

import com.google.android.gms.drive.realtime.CollaborativeObjectEvent;
import com.google.android.gms.drive.realtime.CustomCollaborativeObject;
import com.google.android.gms.drive.realtime.CustomCollaborativeObject.FieldChangedEvent;
import com.google.android.gms.drive.realtime.RealtimeEvent.Listener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class zzh extends zzf
  implements CustomCollaborativeObject
{
  private Set<RealtimeEvent.Listener<CustomCollaborativeObject.FieldChangedEvent>> zzazv = new HashSet();

  public zzh(zzt paramzzt, String paramString1, zzag paramzzag, String paramString2)
  {
    super(paramzzt, paramString1, paramzzag, paramString2);
  }

  void flushCache()
  {
  }

  public void zza(CollaborativeObjectEvent paramCollaborativeObjectEvent)
  {
    super.zza(paramCollaborativeObjectEvent);
    if ((paramCollaborativeObjectEvent instanceof CustomCollaborativeObject.FieldChangedEvent))
    {
      paramCollaborativeObjectEvent = (CustomCollaborativeObject.FieldChangedEvent)paramCollaborativeObjectEvent;
      Iterator localIterator = zzazv.iterator();
      while (localIterator.hasNext())
        ((RealtimeEvent.Listener)localIterator.next()).onEvent(paramCollaborativeObjectEvent);
    }
  }
}