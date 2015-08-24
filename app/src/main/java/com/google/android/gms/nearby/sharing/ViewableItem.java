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

public class ViewableItem
  implements SafeParcelable
{
  public static final Parcelable.Creator<ViewableItem> CREATOR = new zze();
  private final int versionCode;
  private String[] zzbbC;

  private ViewableItem()
  {
    versionCode = 1;
  }

  ViewableItem(int paramInt, String[] paramArrayOfString)
  {
    versionCode = paramInt;
    zzbbC = paramArrayOfString;
  }

  private ViewableItem(Builder paramBuilder)
  {
    this();
    zzbbC = ((String[])Builder.zza(paramBuilder).toArray(new String[Builder.zza(paramBuilder).size()]));
  }

  public static ViewableItem forUri(Uri paramUri)
  {
    return new Builder().addUri(paramUri).build();
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if (!(paramObject instanceof ViewableItem))
      return false;
    paramObject = (ViewableItem)paramObject;
    return zzu.equal(zzbbC, paramObject.zzbbC);
  }

  public String[] getUris()
  {
    return zzbbC;
  }

  int getVersionCode()
  {
    return versionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzbbC });
  }

  public String toString()
  {
    return "ViewableItem[uris=" + Arrays.toString(zzbbC) + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }

  public static class Builder
  {
    private final List<String> zzbbD = new ArrayList();

    public Builder addUri(Uri paramUri)
    {
      zzbbD.add(paramUri.toString());
      return this;
    }

    public ViewableItem build()
    {
      if (!zzbbD.isEmpty());
      for (boolean bool = true; ; bool = false)
      {
        zzv.zza(bool, "ViewableItem needs at least one URI");
        return new ViewableItem(this, null);
      }
    }
  }
}