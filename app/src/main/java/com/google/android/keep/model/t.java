package com.google.android.keep.model;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.keep.binder.Binder;
import com.google.android.keep.c;
import com.google.android.keep.editor.e.b;
import com.google.android.keep.editor.e.d;
import com.google.android.keep.p;
import com.google.android.keep.q.b;
import com.google.android.keep.r;

public class t
  implements e.b, e.d, s, q.b, r
{
  private final c dI;
  private final Activity mActivity;
  private TreeEntityModel me;
  private i no;
  private D np;
  private boolean yF;
  private boolean yG;
  private boolean yH;
  private long yI;

  public t(Activity paramActivity, p paramp)
  {
    paramp.b(this);
    mActivity = paramActivity;
    dI = ((c)paramActivity);
  }

  public void Z(boolean paramBoolean)
  {
    yF = paramBoolean;
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, Long paramLong)
  {
    dI.a(paramInt1, paramInt2, paramInt3, paramLong);
  }

  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    dI.a(paramInt1, paramLong, paramInt2, paramInt3);
  }

  public void a(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    dI.a(paramString1, paramString2, paramString3, paramLong);
  }

  public void aa(boolean paramBoolean)
  {
    yG = paramBoolean;
  }

  public void ab(boolean paramBoolean)
  {
    yH = paramBoolean;
  }

  public void dy()
  {
    long l = System.currentTimeMillis() - yI;
    if (yF)
    {
      dI.a(iM(), l, 2131230878, 2131231015);
      yF = false;
    }
    while (true)
    {
      if (yG)
      {
        dI.a(iM(), 2131230879, 2131231015, null);
        yG = false;
      }
      if (yH)
      {
        dI.a(iM(), 2131230880, 2131231015, null);
        yH = false;
      }
      return;
      dI.a(iM(), l, 2131230881, 2131231015);
    }
  }

  public void g(String paramString)
  {
    dI.g(paramString);
  }

  public int iM()
  {
    if ((me.isInitialized()) && (me.ir() == TreeEntity.TreeEntityType.zP))
      return 2131230864;
    if ((no.isInitialized()) && (no.size() > 0))
      return 2131230866;
    if ((np.isInitialized()) && (np.size() > 0))
      return 2131230865;
    return 2131230863;
  }

  public void j(long paramLong)
  {
    yI = System.currentTimeMillis();
    yF = false;
    yG = false;
  }

  public void n(int paramInt1, int paramInt2)
  {
    dI.a(iM(), paramInt1, paramInt2, null);
  }

  public void onCreate(Bundle paramBundle)
  {
    me = ((TreeEntityModel)Binder.a(mActivity, TreeEntityModel.class));
    np = ((D)Binder.a(mActivity, D.class));
    no = ((i)Binder.a(mActivity, i.class));
  }
}