package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.AncsNotification;

public class AncsNotificationParcelable
  implements SafeParcelable, AncsNotification
{
  public static final Parcelable.Creator<AncsNotificationParcelable> CREATOR = new zze();
  private int mId;
  final int mVersionCode;
  private String zzPa;
  private final String zzaGi;
  private final String zzaZW;
  private final String zzaaG;
  private final String zzasJ;
  private final String zzbGT;
  private byte zzbGU;
  private byte zzbGV;
  private byte zzbGW;
  private byte zzbGX;

  AncsNotificationParcelable(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    mId = paramInt2;
    mVersionCode = paramInt1;
    zzaZW = paramString1;
    zzbGT = paramString2;
    zzaaG = paramString3;
    zzasJ = paramString4;
    zzaGi = paramString5;
    zzPa = paramString6;
    zzbGU = paramByte1;
    zzbGV = paramByte2;
    zzbGW = paramByte3;
    zzbGX = paramByte4;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      paramObject = (AncsNotificationParcelable)paramObject;
      if (zzbGX != paramObject.zzbGX)
        return false;
      if (zzbGW != paramObject.zzbGW)
        return false;
      if (zzbGV != paramObject.zzbGV)
        return false;
      if (zzbGU != paramObject.zzbGU)
        return false;
      if (mId != paramObject.mId)
        return false;
      if (mVersionCode != paramObject.mVersionCode)
        return false;
      if (!zzaZW.equals(paramObject.zzaZW))
        return false;
      if (zzbGT != null)
      {
        if (zzbGT.equals(paramObject.zzbGT));
      }
      else
        while (paramObject.zzbGT != null)
          return false;
      if (!zzPa.equals(paramObject.zzPa))
        return false;
      if (!zzaaG.equals(paramObject.zzaaG))
        return false;
      if (!zzaGi.equals(paramObject.zzaGi))
        return false;
    }
    while (zzasJ.equals(paramObject.zzasJ));
    return false;
  }

  public String getAppId()
  {
    return zzaZW;
  }

  public byte getCategoryCount()
  {
    return zzbGX;
  }

  public byte getCategoryId()
  {
    return zzbGW;
  }

  public String getDateTime()
  {
    return zzbGT;
  }

  public String getDisplayName()
  {
    if (zzPa == null)
      return zzaZW;
    return zzPa;
  }

  public byte getEventFlags()
  {
    return zzbGV;
  }

  public byte getEventId()
  {
    return zzbGU;
  }

  public int getId()
  {
    return mId;
  }

  public String getNotificationText()
  {
    return zzaaG;
  }

  public String getSubtitle()
  {
    return zzaGi;
  }

  public String getTitle()
  {
    return zzasJ;
  }

  public int hashCode()
  {
    int j = mVersionCode;
    int k = mId;
    int m = zzaZW.hashCode();
    if (zzbGT != null);
    for (int i = zzbGT.hashCode(); ; i = 0)
      return ((((((((i + ((j * 31 + k) * 31 + m) * 31) * 31 + zzaaG.hashCode()) * 31 + zzasJ.hashCode()) * 31 + zzaGi.hashCode()) * 31 + zzPa.hashCode()) * 31 + zzbGU) * 31 + zzbGV) * 31 + zzbGW) * 31 + zzbGX;
  }

  public String toString()
  {
    return "AncsNotificationParcelable{mVersionCode=" + mVersionCode + ", mId=" + mId + ", mAppId='" + zzaZW + '\'' + ", mDateTime='" + zzbGT + '\'' + ", mNotificationText='" + zzaaG + '\'' + ", mTitle='" + zzasJ + '\'' + ", mSubtitle='" + zzaGi + '\'' + ", mDisplayName='" + zzPa + '\'' + ", mEventId=" + zzbGU + ", mEventFlags=" + zzbGV + ", mCategoryId=" + zzbGW + ", mCategoryCount=" + zzbGX + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}