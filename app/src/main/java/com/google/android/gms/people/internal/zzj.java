package com.google.android.gms.people.internal;

import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.people.model.Owner;

public final class zzj extends zzc
  implements Owner
{
  public zzj(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }

  public String getAccountName()
  {
    return getString("account_name");
  }

  public String getAvatarUrl()
  {
    return zzm.zzbcV.zzdR(getString("avatar"));
  }

  public String getCoverPhotoUrl()
  {
    return zzm.zzbcV.zzdR(getString("cover_photo_url"));
  }

  public String getDisplayName()
  {
    String str2 = getString("display_name");
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = getAccountName();
    return str1;
  }

  public String getPlusPageId()
  {
    return getString("page_gaia_id");
  }
}