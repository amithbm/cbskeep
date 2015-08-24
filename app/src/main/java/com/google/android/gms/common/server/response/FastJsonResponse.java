package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.util.zzb;
import com.google.android.gms.common.util.zzj;
import com.google.android.gms.common.util.zzk;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class FastJsonResponse
{
  private void zza(StringBuilder paramStringBuilder, Field paramField, Object paramObject)
  {
    if (paramField.getTypeIn() == 11)
    {
      paramStringBuilder.append(((FastJsonResponse)paramField.getConcreteType().cast(paramObject)).toString());
      return;
    }
    if (paramField.getTypeIn() == 7)
    {
      paramStringBuilder.append("\"");
      paramStringBuilder.append(zzj.zzcl((String)paramObject));
      paramStringBuilder.append("\"");
      return;
    }
    paramStringBuilder.append(paramObject);
  }

  private void zza(StringBuilder paramStringBuilder, Field paramField, ArrayList<Object> paramArrayList)
  {
    paramStringBuilder.append("[");
    int i = 0;
    int j = paramArrayList.size();
    while (i < j)
    {
      if (i > 0)
        paramStringBuilder.append(",");
      Object localObject = paramArrayList.get(i);
      if (localObject != null)
        zza(paramStringBuilder, paramField, localObject);
      i += 1;
    }
    paramStringBuilder.append("]");
  }

  public HashMap<String, Object> getConcreteTypeArrays()
  {
    return null;
  }

  public HashMap<String, Object> getConcreteTypes()
  {
    return null;
  }

  public abstract Map<String, Field<?, ?>> getFieldMappings();

  protected Object getFieldValue(Field paramField)
  {
    String str = paramField.getOutputFieldName();
    if (paramField.getConcreteType() != null)
    {
      boolean bool;
      if (getValueObject(paramField.getOutputFieldName()) == null)
      {
        bool = true;
        zzv.zza(bool, "Concrete field shouldn't be value object: %s", new Object[] { paramField.getOutputFieldName() });
        if (!paramField.isTypeOutArray())
          break label71;
      }
      label71: for (paramField = getConcreteTypeArrays(); ; paramField = getConcreteTypes())
      {
        if (paramField == null)
          break label79;
        return paramField.get(str);
        bool = false;
        break;
      }
      try
      {
        label79: paramField = "get" + Character.toUpperCase(str.charAt(0)) + str.substring(1);
        paramField = getClass().getMethod(paramField, new Class[0]).invoke(this, new Object[0]);
        return paramField;
      }
      catch (Exception paramField)
      {
        throw new RuntimeException(paramField);
      }
    }
    return getValueObject(paramField.getOutputFieldName());
  }

  protected <O, I> I getOriginalValue(Field<I, O> paramField, Object paramObject)
  {
    Object localObject = paramObject;
    if (Field.zza(paramField) != null)
      localObject = paramField.convertBack(paramObject);
    return localObject;
  }

  protected abstract Object getValueObject(String paramString);

  protected boolean isConcreteTypeArrayFieldSet(String paramString)
  {
    throw new UnsupportedOperationException("Concrete type arrays not supported");
  }

  protected boolean isConcreteTypeFieldSet(String paramString)
  {
    throw new UnsupportedOperationException("Concrete types not supported");
  }

  protected boolean isFieldSet(Field paramField)
  {
    if (paramField.getTypeOut() == 11)
    {
      if (paramField.isTypeOutArray())
        return isConcreteTypeArrayFieldSet(paramField.getOutputFieldName());
      return isConcreteTypeFieldSet(paramField.getOutputFieldName());
    }
    return isPrimitiveFieldSet(paramField.getOutputFieldName());
  }

  protected abstract boolean isPrimitiveFieldSet(String paramString);

  public String toString()
  {
    Map localMap = getFieldMappings();
    StringBuilder localStringBuilder = new StringBuilder(100);
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Field localField = (Field)localMap.get(str);
      if (isFieldSet(localField))
      {
        Object localObject = getOriginalValue(localField, getFieldValue(localField));
        if (localStringBuilder.length() == 0)
          localStringBuilder.append("{");
        while (true)
        {
          localStringBuilder.append("\"").append(str).append("\":");
          if (localObject != null)
            break label139;
          localStringBuilder.append("null");
          break;
          localStringBuilder.append(",");
        }
        label139: switch (localField.getTypeOut())
        {
        default:
          if (localField.isTypeInArray())
            zza(localStringBuilder, localField, (ArrayList)localObject);
          break;
        case 8:
          localStringBuilder.append("\"").append(zzb.zzj((byte[])localObject)).append("\"");
          break;
        case 9:
          localStringBuilder.append("\"").append(zzb.zzk((byte[])localObject)).append("\"");
          break;
        case 10:
          zzk.zza(localStringBuilder, (HashMap)localObject);
          continue;
          zza(localStringBuilder, localField, localObject);
        }
      }
    }
    if (localStringBuilder.length() > 0)
      localStringBuilder.append("}");
    while (true)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("{}");
    }
  }

  public static class Field<I, O>
    implements SafeParcelable
  {
    public static final zza CREATOR = new zza();
    protected final Class<? extends FastJsonResponse> mConcreteType;
    protected final String mConcreteTypeName;
    protected final String mOutputFieldName;
    protected final int mSafeParcelableFieldId;
    protected final int mTypeIn;
    protected final boolean mTypeInArray;
    protected final int mTypeOut;
    protected final boolean mTypeOutArray;
    private final int mVersionCode;
    private FieldMappingDictionary zzamV;
    private FastJsonResponse.FieldConverter<I, O> zzamW;

    Field(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, ConverterWrapper paramConverterWrapper)
    {
      mVersionCode = paramInt1;
      mTypeIn = paramInt2;
      mTypeInArray = paramBoolean1;
      mTypeOut = paramInt3;
      mTypeOutArray = paramBoolean2;
      mOutputFieldName = paramString1;
      mSafeParcelableFieldId = paramInt4;
      if (paramString2 == null)
        mConcreteType = null;
      for (mConcreteTypeName = null; paramConverterWrapper == null; mConcreteTypeName = paramString2)
      {
        zzamW = null;
        return;
        mConcreteType = SafeParcelResponse.class;
      }
      zzamW = paramConverterWrapper.zzqk();
    }

    public I convertBack(O paramO)
    {
      return zzamW.convertBack(paramO);
    }

    public int describeContents()
    {
      zza localzza = CREATOR;
      return 0;
    }

    public Class<? extends FastJsonResponse> getConcreteType()
    {
      return mConcreteType;
    }

    public Map<String, Field<?, ?>> getConcreteTypeFieldMappingFromDictionary()
    {
      zzv.zzz(mConcreteTypeName);
      zzv.zzz(zzamV);
      return zzamV.getFieldMapping(mConcreteTypeName);
    }

    public String getOutputFieldName()
    {
      return mOutputFieldName;
    }

    public int getSafeParcelableFieldId()
    {
      return mSafeParcelableFieldId;
    }

    public int getTypeIn()
    {
      return mTypeIn;
    }

    public int getTypeOut()
    {
      return mTypeOut;
    }

    public int getVersionCode()
    {
      return mVersionCode;
    }

    public boolean hasConverter()
    {
      return zzamW != null;
    }

    public boolean isTypeInArray()
    {
      return mTypeInArray;
    }

    public boolean isTypeOutArray()
    {
      return mTypeOutArray;
    }

    public void setFieldMappingDictionary(FieldMappingDictionary paramFieldMappingDictionary)
    {
      zzamV = paramFieldMappingDictionary;
    }

    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Field\n");
      localStringBuilder1.append("            versionCode=").append(mVersionCode).append('\n');
      localStringBuilder1.append("                 typeIn=").append(mTypeIn).append('\n');
      localStringBuilder1.append("            typeInArray=").append(mTypeInArray).append('\n');
      localStringBuilder1.append("                typeOut=").append(mTypeOut).append('\n');
      localStringBuilder1.append("           typeOutArray=").append(mTypeOutArray).append('\n');
      localStringBuilder1.append("        outputFieldName=").append(mOutputFieldName).append('\n');
      localStringBuilder1.append("      safeParcelFieldId=").append(mSafeParcelableFieldId).append('\n');
      localStringBuilder1.append("       concreteTypeName=").append(zzqm()).append('\n');
      if (getConcreteType() != null)
        localStringBuilder1.append("     concreteType.class=").append(getConcreteType().getCanonicalName()).append('\n');
      StringBuilder localStringBuilder2 = localStringBuilder1.append("          converterName=");
      if (zzamW == null);
      for (String str = "null"; ; str = zzamW.getClass().getCanonicalName())
      {
        localStringBuilder2.append(str).append('\n');
        return localStringBuilder1.toString();
      }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zza localzza = CREATOR;
      zza.zza(this, paramParcel, paramInt);
    }

    String zzqm()
    {
      if (mConcreteTypeName == null)
        return null;
      return mConcreteTypeName;
    }

    ConverterWrapper zzqn()
    {
      if (zzamW == null)
        return null;
      return ConverterWrapper.zza(zzamW);
    }
  }

  public static abstract interface FieldConverter<I, O>
  {
    public abstract I convertBack(O paramO);
  }
}