package com.google.android.gallery3d.exif;

import android.util.SparseIntArray;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.TimeZone;

public class c
{
  public static final int A;
  public static final int B;
  public static final int C;
  public static final int D;
  public static final int E;
  public static final int F;
  public static final int G;
  public static final int H;
  public static final int I;
  public static final int J;
  public static final int K;
  public static final int L;
  public static final int M;
  public static final int N;
  public static final int O;
  public static final int Q;
  public static final int R;
  public static final int S;
  public static final int T;
  public static final int U;
  public static final int V;
  public static final int W;
  public static final int X;
  public static final int Y;
  public static final int Z;
  public static final int aA;
  public static final int aB;
  public static final int aC;
  public static final int aD;
  public static final int aE;
  public static final int aF;
  public static final int aG;
  public static final int aH;
  public static final int aI;
  public static final int aJ;
  public static final int aK;
  public static final int aL;
  public static final int aM;
  public static final int aN;
  public static final int aO;
  public static final int aP;
  public static final int aQ;
  public static final int aR;
  public static final int aS;
  public static final int aT;
  public static final int aU;
  public static final int aV;
  public static final int aW;
  public static final int aX;
  public static final int aY;
  public static final int aZ;
  public static final int aa;
  public static final int ab;
  public static final int ac;
  public static final int ad;
  public static final int ae;
  public static final int af;
  public static final int ag;
  public static final int ah;
  public static final int ai;
  public static final int aj;
  public static final int ak;
  public static final int al;
  public static final int am;
  public static final int an;
  public static final int ao;
  public static final int ap;
  public static final int aq;
  public static final int ar;
  public static final int as;
  public static final int at;
  public static final int au;
  public static final int av;
  public static final int aw;
  public static final int ax;
  public static final int ay;
  public static final int az;
  public static final int bA;
  public static final int bB;
  public static final int bC;
  public static final int bD;
  public static final int bE;
  public static final int bF;
  private static HashSet<Short> bG;
  protected static HashSet<Short> bH;
  public static final ByteOrder bJ = ByteOrder.BIG_ENDIAN;
  public static final int ba;
  public static final int bb;
  public static final int bc;
  public static final int bd;
  public static final int be;
  public static final int bf;
  public static final int bg;
  public static final int bh;
  public static final int bi;
  public static final int bj;
  public static final int bk;
  public static final int bl;
  public static final int bm;
  public static final int bn;
  public static final int bo;
  public static final int bp;
  public static final int bq;
  public static final int br;
  public static final int bs;
  public static final int bt;
  public static final int bu;
  public static final int bv;
  public static final int bw;
  public static final int bx;
  public static final int by;
  public static final int bz;
  public static final int l = a(0, (short)256);
  public static final int m = a(0, (short)257);
  public static final int n = a(0, (short)258);
  public static final int o = a(0, (short)259);
  public static final int p = a(0, (short)262);
  public static final int q = a(0, (short)270);
  public static final int r = a(0, (short)271);
  public static final int s = a(0, (short)272);
  public static final int u = a(0, (short)273);
  public static final int v = a(0, (short)274);
  public static final int w = a(0, (short)277);
  public static final int z = a(0, (short)278);
  private b bI = new b(bJ);
  private final DateFormat bK = new SimpleDateFormat("yyyy:MM:dd kk:mm:ss");
  private final DateFormat bL = new SimpleDateFormat("yyyy:MM:dd");
  private final Calendar bM = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
  private SparseIntArray bN = null;

