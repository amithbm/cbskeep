package com.google.android.keep.util;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

public class f<T>
  implements Handler.Callback
{
  private final a<T> PA;
  private final int Pz;
  private Handler mHandler = new Handler(this);

  public f(int paramInt, a<T> parama)
  {
    Pz = paramInt;
    PA = parama;
  }

  public boolean handleMessage(Message paramMessage)
  {
    PA.c(paramMessage.obj);
    return true;
  }

  public void i(T paramT)
  {
    mHandler.removeMessages(0);
    mHandler.sendMessageDelayed(mHandler.obtainMessage(0, paramT), Pz);
  }

  public void j(T paramT)
  {
    paramT = mHandler.obtainMessage(0, paramT);
    mHandler.removeMessages(0);
    handleMessage(paramT);
  }

  public static abstract interface a<T>
  {
    public abstract void c(T paramT);
  }
}