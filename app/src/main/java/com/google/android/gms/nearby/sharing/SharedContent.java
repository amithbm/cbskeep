package com.google.android.gms.nearby.sharing;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedContent
  implements SafeParcelable
{
  public static final Parcelable.Creator<SharedContent> CREATOR = new zzc();
  private final int versionCode;

  @Deprecated
  private String zzbbx;
  private ViewableItem[] zzbby;
  private LocalContent[] zzbbz;

  private SharedContent()
  {
    versionCode = 2;
  }

  SharedContent(int paramInt, String paramString, ViewableItem[] paramArrayOfViewableItem, LocalContent[] paramArrayOfLocalContent)
  {
    versionCode = paramInt;
    zzbbx = paramString;
    zzbby = paramArrayOfViewableItem;
    zzbbz = paramArrayOfLocalContent;
  }

  private SharedContent(Builder paramBuilder)
  {
    this();
    if (Builder.zza(paramBuilder) != null);
    for (zzbby = new ViewableItem[] { Builder.zza(paramBuilder) }; ; zzbby = new ViewableItem[0])
    {
      zzbbz = ((LocalContent[])Builder.zzb(paramBuilder).toArray(new LocalContent[Builder.zzb(paramBuilder).size()]));
      return;
    }
  }

  public static SharedContent forViewableUri(Uri paramUri)
  {
    return new Builder().addViewableItem(ViewableItem.forUri(paramUri)).build();
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    do
    {
      return true;
      if (!(paramObject instanceof SharedContent))
        return false;
      paramObject = (SharedContent)paramObject;
    }
    while ((zzu.equal(zzbby, paramObject.zzbby)) && (zzu.equal(zzbbz, paramObject.zzbbz)) && (zzu.equal(zzbbx, paramObject.zzbbx)));
    return false;
  }

  public LocalContent[] getLocalContents()
  {
    return zzbbz;
  }

  public String getUri()
  {
    return zzbbx;
  }

  int getVersionCode()
  {
    return versionCode;
  }

  public ViewableItem[] getViewableItems()
  {
    return zzbby;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzbby, zzbbz, zzbbx });
  }

  public String toString()
  {
    return "SharedContent[viewableItems=" + Arrays.toString(zzbby) + ", localContents=" + Arrays.toString(zzbbz) + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }

  public static class Builder
  {
    private final List<LocalContent> zzbbA = new ArrayList(3);
    private ViewableItem zzbbB;

    public Builder addViewableItem(ViewableItem paramViewableItem)
    {
      if (zzbbB == null);
      for (boolean bool = true; ; bool = false)
      {
        zzv.zza(bool, "SharedContent can have at most one viewableUri");
        zzbbB = paramViewableItem;
        return this;
      }
    }

    public SharedContent build()
    {
      if ((zzbbB != null) || (!zzbbA.isEmpty()));
      for (boolean bool = true; ; bool = false)
      {
        zzv.zza(bool, "SharedContent must contain at least one of either ViewableItem or LocalContent");
        return new SharedContent(this, null);
      }
    }
  }
}