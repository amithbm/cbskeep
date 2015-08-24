package com.google.android.gms.location.copresence;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzv;
import java.util.Arrays;

public final class Message
  implements SafeParcelable
{
  public static final Parcelable.Creator<Message> CREATOR = new zzg();
  private final int mVersionCode;
  private final String zzEK;
  private final byte[] zzaSe;
  private final String zzadp;

  Message(int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    mVersionCode = paramInt;
    String str = paramString1;
    if (paramString1 == null)
      str = "";
    zzadp = str;
    paramString1 = paramString2;
    if (paramString2 == null)
      paramString1 = "";
    zzEK = paramString1;
    zzaSe = ((byte[])zzv.zzz(paramArrayOfByte));
    if (paramArrayOfByte.length <= 102400);
    for (boolean bool = true; ; bool = false)
    {
      zzv.zza(bool, "Payloads may be at most 102400 bytes");
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if (!(paramObject instanceof Message))
        return false;
      paramObject = (Message)paramObject;
    }
    while ((TextUtils.equals(zzEK, paramObject.zzEK)) && (Arrays.equals(zzaSe, paramObject.zzaSe)));
    return false;
  }

  public String getNamespace()
  {
    return zzadp;
  }

  public byte[] getPayload()
  {
    return zzaSe;
  }

  public String getType()
  {
    return zzEK;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzEK, Integer.valueOf(Arrays.hashCode(zzaSe)) });
  }

  public String toString()
  {
    return "Message[" + zzEK + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}