  static
  {
    A = a(0, (short)279);
    B = a(0, (short)282);
    C = a(0, (short)283);
    D = a(0, (short)284);
    E = a(0, (short)296);
    F = a(0, (short)301);
    G = a(0, (short)305);
    H = a(0, (short)306);
    I = a(0, (short)315);
    J = a(0, (short)318);
    K = a(0, (short)319);
    L = a(0, (short)529);
    M = a(0, (short)530);
    N = a(0, (short)531);
    O = a(0, (short)532);
    Q = a(0, (short)-32104);
    R = a(0, (short)-30871);
    S = a(0, (short)-30683);
    T = a(1, (short)513);
    U = a(1, (short)514);
    V = a(2, (short)-32102);
    W = a(2, (short)-32099);
    X = a(2, (short)-30686);
    Y = a(2, (short)-30684);
    Z = a(2, (short)-30681);
    aa = a(2, (short)-30680);
    ab = a(2, (short)-28672);
    ac = a(2, (short)-28669);
    ad = a(2, (short)-28668);
    ae = a(2, (short)-28415);
    af = a(2, (short)-28414);
    ag = a(2, (short)-28159);
    ah = a(2, (short)-28158);
    ai = a(2, (short)-28157);
    aj = a(2, (short)-28156);
    ak = a(2, (short)-28155);
    al = a(2, (short)-28154);
    am = a(2, (short)-28153);
    an = a(2, (short)-28152);
    ao = a(2, (short)-28151);
    ap = a(2, (short)-28150);
    aq = a(2, (short)-28140);
    ar = a(2, (short)-28036);
    as = a(2, (short)-28026);
    at = a(2, (short)-28016);
    au = a(2, (short)-28015);
    av = a(2, (short)-28014);
    aw = a(2, (short)-24576);
    ax = a(2, (short)-24575);
    ay = a(2, (short)-24574);
    az = a(2, (short)-24573);
    aA = a(2, (short)-24572);
    aB = a(2, (short)-24571);
    aC = a(2, (short)-24053);
    aD = a(2, (short)-24052);
    aE = a(2, (short)-24050);
    aF = a(2, (short)-24049);
    aG = a(2, (short)-24048);
    aH = a(2, (short)-24044);
    aI = a(2, (short)-24043);
    aJ = a(2, (short)-24041);
    aK = a(2, (short)-23808);
    aL = a(2, (short)-23807);
    aM = a(2, (short)-23806);
    aN = a(2, (short)-23551);
    aO = a(2, (short)-23550);
    aP = a(2, (short)-23549);
    aQ = a(2, (short)-23548);
    aR = a(2, (short)-23547);
    aS = a(2, (short)-23546);
    aT = a(2, (short)-23545);
    aU = a(2, (short)-23544);
    aV = a(2, (short)-23543);
    aW = a(2, (short)-23542);
    aX = a(2, (short)-23541);
    aY = a(2, (short)-23540);
    aZ = a(2, (short)-23520);
    ba = a(4, (short)0);
    bb = a(4, (short)1);
    bc = a(4, (short)2);
    bd = a(4, (short)3);
    be = a(4, (short)4);
    bf = a(4, (short)5);
    bg = a(4, (short)6);
    bh = a(4, (short)7);
    bi = a(4, (short)8);
    bj = a(4, (short)9);
    bk = a(4, (short)10);
    bl = a(4, (short)11);
    bm = a(4, (short)12);
    bn = a(4, (short)13);
    bo = a(4, (short)14);
    bp = a(4, (short)15);
    bq = a(4, (short)16);
    br = a(4, (short)17);
    bs = a(4, (short)18);
    bt = a(4, (short)19);
    bu = a(4, (short)20);
    bv = a(4, (short)21);
    bw = a(4, (short)22);
    bx = a(4, (short)23);
    by = a(4, (short)24);
    bz = a(4, (short)25);
    bA = a(4, (short)26);
    bB = a(4, (short)27);
    bC = a(4, (short)28);
    bD = a(4, (short)29);
    bE = a(4, (short)30);
    bF = a(3, (short)1);
    bG = new HashSet();
    bG.add(Short.valueOf(b(S)));
    bG.add(Short.valueOf(b(R)));
    bG.add(Short.valueOf(b(T)));
    bG.add(Short.valueOf(b(aB)));
    bG.add(Short.valueOf(b(u)));
    bH = new HashSet(bG);
    bH.add(Short.valueOf(b(-1)));
    bH.add(Short.valueOf(b(U)));
    bH.add(Short.valueOf(b(A)));
  }

