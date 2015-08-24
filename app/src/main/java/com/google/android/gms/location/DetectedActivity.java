package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Comparator;

public class DetectedActivity
  implements SafeParcelable
{
  public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();
  public static final Comparator<DetectedActivity> zzaQT = new Comparator()
  {
    public int zza(DetectedActivity paramAnonymousDetectedActivity1, DetectedActivity paramAnonymousDetectedActivity2)
    {
      int j = Integer.valueOf(paramAnonymousDetectedActivity2.getConfidence()).compareTo(Integer.valueOf(paramAnonymousDetectedActivity1.getConfidence()));
      int i = j;
      if (j == 0)
        i = Integer.valueOf(paramAnonymousDetectedActivity1.getType()).compareTo(Integer.valueOf(paramAnonymousDetectedActivity2.getType()));
      return i;
    }
  };
  private final int mVersionCode;
  int zzaQU;
  int zzaQV;

  public DetectedActivity(int paramInt1, int paramInt2, int paramInt3)
  {
    mVersionCode = paramInt1;
    zzaQU = paramInt2;
    zzaQV = paramInt3;
  }

  private int zzkE(int paramInt)
  {
    int i = paramInt;
    if (paramInt > 15)
      i = 4;
    return i;
  }

  public static String zzkF(int paramInt)
  {
    switch (paramInt)
    {
    case 6:
    default:
      return Integer.toString(paramInt);
    case 0:
      return "IN_VEHICLE";
    case 1:
      return "ON_BICYCLE";
    case 2:
      return "ON_FOOT";
    case 3:
      return "STILL";
    case 4:
      return "UNKNOWN";
    case 5:
      return "TILTING";
    case 7:
      return "WALKING";
    case 8:
    }
    return "RUNNING";
  }

  public int describeContents()
  {
    return 0;
  }

  public int getConfidence()
  {
    return zzaQV;
  }

  public int getType()
  {
    return zzkE(zzaQU);
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  public String toString()
  {
    return "DetectedActivity [type=" + zzkF(getType()) + ", confidence=" + zzaQV + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    DetectedActivityCreator.zza(this, paramParcel, paramInt);
  }
}