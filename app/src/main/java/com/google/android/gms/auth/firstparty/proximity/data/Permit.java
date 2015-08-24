package com.google.android.gms.auth.firstparty.proximity.data;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Permit
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  final int mVersion;
  final String zzEK;
  final String zzLf;
  final String zzTJ;
  final PermitAccess zzTK;
  List<PermitAccess> zzTL;
  final Map<String, PermitAccess> zzTM;
  List<String> zzTN;
  final Set<String> zzTO;

  Permit(int paramInt, String paramString1, String paramString2, String paramString3, PermitAccess paramPermitAccess, List<PermitAccess> paramList, List<String> paramList1)
  {
    this(paramInt, paramString1, paramString2, paramString3, paramPermitAccess, zzl(paramList), new HashSet(paramList1));
  }

  private Permit(int paramInt, String paramString1, String paramString2, String paramString3, PermitAccess paramPermitAccess, Map<String, PermitAccess> paramMap, Set<String> paramSet)
  {
    mVersion = paramInt;
    zzLf = zzv.zzce(paramString1);
    zzTJ = zzv.zzce(paramString2);
    zzEK = zzv.zzce(paramString3);
    zzTK = ((PermitAccess)zzv.zzz(paramPermitAccess));
    if (paramMap == null)
    {
      paramString1 = new HashMap();
      zzTM = paramString1;
      if (paramSet != null)
        break label96;
    }
    label96: for (paramString1 = new HashSet(); ; paramString1 = new HashSet(paramSet))
    {
      zzTO = paramString1;
      return;
      paramString1 = new HashMap(paramMap);
      break;
    }
  }

  private static Map<String, PermitAccess> zzl(List<PermitAccess> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PermitAccess localPermitAccess = (PermitAccess)paramList.next();
      localHashMap.put(localPermitAccess.getId(), localPermitAccess);
    }
    return localHashMap;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    do
    {
      do
      {
        return false;
        if (paramObject == this)
          return true;
      }
      while (!(paramObject instanceof Permit));
      paramObject = (Permit)paramObject;
    }
    while ((!TextUtils.equals(zzTJ, paramObject.zzTJ)) || (!TextUtils.equals(zzLf, paramObject.zzLf)) || (!TextUtils.equals(zzEK, paramObject.zzEK)) || (!zzTK.equals(paramObject.zzTK)) || (!zzTO.equals(paramObject.zzTO)) || (!zzTM.equals(paramObject.zzTM)));
    return true;
  }

  public int hashCode()
  {
    return 31 * (((((zzLf.hashCode() + 527) * 31 + zzTJ.hashCode()) * 31 + zzEK.hashCode()) * 31 + zzTO.hashCode()) * 31 + zzTK.hashCode()) + zzTM.hashCode();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzTL = new ArrayList(zzTM.values());
    zzTN = new ArrayList(zzTO);
    zzd.zza(this, paramParcel, paramInt);
  }
}