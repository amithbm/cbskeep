package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ScopeDetail
  implements SafeParcelable
{
  public static final zzj CREATOR = new zzj();
  String description;
  public FACLData friendPickerData;
  final int version;
  String zzSa;
  String zzTj;
  String zzUo;
  String zzUp;
  List<String> zzUq;

  ScopeDetail(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List<String> paramList, FACLData paramFACLData)
  {
    version = paramInt;
    description = paramString1;
    zzSa = paramString2;
    zzUo = paramString3;
    zzUp = paramString4;
    zzTj = paramString5;
    zzUq = paramList;
    friendPickerData = paramFACLData;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
}