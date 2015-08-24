package com.google.android.gms.feedback;

import android.app.ApplicationErrorReport;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<ErrorReport>
{
  static void zza(ErrorReport paramErrorReport, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcR(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, applicationErrorReport, paramInt, false);
    zzb.zza(paramParcel, 3, description, false);
    zzb.zzc(paramParcel, 4, packageVersion);
    zzb.zza(paramParcel, 5, packageVersionName, false);
    zzb.zza(paramParcel, 6, device, false);
    zzb.zza(paramParcel, 7, buildId, false);
    zzb.zza(paramParcel, 8, buildType, false);
    zzb.zza(paramParcel, 9, model, false);
    zzb.zza(paramParcel, 10, product, false);
    zzb.zza(paramParcel, 11, buildFingerprint, false);
    zzb.zzc(paramParcel, 12, sdk_int);
    zzb.zza(paramParcel, 13, release, false);
    zzb.zza(paramParcel, 14, incremental, false);
    zzb.zza(paramParcel, 15, codename, false);
    zzb.zza(paramParcel, 17, brand, false);
    zzb.zza(paramParcel, 16, board, false);
    zzb.zza(paramParcel, 19, systemLog, false);
    zzb.zza(paramParcel, 18, runningApplications, false);
    zzb.zza(paramParcel, 21, anrStackTraces, false);
    zzb.zza(paramParcel, 20, eventLog, false);
    zzb.zza(paramParcel, 23, screenshotBytes, false);
    zzb.zza(paramParcel, 22, screenshot, false);
    zzb.zzc(paramParcel, 25, screenshotWidth);
    zzb.zzc(paramParcel, 24, screenshotHeight);
    zzb.zzc(paramParcel, 27, networkType);
    zzb.zzc(paramParcel, 26, phoneType);
    zzb.zza(paramParcel, 29, account, false);
    zzb.zza(paramParcel, 28, networkName, false);
    zzb.zza(paramParcel, 31, psdBundle, false);
    zzb.zza(paramParcel, 30, localeString, false);
    zzb.zzc(paramParcel, 34, networkMnc);
    zzb.zza(paramParcel, 35, isCtlAllowed);
    zzb.zza(paramParcel, 32, isSilentSend);
    zzb.zzc(paramParcel, 33, networkMcc);
    zzb.zzc(paramParcel, 38, throwLineNumber);
    zzb.zza(paramParcel, 39, throwClassName, false);
    zzb.zza(paramParcel, 36, exceptionClassName, false);
    zzb.zza(paramParcel, 37, throwFileName, false);
    zzb.zza(paramParcel, 42, exceptionMessage, false);
    zzb.zza(paramParcel, 43, categoryTag, false);
    zzb.zza(paramParcel, 40, throwMethodName, false);
    zzb.zza(paramParcel, 41, stackTrace, false);
    zzb.zza(paramParcel, 46, bitmapTeleporter, paramInt, false);
    zzb.zza(paramParcel, 47, screenshotPath, false);
    zzb.zza(paramParcel, 44, color, false);
    zzb.zza(paramParcel, 45, submittingPackageName, false);
    zzb.zza(paramParcel, 51, launcher, false);
    zzb.zza(paramParcel, 50, excludePii);
    zzb.zza(paramParcel, 49, psdFilePaths, false);
    zzb.zza(paramParcel, 48, fileTeleporterList, paramInt, false);
    zzb.zza(paramParcel, 55, suggestionShown);
    zzb.zza(paramParcel, 54, suggestionSessionId, false);
    zzb.zza(paramParcel, 53, logOptions, paramInt, false);
    zzb.zza(paramParcel, 52, themeSettings, paramInt, false);
    zzb.zza(paramParcel, 56, classificationSignals, false);
    zzb.zzJ(paramParcel, i);
  }

  public ErrorReport zzfD(Parcel paramParcel)
  {
    int i6 = com.google.android.gms.common.internal.safeparcel.zza.zzcQ(paramParcel);
    int i5 = 0;
    ApplicationErrorReport localApplicationErrorReport = null;
    String str30 = null;
    int i4 = 0;
    String str29 = null;
    String str28 = null;
    String str27 = null;
    String str26 = null;
    String str25 = null;
    String str24 = null;
    String str23 = null;
    int i3 = 0;
    String str22 = null;
    String str21 = null;
    String str20 = null;
    String str19 = null;
    String str18 = null;
    String[] arrayOfString4 = null;
    String[] arrayOfString3 = null;
    String[] arrayOfString2 = null;
    String str17 = null;
    String str16 = null;
    byte[] arrayOfByte = null;
    int i2 = 0;
    int i1 = 0;
    int n = 0;
    int m = 0;
    String str15 = null;
    String str14 = null;
    String str13 = null;
    Bundle localBundle2 = null;
    boolean bool4 = false;
    int k = 0;
    int j = 0;
    boolean bool3 = false;
    String str12 = null;
    String str11 = null;
    int i = 0;
    String str10 = null;
    String str9 = null;
    String str8 = null;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    BitmapTeleporter localBitmapTeleporter = null;
    String str3 = null;
    FileTeleporter[] arrayOfFileTeleporter = null;
    String[] arrayOfString1 = null;
    boolean bool2 = false;
    String str2 = null;
    ThemeSettings localThemeSettings = null;
    LogOptions localLogOptions = null;
    String str1 = null;
    boolean bool1 = false;
    Bundle localBundle1 = null;
    while (paramParcel.dataPosition() < i6)
    {
      int i7 = com.google.android.gms.common.internal.safeparcel.zza.zzcP(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzeS(i7))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, i7);
        break;
      case 1:
        i5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, i7);
        break;
      case 2:
        localApplicationErrorReport = (ApplicationErrorReport)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, i7, ApplicationErrorReport.CREATOR);
        break;
      case 3:
        str30 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 4:
        i4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, i7);
        break;
      case 5:
        str29 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 6:
        str28 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 7:
        str27 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 8:
        str26 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 9:
        str25 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 10:
        str24 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 11:
        str23 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 12:
        i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, i7);
        break;
      case 13:
        str22 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 14:
        str21 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 15:
        str20 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 17:
        str18 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 16:
        str19 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 19:
        arrayOfString3 = com.google.android.gms.common.internal.safeparcel.zza.zzB(paramParcel, i7);
        break;
      case 18:
        arrayOfString4 = com.google.android.gms.common.internal.safeparcel.zza.zzB(paramParcel, i7);
        break;
      case 21:
        str17 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 20:
        arrayOfString2 = com.google.android.gms.common.internal.safeparcel.zza.zzB(paramParcel, i7);
        break;
      case 23:
        arrayOfByte = com.google.android.gms.common.internal.safeparcel.zza.zzs(paramParcel, i7);
        break;
      case 22:
        str16 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 25:
        i1 = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, i7);
        break;
      case 24:
        i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, i7);
        break;
      case 27:
        m = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, i7);
        break;
      case 26:
        n = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, i7);
        break;
      case 29:
        str14 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 28:
        str15 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 31:
        localBundle2 = com.google.android.gms.common.internal.safeparcel.zza.zzr(paramParcel, i7);
        break;
      case 30:
        str13 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 34:
        j = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, i7);
        break;
      case 35:
        bool3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, i7);
        break;
      case 32:
        bool4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, i7);
        break;
      case 33:
        k = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, i7);
        break;
      case 38:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, i7);
        break;
      case 39:
        str10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 36:
        str12 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 37:
        str11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 42:
        str7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 43:
        str6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 40:
        str9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 41:
        str8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 46:
        localBitmapTeleporter = (BitmapTeleporter)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, i7, BitmapTeleporter.CREATOR);
        break;
      case 47:
        str3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 44:
        str5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 45:
        str4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 51:
        str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 50:
        bool2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, i7);
        break;
      case 49:
        arrayOfString1 = com.google.android.gms.common.internal.safeparcel.zza.zzB(paramParcel, i7);
        break;
      case 48:
        arrayOfFileTeleporter = (FileTeleporter[])com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, i7, FileTeleporter.CREATOR);
        break;
      case 55:
        bool1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, i7);
        break;
      case 54:
        str1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i7);
        break;
      case 53:
        localLogOptions = (LogOptions)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, i7, LogOptions.CREATOR);
        break;
      case 52:
        localThemeSettings = (ThemeSettings)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, i7, ThemeSettings.CREATOR);
        break;
      case 56:
        localBundle1 = com.google.android.gms.common.internal.safeparcel.zza.zzr(paramParcel, i7);
      }
    }
    if (paramParcel.dataPosition() != i6)
      throw new zza.zza("Overread allowed size end=" + i6, paramParcel);
    return new ErrorReport(i5, localApplicationErrorReport, str30, i4, str29, str28, str27, str26, str25, str24, str23, i3, str22, str21, str20, str19, str18, arrayOfString4, arrayOfString3, arrayOfString2, str17, str16, arrayOfByte, i2, i1, n, m, str15, str14, str13, localBundle2, bool4, k, j, bool3, str12, str11, i, str10, str9, str8, str7, str6, str5, str4, localBitmapTeleporter, str3, arrayOfFileTeleporter, arrayOfString1, bool2, str2, localThemeSettings, localLogOptions, str1, bool1, localBundle1);
  }

  public ErrorReport[] zzic(int paramInt)
  {
    return new ErrorReport[paramInt];
  }
}