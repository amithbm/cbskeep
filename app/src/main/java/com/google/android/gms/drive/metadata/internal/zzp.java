package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class zzp extends zzj<UserMetadata>
{
  public zzp(String paramString, int paramInt)
  {
    super(paramString, zzcA(paramString), Collections.emptyList(), paramInt);
  }

  private static String zzE(String paramString1, String paramString2)
  {
    return paramString1 + "." + paramString2;
  }

  private static Collection<String> zzcA(String paramString)
  {
    return Arrays.asList(new String[] { zzE(paramString, "permissionId"), zzE(paramString, "displayName"), zzE(paramString, "picture"), zzE(paramString, "isAuthenticatedUser"), zzE(paramString, "emailAddress") });
  }
}