package com.google.android.gms.drive.realtime;

public abstract interface Model
{
  public abstract CollaborativeList createList();

  public abstract CollaborativeMap createMap();

  public abstract CollaborativeString createString();

  public abstract CollaborativeMap getRoot();

  public abstract void performCompoundOperation(CompoundOperation paramCompoundOperation, String paramString);

  public static class UndoRedoStateChangedEvent
    implements RealtimeEvent
  {
    private final boolean zzayU;
    private final boolean zzayV;

    public UndoRedoStateChangedEvent(boolean paramBoolean1, boolean paramBoolean2)
    {
      zzayU = paramBoolean1;
      zzayV = paramBoolean2;
    }
  }
}