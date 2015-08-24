package com.google.android.gms.drive.realtime;

import java.util.List;

public abstract interface IndexReference extends CollaborativeObject
{
  public static class ReferenceShiftedEvent extends CollaborativeObjectEvent
  {
    private final String zzayQ;
    private final String zzayR;
    private final int zzayS;
    private final int zzayT;

    public ReferenceShiftedEvent(String paramString1, String paramString2, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, IndexReference paramIndexReference, String paramString3, String paramString4, int paramInt1, int paramInt2)
    {
      super(paramString1, paramString2, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
      zzayQ = paramString4;
      zzayR = paramString3;
      zzayS = paramInt2;
      zzayT = paramInt1;
    }

    public String toString()
    {
      return "ReferenceShiftedEvent [newObjectId=" + zzayQ + ", oldObjectId=" + zzayR + ", " + "newIndex=" + zzayS + "oldIndex" + zzayT + "]";
    }
  }
}