  public c()
  {
    bL.setTimeZone(TimeZone.getTimeZone("UTC"));
  }

  public static int a(int paramInt, short paramShort)
  {
    return 0xFFFF & paramShort | paramInt << 16;
  }

  protected static int a(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
      k = 0;
    int i;
    int[] arrayOfInt;
    int j;
    do
    {
      return k;
      i = 0;
      arrayOfInt = g.A();
      j = 0;
      k = i;
    }
    while (j >= 5);
    int i2 = paramArrayOfInt.length;
    int k = 0;
    while (true)
    {
      int i1 = i;
      if (k < i2)
      {
        i1 = paramArrayOfInt[k];
        if (arrayOfInt[j] == i1)
          i1 = i | 1 << j;
      }
      else
      {
        j += 1;
        i = i1;
        break;
      }
      k += 1;
    }
  }

  protected static boolean a(short paramShort)
  {
    return bG.contains(Short.valueOf(paramShort));
  }

  public static int b(short paramShort)
  {
    switch (paramShort)
    {
    case 1:
    case 2:
    case 4:
    case 5:
    case 7:
    default:
      return 0;
    case 6:
      return 90;
    case 3:
      return 180;
    case 8:
    }
    return 270;
  }

  public static short b(int paramInt)
  {
    return (short)paramInt;
  }

  public static int c(int paramInt)
  {
    return paramInt >>> 16;
  }

  protected static boolean d(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = g.A();
    int i = g(paramInt1);
    paramInt1 = 0;
    while (paramInt1 < arrayOfInt.length)
    {
      if ((paramInt2 == arrayOfInt[paramInt1]) && ((i >> paramInt1 & 0x1) == 1))
        return true;
      paramInt1 += 1;
    }
    return false;
  }

