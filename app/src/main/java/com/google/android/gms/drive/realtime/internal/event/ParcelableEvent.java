package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableEvent> CREATOR = new zzc();
  final int mVersionCode;
  final String zzFm;
  final String zzGc;
  final ObjectChangedDetails zzaAA;
  final FieldChangedDetails zzaAB;
  final String zzaAs;
  final TextInsertedDetails zzaAt;
  final TextDeletedDetails zzaAu;
  final ValuesAddedDetails zzaAv;
  final ValuesRemovedDetails zzaAw;
  final ValuesSetDetails zzaAx;
  final ValueChangedDetails zzaAy;
  final ReferenceShiftedDetails zzaAz;
  final boolean zzayA;
  final List<String> zzayB;
  final boolean zzayy;
  final boolean zzayz;
  final String zzazO;

  ParcelableEvent(int paramInt, String paramString1, String paramString2, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3, String paramString4, TextInsertedDetails paramTextInsertedDetails, TextDeletedDetails paramTextDeletedDetails, ValuesAddedDetails paramValuesAddedDetails, ValuesRemovedDetails paramValuesRemovedDetails, ValuesSetDetails paramValuesSetDetails, ValueChangedDetails paramValueChangedDetails, ReferenceShiftedDetails paramReferenceShiftedDetails, ObjectChangedDetails paramObjectChangedDetails, FieldChangedDetails paramFieldChangedDetails)
  {
    mVersionCode = paramInt;
    zzGc = paramString1;
    zzFm = paramString2;
    zzayB = paramList;
    zzayy = paramBoolean1;
    zzayz = paramBoolean2;
    zzayA = paramBoolean3;
    zzazO = paramString3;
    zzaAs = paramString4;
    zzaAt = paramTextInsertedDetails;
    zzaAu = paramTextDeletedDetails;
    zzaAv = paramValuesAddedDetails;
    zzaAw = paramValuesRemovedDetails;
    zzaAx = paramValuesSetDetails;
    zzaAy = paramValueChangedDetails;
    zzaAz = paramReferenceShiftedDetails;
    zzaAA = paramObjectChangedDetails;
    zzaAB = paramFieldChangedDetails;
  }

  public int describeContents()
  {
    return 0;
  }

  public List<String> getCompoundOperationNames()
  {
    return zzayB;
  }

  public String getObjectId()
  {
    return zzazO;
  }

  public String getSessionId()
  {
    return zzGc;
  }

  public String getUserId()
  {
    return zzFm;
  }

  public boolean isLocal()
  {
    return zzayy;
  }

  public boolean isRedo()
  {
    return zzayA;
  }

  public boolean isUndo()
  {
    return zzayz;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }

  public String zztY()
  {
    return zzaAs;
  }

  public TextInsertedDetails zztZ()
  {
    return zzaAt;
  }

  public TextDeletedDetails zzua()
  {
    return zzaAu;
  }

  public ValuesAddedDetails zzub()
  {
    return zzaAv;
  }

  public ValuesRemovedDetails zzuc()
  {
    return zzaAw;
  }

  public ValuesSetDetails zzud()
  {
    return zzaAx;
  }

  public ValueChangedDetails zzue()
  {
    return zzaAy;
  }

  public ReferenceShiftedDetails zzuf()
  {
    return zzaAz;
  }

  public ObjectChangedDetails zzug()
  {
    return zzaAA;
  }

  public FieldChangedDetails zzuh()
  {
    return zzaAB;
  }
}