package com.google.android.gallery3d.exif;

import android.util.Log;
import android.util.SparseIntArray;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Map.Entry;
import java.util.TreeMap;

class d
{
  private static final Charset US_ASCII = Charset.forName("US-ASCII");
  private static final short cf = c.b(c.R);
  private static final short cg = c.b(c.S);
  private static final short ch = c.b(c.aB);
  private static final short ci = c.b(c.T);
  private static final short cj = c.b(c.U);
  private static final short ck = c.b(c.u);
  private static final short cl = c.b(c.A);
  private final a bO;
  private final int bP;
  private int bQ = 0;
  private int bR = 0;
  private int bS;
  private f bT;
  private c bU;
  private f bV;
  private f bW;
  private boolean bX;
  private boolean bY = false;
  private int bZ;
  private int ca = 0;
  private byte[] cb;
  private int cc;
  private int cd;
  private final c ce;
  private final TreeMap<Integer, Object> cm = new TreeMap();

  private d(InputStream paramInputStream, int paramInt, c paramc)
    throws IOException, ExifInvalidFormatException
  {
    if (paramInputStream == null)
      throw new IOException("Null argument inputStream to ExifParser");
    ce = paramc;
    bY = b(paramInputStream);
    bO = new a(paramInputStream);
    bP = paramInt;
    if (!bY);
    long l;
    do
    {
      do
      {
        return;
        o();
        l = bO.c();
        if (l > 2147483647L)
          throw new ExifInvalidFormatException("Invalid offset " + l);
        cc = ((int)l);
        bS = 0;
      }
      while ((!h(0)) && (!h()));
      a(0, l);
    }
    while (l == 8L);
    cb = new byte[(int)l - 8];
    read(cb);
  }

  protected static d a(InputStream paramInputStream, c paramc)
    throws IOException, ExifInvalidFormatException
  {
    return new d(paramInputStream, 63, paramc);
  }

  private void a(int paramInt, long paramLong)
  {
    cm.put(Integer.valueOf((int)paramLong), new b(paramInt, h(paramInt)));
  }

  private void b(int paramInt, long paramLong)
  {
    cm.put(Integer.valueOf((int)paramLong), new c(4, paramInt));
  }

