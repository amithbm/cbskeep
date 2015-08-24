package com.google.android.gms.drive.realtime;

import com.google.android.gms.common.api.Status;

public abstract interface RealtimeDocument
{
  public abstract void addCollaboratorJoinedListener(RealtimeEvent.Listener<CollaboratorJoinedEvent> paramListener);

  public abstract void addCollaboratorLeftListener(RealtimeEvent.Listener<CollaboratorLeftEvent> paramListener);

  public abstract void close();

  public abstract Model getModel();

  public abstract void removeCollaboratorJoinedListener(RealtimeEvent.Listener<CollaboratorJoinedEvent> paramListener);

  public abstract void removeCollaboratorLeftListener(RealtimeEvent.Listener<CollaboratorLeftEvent> paramListener);

  public static class CollaboratorJoinedEvent
    implements RealtimeEvent
  {
    private final Collaborator zzayX;

    public CollaboratorJoinedEvent(Collaborator paramCollaborator)
    {
      zzayX = paramCollaborator;
    }

    public Collaborator getCollaborator()
    {
      return zzayX;
    }

    public String toString()
    {
      return "CollaboratorJoinedEvent [collaborator=" + zzayX + "]";
    }
  }

  public static class CollaboratorLeftEvent
    implements RealtimeEvent
  {
    private final Collaborator zzayX;

    public CollaboratorLeftEvent(Collaborator paramCollaborator)
    {
      zzayX = paramCollaborator;
    }

    public Collaborator getCollaborator()
    {
      return zzayX;
    }

    public String toString()
    {
      return "CollaboratorLeftEvent [collaborator=" + zzayX + "]";
    }
  }

  public static class ErrorEvent
    implements RealtimeEvent
  {
    private final Status zzaza;

    public ErrorEvent(Status paramStatus)
    {
      zzaza = paramStatus;
    }
  }
}