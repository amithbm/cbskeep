package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class RegisterSectionInfo
  implements SafeParcelable
{
  public static final zzy CREATOR = new zzy();
  public final Feature[] features;
  public final String format;
  public final boolean indexPrefixes;
  final int mVersionCode;
  public final String name;
  public final boolean noIndex;
  public final String schemaOrgProperty;
  public final String subsectionSeparator;
  public final int weight;
  final int[] zzNM;

  RegisterSectionInfo(int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString3, Feature[] paramArrayOfFeature, int[] paramArrayOfInt, String paramString4)
  {
    mVersionCode = paramInt1;
    name = paramString1;
    format = paramString2;
    noIndex = paramBoolean1;
    weight = paramInt2;
    indexPrefixes = paramBoolean2;
    subsectionSeparator = paramString3;
    features = paramArrayOfFeature;
    zzNM = paramArrayOfInt;
    schemaOrgProperty = paramString4;
  }

  RegisterSectionInfo(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString3, Feature[] paramArrayOfFeature, int[] paramArrayOfInt, String paramString4)
  {
    this(2, paramString1, paramString2, paramBoolean1, paramInt, paramBoolean2, paramString3, paramArrayOfFeature, paramArrayOfInt, paramString4);
  }

  public int describeContents()
  {
    zzy localzzy = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzy localzzy = CREATOR;
    zzy.zza(this, paramParcel, paramInt);
  }

  public static final class Builder
  {
    private final String mName;
    private String zzNN;
    private boolean zzNO;
    private int zzNP;
    private boolean zzNQ;
    private String zzNR;
    private final List<Feature> zzNS;
    private BitSet zzNT;
    private String zzNU;

    public Builder(String paramString)
    {
      mName = paramString;
      zzNP = 1;
      zzNS = new ArrayList();
    }

    public Builder addSemanticLabel(int paramInt)
    {
      if (zzNT == null)
        zzNT = new BitSet();
      zzNT.set(paramInt);
      return this;
    }

    public RegisterSectionInfo build()
    {
      int i = 0;
      Object localObject = null;
      if (zzNT != null)
      {
        int[] arrayOfInt = new int[zzNT.cardinality()];
        int j = zzNT.nextSetBit(0);
        while (true)
        {
          localObject = arrayOfInt;
          if (j < 0)
            break;
          arrayOfInt[i] = j;
          j = zzNT.nextSetBit(j + 1);
          i += 1;
        }
      }
      return new RegisterSectionInfo(mName, zzNN, zzNO, zzNP, zzNQ, zzNR, (Feature[])zzNS.toArray(new Feature[zzNS.size()]), localObject, zzNU);
    }

    public Builder format(String paramString)
    {
      zzNN = paramString;
      return this;
    }

    public Builder indexPrefixes(boolean paramBoolean)
    {
      zzNQ = paramBoolean;
      return this;
    }

    public Builder noIndex(boolean paramBoolean)
    {
      zzNO = paramBoolean;
      return this;
    }

    public Builder schemaOrgProperty(String paramString)
    {
      zzNU = paramString;
      return this;
    }
  }
}