package com.google.android.gms.drive.realtime;

import java.util.List;

public abstract interface CollaborativeString extends CollaborativeObject, Appendable, CharSequence
{
  public abstract void addTextDeletedListener(RealtimeEvent.Listener<TextDeletedEvent> paramListener);

  public abstract void addTextInsertedListener(RealtimeEvent.Listener<TextInsertedEvent> paramListener);

  public abstract void insertString(int paramInt, String paramString);

  public abstract void removeRange(int paramInt1, int paramInt2);

  public abstract void removeTextDeletedListener(RealtimeEvent.Listener<TextDeletedEvent> paramListener);

  public abstract void removeTextInsertedListener(RealtimeEvent.Listener<TextInsertedEvent> paramListener);

  public abstract void setText(String paramString);

  public static class TextDeletedEvent extends CollaborativeObjectEvent
  {
    private final int index;
    private final String zzayC;

    public TextDeletedEvent(String paramString1, String paramString2, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, CollaborativeString paramCollaborativeString, String paramString3, int paramInt)
    {
      super(paramString1, paramString2, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
      zzayC = paramString3;
      index = paramInt;
    }

    public int getIndex()
    {
      return index;
    }

    public String getText()
    {
      return zzayC;
    }

    public String toString()
    {
      return "TextDeletedEvent [target=" + getTarget() + ", text=" + zzayC + ", index=" + index + "]";
    }
  }

  public static class TextInsertedEvent extends CollaborativeObjectEvent
  {
    private final int index;
    private final String zzayC;

    public TextInsertedEvent(String paramString1, String paramString2, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, CollaborativeString paramCollaborativeString, String paramString3, int paramInt)
    {
      super(paramString1, paramString2, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
      zzayC = paramString3;
      index = paramInt;
    }

    public int getIndex()
    {
      return index;
    }

    public String getText()
    {
      return zzayC;
    }

    public String toString()
    {
      return "TextInsertedEvent [target=" + getTarget() + ", text=" + zzayC + ", " + "index=" + index + "]";
    }
  }
}