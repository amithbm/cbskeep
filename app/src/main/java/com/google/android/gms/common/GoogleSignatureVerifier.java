package com.google.android.gms.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;
import java.util.Set;

public class GoogleSignatureVerifier
{
  private static final GoogleSignatureVerifier zzagt = new GoogleSignatureVerifier();

  public static GoogleSignatureVerifier getInstance()
  {
    return zzagt;
  }

  private boolean zza(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    if (paramPackageInfo.signatures.length != 1)
    {
      Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      return false;
    }
    zzc.zzb localzzb = new zzc.zzb(paramPackageInfo.signatures[0].toByteArray());
    if (paramBoolean);
    for (paramPackageInfo = zzc.zzol(); paramPackageInfo.contains(localzzb); paramPackageInfo = zzc.zzom())
      return true;
    if (Log.isLoggable("GoogleSignatureVerifier", 2))
      Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(localzzb.getBytes(), 0));
    return false;
  }

  public boolean isPackageGoogleSigned(PackageManager paramPackageManager, PackageInfo paramPackageInfo)
  {
    boolean bool1 = false;
    if (paramPackageInfo == null);
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        if (GooglePlayServicesUtil.honorsDebugCertificates(paramPackageManager))
          return zza(paramPackageInfo, true);
        bool2 = zza(paramPackageInfo, false);
        bool1 = bool2;
      }
      while (bool2);
      bool1 = bool2;
    }
    while (!zza(paramPackageInfo, true));
    Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
    return bool2;
  }

  public boolean isPackageGoogleSigned(PackageManager paramPackageManager, String paramString)
  {
    try
    {
      PackageInfo localPackageInfo = paramPackageManager.getPackageInfo(paramString, 64);
      return isPackageGoogleSigned(paramPackageManager, localPackageInfo);
    }
    catch (PackageManager.NameNotFoundException paramPackageManager)
    {
      if (Log.isLoggable("GoogleSignatureVerifier", 3))
        Log.d("GoogleSignatureVerifier", "Package manager can't find package " + paramString + ", defaulting to false");
    }
    return false;
  }

  public void verifyPackageIsGoogleSigned(PackageManager paramPackageManager, String paramString)
    throws SecurityException
  {
    if (!isPackageGoogleSigned(paramPackageManager, paramString))
      throw new SecurityException("Signature check failed for " + paramString);
  }

  zzc.zza zza(PackageInfo paramPackageInfo, zzc.zza[] paramArrayOfzza)
  {
    if (paramPackageInfo.signatures.length != 1)
    {
      Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      return null;
    }
    paramPackageInfo = new zzc.zzb(paramPackageInfo.signatures[0].toByteArray());
    int i = 0;
    while (i < paramArrayOfzza.length)
    {
      if (paramArrayOfzza[i].equals(paramPackageInfo))
        return paramArrayOfzza[i];
      i += 1;
    }
    if (Log.isLoggable("GoogleSignatureVerifier", 2))
      Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(paramPackageInfo.getBytes(), 0));
    return null;
  }
}