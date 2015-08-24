package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzv;

public class Thing
{
  final Bundle zzOS;

  Thing(Bundle paramBundle)
  {
    zzOS = paramBundle;
  }

  public Bundle zzkE()
  {
    return zzOS;
  }

  public static class Builder
  {
    final Bundle zzOT = new Bundle();

    public Thing build()
    {
      return new Thing(zzOT);
    }

    public Builder put(String paramString, Thing paramThing)
    {
      zzv.zzz(paramString);
      if (paramThing != null)
        zzOT.putParcelable(paramString, paramThing.zzOS);
      return this;
    }

    public Builder put(String paramString1, String paramString2)
    {
      zzv.zzz(paramString1);
      if (paramString2 != null)
        zzOT.putString(paramString1, paramString2);
      return this;
    }

    public Builder setName(String paramString)
    {
      zzv.zzz(paramString);
      put("name", paramString);
      return this;
    }

    public Builder setUrl(Uri paramUri)
    {
      zzv.zzz(paramUri);
      put("url", paramUri.toString());
      return this;
    }
  }
}