  private void e()
  {
    int i = a(new int[] { 0, 1 }) << 24;
    bN.put(r, 0x20000 | i | 0x0);
    bN.put(l, 0x40000 | i | 0x1);
    bN.put(m, 0x40000 | i | 0x1);
    bN.put(n, 0x30000 | i | 0x3);
    bN.put(o, 0x30000 | i | 0x1);
    bN.put(p, 0x30000 | i | 0x1);
    bN.put(v, 0x30000 | i | 0x1);
    bN.put(w, 0x30000 | i | 0x1);
    bN.put(D, 0x30000 | i | 0x1);
    bN.put(M, 0x30000 | i | 0x2);
    bN.put(N, 0x30000 | i | 0x1);
    bN.put(B, 0x50000 | i | 0x1);
    bN.put(C, 0x50000 | i | 0x1);
    bN.put(E, 0x30000 | i | 0x1);
    bN.put(u, 0x40000 | i | 0x0);
    bN.put(z, 0x40000 | i | 0x1);
    bN.put(A, 0x40000 | i | 0x0);
    bN.put(F, 0x30000 | i | 0x300);
    bN.put(J, 0x50000 | i | 0x2);
    bN.put(K, 0x50000 | i | 0x6);
    bN.put(L, 0x50000 | i | 0x3);
    bN.put(O, 0x50000 | i | 0x6);
    bN.put(H, 0x20000 | i | 0x14);
    bN.put(q, 0x20000 | i | 0x0);
    bN.put(r, 0x20000 | i | 0x0);
    bN.put(s, 0x20000 | i | 0x0);
    bN.put(G, 0x20000 | i | 0x0);
    bN.put(I, 0x20000 | i | 0x0);
    bN.put(Q, 0x20000 | i | 0x0);
    bN.put(R, 0x40000 | i | 0x1);
    bN.put(S, 0x40000 | i | 0x1);
    i = a(new int[] { 1 }) << 24;
    bN.put(T, 0x40000 | i | 0x1);
    bN.put(U, 0x40000 | i | 0x1);
    i = a(new int[] { 2 }) << 24;
    bN.put(ab, 0x70000 | i | 0x4);
    bN.put(aw, 0x70000 | i | 0x4);
    bN.put(ax, 0x30000 | i | 0x1);
    bN.put(ae, 0x70000 | i | 0x4);
    bN.put(af, 0x50000 | i | 0x1);
    bN.put(ay, 0x40000 | i | 0x1);
    bN.put(az, 0x40000 | i | 0x1);
    bN.put(ar, 0x70000 | i | 0x0);
    bN.put(as, 0x70000 | i | 0x0);
    bN.put(aA, 0x20000 | i | 0xD);
    bN.put(ac, 0x20000 | i | 0x14);
    bN.put(ad, 0x20000 | i | 0x14);
    bN.put(at, 0x20000 | i | 0x0);
    bN.put(au, 0x20000 | i | 0x0);
    bN.put(av, 0x20000 | i | 0x0);
    bN.put(aZ, 0x20000 | i | 0x21);
    bN.put(V, 0x50000 | i | 0x1);
    bN.put(W, 0x50000 | i | 0x1);
    bN.put(X, 0x30000 | i | 0x1);
    bN.put(Y, 0x20000 | i | 0x0);
    bN.put(Z, 0x30000 | i | 0x0);
    bN.put(aa, 0x70000 | i | 0x0);
    bN.put(ag, 0xA0000 | i | 0x1);
    bN.put(ah, 0x50000 | i | 0x1);
    bN.put(ai, 0xA0000 | i | 0x1);
    bN.put(aj, 0xA0000 | i | 0x1);
    bN.put(ak, 0x50000 | i | 0x1);
    bN.put(al, 0x50000 | i | 0x1);
    bN.put(am, 0x30000 | i | 0x1);
    bN.put(an, 0x30000 | i | 0x1);
    bN.put(ao, 0x30000 | i | 0x1);
    bN.put(ap, 0x50000 | i | 0x1);
    bN.put(aq, 0x30000 | i | 0x0);
    bN.put(aC, 0x50000 | i | 0x1);
    bN.put(aD, 0x70000 | i | 0x0);
    bN.put(aE, 0x50000 | i | 0x1);
    bN.put(aF, 0x50000 | i | 0x1);
    bN.put(aG, 0x30000 | i | 0x1);
    bN.put(aH, 0x30000 | i | 0x2);
    bN.put(aI, 0x50000 | i | 0x1);
    bN.put(aJ, 0x30000 | i | 0x1);
    bN.put(aK, 0x70000 | i | 0x1);
    bN.put(aL, 0x70000 | i | 0x1);
    bN.put(aM, 0x70000 | i | 0x0);
    bN.put(aN, 0x30000 | i | 0x1);
    bN.put(aO, 0x30000 | i | 0x1);
    bN.put(aP, 0x30000 | i | 0x1);
    bN.put(aQ, 0x50000 | i | 0x1);
    bN.put(aR, 0x30000 | i | 0x1);
    bN.put(aS, 0x30000 | i | 0x1);
    bN.put(aT, 0x50000 | i | 0x1);
    bN.put(aU, 0x30000 | i | 0x1);
    bN.put(aV, 0x30000 | i | 0x1);
    bN.put(aW, 0x30000 | i | 0x1);
    bN.put(aX, 0x70000 | i | 0x0);
    bN.put(aY, 0x30000 | i | 0x1);
    bN.put(aB, 0x40000 | i | 0x1);
    i = a(new int[] { 4 }) << 24;
    bN.put(ba, 0x10000 | i | 0x4);
    bN.put(bb, 0x20000 | i | 0x2);
    bN.put(bd, 0x20000 | i | 0x2);
    bN.put(bc, 0xA0000 | i | 0x3);
    bN.put(be, 0xA0000 | i | 0x3);
    bN.put(bf, 0x10000 | i | 0x1);
    bN.put(bg, 0x50000 | i | 0x1);
    bN.put(bh, 0x50000 | i | 0x3);
    bN.put(bi, 0x20000 | i | 0x0);
    bN.put(bj, 0x20000 | i | 0x2);
    bN.put(bk, 0x20000 | i | 0x2);
    bN.put(bl, 0x50000 | i | 0x1);
    bN.put(bm, 0x20000 | i | 0x2);
    bN.put(bn, 0x50000 | i | 0x1);
    bN.put(bo, 0x20000 | i | 0x2);
    bN.put(bp, 0x50000 | i | 0x1);
    bN.put(bq, 0x20000 | i | 0x2);
    bN.put(br, 0x50000 | i | 0x1);
    bN.put(bs, 0x20000 | i | 0x0);
    bN.put(bt, 0x20000 | i | 0x2);
    bN.put(bu, 0x50000 | i | 0x1);
    bN.put(bx, 0x20000 | i | 0x2);
    bN.put(by, 0x50000 | i | 0x1);
    bN.put(bz, 0x20000 | i | 0x2);
    bN.put(bA, 0x50000 | i | 0x1);
    bN.put(bB, 0x70000 | i | 0x0);
    bN.put(bC, 0x70000 | i | 0x0);
    bN.put(bD, 0x20000 | i | 0xB);
    bN.put(bE, 0x30000 | i | 0xB);
    i = a(new int[] { 3 });
    bN.put(bF, 0x20000 | i << 24 | 0x0);
  }

