package com.google.android.gms.googlehelp;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import android.view.View;
import android.view.Window;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.feedback.ErrorReport;
import com.google.android.gms.feedback.ThemeSettings;
import com.google.android.gms.googlehelp.internal.common.OverflowMenuItem;
import com.google.android.gms.googlehelp.internal.common.TogglingData;
import java.util.ArrayList;
import java.util.List;

public final class GoogleHelp
  implements SafeParcelable
{
  public static final Parcelable.Creator<GoogleHelp> CREATOR = new zzb();
  Bundle mPsdBundle;
  ThemeSettings mThemeSettings;
  final int mVersionCode;
  private Bitmap zzaBu;
  String zzaNZ;
  Account zzaOa;
  String zzaOb;
  int zzaOc;
  int zzaOd;
  boolean zzaOe;
  boolean zzaOf;
  List<String> zzaOg;

  @Deprecated
  Bundle zzaOh;

  @Deprecated
  Bitmap zzaOi;

  @Deprecated
  byte[] zzaOj;

  @Deprecated
  int zzaOk;

  @Deprecated
  int zzaOl;
  String zzaOm;
  Uri zzaOn;
  List<OverflowMenuItem> zzaOo;

  @Deprecated
  int zzaOp;
  List<OfflineSuggestion> zzaOq;
  boolean zzaOr;
  ErrorReport zzaOs = new ErrorReport();
  TogglingData zzaOt;
  int zzaOu;
  PendingIntent zzaOv;

  GoogleHelp(int paramInt1, String paramString1, Account paramAccount, Bundle paramBundle1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, List<String> paramList, Bundle paramBundle2, Bitmap paramBitmap, byte[] paramArrayOfByte, int paramInt4, int paramInt5, String paramString3, Uri paramUri, List<OverflowMenuItem> paramList1, int paramInt6, ThemeSettings paramThemeSettings, List<OfflineSuggestion> paramList2, boolean paramBoolean3, ErrorReport paramErrorReport, TogglingData paramTogglingData, int paramInt7, PendingIntent paramPendingIntent)
  {
    mVersionCode = paramInt1;
    zzaNZ = paramString1;
    zzaOa = paramAccount;
    mPsdBundle = paramBundle1;
    zzaOb = paramString2;
    zzaOc = paramInt2;
    zzaOd = paramInt3;
    zzaOe = paramBoolean1;
    zzaOf = paramBoolean2;
    zzaOg = paramList;
    zzaOv = paramPendingIntent;
    zzaOh = paramBundle2;
    zzaOi = paramBitmap;
    zzaOj = paramArrayOfByte;
    zzaOk = paramInt4;
    zzaOl = paramInt5;
    zzaOm = paramString3;
    zzaOn = paramUri;
    zzaOo = paramList1;
    if (mVersionCode < 4);
    for (mThemeSettings = new ThemeSettings().setTheme(paramInt6); ; mThemeSettings = paramString1)
    {
      zzaOq = paramList2;
      zzaOr = paramBoolean3;
      zzaOs = paramErrorReport;
      if (zzaOs != null)
        zzaOs.launcher = "GoogleHelp";
      zzaOt = paramTogglingData;
      zzaOu = paramInt7;
      return;
      paramString1 = paramThemeSettings;
      if (paramThemeSettings == null)
        paramString1 = new ThemeSettings();
    }
  }

  public GoogleHelp(String paramString)
  {
    this(7, paramString, null, null, null, 0, 0, true, true, new ArrayList(), null, null, null, 0, 0, null, null, new ArrayList(), 0, null, new ArrayList(), false, new ErrorReport(), null, 0, null);
  }

  public static Bitmap getScreenshot(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getWindow().getDecorView().getRootView();
      Bitmap localBitmap = Bitmap.createBitmap(paramActivity.getWidth(), paramActivity.getHeight(), Bitmap.Config.ARGB_8888);
      paramActivity.draw(new Canvas(localBitmap));
      return localBitmap;
    }
    catch (Exception paramActivity)
    {
      Log.w("GOOGLEHELP_GoogleHelp", "Get screenshot failed!", paramActivity);
    }
    return null;
  }

  public static GoogleHelp newInstance(String paramString)
  {
    return new GoogleHelp(paramString);
  }

  public Intent buildHelpIntent()
  {
    return new Intent("com.google.android.gms.googlehelp.HELP").setPackage("com.google.android.gms").putExtra("EXTRA_GOOGLE_HELP", this);
  }

  @Deprecated
  public Intent buildHelpIntent(Context paramContext)
  {
    return buildHelpIntent();
  }

  public int describeContents()
  {
    return 0;
  }

  public Uri getFallbackSupportUri()
  {
    return zzaOn;
  }

  public TogglingData getTogglingData()
  {
    return zzaOt;
  }

  public GoogleHelp setGoogleAccount(Account paramAccount)
  {
    zzaOa = paramAccount;
    return this;
  }

  @Deprecated
  public GoogleHelp setScreenshot(Bitmap paramBitmap)
  {
    zzaBu = paramBitmap;
    Log.w("GOOGLEHELP_GoogleHelp", "This method to attach screenshot stands deprecated and will be removed in time.Use of this method may cause TransactionTooLarge exceptions. Please use feedback options to attach screenshot.");
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if ((zzaBu != null) && (zzaOs.bitmapTeleporter == null))
      zzaOs.setScreenshot(zzaBu);
    zzb.zza(this, paramParcel, paramInt);
  }
}