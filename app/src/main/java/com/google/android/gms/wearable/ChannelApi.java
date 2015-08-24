package com.google.android.gms.wearable;

public abstract interface ChannelApi
{
  public static abstract interface ChannelListener
  {
    public abstract void onChannelClosed(Channel paramChannel, int paramInt1, int paramInt2);

    public abstract void onChannelOpened(Channel paramChannel);

    public abstract void onInputClosed(Channel paramChannel, int paramInt1, int paramInt2);

    public abstract void onOutputClosed(Channel paramChannel, int paramInt1, int paramInt2);
  }
}