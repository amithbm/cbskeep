package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GlobalSearchQuerySpecification
  implements SafeParcelable
{
  public static final zzo CREATOR = new zzo();
  public final String context;
  public final int debugLevel;
  final int mVersionCode;
  public final int queryTokenizer;
  public final int rankingStrategy;
  public final boolean returnPerCorpusResults;
  public final int scoringVerbosityLevel;
  final CorpusId[] zzMX;
  final CorpusScoringInfo[] zzMY;
  private final transient Map<String, Set<String>> zzMZ;
  private final transient Map<CorpusId, CorpusScoringInfo> zzNa;

  GlobalSearchQuerySpecification(int paramInt1, CorpusId[] paramArrayOfCorpusId, int paramInt2, CorpusScoringInfo[] paramArrayOfCorpusScoringInfo, int paramInt3, int paramInt4, int paramInt5, String paramString, boolean paramBoolean)
  {
    mVersionCode = paramInt1;
    zzMX = paramArrayOfCorpusId;
    scoringVerbosityLevel = paramInt2;
    debugLevel = paramInt3;
    rankingStrategy = paramInt4;
    queryTokenizer = paramInt5;
    context = paramString;
    returnPerCorpusResults = paramBoolean;
    zzMY = paramArrayOfCorpusScoringInfo;
    if ((paramArrayOfCorpusId == null) || (paramArrayOfCorpusId.length == 0))
    {
      zzMZ = null;
      if ((paramArrayOfCorpusScoringInfo != null) && (paramArrayOfCorpusScoringInfo.length != 0))
        break label194;
      zzNa = null;
    }
    while (true)
    {
      return;
      zzMZ = new HashMap();
      paramInt1 = 0;
      while (paramInt1 < paramArrayOfCorpusId.length)
      {
        Set localSet = (Set)zzMZ.get(paramArrayOfCorpusId[paramInt1].packageName);
        paramString = localSet;
        if (localSet == null)
        {
          paramString = new HashSet();
          zzMZ.put(paramArrayOfCorpusId[paramInt1].packageName, paramString);
        }
        if (paramArrayOfCorpusId[paramInt1].corpusName != null)
          paramString.add(paramArrayOfCorpusId[paramInt1].corpusName);
        paramInt1 += 1;
      }
      break;
      label194: zzNa = new HashMap(paramArrayOfCorpusScoringInfo.length);
      paramInt1 = i;
      while (paramInt1 < paramArrayOfCorpusScoringInfo.length)
      {
        zzNa.put(paramArrayOfCorpusScoringInfo[paramInt1].corpus, paramArrayOfCorpusScoringInfo[paramInt1]);
        paramInt1 += 1;
      }
    }
  }

  public int describeContents()
  {
    zzo localzzo = CREATOR;
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo localzzo = CREATOR;
    zzo.zza(this, paramParcel, paramInt);
  }
}