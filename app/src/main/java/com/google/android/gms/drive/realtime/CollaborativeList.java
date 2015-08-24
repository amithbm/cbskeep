package com.google.android.gms.drive.realtime;

import java.util.List;

public abstract interface CollaborativeList extends CollaborativeObject, List<Object>
{
  public abstract void addValuesAddedListener(RealtimeEvent.Listener<ValuesAddedEvent> paramListener);

  public abstract void addValuesRemovedListener(RealtimeEvent.Listener<ValuesRemovedEvent> paramListener);

  public abstract void removeValuesAddedListener(RealtimeEvent.Listener<ValuesAddedEvent> paramListener);

  public abstract void removeValuesRemovedListener(RealtimeEvent.Listener<ValuesRemovedEvent> paramListener);

  public static class ValuesAddedEvent extends CollaborativeObjectEvent
  {
    private final int mIndex;
    private final List<Object> zzayl;
    private final CollaborativeList zzaym;
    private final Integer zzayn;

    public ValuesAddedEvent(String paramString1, String paramString2, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, CollaborativeList paramCollaborativeList1, List<Object> paramList1, int paramInt, CollaborativeList paramCollaborativeList2, Integer paramInteger)
    {
      super(paramString1, paramString2, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
      zzayl = paramList1;
      mIndex = paramInt;
      zzaym = paramCollaborativeList2;
      zzayn = paramInteger;
    }

    public String toString()
    {
      return "ValuesAddedEvent [target=" + getTarget() + ", values=" + zzayl + ", " + "index=" + mIndex + ", movedFromList=" + zzaym + ", movedFromIndex=" + zzayn + "]";
    }
  }

  public static class ValuesRemovedEvent extends CollaborativeObjectEvent
  {
    private final int mIndex;
    private final List<Object> zzayl;
    private final CollaborativeList zzayo;
    private final Integer zzayp;

    public ValuesRemovedEvent(String paramString1, String paramString2, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, CollaborativeList paramCollaborativeList1, List<Object> paramList1, int paramInt, CollaborativeList paramCollaborativeList2, Integer paramInteger)
    {
      super(paramString1, paramString2, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
      zzayl = paramList1;
      mIndex = paramInt;
      zzayo = paramCollaborativeList2;
      zzayp = paramInteger;
    }

    public String toString()
    {
      return "ValuesRemovedEvent [target=" + getTarget() + ", values=" + zzayl + ", " + "index=" + mIndex + ", movedToList=" + zzayo + ", movedToIndex=" + zzayp + "]";
    }
  }

  public static class ValuesSetEvent extends CollaborativeObjectEvent
  {
    private final int index;
    private final List<Object> zzayq;
    private final List<Object> zzayr;

    public ValuesSetEvent(String paramString1, String paramString2, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, CollaborativeList paramCollaborativeList, List<Object> paramList1, List<Object> paramList2, int paramInt)
    {
      super(paramString1, paramString2, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
      zzayq = paramList2;
      zzayr = paramList1;
      index = paramInt;
    }

    public String toString()
    {
      return "ValuesSetEvent [target=" + getTarget() + ", newValues=" + zzayq + ", oldValues=" + zzayr + ", index=" + index + "]";
    }
  }
}