package com.google.android.gms.drive.realtime;

import java.util.List;

public abstract interface CustomCollaborativeObject extends CollaborativeObject
{
  public static class FieldChangedEvent extends CollaborativeObjectEvent
  {
    private final String zzawt;
    private final Object zzayM;
    private final Object zzayN;

    public FieldChangedEvent(CollaborativeObject paramCollaborativeObject, String paramString1, String paramString2, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3, Object paramObject1, Object paramObject2)
    {
      super(paramString1, paramString2, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
      zzawt = paramString3;
      zzayM = paramObject1;
      zzayN = paramObject2;
    }

    public String toString()
    {
      return "FieldChangedEvent [target=" + getTarget() + ", fieldName=" + zzawt + ", newFieldValue=" + zzayN + ", oldFieldValue=" + zzayM + "]";
    }
  }
}