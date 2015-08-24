package com.google.android.gms.feedback;

import android.app.ApplicationErrorReport;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.ByteArrayOutputStream;

public class ErrorReport
  implements SafeParcelable
{
  public static final Parcelable.Creator<ErrorReport> CREATOR = new zza();
  public String account;
  public String anrStackTraces;
  public ApplicationErrorReport applicationErrorReport = new ApplicationErrorReport();
  public BitmapTeleporter bitmapTeleporter;
  public String board;
  public String brand;
  public String buildFingerprint;
  public String buildId;
  public String buildType;
  public String categoryTag;
  public Bundle classificationSignals;
  public String codename;

  @Deprecated
  public String color;
  public String description;
  public String device;
  public String[] eventLog;
  public String exceptionClassName;
  public String exceptionMessage;
  public boolean excludePii;
  public FileTeleporter[] fileTeleporterList;
  public String incremental;
  public boolean isCtlAllowed;
  public boolean isSilentSend;
  public String launcher;
  public String localeString;
  public LogOptions logOptions;
  public String model;
  public int networkMcc;
  public int networkMnc;
  public String networkName;
  public int networkType;
  public int packageVersion;
  public String packageVersionName;
  public int phoneType;
  public String product;
  public Bundle psdBundle;
  public String[] psdFilePaths;
  public String release;
  public String[] runningApplications;
  public String screenshot;
  public byte[] screenshotBytes;
  public int screenshotHeight;
  public String screenshotPath;
  public int screenshotWidth;
  public int sdk_int;
  public String stackTrace;
  public String submittingPackageName;
  public String suggestionSessionId;
  public boolean suggestionShown;
  public String[] systemLog;
  public ThemeSettings themeSettings;
  public String throwClassName;
  public String throwFileName;
  public int throwLineNumber;
  public String throwMethodName;
  public final int versionCode;

  public ErrorReport()
  {
    versionCode = 8;
  }

  ErrorReport(int paramInt1, ApplicationErrorReport paramApplicationErrorReport, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt3, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString14, String paramString15, byte[] paramArrayOfByte, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString16, String paramString17, String paramString18, Bundle paramBundle1, boolean paramBoolean1, int paramInt8, int paramInt9, boolean paramBoolean2, String paramString19, String paramString20, int paramInt10, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26, String paramString27, BitmapTeleporter paramBitmapTeleporter, String paramString28, FileTeleporter[] paramArrayOfFileTeleporter, String[] paramArrayOfString4, boolean paramBoolean3, String paramString29, ThemeSettings paramThemeSettings, LogOptions paramLogOptions, String paramString30, boolean paramBoolean4, Bundle paramBundle2)
  {
    versionCode = paramInt1;
    applicationErrorReport = paramApplicationErrorReport;
    description = paramString1;
    packageVersion = paramInt2;
    packageVersionName = paramString2;
    device = paramString3;
    buildId = paramString4;
    buildType = paramString5;
    model = paramString6;
    product = paramString7;
    buildFingerprint = paramString8;
    sdk_int = paramInt3;
    release = paramString9;
    incremental = paramString10;
    codename = paramString11;
    board = paramString12;
    brand = paramString13;
    runningApplications = paramArrayOfString1;
    systemLog = paramArrayOfString2;
    eventLog = paramArrayOfString3;
    anrStackTraces = paramString14;
    screenshot = paramString15;
    screenshotBytes = paramArrayOfByte;
    screenshotHeight = paramInt4;
    screenshotWidth = paramInt5;
    phoneType = paramInt6;
    networkType = paramInt7;
    networkName = paramString16;
    account = paramString17;
    localeString = paramString18;
    psdBundle = paramBundle1;
    isSilentSend = paramBoolean1;
    networkMcc = paramInt8;
    networkMnc = paramInt9;
    isCtlAllowed = paramBoolean2;
    exceptionClassName = paramString19;
    throwFileName = paramString20;
    throwLineNumber = paramInt10;
    throwClassName = paramString21;
    throwMethodName = paramString22;
    stackTrace = paramString23;
    exceptionMessage = paramString24;
    categoryTag = paramString25;
    color = paramString26;
    submittingPackageName = paramString27;
    bitmapTeleporter = paramBitmapTeleporter;
    screenshotPath = paramString28;
    fileTeleporterList = paramArrayOfFileTeleporter;
    psdFilePaths = paramArrayOfString4;
    excludePii = paramBoolean3;
    launcher = paramString29;
    themeSettings = paramThemeSettings;
    logOptions = paramLogOptions;
    suggestionSessionId = paramString30;
    suggestionShown = paramBoolean4;
    classificationSignals = paramBundle2;
  }

  private static Bitmap zza(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return Bitmap.createScaledBitmap(paramBitmap, paramInt1, paramInt2, true);
  }

  public int describeContents()
  {
    return 0;
  }

  public void setScreenshot(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
      Log.e("ErrorReport", "Bitmap is null or recycled. Cant compress. We will not attach screenshot");
    do
    {
      return;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 70, localByteArrayOutputStream);
      screenshot = Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 0);
      screenshotWidth = paramBitmap.getWidth();
      screenshotHeight = paramBitmap.getHeight();
    }
    while (screenshot.getBytes().length <= 262144);
    Log.d("ErrorReport", "Encountered large screenshot, size: " + screenshot.getBytes().length + ",  compressing further.");
    setScreenshot(zza(paramBitmap, screenshotWidth >> 1, screenshotHeight >> 1));
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}