package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;

public class Message
  implements SafeParcelable
{
  public static final Parcelable.Creator<Message> CREATOR = new zza();
  private final byte[] content;
  private final String type;
  final int versionCode;
  private final String zzamK;

  Message(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    if (paramArrayOfByte.length <= 102400);
    for (boolean bool = true; ; bool = false)
    {
      zzv.zzb(bool, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(102400) });
      versionCode = paramInt;
      content = ((byte[])zzv.zzz(paramArrayOfByte));
      type = ((String)zzv.zzz(paramString2));
      paramArrayOfByte = paramString1;
      if (paramString1 == null)
        paramArrayOfByte = "";
      zzamK = paramArrayOfByte;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public byte[] getContent()
  {
    return content;
  }

  public String getNamespace()
  {
    return zzamK;
  }

  public String getType()
  {
    return type;
  }

  public String toString()
  {
    return "Message{type='" + type + "'" + ", namespace='" + zzamK + "'" + ", content=[" + content.length + " bytes]" + "}";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}