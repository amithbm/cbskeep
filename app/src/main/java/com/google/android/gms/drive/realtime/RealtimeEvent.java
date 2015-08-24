package com.google.android.gms.drive.realtime;

public abstract interface RealtimeEvent
{
  public static abstract interface Listener<E extends RealtimeEvent>
  {
    public abstract void onEvent(E paramE);
  }
}