package com.google.android.keep.model;

import android.text.TextUtils;
import com.google.android.keep.syncadapter.DownSyncResponseProcessor.SyncType;

public abstract interface TreeEntity extends c
{
  public abstract String getServerId();

  public abstract String getTitle();

  public abstract long gp();

  public abstract TreeEntitySettings iA();

  public abstract TreeEntityType ir();

  public abstract ColorMap.ColorPair iz();

  public abstract boolean jr();

  public abstract boolean js();

  public abstract long jt();

  public static enum TreeEntityType
  {
    public static TreeEntityType ar(String paramString)
    {
      if (TextUtils.equals(paramString, DownSyncResponseProcessor.SyncType.FV.getTypeName()))
        return zO;
      if (TextUtils.equals(paramString, DownSyncResponseProcessor.SyncType.FX.getTypeName()))
        return zP;
      throw new IllegalStateException("Invalid type: " + paramString);
    }

    public static TreeEntityType bn(int paramInt)
    {
      switch (paramInt)
      {
      default:
        throw new IllegalStateException("Invalid type: " + paramInt);
      case 1:
        return zP;
      case 0:
      }
      return zO;
    }

    public static int e(TreeEntityType paramTreeEntityType)
    {
      switch (TreeEntity.1.rz[paramTreeEntityType.ordinal()])
      {
      default:
        throw new IllegalStateException("Unknown tree entity type " + paramTreeEntityType);
      case 1:
        return 0;
      case 2:
      }
      return 1;
    }

    public static String f(TreeEntityType paramTreeEntityType)
    {
      switch (TreeEntity.1.rz[paramTreeEntityType.ordinal()])
      {
      default:
        throw new IllegalStateException("Unknown tree entity type " + paramTreeEntityType);
      case 1:
        return DownSyncResponseProcessor.SyncType.FV.getTypeName();
      case 2:
      }
      return DownSyncResponseProcessor.SyncType.FX.getTypeName();
    }
  }
}