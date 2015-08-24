package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.util.zzj;
import com.google.android.gms.common.util.zzk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SafeParcelResponse extends FastJsonResponse
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  private final String mClassName;
  private final int mVersionCode;
  private final FieldMappingDictionary zzamV;
  private int zzanA;
  private final Parcel zzanx;
  private final int zzany;
  private int zzanz;

  SafeParcelResponse(int paramInt, Parcel paramParcel, FieldMappingDictionary paramFieldMappingDictionary)
  {
    mVersionCode = paramInt;
    zzanx = ((Parcel)zzv.zzz(paramParcel));
    zzany = 2;
    zzamV = paramFieldMappingDictionary;
    if (zzamV == null);
    for (mClassName = null; ; mClassName = zzamV.getRootClassName())
    {
      zzanz = 2;
      return;
    }
  }

  private static HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> zzE(Map<String, FastJsonResponse.Field<?, ?>> paramMap)
  {
    HashMap localHashMap = new HashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localHashMap.put(Integer.valueOf(((FastJsonResponse.Field)localEntry.getValue()).getSafeParcelableFieldId()), localEntry);
    }
    return localHashMap;
  }

  private void zza(StringBuilder paramStringBuilder, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown type = " + paramInt);
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
      paramStringBuilder.append(paramObject);
      return;
    case 7:
      paramStringBuilder.append("\"").append(zzj.zzcl(paramObject.toString())).append("\"");
      return;
    case 8:
      paramStringBuilder.append("\"").append(com.google.android.gms.common.util.zzb.zzj((byte[])paramObject)).append("\"");
      return;
    case 9:
      paramStringBuilder.append("\"").append(com.google.android.gms.common.util.zzb.zzk((byte[])paramObject));
      paramStringBuilder.append("\"");
      return;
    case 10:
      zzk.zza(paramStringBuilder, (HashMap)paramObject);
      return;
    case 11:
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }

  private void zza(StringBuilder paramStringBuilder, FastJsonResponse.Field<?, ?> paramField, Parcel paramParcel, int paramInt)
  {
    switch (paramField.getTypeOut())
    {
    default:
      throw new IllegalArgumentException("Unknown field out type = " + paramField.getTypeOut());
    case 0:
      zzb(paramStringBuilder, paramField, getOriginalValue(paramField, Integer.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, paramInt))));
      return;
    case 1:
      zzb(paramStringBuilder, paramField, getOriginalValue(paramField, com.google.android.gms.common.internal.safeparcel.zza.zzk(paramParcel, paramInt)));
      return;
    case 2:
      zzb(paramStringBuilder, paramField, getOriginalValue(paramField, Long.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzi(paramParcel, paramInt))));
      return;
    case 3:
      zzb(paramStringBuilder, paramField, getOriginalValue(paramField, Float.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzl(paramParcel, paramInt))));
      return;
    case 4:
      zzb(paramStringBuilder, paramField, getOriginalValue(paramField, Double.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzm(paramParcel, paramInt))));
      return;
    case 5:
      zzb(paramStringBuilder, paramField, getOriginalValue(paramField, com.google.android.gms.common.internal.safeparcel.zza.zzo(paramParcel, paramInt)));
      return;
    case 6:
      zzb(paramStringBuilder, paramField, getOriginalValue(paramField, Boolean.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, paramInt))));
      return;
    case 7:
      zzb(paramStringBuilder, paramField, getOriginalValue(paramField, com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, paramInt)));
      return;
    case 8:
    case 9:
      zzb(paramStringBuilder, paramField, getOriginalValue(paramField, com.google.android.gms.common.internal.safeparcel.zza.zzs(paramParcel, paramInt)));
      return;
    case 10:
      zzb(paramStringBuilder, paramField, getOriginalValue(paramField, zzm(com.google.android.gms.common.internal.safeparcel.zza.zzr(paramParcel, paramInt))));
      return;
    case 11:
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }

  private void zza(StringBuilder paramStringBuilder, String paramString, FastJsonResponse.Field<?, ?> paramField, Parcel paramParcel, int paramInt)
  {
    paramStringBuilder.append("\"").append(paramString).append("\":");
    if (paramField.hasConverter())
    {
      zza(paramStringBuilder, paramField, paramParcel, paramInt);
      return;
    }
    zzb(paramStringBuilder, paramField, paramParcel, paramInt);
  }

  private void zza(StringBuilder paramStringBuilder, Map<String, FastJsonResponse.Field<?, ?>> paramMap, Parcel paramParcel)
  {
    paramMap = zzE(paramMap);
    paramStringBuilder.append('{');
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzcQ(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzcP(paramParcel);
      Map.Entry localEntry = (Map.Entry)paramMap.get(Integer.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzeS(k)));
      if (localEntry != null)
      {
        if (i != 0)
          paramStringBuilder.append(",");
        zza(paramStringBuilder, (String)localEntry.getKey(), (FastJsonResponse.Field)localEntry.getValue(), paramParcel, k);
        i = 1;
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    paramStringBuilder.append('}');
  }

  private void zzb(StringBuilder paramStringBuilder, FastJsonResponse.Field<?, ?> paramField, Parcel paramParcel, int paramInt)
  {
    if (paramField.isTypeOutArray())
    {
      paramStringBuilder.append("[");
      switch (paramField.getTypeOut())
      {
      default:
        throw new IllegalStateException("Unknown field type out.");
      case 0:
        com.google.android.gms.common.util.zza.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zza.zzv(paramParcel, paramInt));
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      }
      while (true)
      {
        paramStringBuilder.append("]");
        return;
        com.google.android.gms.common.util.zza.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zza.zzx(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zza.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zza.zzw(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zza.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zza.zzy(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zza.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zza.zzz(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zza.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zza.zzA(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zza.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zza.zzu(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zza.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zza.zzB(paramParcel, paramInt));
        continue;
        throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
        paramParcel = com.google.android.gms.common.internal.safeparcel.zza.zzG(paramParcel, paramInt);
        int i = paramParcel.length;
        paramInt = 0;
        while (paramInt < i)
        {
          if (paramInt > 0)
            paramStringBuilder.append(",");
          paramParcel[paramInt].setDataPosition(0);
          zza(paramStringBuilder, paramField.getConcreteTypeFieldMappingFromDictionary(), paramParcel[paramInt]);
          paramInt += 1;
        }
      }
    }
    switch (paramField.getTypeOut())
    {
    default:
      throw new IllegalStateException("Unknown field type out");
    case 0:
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, paramInt));
      return;
    case 1:
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzk(paramParcel, paramInt));
      return;
    case 2:
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzi(paramParcel, paramInt));
      return;
    case 3:
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzl(paramParcel, paramInt));
      return;
    case 4:
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzm(paramParcel, paramInt));
      return;
    case 5:
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzo(paramParcel, paramInt));
      return;
    case 6:
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, paramInt));
      return;
    case 7:
      paramField = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(zzj.zzcl(paramField)).append("\"");
      return;
    case 8:
      paramField = com.google.android.gms.common.internal.safeparcel.zza.zzs(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(com.google.android.gms.common.util.zzb.zzj(paramField)).append("\"");
      return;
    case 9:
      paramField = com.google.android.gms.common.internal.safeparcel.zza.zzs(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(com.google.android.gms.common.util.zzb.zzk(paramField));
      paramStringBuilder.append("\"");
      return;
    case 10:
      paramField = com.google.android.gms.common.internal.safeparcel.zza.zzr(paramParcel, paramInt);
      paramParcel = paramField.keySet();
      paramParcel.size();
      paramStringBuilder.append("{");
      paramParcel = paramParcel.iterator();
      for (paramInt = 1; paramParcel.hasNext(); paramInt = 0)
      {
        String str = (String)paramParcel.next();
        if (paramInt == 0)
          paramStringBuilder.append(",");
        paramStringBuilder.append("\"").append(str).append("\"");
        paramStringBuilder.append(":");
        paramStringBuilder.append("\"").append(zzj.zzcl(paramField.getString(str))).append("\"");
      }
      paramStringBuilder.append("}");
      return;
    case 11:
    }
    paramParcel = com.google.android.gms.common.internal.safeparcel.zza.zzF(paramParcel, paramInt);
    paramParcel.setDataPosition(0);
    zza(paramStringBuilder, paramField.getConcreteTypeFieldMappingFromDictionary(), paramParcel);
  }

  private void zzb(StringBuilder paramStringBuilder, FastJsonResponse.Field<?, ?> paramField, Object paramObject)
  {
    if (paramField.isTypeInArray())
    {
      zzb(paramStringBuilder, paramField, (ArrayList)paramObject);
      return;
    }
    zza(paramStringBuilder, paramField.getTypeIn(), paramObject);
  }

  private void zzb(StringBuilder paramStringBuilder, FastJsonResponse.Field<?, ?> paramField, ArrayList<?> paramArrayList)
  {
    paramStringBuilder.append("[");
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (i != 0)
        paramStringBuilder.append(",");
      zza(paramStringBuilder, paramField.getTypeIn(), paramArrayList.get(i));
      i += 1;
    }
    paramStringBuilder.append("]");
  }

  public static HashMap<String, String> zzm(Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramBundle.getString(str));
    }
    return localHashMap;
  }

  public int describeContents()
  {
    zzf localzzf = CREATOR;
    return 0;
  }

  public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings()
  {
    if (zzamV == null)
      return null;
    return zzamV.getFieldMapping(mClassName);
  }

  protected Object getValueObject(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }

  public int getVersionCode()
  {
    return mVersionCode;
  }

  protected boolean isPrimitiveFieldSet(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }

  public String toString()
  {
    zzv.zzb(zzamV, "Cannot convert to JSON on client side.");
    Parcel localParcel = zzqq();
    localParcel.setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    zza(localStringBuilder, zzamV.getFieldMapping(mClassName), localParcel);
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf localzzf = CREATOR;
    zzf.zza(this, paramParcel, paramInt);
  }

  public Parcel zzqq()
  {
    switch (zzanz)
    {
    default:
    case 0:
    case 1:
    }
    while (true)
    {
      return zzanx;
      zzanA = com.google.android.gms.common.internal.safeparcel.zzb.zzcR(zzanx);
      com.google.android.gms.common.internal.safeparcel.zzb.zzJ(zzanx, zzanA);
      zzanz = 2;
      continue;
      com.google.android.gms.common.internal.safeparcel.zzb.zzJ(zzanx, zzanA);
      zzanz = 2;
    }
  }

  FieldMappingDictionary zzqr()
  {
    switch (zzany)
    {
    default:
      throw new IllegalStateException("Invalid creation type: " + zzany);
    case 0:
      return null;
    case 1:
      return zzamV;
    case 2:
    }
    return zzamV;
  }
}