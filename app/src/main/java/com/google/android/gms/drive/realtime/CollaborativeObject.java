package com.google.android.gms.drive.realtime;

import java.util.List;

public abstract interface CollaborativeObject
{
  public abstract void addObjectChangedListener(RealtimeEvent.Listener<ObjectChangedEvent> paramListener);

  public abstract String getId();

  public abstract void removeObjectChangedListener(RealtimeEvent.Listener<ObjectChangedEvent> paramListener);

  public static class ObjectChangedEvent extends CollaborativeObjectEvent
  {
    private final List<String> zzayv;
    private List<CollaborativeObjectEvent> zzayw;

    public ObjectChangedEvent(String paramString1, String paramString2, List<String> paramList1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, CollaborativeObject paramCollaborativeObject, List<CollaborativeObjectEvent> paramList, List<String> paramList2)
    {
      super(paramString1, paramString2, paramList1, paramBoolean1, paramBoolean2, paramBoolean3);
      zzayv = paramList2;
      zzayw = paramList;
    }

    public List<CollaborativeObjectEvent> getCauses()
    {
      return zzayw;
    }

    public List<String> getObjectIdsToInform()
    {
      return zzayv;
    }

    public String toString()
    {
      return "ObjectChangedEvent [target=" + getTarget().getId() + "]";
    }
  }

  public static class UnknownEvent extends CollaborativeObjectEvent
  {
    public UnknownEvent(String paramString1, String paramString2, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, CollaborativeObject paramCollaborativeObject)
    {
      super(paramString1, paramString2, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
    }

    public String toString()
    {
      return "UnknownEvent [target=" + getTarget().getId() + "]";
    }
  }
}