  protected static int g(int paramInt)
  {
    return paramInt >>> 24;
  }

  public f a(int paramInt1, int paramInt2)
  {
    if (!f.k(paramInt2))
      return null;
    return bI.a(b(paramInt1), paramInt2);
  }

  public void a(InputStream paramInputStream)
    throws IOException
  {
    if (paramInputStream == null)
      throw new IllegalArgumentException("Argument is null");
    try
    {
      paramInputStream = new e(this).c(paramInputStream);
      bI = paramInputStream;
      return;
    }
    catch (ExifInvalidFormatException paramInputStream)
    {
    }
    throw new IOException("Invalid exif format : " + paramInputStream);
  }

  // ERROR //
  public void a(java.lang.String paramString)
    throws java.io.FileNotFoundException, IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 519	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 521
    //   11: invokespecial 522	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aconst_null
    //   16: astore_2
    //   17: new 552	java/io/BufferedInputStream
    //   20: dup
    //   21: new 554	java/io/FileInputStream
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 555	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   29: invokespecial 557	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore_1
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 559	com/google/android/gallery3d/exif/c:a	(Ljava/io/InputStream;)V
    //   38: aload_1
    //   39: invokevirtual 564	java/io/InputStream:close	()V
    //   42: return
    //   43: astore_1
    //   44: aload_2
    //   45: invokestatic 568	com/google/android/keep/util/e:e	(Ljava/io/InputStream;)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_3
    //   51: aload_1
    //   52: astore_2
    //   53: aload_3
    //   54: astore_1
    //   55: goto -11 -> 44
    //
    // Exception table:
    //   from	to	target	type
    //   17	33	43	java/io/IOException
    //   33	38	50	java/io/IOException
  }

  public Integer b(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = c(paramInt1, paramInt2);
    if ((arrayOfInt == null) || (arrayOfInt.length <= 0))
      return null;
    return new Integer(arrayOfInt[0]);
  }

  public int[] c(int paramInt1, int paramInt2)
  {
    f localf = a(paramInt1, paramInt2);
    if (localf == null)
      return null;
    return localf.x();
  }

  protected SparseIntArray d()
  {
    if (bN == null)
    {
      bN = new SparseIntArray();
      e();
    }
    return bN;
  }

  public f d(int paramInt)
  {
    return a(paramInt, f(paramInt));
  }

  public Integer e(int paramInt)
  {
    return b(paramInt, f(paramInt));
  }

  public int f(int paramInt)
  {
    if (d().get(paramInt) == 0)
      return -1;
    return c(paramInt);
  }
}