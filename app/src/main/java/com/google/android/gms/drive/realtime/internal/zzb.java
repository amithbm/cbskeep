package com.google.android.gms.drive.realtime.internal;

import com.google.android.gms.drive.realtime.CollaborativeObjectEvent;
import com.google.android.gms.drive.realtime.IndexReference;
import com.google.android.gms.drive.realtime.IndexReference.ReferenceShiftedEvent;
import com.google.android.gms.drive.realtime.RealtimeEvent.Listener;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;

public class zzb extends zzf
  implements IndexReference
{
  private final Set<RealtimeEvent.Listener<IndexReference.ReferenceShiftedEvent>> zzazd = Collections.newSetFromMap(new IdentityHashMap());
  private ParcelableIndexReference zzaze;

  public zzb(zzt paramzzt, String paramString, zzag paramzzag)
  {
    super(paramzzt, paramString, paramzzag, "IndexReference");
  }

  void flushCache()
  {
    zzaze = null;
  }

  public void zza(CollaborativeObjectEvent paramCollaborativeObjectEvent)
  {
    if ((paramCollaborativeObjectEvent instanceof IndexReference.ReferenceShiftedEvent))
    {
      IndexReference.ReferenceShiftedEvent localReferenceShiftedEvent = (IndexReference.ReferenceShiftedEvent)paramCollaborativeObjectEvent;
      Iterator localIterator = zzazd.iterator();
      while (localIterator.hasNext())
        ((RealtimeEvent.Listener)localIterator.next()).onEvent(localReferenceShiftedEvent);
    }
    super.zza(paramCollaborativeObjectEvent);
  }
}