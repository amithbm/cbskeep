package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzv;

public final class Action extends Thing
{
  private Action(Bundle paramBundle)
  {
    super(paramBundle);
  }

  public static final class Builder extends Thing.Builder
  {
    public Builder(String paramString)
    {
      zzv.zzz(paramString);
      super.put("type", paramString);
    }

    public Action build()
    {
      zzv.zzb(zzOT.get("object"), "setObject is required before calling build().");
      zzv.zzb(zzOT.get("type"), "setType is required before calling build().");
      Bundle localBundle = (Bundle)zzOT.getParcelable("object");
      zzv.zzb(localBundle.get("name"), "Must call setObject() with a valid name. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
      zzv.zzb(localBundle.get("url"), "Must call setObject() with a valid app URI. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
      return new Action(zzOT, null);
    }

    public Builder put(String paramString, Thing paramThing)
    {
      return (Builder)super.put(paramString, paramThing);
    }

    public Builder put(String paramString1, String paramString2)
    {
      return (Builder)super.put(paramString1, paramString2);
    }

    public Builder setAccountName(String paramString)
    {
      zzv.zzz(paramString);
      return (Builder)super.put(".private:accountName", paramString);
    }

    public Builder setActionStatus(String paramString)
    {
      zzv.zzz(paramString);
      return (Builder)super.put("actionStatus", paramString);
    }

    public Builder setContextOnly(boolean paramBoolean)
    {
      zzOT.putBoolean(".private:isContextOnly", paramBoolean);
      return this;
    }

    public Builder setName(String paramString)
    {
      return (Builder)super.put("name", paramString);
    }

    public Builder setObject(Thing paramThing)
    {
      zzv.zzz(paramThing);
      return (Builder)super.put("object", paramThing);
    }

    public Builder setUrl(Uri paramUri)
    {
      if (paramUri != null)
        super.put("url", paramUri.toString());
      return this;
    }
  }
}