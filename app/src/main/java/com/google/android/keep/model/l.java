package com.google.android.keep.model;

import android.support.v4.app.FragmentActivity;
import com.google.android.keep.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class l extends ModelEventDispatcher
{
  private k vB;
  private v vC;

  public l(FragmentActivity paramFragmentActivity, p paramp)
  {
    vB = new k(paramFragmentActivity, paramp);
    vB.a(this);
    vC = new v(paramFragmentActivity, paramp);
    vC.a(this);
  }

  public Label P(String paramString)
  {
    return vB.P(paramString);
  }

  public Label Q(String paramString)
  {
    return vB.Q(paramString);
  }

  public Label S(String paramString)
  {
    return vB.R(paramString);
  }

  public void T(String paramString)
  {
    vB.d(P(paramString));
  }

  public void a(String paramString, long paramLong)
  {
    Label localLabel = vB.Q(paramString);
    if (localLabel != null)
    {
      vC.a(new u(paramString, paramLong));
      localLabel.hn();
    }
  }

  public void b(String paramString, long paramLong)
  {
    paramString = vC.d(paramLong, paramString);
    vC.b(paramString);
  }

  public void c(ModelEventDispatcher.a parama)
  {
    if (parama.a(new ModelEventDispatcher.EventType[] { ModelEventDispatcher.EventType.wF }))
    {
      if ((vC.isInitialized()) && (vB.isInitialized()))
        super.c(new ModelEventDispatcher.a(this, ModelEventDispatcher.EventType.wF));
      return;
    }
    super.c(parama);
  }

  public ArrayList<Label> ho()
  {
    ArrayList localArrayList = new ArrayList(vB.ho());
    Collections.sort(localArrayList);
    return localArrayList;
  }

  public ArrayList<Label> v(long paramLong)
  {
    Object localObject = vC.G(paramLong);
    localObject = vB.a((HashSet)localObject);
    Collections.sort((List)localObject);
    return localObject;
  }
}