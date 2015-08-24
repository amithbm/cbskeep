package com.google.android.gms.drive.realtime.internal;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.Collaborator;

public class ParcelableCollaborator
  implements SafeParcelable, Collaborator
{
  public static final Parcelable.Creator<ParcelableCollaborator> CREATOR = new zzah();
  final int mVersionCode;
  final String zzFm;
  final String zzGc;
  final String zzPa;
  final boolean zzafr;
  final boolean zzazL;
  final String zzazM;
  final String zzazN;

  ParcelableCollaborator(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    mVersionCode = paramInt;
    zzazL = paramBoolean1;
    zzafr = paramBoolean2;
    zzGc = paramString1;
    zzFm = paramString2;
    zzPa = paramString3;
    zzazM = paramString4;
    zzazN = paramString5;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof ParcelableCollaborator))
      return false;
    paramObject = (ParcelableCollaborator)paramObject;
    return zzGc.equals(paramObject.zzGc);
  }

  public int getColor()
  {
    return Color.parseColor(zzazM);
  }

  public String getUserId()
  {
    return zzFm;
  }

  public int hashCode()
  {
    return zzGc.hashCode();
  }

  public String toString()
  {
    return "Collaborator [isMe=" + zzazL + ", isAnonymous=" + zzafr + ", sessionId=" + zzGc + ", userId=" + zzFm + ", displayName=" + zzPa + ", color=" + zzazM + ", photoUrl=" + zzazN + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzah.zza(this, paramParcel, paramInt);
  }
}