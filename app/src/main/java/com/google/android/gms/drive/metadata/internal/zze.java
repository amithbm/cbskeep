package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zzmr;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zzmv;
import java.util.HashMap;
import java.util.Map;

public final class zze
{
  private static final Map<String, MetadataField<?>> zzawC = new HashMap();

  static
  {
    zzb(zzmr.zzawF);
    zzb(zzmr.zzaxk);
    zzb(zzmr.zzaxb);
    zzb(zzmr.zzaxi);
    zzb(zzmr.zzaxl);
    zzb(zzmr.zzawS);
    zzb(zzmr.zzawR);
    zzb(zzmr.zzawT);
    zzb(zzmr.zzawU);
    zzb(zzmr.zzawP);
    zzb(zzmr.zzawW);
    zzb(zzmr.zzawX);
    zzb(zzmr.zzawY);
    zzb(zzmr.zzaxg);
    zzb(zzmr.zzawG);
    zzb(zzmr.zzaxd);
    zzb(zzmr.zzawI);
    zzb(zzmr.zzawQ);
    zzb(zzmr.zzawJ);
    zzb(zzmr.zzawK);
    zzb(zzmr.zzawL);
    zzb(zzmr.zzawM);
    zzb(zzmr.zzaxa);
    zzb(zzmr.zzawV);
    zzb(zzmr.zzaxc);
    zzb(zzmr.zzaxe);
    zzb(zzmr.zzaxf);
    zzb(zzmr.zzaxh);
    zzb(zzmr.zzaxm);
    zzb(zzmr.zzaxn);
    zzb(zzmr.zzawO);
    zzb(zzmr.zzawN);
    zzb(zzmr.zzaxj);
    zzb(zzmr.zzawZ);
    zzb(zzmr.zzawH);
    zzb(zzmr.zzaxo);
    zzb(zzmr.zzaxp);
    zzb(zzmr.zzaxq);
    zzb(zzmr.zzaxr);
    zzb(zzmr.zzaxs);
    zzb(zzmt.zzaxt);
    zzb(zzmt.zzaxv);
    zzb(zzmt.zzaxw);
    zzb(zzmt.zzaxx);
    zzb(zzmt.zzaxu);
    zzb(zzmv.zzaxz);
    zzb(zzmv.zzaxA);
  }

  private static void zzb(MetadataField<?> paramMetadataField)
  {
    if (zzawC.containsKey(paramMetadataField.getName()))
      throw new IllegalArgumentException("Duplicate field name registered: " + paramMetadataField.getName());
    zzawC.put(paramMetadataField.getName(), paramMetadataField);
  }

  public static MetadataField<?> zzcx(String paramString)
  {
    return (MetadataField)zzawC.get(paramString);
  }
}