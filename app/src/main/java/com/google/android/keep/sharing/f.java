package com.google.android.keep.sharing;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.keep.model.Sharee;
import com.google.android.keep.model.j;
import com.google.android.keep.ui.CircularImageView;
import com.google.android.keep.ui.c;
import com.google.android.keep.util.B;
import com.google.android.keep.util.a;
import java.util.HashMap;
import java.util.List;

public class f extends ArrayAdapter<Sharee>
{
  private final a Fe;
  private final HashMap<Sharee, Integer> Fk = new HashMap();
  private boolean Fl = false;
  protected final c eF;
  protected final j fr;
  protected final Context mContext;
  protected final LayoutInflater mInflater;

  public f(Context paramContext, a parama, j paramj, c paramc)
  {
    super(paramContext, 2130968756);
    mContext = paramContext;
    Fe = parama;
    mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    eF = paramc;
    fr = paramj;
  }

  protected void a(View paramView, Sharee paramSharee)
  {
    paramView.findViewById(2131493363).setVisibility(0);
    TextView localTextView1 = (TextView)paramView.findViewById(2131493364);
    TextView localTextView2 = (TextView)paramView.findViewById(2131493365);
    String str = paramSharee.getDisplayName();
    paramSharee = paramSharee.getEmail();
    if (TextUtils.equals(str, paramSharee))
    {
      localTextView1.setText(paramSharee);
      localTextView2.setVisibility(8);
    }
    while (true)
    {
      paramView = paramView.findViewById(2131493367);
      if (paramView != null)
        paramView.setVisibility(8);
      return;
      localTextView1.setText(str);
      localTextView2.setText(paramSharee);
      localTextView2.setVisibility(0);
    }
  }

  protected void b(View paramView, Sharee paramSharee)
  {
    View localView2 = paramView.findViewById(2131493367);
    View localView1 = localView2;
    if (localView2 == null)
      localView1 = ((ViewStub)paramView.findViewById(2131493366)).inflate();
    localView1.setVisibility(0);
    ((TextView)paramView.findViewById(2131493369)).setText(paramSharee.getEmail());
    paramView.findViewById(2131493363).setVisibility(8);
  }

  public void b(Sharee paramSharee)
  {
    super.add(paramSharee);
    if (!Fk.containsKey(paramSharee))
      Fk.put(paramSharee, Integer.valueOf(Fk.size()));
  }

  public long getItemId(int paramInt)
  {
    Sharee localSharee = (Sharee)getItem(paramInt);
    return ((Integer)Fk.get(localSharee)).intValue();
  }

  public View getView(final int paramInt, final View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = mInflater.inflate(2130968756, paramViewGroup, false);
      paramViewGroup = (Sharee)getItem(paramInt);
      paramView.setTag(paramViewGroup);
      if (!B.bL(paramViewGroup.getEmail()))
        break label107;
      b(paramView, paramViewGroup);
    }
    Object localObject;
    while (true)
    {
      localObject = (CircularImageView)paramView.findViewById(2131493362);
      eF.a(paramViewGroup.getEmail(), fr.getName(), (ImageView)localObject);
      localObject = (ImageView)paramView.findViewById(2131493242);
      if (!Fl)
        break label116;
      ((ImageView)localObject).setVisibility(8);
      return paramView;
      break;
      label107: a(paramView, paramViewGroup);
    }
    label116: ((ImageView)localObject).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = (Sharee)getItem(paramInt);
        f.a(f.this).a(paramAnonymousView, paramView);
        a.a(paramView, mContext.getResources().getString(2131231340, new Object[] { paramAnonymousView.getDisplayName() }));
      }
    });
    if (paramViewGroup.iD())
    {
      ((ImageView)localObject).setVisibility(4);
      return paramView;
    }
    ((ImageView)localObject).setVisibility(0);
    return paramView;
  }

  public boolean hasStableIds()
  {
    return true;
  }

  public void v(List<Sharee> paramList)
  {
    super.addAll(paramList);
    int i = 0;
    while (i < paramList.size())
    {
      Sharee localSharee = (Sharee)paramList.get(i);
      Fk.put(localSharee, Integer.valueOf(i));
      i += 1;
    }
  }

  public void w(List<Sharee> paramList)
  {
    clear();
    v(paramList);
  }

  public static abstract interface a
  {
    public abstract void a(Sharee paramSharee, View paramView);
  }
}