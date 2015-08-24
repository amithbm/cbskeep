package com.google.android.gms.drive.realtime;

import java.util.List;
import java.util.Map;

public abstract interface CollaborativeMap extends CollaborativeObject, Map<String, Object>
{
  public abstract void addValueChangedListener(RealtimeEvent.Listener<ValueChangedEvent> paramListener);

  public abstract void removeValueChangedListener(RealtimeEvent.Listener<ValueChangedEvent> paramListener);

  public static class ValueChangedEvent extends CollaborativeObjectEvent
  {
    private final String zzays;
    private final Object zzayt;
    private final Object zzayu;

    public ValueChangedEvent(String paramString1, String paramString2, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, CollaborativeMap paramCollaborativeMap, String paramString3, Object paramObject1, Object paramObject2)
    {
      super(paramString1, paramString2, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
      zzays = paramString3;
      zzayt = paramObject1;
      zzayu = paramObject2;
    }

    public Object getNewValue()
    {
      return zzayu;
    }

    public String getProperty()
    {
      return zzays;
    }

    public String toString()
    {
      return "ValueChangedEvent [target=" + getTarget() + ", property=" + zzays + ", newValue=" + zzayu + ", oldValue=" + zzayt + "]";
    }
  }
}