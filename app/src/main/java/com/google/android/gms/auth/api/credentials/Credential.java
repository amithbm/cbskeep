package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import java.util.Collections;
import java.util.List;

public class Credential
  implements SafeParcelable
{
  public static final Parcelable.Creator<Credential> CREATOR = new zza();
  private final List<IdToken> mIdTokens;
  private final String mName;
  final int mVersionCode;
  private final String zzLf;
  private final String zzQJ;
  private final String zzQK;
  private final Uri zzQL;
  private final String zzQM;
  private final String zzQN;

  Credential(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, List<IdToken> paramList, String paramString5, String paramString6)
  {
    mVersionCode = paramInt;
    zzQJ = paramString1;
    zzQK = paramString2;
    zzLf = ((String)zzv.zzz(paramString3));
    mName = paramString4;
    zzQL = paramUri;
    if (paramList == null);
    for (paramString1 = Collections.emptyList(); ; paramString1 = Collections.unmodifiableList(paramList))
    {
      mIdTokens = paramString1;
      zzQM = paramString5;
      zzQN = paramString6;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public String getAccountType()
  {
    return zzQN;
  }

  public String getId()
  {
    return zzLf;
  }

  public List<IdToken> getIdTokens()
  {
    return mIdTokens;
  }

  public String getName()
  {
    return mName;
  }

  public String getPassword()
  {
    return zzQM;
  }

  public Uri getProfilePictureUri()
  {
    return zzQL;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }

  public String zzkP()
  {
    return zzQJ;
  }

  public String zzkQ()
  {
    return zzQK;
  }
}