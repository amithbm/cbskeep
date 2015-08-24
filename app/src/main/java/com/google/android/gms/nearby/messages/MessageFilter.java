package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageFilter
  implements SafeParcelable
{
  public static final Parcelable.Creator<MessageFilter> CREATOR = new zzb();
  public static final MessageFilter INCLUDE_ALL_MY_TYPES = new zza().zzAs().zzAt();
  final int versionCode;
  private final List<MessageType> zzbaY;

  MessageFilter(int paramInt, List<MessageType> paramList)
  {
    versionCode = paramInt;
    zzbaY = Collections.unmodifiableList((List)zzv.zzz(paramList));
  }

  private MessageFilter(List<MessageType> paramList)
  {
    this(1, paramList);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof MessageFilter))
      return false;
    paramObject = (MessageFilter)paramObject;
    return zzu.equal(zzbaY, paramObject.zzbaY);
  }

  public int hashCode()
  {
    return zzu.hashCode(new Object[] { zzbaY });
  }

  public String toString()
  {
    return "MessageFilter" + zzbaY;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }

  List<MessageType> zzAr()
  {
    return zzbaY;
  }

  public static final class zza
  {
    private final List<MessageType> zzbaY = new ArrayList();

    private zza zzM(String paramString1, String paramString2)
    {
      zzbaY.add(new MessageType(paramString1, paramString2));
      return this;
    }

    public zza zzAs()
    {
      return zzM("", "");
    }

    public MessageFilter zzAt()
    {
      if (!zzbaY.isEmpty());
      for (boolean bool = true; ; bool = false)
      {
        zzv.zza(bool, "At least one of the include methods must be called.");
        return new MessageFilter(zzbaY, null);
      }
    }
  }
}