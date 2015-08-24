package com.google.android.gms.people.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.people.model.AutocompleteBuffer;
import com.google.android.gms.people.model.AutocompleteEntry;
import com.google.android.gms.people.model.AvatarReference;

public class zzb extends zzc
  implements AutocompleteEntry
{
  private final Bundle zzajg;
  private final AutocompleteBuffer zzbcS;

  public zzb(AutocompleteBuffer paramAutocompleteBuffer, DataHolder paramDataHolder, int paramInt, Bundle paramBundle)
  {
    super(paramDataHolder, paramInt);
    zzajg = paramBundle;
    zzbcS = paramAutocompleteBuffer;
  }

  public AvatarReference getAvatarReference()
  {
    String str = getString("avatar_location");
    if (TextUtils.isEmpty(str))
      return null;
    return new AvatarReference(getInteger("avatar_source"), str);
  }

  public String getPersonDisplayName()
  {
    return getString("display_name");
  }
}