package com.google.android.keep.sharing;

import com.google.android.gms.drive.realtime.CollaborativeString;
import com.google.android.gms.drive.realtime.CollaborativeString.TextDeletedEvent;
import com.google.android.gms.drive.realtime.CollaborativeString.TextInsertedEvent;
import com.google.android.gms.drive.realtime.RealtimeEvent.Listener;

public class b
{
  private CollaborativeString Ev;
  private boolean Ew = false;
  private a Ex;
  private RealtimeEvent.Listener<CollaborativeString.TextInsertedEvent> Ey;
  private RealtimeEvent.Listener<CollaborativeString.TextDeletedEvent> Ez;

  public b(CollaborativeString paramCollaborativeString, a parama)
  {
    Ev = paramCollaborativeString;
    Ex = parama;
    kM();
  }

  private void kM()
  {
    if (Ey == null)
    {
      Ey = new RealtimeEvent.Listener()
      {
        public void a(CollaborativeString.TextInsertedEvent paramAnonymousTextInsertedEvent)
        {
          if (paramAnonymousTextInsertedEvent.isLocal());
          while (b.a(b.this) == null)
            return;
          b.a(b.this, true);
          b.a(b.this).c(paramAnonymousTextInsertedEvent.getIndex(), paramAnonymousTextInsertedEvent.getText());
          b.a(b.this, false);
        }
      };
      Ev.addTextInsertedListener(Ey);
    }
    if (Ez == null)
    {
      Ez = new RealtimeEvent.Listener()
      {
        public void a(CollaborativeString.TextDeletedEvent paramAnonymousTextDeletedEvent)
        {
          if (paramAnonymousTextDeletedEvent.isLocal());
          while (b.a(b.this) == null)
            return;
          b.a(b.this, true);
          b.a(b.this).d(paramAnonymousTextDeletedEvent.getIndex(), paramAnonymousTextDeletedEvent.getText());
          b.a(b.this, false);
        }
      };
      Ev.addTextDeletedListener(Ez);
    }
  }

  public void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((Ew) || (paramCharSequence == null));
    do
    {
      return;
      while ((paramInt3 > 0) && (paramInt1 < Ev.length()) && (paramInt2 > 0) && (paramCharSequence.charAt(paramInt1) == Ev.charAt(paramInt1)))
      {
        paramInt1 += 1;
        paramInt2 -= 1;
        paramInt3 -= 1;
      }
      if (paramInt2 > 0)
        Ev.removeRange(paramInt1, paramInt1 + paramInt2);
    }
    while (paramInt3 <= 0);
    Ev.insertString(paramInt1, paramCharSequence.subSequence(paramInt1, paramInt1 + paramInt3).toString());
  }

  public void ao(boolean paramBoolean)
  {
    Ew = paramBoolean;
  }

  public void kN()
  {
    if (Ev != null)
    {
      Ev.removeTextInsertedListener(Ey);
      Ev.removeTextDeletedListener(Ez);
      Ev = null;
    }
    Ex = null;
  }

  public static abstract interface a
  {
    public abstract void c(int paramInt, String paramString);

    public abstract void d(int paramInt, String paramString);
  }
}