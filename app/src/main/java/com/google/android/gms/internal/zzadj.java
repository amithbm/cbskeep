package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzadj extends zzadq<zzadj>
{
  public zza[] zzbIS;

  public zzadj()
  {
    zzHb();
  }

  public static zzadj zzN(byte[] paramArrayOfByte)
    throws zzadw
  {
    return (zzadj)zzadx.zza(new zzadj(), paramArrayOfByte);
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
      while (!(paramObject instanceof zzadj));
      paramObject = (zzadj)paramObject;
      bool1 = bool2;
    }
    while (!zzadv.equals(zzbIS, paramObject.zzbIS));
    return zza(paramObject);
  }

  public int hashCode()
  {
    return (zzadv.hashCode(zzbIS) + 527) * 31 + zzHD();
  }

  protected int zzB()
  {
    int i = super.zzB();
    int k = i;
    if (zzbIS != null)
    {
      k = i;
      if (zzbIS.length > 0)
      {
        int j = 0;
        while (true)
        {
          k = i;
          if (j >= zzbIS.length)
            break;
          zza localzza = zzbIS[j];
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

  public zzadj zzHb()
  {
    zzbIS = zza.zzHc();
    zzbJM = null;
    zzbJX = -1;
    return this;
  }

  public void zza(zzadp paramzzadp)
    throws IOException
  {
    if ((zzbIS != null) && (zzbIS.length > 0))
    {
      int i = 0;
      while (i < zzbIS.length)
      {
        zza localzza = zzbIS[i];
        if (localzza != null)
          paramzzadp.zza(1, localzza);
        i += 1;
      }
    }
    super.zza(paramzzadp);
  }

  public zzadj zzao(zzado paramzzado)
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
      if (zzbIS == null);
      zza[] arrayOfzza;
      for (i = 0; ; i = zzbIS.length)
      {
        arrayOfzza = new zza[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(zzbIS, 0, arrayOfzza, 0, i);
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
      zzbIS = arrayOfzza;
    }
  }

  public static final class zza extends zzadq<zza>
  {
    private static volatile zza[] zzbIT;
    public String name;
    public zza zzbIU;

    public zza()
    {
      zzHd();
    }

    public static zza[] zzHc()
    {
      if (zzbIT == null);
      synchronized (zzadv.zzbJW)
      {
        if (zzbIT == null)
          zzbIT = new zza[0];
        return zzbIT;
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
          while (!(paramObject instanceof zza));
          paramObject = (zza)paramObject;
          if (name != null)
            break;
          bool1 = bool2;
        }
        while (paramObject.name != null);
        if (zzbIU != null)
          break label79;
        bool1 = bool2;
      }
      while (paramObject.zzbIU != null);
      label79: 
      while (zzbIU.equals(paramObject.zzbIU))
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
        if (zzbIU != null)
          break label48;
      }
      while (true)
      {
        return ((i + 527) * 31 + j) * 31 + zzHD();
        i = name.hashCode();
        break;
        label48: j = zzbIU.hashCode();
      }
    }

    protected int zzB()
    {
      int j = super.zzB() + zzadp.zzm(1, name);
      int i = j;
      if (zzbIU != null)
        i = j + zzadp.zzc(2, zzbIU);
      return i;
    }

    public zza zzHd()
    {
      name = "";
      zzbIU = null;
      zzbJM = null;
      zzbJX = -1;
      return this;
    }

    public void zza(zzadp paramzzadp)
      throws IOException
    {
      paramzzadp.zzb(1, name);
      if (zzbIU != null)
        paramzzadp.zza(2, zzbIU);
      super.zza(paramzzadp);
    }

    public zza zzap(zzado paramzzado)
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
        if (zzbIU == null)
          zzbIU = new zza();
        paramzzado.zza(zzbIU);
      }
    }

    public static final class zza extends zzadq<zza>
    {
      private static volatile zza[] zzbIV;
      public int type;
      public zza zzbIW;

      public zza()
      {
        zzHf();
      }

      public static zza[] zzHe()
      {
        if (zzbIV == null);
        synchronized (zzadv.zzbJW)
        {
          if (zzbIV == null)
            zzbIV = new zza[0];
          return zzbIV;
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
            while (!(paramObject instanceof zza));
            paramObject = (zza)paramObject;
            bool1 = bool2;
          }
          while (type != paramObject.type);
          if (zzbIW != null)
            break;
          bool1 = bool2;
        }
        while (paramObject.zzbIW != null);
        while (zzbIW.equals(paramObject.zzbIW))
          return zza(paramObject);
        return false;
      }

      public int hashCode()
      {
        int j = type;
        if (zzbIW == null);
        for (int i = 0; ; i = zzbIW.hashCode())
          return (i + (j + 527) * 31) * 31 + zzHD();
      }

      protected int zzB()
      {
        int j = super.zzB() + zzadp.zzR(1, type);
        int i = j;
        if (zzbIW != null)
          i = j + zzadp.zzc(2, zzbIW);
        return i;
      }

      public zza zzHf()
      {
        type = 1;
        zzbIW = null;
        zzbJM = null;
        zzbJX = -1;
        return this;
      }

      public void zza(zzadp paramzzadp)
        throws IOException
      {
        paramzzadp.zzP(1, type);
        if (zzbIW != null)
          paramzzadp.zza(2, zzbIW);
        super.zza(paramzzadp);
      }

      public zza zzaq(zzado paramzzado)
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
            i = paramzzado.zzHo();
            switch (i)
            {
            default:
              break;
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
            case 12:
            case 13:
            case 14:
            case 15:
            }
            type = i;
            break;
          case 18:
          }
          if (zzbIW == null)
            zzbIW = new zza();
          paramzzado.zza(zzbIW);
        }
      }

      public static final class zza extends zzadq<zza>
      {
        public byte[] zzbIX;
        public String zzbIY;
        public double zzbIZ;
        public float zzbJa;
        public long zzbJb;
        public int zzbJc;
        public int zzbJd;
        public boolean zzbJe;
        public zzadj.zza[] zzbJf;
        public zzadj.zza.zza[] zzbJg;
        public String[] zzbJh;
        public long[] zzbJi;
        public float[] zzbJj;
        public long zzbJk;

        public zza()
        {
          zzHg();
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
              while (!(paramObject instanceof zza));
              paramObject = (zza)paramObject;
              bool1 = bool2;
            }
            while (!Arrays.equals(zzbIX, paramObject.zzbIX));
            if (zzbIY != null)
              break;
            bool1 = bool2;
          }
          while (paramObject.zzbIY != null);
          while (zzbIY.equals(paramObject.zzbIY))
          {
            bool1 = bool2;
            if (Double.doubleToLongBits(zzbIZ) != Double.doubleToLongBits(paramObject.zzbIZ))
              break;
            bool1 = bool2;
            if (Float.floatToIntBits(zzbJa) != Float.floatToIntBits(paramObject.zzbJa))
              break;
            bool1 = bool2;
            if (zzbJb != paramObject.zzbJb)
              break;
            bool1 = bool2;
            if (zzbJc != paramObject.zzbJc)
              break;
            bool1 = bool2;
            if (zzbJd != paramObject.zzbJd)
              break;
            bool1 = bool2;
            if (zzbJe != paramObject.zzbJe)
              break;
            bool1 = bool2;
            if (!zzadv.equals(zzbJf, paramObject.zzbJf))
              break;
            bool1 = bool2;
            if (!zzadv.equals(zzbJg, paramObject.zzbJg))
              break;
            bool1 = bool2;
            if (!zzadv.equals(zzbJh, paramObject.zzbJh))
              break;
            bool1 = bool2;
            if (!zzadv.equals(zzbJi, paramObject.zzbJi))
              break;
            bool1 = bool2;
            if (!zzadv.equals(zzbJj, paramObject.zzbJj))
              break;
            bool1 = bool2;
            if (zzbJk != paramObject.zzbJk)
              break;
            return zza(paramObject);
          }
          return false;
        }

        public int hashCode()
        {
          int k = Arrays.hashCode(zzbIX);
          int i;
          int m;
          int n;
          int i1;
          int i2;
          int i3;
          if (zzbIY == null)
          {
            i = 0;
            long l = Double.doubleToLongBits(zzbIZ);
            m = (int)(l ^ l >>> 32);
            n = Float.floatToIntBits(zzbJa);
            i1 = (int)(zzbJb ^ zzbJb >>> 32);
            i2 = zzbJc;
            i3 = zzbJd;
            if (!zzbJe)
              break label221;
          }
          label221: for (int j = 1231; ; j = 1237)
          {
            return (((((((j + ((((((i + (k + 527) * 31) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31) * 31 + zzadv.hashCode(zzbJf)) * 31 + zzadv.hashCode(zzbJg)) * 31 + zzadv.hashCode(zzbJh)) * 31 + zzadv.hashCode(zzbJi)) * 31 + zzadv.hashCode(zzbJj)) * 31 + (int)(zzbJk ^ zzbJk >>> 32)) * 31 + zzHD();
            i = zzbIY.hashCode();
            break;
          }
        }

        protected int zzB()
        {
          int i2 = 0;
          int j = super.zzB();
          int i = j;
          if (!Arrays.equals(zzbIX, zzaea.zzbKg))
            i = j + zzadp.zzb(1, zzbIX);
          j = i;
          if (!zzbIY.equals(""))
            j = i + zzadp.zzm(2, zzbIY);
          i = j;
          if (Double.doubleToLongBits(zzbIZ) != Double.doubleToLongBits(0.0D))
            i = j + zzadp.zzb(3, zzbIZ);
          j = i;
          if (Float.floatToIntBits(zzbJa) != Float.floatToIntBits(0.0F))
            j = i + zzadp.zzc(4, zzbJa);
          i = j;
          if (zzbJb != 0L)
            i = j + zzadp.zzi(5, zzbJb);
          j = i;
          if (zzbJc != 0)
            j = i + zzadp.zzR(6, zzbJc);
          int k = j;
          if (zzbJd != 0)
            k = j + zzadp.zzS(7, zzbJd);
          i = k;
          if (zzbJe)
            i = k + zzadp.zze(8, zzbJe);
          j = i;
          Object localObject;
          if (zzbJf != null)
          {
            j = i;
            if (zzbJf.length > 0)
            {
              j = 0;
              while (j < zzbJf.length)
              {
                localObject = zzbJf[j];
                k = i;
                if (localObject != null)
                  k = i + zzadp.zzc(9, (zzadx)localObject);
                j += 1;
                i = k;
              }
              j = i;
            }
          }
          i = j;
          if (zzbJg != null)
          {
            i = j;
            if (zzbJg.length > 0)
            {
              i = j;
              j = 0;
              while (j < zzbJg.length)
              {
                localObject = zzbJg[j];
                k = i;
                if (localObject != null)
                  k = i + zzadp.zzc(10, (zzadx)localObject);
                j += 1;
                i = k;
              }
            }
          }
          j = i;
          if (zzbJh != null)
          {
            j = i;
            if (zzbJh.length > 0)
            {
              j = 0;
              k = 0;
              int n;
              for (int m = 0; j < zzbJh.length; m = n)
              {
                localObject = zzbJh[j];
                int i1 = k;
                n = m;
                if (localObject != null)
                {
                  n = m + 1;
                  i1 = k + zzadp.zzgf((String)localObject);
                }
                j += 1;
                k = i1;
              }
              j = i + k + m * 1;
            }
          }
          i = j;
          if (zzbJi != null)
          {
            i = j;
            if (zzbJi.length > 0)
            {
              k = 0;
              i = i2;
              while (i < zzbJi.length)
              {
                k += zzadp.zzan(zzbJi[i]);
                i += 1;
              }
              i = j + k + zzbJi.length * 1;
            }
          }
          j = i;
          if (zzbJk != 0L)
            j = i + zzadp.zzi(13, zzbJk);
          i = j;
          if (zzbJj != null)
          {
            i = j;
            if (zzbJj.length > 0)
              i = j + zzbJj.length * 4 + zzbJj.length * 1;
          }
          return i;
        }

        public zza zzHg()
        {
          zzbIX = zzaea.zzbKg;
          zzbIY = "";
          zzbIZ = 0.0D;
          zzbJa = 0.0F;
          zzbJb = 0L;
          zzbJc = 0;
          zzbJd = 0;
          zzbJe = false;
          zzbJf = zzadj.zza.zzHc();
          zzbJg = zzadj.zza.zza.zzHe();
          zzbJh = zzaea.zzbKe;
          zzbJi = zzaea.zzbKa;
          zzbJj = zzaea.zzbKb;
          zzbJk = 0L;
          zzbJM = null;
          zzbJX = -1;
          return this;
        }

        public void zza(zzadp paramzzadp)
          throws IOException
        {
          int j = 0;
          if (!Arrays.equals(zzbIX, zzaea.zzbKg))
            paramzzadp.zza(1, zzbIX);
          if (!zzbIY.equals(""))
            paramzzadp.zzb(2, zzbIY);
          if (Double.doubleToLongBits(zzbIZ) != Double.doubleToLongBits(0.0D))
            paramzzadp.zza(3, zzbIZ);
          if (Float.floatToIntBits(zzbJa) != Float.floatToIntBits(0.0F))
            paramzzadp.zzb(4, zzbJa);
          if (zzbJb != 0L)
            paramzzadp.zzb(5, zzbJb);
          if (zzbJc != 0)
            paramzzadp.zzP(6, zzbJc);
          if (zzbJd != 0)
            paramzzadp.zzQ(7, zzbJd);
          if (zzbJe)
            paramzzadp.zzd(8, zzbJe);
          int i;
          Object localObject;
          if ((zzbJf != null) && (zzbJf.length > 0))
          {
            i = 0;
            while (i < zzbJf.length)
            {
              localObject = zzbJf[i];
              if (localObject != null)
                paramzzadp.zza(9, (zzadx)localObject);
              i += 1;
            }
          }
          if ((zzbJg != null) && (zzbJg.length > 0))
          {
            i = 0;
            while (i < zzbJg.length)
            {
              localObject = zzbJg[i];
              if (localObject != null)
                paramzzadp.zza(10, (zzadx)localObject);
              i += 1;
            }
          }
          if ((zzbJh != null) && (zzbJh.length > 0))
          {
            i = 0;
            while (i < zzbJh.length)
            {
              localObject = zzbJh[i];
              if (localObject != null)
                paramzzadp.zzb(11, (String)localObject);
              i += 1;
            }
          }
          if ((zzbJi != null) && (zzbJi.length > 0))
          {
            i = 0;
            while (i < zzbJi.length)
            {
              paramzzadp.zzb(12, zzbJi[i]);
              i += 1;
            }
          }
          if (zzbJk != 0L)
            paramzzadp.zzb(13, zzbJk);
          if ((zzbJj != null) && (zzbJj.length > 0))
          {
            i = j;
            while (i < zzbJj.length)
            {
              paramzzadp.zzb(14, zzbJj[i]);
              i += 1;
            }
          }
          super.zza(paramzzadp);
        }

        public zza zzar(zzado paramzzado)
          throws IOException
        {
          while (true)
          {
            int i = paramzzado.zzHl();
            Object localObject;
            switch (i)
            {
            default:
              if (zza(paramzzado, i))
                continue;
            case 0:
              return this;
            case 10:
              zzbIX = paramzzado.readBytes();
              break;
            case 18:
              zzbIY = paramzzado.readString();
              break;
            case 25:
              zzbIZ = paramzzado.readDouble();
              break;
            case 37:
              zzbJa = paramzzado.readFloat();
              break;
            case 40:
              zzbJb = paramzzado.zzHn();
              break;
            case 48:
              zzbJc = paramzzado.zzHo();
              break;
            case 56:
              zzbJd = paramzzado.zzHr();
              break;
            case 64:
              zzbJe = paramzzado.zzHq();
              break;
            case 74:
              j = zzaea.zzc(paramzzado, 74);
              if (zzbJf == null);
              for (i = 0; ; i = zzbJf.length)
              {
                localObject = new zzadj.zza[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(zzbJf, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = new zzadj.zza();
                  paramzzado.zza(localObject[j]);
                  paramzzado.zzHl();
                  j += 1;
                }
              }
              localObject[j] = new zzadj.zza();
              paramzzado.zza(localObject[j]);
              zzbJf = ((zzadj.zza[])localObject);
              break;
            case 82:
              j = zzaea.zzc(paramzzado, 82);
              if (zzbJg == null);
              for (i = 0; ; i = zzbJg.length)
              {
                localObject = new zzadj.zza.zza[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(zzbJg, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = new zzadj.zza.zza();
                  paramzzado.zza(localObject[j]);
                  paramzzado.zzHl();
                  j += 1;
                }
              }
              localObject[j] = new zzadj.zza.zza();
              paramzzado.zza(localObject[j]);
              zzbJg = ((zzadj.zza.zza[])localObject);
              break;
            case 90:
              j = zzaea.zzc(paramzzado, 90);
              if (zzbJh == null);
              for (i = 0; ; i = zzbJh.length)
              {
                localObject = new String[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(zzbJh, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = paramzzado.readString();
                  paramzzado.zzHl();
                  j += 1;
                }
              }
              localObject[j] = paramzzado.readString();
              zzbJh = ((String[])localObject);
              break;
            case 96:
              j = zzaea.zzc(paramzzado, 96);
              if (zzbJi == null);
              for (i = 0; ; i = zzbJi.length)
              {
                localObject = new long[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(zzbJi, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = paramzzado.zzHn();
                  paramzzado.zzHl();
                  j += 1;
                }
              }
              localObject[j] = paramzzado.zzHn();
              zzbJi = ((long[])localObject);
              break;
            case 98:
              k = paramzzado.zzrU(paramzzado.zzHt());
              i = paramzzado.getPosition();
              j = 0;
              while (paramzzado.zzHy() > 0)
              {
                paramzzado.zzHn();
                j += 1;
              }
              paramzzado.zzrW(i);
              if (zzbJi == null);
              for (i = 0; ; i = zzbJi.length)
              {
                localObject = new long[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(zzbJi, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length)
                {
                  localObject[j] = paramzzado.zzHn();
                  j += 1;
                }
              }
              zzbJi = ((long[])localObject);
              paramzzado.zzrV(k);
              break;
            case 104:
              zzbJk = paramzzado.zzHn();
              break;
            case 117:
              j = zzaea.zzc(paramzzado, 117);
              if (zzbJj == null);
              for (i = 0; ; i = zzbJj.length)
              {
                localObject = new float[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(zzbJj, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = paramzzado.readFloat();
                  paramzzado.zzHl();
                  j += 1;
                }
              }
              localObject[j] = paramzzado.readFloat();
              zzbJj = ((float[])localObject);
              break;
            case 114:
            }
            i = paramzzado.zzHt();
            int k = paramzzado.zzrU(i);
            int j = i / 4;
            if (zzbJj == null);
            for (i = 0; ; i = zzbJj.length)
            {
              localObject = new float[j + i];
              j = i;
              if (i != 0)
              {
                System.arraycopy(zzbJj, 0, localObject, 0, i);
                j = i;
              }
              while (j < localObject.length)
              {
                localObject[j] = paramzzado.readFloat();
                j += 1;
              }
            }
            zzbJj = ((float[])localObject);
            paramzzado.zzrV(k);
          }
        }
      }
    }
  }
}