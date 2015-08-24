package com.google.android.gms.googlehelp;

import android.accounts.Account;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.feedback.ErrorReport;
import com.google.android.gms.feedback.ThemeSettings;
import com.google.android.gms.googlehelp.internal.common.OverflowMenuItem;
import com.google.android.gms.googlehelp.internal.common.TogglingData;
import java.util.ArrayList;

public class zzb
  implements Parcelable.Creator<GoogleHelp>
{
  static void zza(GoogleHelp paramGoogleHelp, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, zzaNZ, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, zzaOa, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, mPsdBundle, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, zzaOe);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 6, zzaOf);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 7, zzaOg, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 10, zzaOh, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 11, zzaOi, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 14, zzaOm, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 15, zzaOn, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 17, zzaOp);
    com.google.android.gms.common.internal.safeparcel.zzb.zzd(paramParcel, 16, zzaOo, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 19, zzaOj, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzd(paramParcel, 18, zzaOq, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 21, zzaOl);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 20, zzaOk);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 23, zzaOs, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 22, zzaOr);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 25, mThemeSettings, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 29, zzaOc);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 28, zzaOb, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 31, zzaOt, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 30, zzaOd);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 32, zzaOu);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 33, zzaOv, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzJ(paramParcel, i);
  }

  public GoogleHelp zzhz(Parcel paramParcel)
  {
    int i3 = zza.zzcQ(paramParcel);
    int i2 = 0;
    String str3 = null;
    Account localAccount = null;
    Bundle localBundle2 = null;
    String str2 = null;
    int i1 = 0;
    int n = 0;
    boolean bool3 = false;
    boolean bool2 = false;
    ArrayList localArrayList3 = null;
    Bundle localBundle1 = null;
    Bitmap localBitmap = null;
    byte[] arrayOfByte = null;
    int m = 0;
    int k = 0;
    String str1 = null;
    Uri localUri = null;
    ArrayList localArrayList2 = null;
    int j = 0;
    ThemeSettings localThemeSettings = null;
    ArrayList localArrayList1 = null;
    boolean bool1 = false;
    ErrorReport localErrorReport = null;
    TogglingData localTogglingData = null;
    int i = 0;
    PendingIntent localPendingIntent = null;
    while (paramParcel.dataPosition() < i3)
    {
      int i4 = zza.zzcP(paramParcel);
      switch (zza.zzeS(i4))
      {
      case 8:
      case 9:
      case 12:
      case 13:
      case 24:
      case 26:
      case 27:
      default:
        zza.zzb(paramParcel, i4);
        break;
      case 1:
        i2 = zza.zzg(paramParcel, i4);
        break;
      case 2:
        str3 = zza.zzp(paramParcel, i4);
        break;
      case 3:
        localAccount = (Account)zza.zza(paramParcel, i4, Account.CREATOR);
        break;
      case 4:
        localBundle2 = zza.zzr(paramParcel, i4);
        break;
      case 5:
        bool3 = zza.zzc(paramParcel, i4);
        break;
      case 6:
        bool2 = zza.zzc(paramParcel, i4);
        break;
      case 7:
        localArrayList3 = zza.zzE(paramParcel, i4);
        break;
      case 10:
        localBundle1 = zza.zzr(paramParcel, i4);
        break;
      case 11:
        localBitmap = (Bitmap)zza.zza(paramParcel, i4, Bitmap.CREATOR);
        break;
      case 14:
        str1 = zza.zzp(paramParcel, i4);
        break;
      case 15:
        localUri = (Uri)zza.zza(paramParcel, i4, Uri.CREATOR);
        break;
      case 17:
        j = zza.zzg(paramParcel, i4);
        break;
      case 16:
        localArrayList2 = zza.zzc(paramParcel, i4, OverflowMenuItem.CREATOR);
        break;
      case 19:
        arrayOfByte = zza.zzs(paramParcel, i4);
        break;
      case 18:
        localArrayList1 = zza.zzc(paramParcel, i4, OfflineSuggestion.CREATOR);
        break;
      case 21:
        k = zza.zzg(paramParcel, i4);
        break;
      case 20:
        m = zza.zzg(paramParcel, i4);
        break;
      case 23:
        localErrorReport = (ErrorReport)zza.zza(paramParcel, i4, ErrorReport.CREATOR);
        break;
      case 22:
        bool1 = zza.zzc(paramParcel, i4);
        break;
      case 25:
        localThemeSettings = (ThemeSettings)zza.zza(paramParcel, i4, ThemeSettings.CREATOR);
        break;
      case 29:
        i1 = zza.zzg(paramParcel, i4);
        break;
      case 28:
        str2 = zza.zzp(paramParcel, i4);
        break;
      case 31:
        localTogglingData = (TogglingData)zza.zza(paramParcel, i4, TogglingData.CREATOR);
        break;
      case 30:
        n = zza.zzg(paramParcel, i4);
        break;
      case 32:
        i = zza.zzg(paramParcel, i4);
        break;
      case 33:
        localPendingIntent = (PendingIntent)zza.zza(paramParcel, i4, PendingIntent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i3)
      throw new zza.zza("Overread allowed size end=" + i3, paramParcel);
    return new GoogleHelp(i2, str3, localAccount, localBundle2, str2, i1, n, bool3, bool2, localArrayList3, localBundle1, localBitmap, arrayOfByte, m, k, str1, localUri, localArrayList2, j, localThemeSettings, localArrayList1, bool1, localErrorReport, localTogglingData, i, localPendingIntent);
  }

  public GoogleHelp[] zzks(int paramInt)
  {
    return new GoogleHelp[paramInt];
  }
}