  private void b(f paramf)
  {
    if (paramf.w() == 0);
    int i;
    int j;
    label237: 
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
                do
                {
                  return;
                  i = paramf.u();
                  j = paramf.t();
                  if ((i != cf) || (!e(j, c.R)))
                    break;
                }
                while ((!h(2)) && (!h(3)));
                a(2, paramf.o(0));
                return;
                if ((i != cg) || (!e(j, c.S)))
                  break;
              }
              while (!h(4));
              a(4, paramf.o(0));
              return;
              if ((i != ch) || (!e(j, c.aB)))
                break;
            }
            while (!h(3));
            a(3, paramf.o(0));
            return;
            if ((i != ci) || (!e(j, c.T)))
              break;
          }
          while (!f());
          c(paramf.o(0));
          return;
          if ((i != cj) || (!e(j, c.U)))
            break;
        }
        while (!f());
        bW = paramf;
        return;
        if ((i != ck) || (!e(j, c.u)))
          break;
      }
      while (!f());
      if (paramf.hasValue())
      {
        i = 0;
        if (i < paramf.w())
        {
          if (paramf.v() != 3)
            break label270;
          b(i, paramf.o(i));
        }
        while (true)
        {
          i += 1;
          break label237;
          break;
          b(i, paramf.o(i));
        }
      }
      cm.put(Integer.valueOf(paramf.getOffset()), new a(paramf, false));
      return;
    }
    while ((i != cl) || (!e(j, c.A)) || (!f()) || (!paramf.hasValue()));
    label270: bV = paramf;
  }

  private boolean b(InputStream paramInputStream)
    throws IOException, ExifInvalidFormatException
  {
    boolean bool2 = false;
    paramInputStream = new a(paramInputStream);
    if (paramInputStream.readShort() != -40)
      throw new ExifInvalidFormatException("Invalid JPEG format");
    for (short s = paramInputStream.readShort(); ; s = paramInputStream.readShort())
    {
      boolean bool1 = bool2;
      int i;
      if (s != -39)
      {
        bool1 = bool2;
        if (!h.g(s))
        {
          int j = paramInputStream.readUnsignedShort();
          i = j;
          if (s != -31)
            break label154;
          i = j;
          if (j < 8)
            break label154;
          int k = paramInputStream.readInt();
          int m = paramInputStream.readShort();
          j -= 6;
          i = j;
          if (k != 1165519206)
            break label154;
          i = j;
          if (m != 0)
            break label154;
          cd = paramInputStream.a();
          bZ = j;
          ca = (cd + bZ);
          bool1 = true;
        }
      }
      return bool1;
      label154: if ((i < 2) || (i - 2 != paramInputStream.skip(i - 2)))
      {
        Log.w("ExifParser", "Invalid JPEG format.");
        return false;
      }
    }
  }

  private void c(long paramLong)
  {
    cm.put(Integer.valueOf((int)paramLong), new c(3));
  }

  private boolean e(int paramInt1, int paramInt2)
  {
    paramInt2 = ce.d().get(paramInt2);
    if (paramInt2 == 0)
      return false;
    return c.d(paramInt2, paramInt1);
  }

  private boolean f()
  {
    return (bP & 0x20) != 0;
  }

  private boolean h()
  {
    switch (bS)
    {
    default:
    case 0:
      do
        return false;
      while ((!h(2)) && (!h(4)) && (!h(3)) && (!h(1)));
      return true;
    case 1:
      return f();
    case 2:
    }
    return h(3);
  }

  private boolean h(int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default:
      bool = false;
    case 0:
    case 1:
    case 2:
    case 4:
    case 3:
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
              return bool;
            while ((bP & 0x1) != 0);
            return false;
          }
          while ((bP & 0x2) != 0);
          return false;
        }
        while ((bP & 0x4) != 0);
        return false;
      }
      while ((bP & 0x8) != 0);
      return false;
    }
    while ((bP & 0x10) != 0);
    return false;
  }

  private void i(int paramInt)
    throws IOException
  {
    bO.b(paramInt);
    while ((!cm.isEmpty()) && (((Integer)cm.firstKey()).intValue() < paramInt))
      cm.pollFirstEntry();
  }

  private f n()
    throws IOException, ExifInvalidFormatException
  {
    short s1 = bO.readShort();
    short s2 = bO.readShort();
    long l1 = bO.c();
    if (l1 > 2147483647L)
      throw new ExifInvalidFormatException("Number of component is larger then Integer.MAX_VALUE");
    if (!f.c(s2))
    {
      Log.w("ExifParser", String.format("Tag %04x: Invalid data type %d", new Object[] { Short.valueOf(s1), Short.valueOf(s2) }));
      bO.skip(4L);
      return null;
    }
    int i = (int)l1;
    int j = bS;
    if ((int)l1 != 0);
    f localf;
    long l2;
    for (boolean bool = true; ; bool = false)
    {
      localf = new f(s1, s2, i, j, bool);
      i = localf.getDataSize();
      if (i <= 4)
        break label242;
      l2 = bO.c();
      if (l2 <= 2147483647L)
        break;
      throw new ExifInvalidFormatException("offset is larger then Integer.MAX_VALUE");
    }
    if ((l2 < cc) && (s2 == 7))
    {
      byte[] arrayOfByte = new byte[(int)l1];
      System.arraycopy(cb, (int)l2 - 8, arrayOfByte, 0, (int)l1);
      localf.setValue(arrayOfByte);
      return localf;
    }
    localf.setOffset((int)l2);
    return localf;
    label242: bool = localf.z();
    localf.a(false);
    c(localf);
    localf.a(bool);
    bO.skip(4 - i);
    localf.setOffset(bO.a() - 4);
    return localf;
  }

  private void o()
    throws IOException, ExifInvalidFormatException
  {
    int i = bO.readShort();
    if (18761 == i)
      bO.a(ByteOrder.LITTLE_ENDIAN);
    while (bO.readShort() != 42)
    {
      throw new ExifInvalidFormatException("Invalid TIFF header");
      if (19789 == i)
        bO.a(ByteOrder.BIG_ENDIAN);
      else
        throw new ExifInvalidFormatException("Invalid TIFF header");
    }
  }

  protected String a(int paramInt, Charset paramCharset)
    throws IOException
  {
    if (paramInt > 0)
      return bO.a(paramInt, paramCharset);
    return "";
  }

  protected void a(f paramf)
  {
    if (paramf.getOffset() >= bO.a())
      cm.put(Integer.valueOf(paramf.getOffset()), new a(paramf, true));
  }

  protected ByteOrder b()
  {
    return bO.b();
  }

  protected void c(f paramf)
    throws IOException
  {
    int i = paramf.v();
    if ((i == 2) || (i == 7) || (i == 1))
    {
      i = paramf.w();
      if ((cm.size() > 0) && (((Integer)cm.firstEntry().getKey()).intValue() < bO.a() + i))
      {
        localObject = cm.firstEntry().getValue();
        if (!(localObject instanceof c))
          break label221;
        Log.w("ExifParser", "Thumbnail overlaps value for tag: \n" + paramf.toString());
        localObject = cm.pollFirstEntry();
        Log.w("ExifParser", "Invalid thumbnail offset: " + ((Map.Entry)localObject).getKey());
      }
    }
    switch (paramf.v())
    {
    case 6:
    case 8:
    default:
      return;
      if ((localObject instanceof b))
        Log.w("ExifParser", "Ifd " + ((b)localObject).cp + " overlaps value for tag: \n" + paramf.toString());
      while (true)
      {
        i = ((Integer)cm.firstEntry().getKey()).intValue() - bO.a();
        Log.w("ExifParser", "Invalid size of tag: \n" + paramf.toString() + " setting count to: " + i);
        paramf.m(i);
        break;
        if ((localObject instanceof a))
          Log.w("ExifParser", "Tag value for tag: \n" + ((a)localObject).cn.toString() + " overlaps value for tag: \n" + paramf.toString());
      }
    case 1:
    case 7:
      localObject = new byte[paramf.w()];
      read((byte[])localObject);
      paramf.setValue((byte[])localObject);
      return;
    case 2:
      paramf.setValue(j(paramf.w()));
      return;
    case 4:
      localObject = new long[paramf.w()];
      i = 0;
      j = localObject.length;
      while (i < j)
      {
        localObject[i] = p();
        i += 1;
      }
      paramf.a((long[])localObject);
      return;
    case 5:
      localObject = new i[paramf.w()];
      i = 0;
      j = localObject.length;
      while (i < j)
      {
        localObject[i] = q();
        i += 1;
      }
      paramf.a((i[])localObject);
      return;
    case 3:
      localObject = new int[paramf.w()];
      i = 0;
      j = localObject.length;
      while (i < j)
      {
        localObject[i] = readUnsignedShort();
        i += 1;
      }
      paramf.b((int[])localObject);
      return;
    case 9:
      label221: localObject = new int[paramf.w()];
      i = 0;
      j = localObject.length;
      while (i < j)
      {
        localObject[i] = r();
        i += 1;
      }
      paramf.b((int[])localObject);
      return;
    case 10:
    }
    Object localObject = new i[paramf.w()];
    i = 0;
    int j = localObject.length;
    while (i < j)
    {
      localObject[i] = s();
      i += 1;
    }
    paramf.a((i[])localObject);
  }

  protected void g()
    throws IOException, ExifInvalidFormatException
  {
    int k = bQ + 2 + bR * 12;
    int i = bO.a();
    if (i > k);
    long l;
    do
    {
      return;
      if (bX)
        while (i < k)
        {
          bT = n();
          int j = i + 12;
          i = j;
          if (bT != null)
          {
            b(bT);
            i = j;
          }
        }
      i(k);
      l = p();
    }
    while ((bS != 0) || ((!h(1)) && (!f())) || (l <= 0L));
    a(1, l);
  }

  protected f i()
  {
    return bT;
  }

  protected int j()
  {
    return bS;
  }

  protected String j(int paramInt)
    throws IOException
  {
    return a(paramInt, US_ASCII);
  }

  protected int k()
  {
    return bU.cq;
  }

  protected int l()
  {
    if (bV == null)
      return 0;
    return (int)bV.o(0);
  }

  protected int m()
  {
    if (bW == null)
      return 0;
    return (int)bW.o(0);
  }

  protected int next()
    throws IOException, ExifInvalidFormatException
  {
    if (!bY)
      return 5;
    int i = bO.a();
    int j = bQ + 2 + bR * 12;
    if (i < j)
    {
      bT = n();
      if (bT == null)
        return next();
      if (bX)
        b(bT);
      return 1;
    }
    long l;
    if (i == j)
    {
      if (bS != 0)
        break label264;
      l = p();
      if (((h(1)) || (f())) && (l != 0L))
        a(1, l);
    }
    while (cm.size() != 0)
    {
      Object localObject1 = cm.pollFirstEntry();
      Object localObject2 = ((Map.Entry)localObject1).getValue();
      try
      {
        i(((Integer)((Map.Entry)localObject1).getKey()).intValue());
        if (!(localObject2 instanceof b))
          break label468;
        bS = ((b)localObject2).cp;
        bR = bO.readUnsignedShort();
        bQ = ((Integer)((Map.Entry)localObject1).getKey()).intValue();
        if (bR * 12 + bQ + 2 <= bZ)
          break label440;
        Log.w("ExifParser", "Invalid size of IFD " + bS);
        return 5;
        label264: i = 4;
        if (cm.size() > 0)
          i = ((Integer)cm.firstEntry().getKey()).intValue() - bO.a();
        if (i < 4)
        {
          Log.w("ExifParser", "Invalid size of link to next IFD: " + i);
          continue;
        }
        l = p();
        if (l == 0L)
          continue;
        Log.w("ExifParser", "Invalid link to next IFD: " + l);
      }
      catch (IOException localIOException)
      {
        Log.w("ExifParser", "Failed to skip to data at: " + ((Map.Entry)localObject1).getKey() + " for " + localObject2.getClass().getName() + ", the file may be broken.");
      }
      continue;
      label440: bX = h();
      if (((b)localObject2).co)
        return 0;
      g();
      continue;
      label468: if ((localObject2 instanceof c))
      {
        bU = ((c)localObject2);
        return bU.type;
      }
      localObject1 = (a)localObject2;
      bT = ((a)localObject1).cn;
      if (bT.v() != 7)
      {
        c(bT);
        b(bT);
      }
      if (((a)localObject1).co)
        return 2;
    }
    return 5;
  }

  protected long p()
    throws IOException
  {
    return r() & 0xFFFFFFFF;
  }

  protected i q()
    throws IOException
  {
    return new i(p(), p());
  }

  protected int r()
    throws IOException
  {
    return bO.readInt();
  }

  protected int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return bO.read(paramArrayOfByte);
  }

  protected int readUnsignedShort()
    throws IOException
  {
    return bO.readShort() & 0xFFFF;
  }

  protected i s()
    throws IOException
  {
    int i = r();
    int j = r();
    return new i(i, j);
  }

  private static class a
  {
    f cn;
    boolean co;

    a(f paramf, boolean paramBoolean)
    {
      cn = paramf;
      co = paramBoolean;
    }
  }

  private static class b
  {
    boolean co;
    int cp;

    b(int paramInt, boolean paramBoolean)
    {
      cp = paramInt;
      co = paramBoolean;
    }
  }

  private static class c
  {
    int cq;
    int type;

    c(int paramInt)
    {
      cq = 0;
      type = paramInt;
    }

    c(int paramInt1, int paramInt2)
    {
      type = paramInt1;
      cq = paramInt2;
    }
  }
}