package com.google.android.gms.feedback;

import android.app.ApplicationErrorReport;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import java.util.ArrayList;

public class zzb
  implements Parcelable.Creator<FeedbackOptions>
{
  static void zza(FeedbackOptions paramFeedbackOptions, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, mAccountInUse, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, mPsdBundle, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, mDescription, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 6, mApplicationErrorReport, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 7, mCategoryTag, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 8, mBitmapTeleporter, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 9, mPackageName, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzd(paramParcel, 10, mFileTeleporters, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 11, mExcludePii);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 12, mThemeSettings, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 13, mLogOptions, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, i);
  }

  public FeedbackOptions zzfE(Parcel paramParcel)
  {
    int j = zza.zzcQ(paramParcel);
    int i = 0;
    String str4 = null;
    Bundle localBundle = null;
    String str3 = null;
    ApplicationErrorReport localApplicationErrorReport = null;
    String str2 = null;
    BitmapTeleporter localBitmapTeleporter = null;
    String str1 = null;
    ArrayList localArrayList = null;
    boolean bool = false;
    ThemeSettings localThemeSettings = null;
    LogOptions localLogOptions = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcP(paramParcel);
      switch (zza.zzeS(k))
      {
      case 4:
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        str4 = zza.zzp(paramParcel, k);
        break;
      case 3:
        localBundle = zza.zzr(paramParcel, k);
        break;
      case 5:
        str3 = zza.zzp(paramParcel, k);
        break;
      case 6:
        localApplicationErrorReport = (ApplicationErrorReport)zza.zza(paramParcel, k, ApplicationErrorReport.CREATOR);
        break;
      case 7:
        str2 = zza.zzp(paramParcel, k);
        break;
      case 8:
        localBitmapTeleporter = (BitmapTeleporter)zza.zza(paramParcel, k, BitmapTeleporter.CREATOR);
        break;
      case 9:
        str1 = zza.zzp(paramParcel, k);
        break;
      case 10:
        localArrayList = zza.zzc(paramParcel, k, FileTeleporter.CREATOR);
        break;
      case 11:
        bool = zza.zzc(paramParcel, k);
        break;
      case 12:
        localThemeSettings = (ThemeSettings)zza.zza(paramParcel, k, ThemeSettings.CREATOR);
        break;
      case 13:
        localLogOptions = (LogOptions)zza.zza(paramParcel, k, LogOptions.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    return new FeedbackOptions(i, str4, localBundle, str3, localApplicationErrorReport, str2, localBitmapTeleporter, str1, localArrayList, bool, localThemeSettings, localLogOptions);
  }

  public FeedbackOptions[] zzid(int paramInt)
  {
    return new FeedbackOptions[paramInt];
  }
}