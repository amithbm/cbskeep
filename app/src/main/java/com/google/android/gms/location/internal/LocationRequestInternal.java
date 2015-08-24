package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class LocationRequestInternal
  implements SafeParcelable
{
  public static final zzk CREATOR = new zzk();
  static final List<ClientIdentity> zzaTM = Collections.emptyList();
  final String mTag;
  private final int mVersionCode;
  LocationRequest zzaEr;
  boolean zzaTN;
  boolean zzaTO;
  boolean zzaTP;
  List<ClientIdentity> zzaTQ;

  LocationRequestInternal(int paramInt, LocationRequest paramLocationRequest, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<ClientIdentity> paramList, String paramString)
  {
    mVersionCode = paramInt;
    zzaEr = paramLocationRequest;
    zzaTN = paramBoolean1;
    zzaTO = paramBoolean2;
    zzaTP = paramBoolean3;
    zzaTQ = paramList;
    mTag = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LocationRequestInternal));
    do
    {
      return false;
      paramObject = (LocationRequestInternal)paramObject;
    }
    while ((!zzu.equal(zzaEr, paramObject.zzaEr)) || (zzaTN != paramObject.zzaTN) || (zzaTO != paramObject.zzaTO) || (zzaTP != paramObject.zzaTP) || (!zzu.equal(zzaTQ, paramObject.zzaTQ)));
    return true;
  }

  int getVersionCode()
  {
    return mVersionCode;
  }

  public int hashCode()
  {
    return zzaEr.hashCode();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(zzaEr.toString());
    localStringBuilder.append(" requestNlpDebugInfo=");
    localStringBuilder.append(zzaTN);
    localStringBuilder.append(" restorePendingIntentListeners=");
    localStringBuilder.append(zzaTO);
    localStringBuilder.append(" triggerUpdate=");
    localStringBuilder.append(zzaTP);
    localStringBuilder.append(" clients=");
    localStringBuilder.append(zzaTQ);
    if (mTag != null)
    {
      localStringBuilder.append(" tag=");
      localStringBuilder.append(mTag);
    }
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
}