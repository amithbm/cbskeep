package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzqc
{
  public static final class zza extends zzadq<zza>
  {
    public zza[] zzaPA;

    public zza()
    {
      zzxT();
    }

    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this)
        bool1 = true;
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        }
        while (!(paramObject instanceof zza));
        paramObject = (zza)paramObject;
        bool1 = bool2;
      }
      while (!zzadv.equals(zzaPA, paramObject.zzaPA));
      return zza(paramObject);
    }

    public int hashCode()
    {
      return (zzadv.hashCode(zzaPA) + 527) * 31 + zzHD();
    }

    protected int zzB()
    {
      int i = super.zzB();
      int k = i;
      if (zzaPA != null)
      {
        k = i;
        if (zzaPA.length > 0)
        {
          int j = 0;
          while (true)
          {
            k = i;
            if (j >= zzaPA.length)
              break;
            zza localzza = zzaPA[j];
            k = i;
            if (localzza != null)
              k = i + zzadp.zzc(1, localzza);
            j += 1;
            i = k;
          }
        }
      }
      return k;
    }

    public zza zzI(zzado paramzzado)
      throws IOException
    {
      while (true)
      {
        int i = paramzzado.zzHl();
        switch (i)
        {
        default:
          if (zza(paramzzado, i))
            continue;
        case 0:
          return this;
        case 10:
        }
        int j = zzaea.zzc(paramzzado, 10);
        if (zzaPA == null);
        zza[] arrayOfzza;
        for (i = 0; ; i = zzaPA.length)
        {
          arrayOfzza = new zza[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzaPA, 0, arrayOfzza, 0, i);
            j = i;
          }
          while (j < arrayOfzza.length - 1)
          {
            arrayOfzza[j] = new zza();
            paramzzado.zza(arrayOfzza[j]);
            paramzzado.zzHl();
            j += 1;
          }
        }
        arrayOfzza[j] = new zza();
        paramzzado.zza(arrayOfzza[j]);
        zzaPA = arrayOfzza;
      }
    }

    public void zza(zzadp paramzzadp)
      throws IOException
    {
      if ((zzaPA != null) && (zzaPA.length > 0))
      {
        int i = 0;
        while (i < zzaPA.length)
        {
          zza localzza = zzaPA[i];
          if (localzza != null)
            paramzzadp.zza(1, localzza);
          i += 1;
        }
      }
      super.zza(paramzzadp);
    }

    public zza zzxT()
    {
      zzaPA = zza.zzxU();
      zzbJM = null;
      zzbJX = -1;
      return this;
    }

    public static final class zza extends zzadq<zza>
    {
      private static volatile zza[] zzaPB;
      public int viewId;
      public String zzaPC;
      public String zzaPD;

      public zza()
      {
        zzxV();
      }

      public static zza[] zzxU()
      {
        if (zzaPB == null);
        synchronized (zzadv.zzbJW)
        {
          if (zzaPB == null)
            zzaPB = new zza[0];
          return zzaPB;
        }
      }

      public boolean equals(Object paramObject)
      {
        boolean bool2 = false;
        boolean bool1;
        if (paramObject == this)
          bool1 = true;
        label41: 
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            }
            while (!(paramObject instanceof zza));
            paramObject = (zza)paramObject;
            if (zzaPC != null)
              break;
            bool1 = bool2;
          }
          while (paramObject.zzaPC != null);
          if (zzaPD != null)
            break label92;
          bool1 = bool2;
        }
        while (paramObject.zzaPD != null);
        label92: 
        while (zzaPD.equals(paramObject.zzaPD))
        {
          bool1 = bool2;
          if (viewId != paramObject.viewId)
            break;
          return zza(paramObject);
          if (zzaPC.equals(paramObject.zzaPC))
            break label41;
          return false;
        }
        return false;
      }

      public int hashCode()
      {
        int j = 0;
        int i;
        if (zzaPC == null)
        {
          i = 0;
          if (zzaPD != null)
            break label56;
        }
        while (true)
        {
          return (((i + 527) * 31 + j) * 31 + viewId) * 31 + zzHD();
          i = zzaPC.hashCode();
          break;
          label56: j = zzaPD.hashCode();
        }
      }

      protected int zzB()
      {
        int j = super.zzB();
        int i = j;
        if (!zzaPC.equals(""))
          i = j + zzadp.zzm(1, zzaPC);
        j = i;
        if (!zzaPD.equals(""))
          j = i + zzadp.zzm(2, zzaPD);
        i = j;
        if (viewId != 0)
          i = j + zzadp.zzR(3, viewId);
        return i;
      }

      public zza zzJ(zzado paramzzado)
        throws IOException
      {
        while (true)
        {
          int i = paramzzado.zzHl();
          switch (i)
          {
          default:
            if (zza(paramzzado, i))
              continue;
          case 0:
            return this;
          case 10:
            zzaPC = paramzzado.readString();
            break;
          case 18:
            zzaPD = paramzzado.readString();
            break;
          case 24:
          }
          viewId = paramzzado.zzHo();
        }
      }

      public void zza(zzadp paramzzadp)
        throws IOException
      {
        if (!zzaPC.equals(""))
          paramzzadp.zzb(1, zzaPC);
        if (!zzaPD.equals(""))
          paramzzadp.zzb(2, zzaPD);
        if (viewId != 0)
          paramzzadp.zzP(3, viewId);
        super.zza(paramzzadp);
      }

      public zza zzxV()
      {
        zzaPC = "";
        zzaPD = "";
        viewId = 0;
        zzbJM = null;
        zzbJX = -1;
        return this;
      }
    }
  }

  public static final class zzb extends zzadq<zzb>
  {
    private static volatile zzb[] zzaPE;
    public String name;
    public zzqc.zzd zzaPF;

    public zzb()
    {
      zzxX();
    }

    public static zzb[] zzxW()
    {
      if (zzaPE == null);
      synchronized (zzadv.zzbJW)
      {
        if (zzaPE == null)
          zzaPE = new zzb[0];
        return zzaPE;
      }
    }

    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this)
        bool1 = true;
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          }
          while (!(paramObject instanceof zzb));
          paramObject = (zzb)paramObject;
          if (name != null)
            break;
          bool1 = bool2;
        }
        while (paramObject.name != null);
        if (zzaPF != null)
          break label79;
        bool1 = bool2;
      }
      while (paramObject.zzaPF != null);
      label79: 
      while (zzaPF.equals(paramObject.zzaPF))
      {
        return zza(paramObject);
        if (name.equals(paramObject.name))
          break;
        return false;
      }
      return false;
    }

    public int hashCode()
    {
      int j = 0;
      int i;
      if (name == null)
      {
        i = 0;
        if (zzaPF != null)
          break label48;
      }
      while (true)
      {
        return ((i + 527) * 31 + j) * 31 + zzHD();
        i = name.hashCode();
        break;
        label48: j = zzaPF.hashCode();
      }
    }

    protected int zzB()
    {
      int j = super.zzB();
      int i = j;
      if (!name.equals(""))
        i = j + zzadp.zzm(1, name);
      j = i;
      if (zzaPF != null)
        j = i + zzadp.zzc(2, zzaPF);
      return j;
    }

    public zzb zzK(zzado paramzzado)
      throws IOException
    {
      while (true)
      {
        int i = paramzzado.zzHl();
        switch (i)
        {
        default:
          if (zza(paramzzado, i))
            continue;
        case 0:
          return this;
        case 10:
          name = paramzzado.readString();
          break;
        case 18:
        }
        if (zzaPF == null)
          zzaPF = new zzqc.zzd();
        paramzzado.zza(zzaPF);
      }
    }

    public void zza(zzadp paramzzadp)
      throws IOException
    {
      if (!name.equals(""))
        paramzzadp.zzb(1, name);
      if (zzaPF != null)
        paramzzadp.zza(2, zzaPF);
      super.zza(paramzzadp);
    }

    public zzb zzxX()
    {
      name = "";
      zzaPF = null;
      zzbJM = null;
      zzbJX = -1;
      return this;
    }
  }

  public static final class zzc extends zzadq<zzc>
  {
    public String type;
    public zzqc.zzb[] zzaPG;

    public zzc()
    {
      zzxY();
    }

    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this)
        bool1 = true;
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        }
        while (!(paramObject instanceof zzc));
        paramObject = (zzc)paramObject;
        if (type != null)
          break;
        bool1 = bool2;
      }
      while (paramObject.type != null);
      while (type.equals(paramObject.type))
      {
        bool1 = bool2;
        if (!zzadv.equals(zzaPG, paramObject.zzaPG))
          break;
        return zza(paramObject);
      }
      return false;
    }

    public int hashCode()
    {
      if (type == null);
      for (int i = 0; ; i = type.hashCode())
        return ((i + 527) * 31 + zzadv.hashCode(zzaPG)) * 31 + zzHD();
    }

    protected int zzB()
    {
      int j = super.zzB();
      int i = j;
      if (!type.equals(""))
        i = j + zzadp.zzm(1, type);
      j = i;
      if (zzaPG != null)
      {
        j = i;
        if (zzaPG.length > 0)
        {
          j = 0;
          while (j < zzaPG.length)
          {
            zzqc.zzb localzzb = zzaPG[j];
            int k = i;
            if (localzzb != null)
              k = i + zzadp.zzc(2, localzzb);
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      return j;
    }

    public zzc zzL(zzado paramzzado)
      throws IOException
    {
      while (true)
      {
        int i = paramzzado.zzHl();
        switch (i)
        {
        default:
          if (zza(paramzzado, i))
            continue;
        case 0:
          return this;
        case 10:
          type = paramzzado.readString();
          break;
        case 18:
        }
        int j = zzaea.zzc(paramzzado, 18);
        if (zzaPG == null);
        zzqc.zzb[] arrayOfzzb;
        for (i = 0; ; i = zzaPG.length)
        {
          arrayOfzzb = new zzqc.zzb[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzaPG, 0, arrayOfzzb, 0, i);
            j = i;
          }
          while (j < arrayOfzzb.length - 1)
          {
            arrayOfzzb[j] = new zzqc.zzb();
            paramzzado.zza(arrayOfzzb[j]);
            paramzzado.zzHl();
            j += 1;
          }
        }
        arrayOfzzb[j] = new zzqc.zzb();
        paramzzado.zza(arrayOfzzb[j]);
        zzaPG = arrayOfzzb;
      }
    }

    public void zza(zzadp paramzzadp)
      throws IOException
    {
      if (!type.equals(""))
        paramzzadp.zzb(1, type);
      if ((zzaPG != null) && (zzaPG.length > 0))
      {
        int i = 0;
        while (i < zzaPG.length)
        {
          zzqc.zzb localzzb = zzaPG[i];
          if (localzzb != null)
            paramzzadp.zza(2, localzzb);
          i += 1;
        }
      }
      super.zza(paramzzadp);
    }

    public zzc zzxY()
    {
      type = "";
      zzaPG = zzqc.zzb.zzxW();
      zzbJM = null;
      zzbJX = -1;
      return this;
    }
  }

  public static final class zzd extends zzadq<zzd>
  {
    public boolean zzaPH;
    public long zzaPI;
    public double zzaPJ;
    public zzqc.zzc zzaPK;
    public String zzamQ;

    public zzd()
    {
      zzxZ();
    }

    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this)
        bool1 = true;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return bool1;
                  bool1 = bool2;
                }
                while (!(paramObject instanceof zzd));
                paramObject = (zzd)paramObject;
                bool1 = bool2;
              }
              while (zzaPH != paramObject.zzaPH);
              if (zzamQ != null)
                break;
              bool1 = bool2;
            }
            while (paramObject.zzamQ != null);
            bool1 = bool2;
          }
          while (zzaPI != paramObject.zzaPI);
          bool1 = bool2;
        }
        while (Double.doubleToLongBits(zzaPJ) != Double.doubleToLongBits(paramObject.zzaPJ));
        if (zzaPK != null)
          break label126;
        bool1 = bool2;
      }
      while (paramObject.zzaPK != null);
      label126: 
      while (zzaPK.equals(paramObject.zzaPK))
      {
        return zza(paramObject);
        if (zzamQ.equals(paramObject.zzamQ))
          break;
        return false;
      }
      return false;
    }

    public int hashCode()
    {
      int k = 0;
      int i;
      int j;
      label22: int m;
      int n;
      if (zzaPH)
      {
        i = 1231;
        if (zzamQ != null)
          break label107;
        j = 0;
        m = (int)(zzaPI ^ zzaPI >>> 32);
        long l = Double.doubleToLongBits(zzaPJ);
        n = (int)(l ^ l >>> 32);
        if (zzaPK != null)
          break label118;
      }
      while (true)
      {
        return ((((j + (i + 527) * 31) * 31 + m) * 31 + n) * 31 + k) * 31 + zzHD();
        i = 1237;
        break;
        label107: j = zzamQ.hashCode();
        break label22;
        label118: k = zzaPK.hashCode();
      }
    }

    protected int zzB()
    {
      int j = super.zzB();
      int i = j;
      if (zzaPH)
        i = j + zzadp.zze(1, zzaPH);
      j = i;
      if (!zzamQ.equals(""))
        j = i + zzadp.zzm(2, zzamQ);
      i = j;
      if (zzaPI != 0L)
        i = j + zzadp.zzi(3, zzaPI);
      j = i;
      if (Double.doubleToLongBits(zzaPJ) != Double.doubleToLongBits(0.0D))
        j = i + zzadp.zzb(4, zzaPJ);
      i = j;
      if (zzaPK != null)
        i = j + zzadp.zzc(5, zzaPK);
      return i;
    }

    public zzd zzM(zzado paramzzado)
      throws IOException
    {
      while (true)
      {
        int i = paramzzado.zzHl();
        switch (i)
        {
        default:
          if (zza(paramzzado, i))
            continue;
        case 0:
          return this;
        case 8:
          zzaPH = paramzzado.zzHq();
          break;
        case 18:
          zzamQ = paramzzado.readString();
          break;
        case 24:
          zzaPI = paramzzado.zzHn();
          break;
        case 33:
          zzaPJ = paramzzado.readDouble();
          break;
        case 42:
        }
        if (zzaPK == null)
          zzaPK = new zzqc.zzc();
        paramzzado.zza(zzaPK);
      }
    }

    public void zza(zzadp paramzzadp)
      throws IOException
    {
      if (zzaPH)
        paramzzadp.zzd(1, zzaPH);
      if (!zzamQ.equals(""))
        paramzzadp.zzb(2, zzamQ);
      if (zzaPI != 0L)
        paramzzadp.zzb(3, zzaPI);
      if (Double.doubleToLongBits(zzaPJ) != Double.doubleToLongBits(0.0D))
        paramzzadp.zza(4, zzaPJ);
      if (zzaPK != null)
        paramzzadp.zza(5, zzaPK);
      super.zza(paramzzadp);
    }

    public zzd zzxZ()
    {
      zzaPH = false;
      zzamQ = "";
      zzaPI = 0L;
      zzaPJ = 0.0D;
      zzaPK = null;
      zzbJM = null;
      zzbJX = -1;
      return this;
    }
  }
}