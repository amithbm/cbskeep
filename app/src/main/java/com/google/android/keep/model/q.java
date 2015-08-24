package com.google.android.keep.model;

import android.text.TextUtils;
import com.google.android.keep.provider.h;
import com.google.android.keep.provider.k;
import com.google.android.keep.provider.n;

public class q
{
  private String iF;
  private String ja;
  private String uK;
  private long uL = 0L;
  private Long vG;
  private int xJ = 0;
  private int xK = 0;
  private long[] xL;
  private m[] xM;
  private boolean xN;
  private int xO;
  private Sharee[] xP;
  private Long yj;
  private Long yk;
  private Boolean yl;
  private Boolean ym;
  private TreeEntity.TreeEntityType yn;
  private ColorMap.ColorPair yo;
  private TreeEntitySettings yp;
  protected Long yq;
  protected Long yr;
  protected long ys;
  private long yt = 0L;
  private String yu;
  private boolean yv;
  private String yw;
  private boolean yx;
  protected boolean yy;

  public q A(long paramLong)
  {
    yt = paramLong;
    return this;
  }

  public q B(long paramLong)
  {
    if (paramLong != 0L)
      throw new IllegalArgumentException("In Browse mode, parent id should be 0 instead of " + paramLong);
    vG = Long.valueOf(paramLong);
    return this;
  }

  public q C(long paramLong)
  {
    yq = Long.valueOf(paramLong);
    return this;
  }

  public q D(long paramLong)
  {
    yr = Long.valueOf(paramLong);
    return this;
  }

  public q E(long paramLong)
  {
    ys = paramLong;
    return this;
  }

  public q F(long paramLong)
  {
    uL = paramLong;
    return this;
  }

  public q T(boolean paramBoolean)
  {
    yl = Boolean.valueOf(paramBoolean);
    return this;
  }

  public q U(boolean paramBoolean)
  {
    ym = Boolean.valueOf(paramBoolean);
    return this;
  }

  public q V(boolean paramBoolean)
  {
    xN = paramBoolean;
    return this;
  }

  public q W(boolean paramBoolean)
  {
    yv = paramBoolean;
    return this;
  }

  public q X(boolean paramBoolean)
  {
    yx = paramBoolean;
    return this;
  }

  public q Y(boolean paramBoolean)
  {
    yy = paramBoolean;
    return this;
  }

  public q a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    yp = new TreeEntitySettings(paramBoolean1, paramBoolean2, paramBoolean3);
    return this;
  }

  public q af(String paramString)
  {
    uK = paramString;
    return this;
  }

  public q ag(String paramString)
  {
    iF = paramString;
    return this;
  }

  public q ah(String paramString)
  {
    ja = paramString;
    return this;
  }

  public q ai(String paramString)
  {
    yo = ColorMap.I(paramString);
    return this;
  }

  public q aj(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    for (paramString = null; ; paramString = k.aL(paramString))
    {
      xM = paramString;
      return this;
    }
  }

  public q ak(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    for (paramString = null; ; paramString = h.aG(paramString))
    {
      xL = paramString;
      return this;
    }
  }

  public q al(String paramString)
  {
    yw = paramString;
    return this;
  }

  public q am(String paramString)
  {
    yu = paramString;
    return this;
  }

  public q an(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    for (paramString = null; ; paramString = n.aS(paramString))
    {
      xP = paramString;
      return this;
    }
  }

  public q b(ColorMap.ColorPair paramColorPair)
  {
    yo = paramColorPair;
    return this;
  }

  public q b(TreeEntity.TreeEntityType paramTreeEntityType)
  {
    yn = paramTreeEntityType;
    return this;
  }

  public q b(TreeEntitySettings paramTreeEntitySettings)
  {
    yp = paramTreeEntitySettings;
    return this;
  }

  public q bc(int paramInt)
  {
    xK = paramInt;
    return this;
  }

  public q bd(int paramInt)
  {
    xJ = paramInt;
    return this;
  }

  public q be(int paramInt)
  {
    xO = paramInt;
    return this;
  }

  public long gJ()
  {
    return uL;
  }

  public long getChangesSeenTimestamp()
  {
    return ys;
  }

  public Boolean getIsArchived()
  {
    return yl;
  }

  public String getLastModifierEmail()
  {
    return yu;
  }

  public String getServerId()
  {
    return iF;
  }

  public String getSharerEmail()
  {
    return yw;
  }

  public String getTitle()
  {
    return ja;
  }

  public String gu()
  {
    return uK;
  }

  public Long hp()
  {
    return vG;
  }

  public TreeEntitySettings iA()
  {
    return yp;
  }

  public int iB()
  {
    return xK;
  }

  public int iC()
  {
    return xJ;
  }

  public boolean iD()
  {
    return yv;
  }

  public boolean iE()
  {
    return yx;
  }

  public int iF()
  {
    return xO;
  }

  public boolean iG()
  {
    return yy;
  }

  public long[] ik()
  {
    return xL;
  }

  public m[] im()
  {
    return xM;
  }

  public boolean in()
  {
    return xN;
  }

  public Sharee[] iq()
  {
    return xP;
  }

  public TreeEntity.TreeEntityType ir()
  {
    return yn;
  }

  public Long it()
  {
    return yj;
  }

  public Long iu()
  {
    return yk;
  }

  public Long iv()
  {
    return Long.valueOf(yt);
  }

  public Boolean iw()
  {
    return ym;
  }

  public Long ix()
  {
    return yq;
  }

  public Long iy()
  {
    return yr;
  }

  public ColorMap.ColorPair iz()
  {
    return yo;
  }

  public q y(long paramLong)
  {
    yj = Long.valueOf(paramLong);
    return this;
  }

  public q z(long paramLong)
  {
    yk = Long.valueOf(paramLong);
    return this;
  }
}