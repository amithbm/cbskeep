package com.google.android.keep.browse;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.keep.model.ColorMap.ColorPair;
import com.google.android.keep.model.Note;
import com.google.android.keep.model.Sharee;
import com.google.android.keep.model.j;
import com.google.android.keep.ui.IndexListItem;
import com.google.android.keep.ui.c;
import com.google.android.keep.util.d;
import com.google.android.keep.util.e;
import com.google.android.keep.util.o;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class r
{
  private static abstract class a
  {
    public final View jH;
    public final ViewGroup jI;
    public final View jJ;

    public a(View paramView)
    {
      jH = paramView;
      jI = ((ViewGroup)paramView.findViewById(2131493074));
      jJ = paramView.findViewById(2131493116);
    }

    public void setAlpha(float paramFloat)
    {
      Drawable localDrawable = jI.getBackground();
      if (localDrawable != null)
        localDrawable.setAlpha((int)(255.0F * paramFloat));
    }
  }

  public static class b extends r.a
  {
    public final TextView jK;

    public b(View paramView)
    {
      super();
      jK = ((TextView)paramView.findViewById(2131493094));
    }
  }

  public static class c extends r.d
  {
    public final View jL;

    public c(View paramView)
    {
      super();
      jL = paramView.findViewById(2131493086);
    }

    public void setAlpha(float paramFloat)
    {
      super.setAlpha(paramFloat);
      int j = jI.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = jI.getChildAt(i);
        if ((localView instanceof IndexListItem))
          localView.setAlpha(paramFloat);
        i += 1;
      }
      if (jL != null)
        jL.setAlpha(paramFloat);
    }
  }

  public static class d extends r.e
  {
    private final List<ViewStub> jM = Lists.newArrayListWithCapacity(6);
    private final List<ImageView> jN = Lists.newArrayListWithCapacity(6);
    private final View jO;

    public d(View paramView)
    {
      super();
      jM.add((ViewStub)paramView.findViewById(2131493062));
      jM.add((ViewStub)paramView.findViewById(2131493064));
      jM.add((ViewStub)paramView.findViewById(2131493066));
      jM.add((ViewStub)paramView.findViewById(2131493068));
      jM.add((ViewStub)paramView.findViewById(2131493070));
      jM.add((ViewStub)paramView.findViewById(2131493072));
      jN.add((ImageView)paramView.findViewById(2131493063));
      jN.add((ImageView)paramView.findViewById(2131493065));
      jN.add((ImageView)paramView.findViewById(2131493067));
      jN.add((ImageView)paramView.findViewById(2131493069));
      jN.add((ImageView)paramView.findViewById(2131493071));
      jN.add((ImageView)paramView.findViewById(2131493073));
      jO = jH.findViewById(2131493101);
    }

    public static void a(ImageView paramImageView, int paramInt1, int paramInt2)
      throws IllegalArgumentException
    {
      if ((paramInt1 < 0) || (paramInt2 < 0))
        throw new IllegalArgumentException("Photo dimensions cannot be negative.");
      ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      paramImageView.setLayoutParams(localLayoutParams);
    }

    public ImageView af(int paramInt)
    {
      ImageView localImageView2 = (ImageView)jN.get(paramInt);
      ViewStub localViewStub = (ViewStub)jM.get(paramInt);
      ImageView localImageView1 = localImageView2;
      if (localImageView2 == null)
      {
        localImageView1 = localImageView2;
        if (localViewStub != null)
        {
          localImageView1 = (ImageView)localViewStub.inflate();
          jN.set(paramInt, localImageView1);
        }
      }
      return localImageView1;
    }

    public void ag(int paramInt)
    {
      jO.setBackgroundColor(paramInt);
      jO.setVisibility(0);
    }

    public int cN()
    {
      return 6;
    }

    public void cO()
    {
      Iterator localIterator = jN.iterator();
      while (localIterator.hasNext())
      {
        ImageView localImageView = (ImageView)localIterator.next();
        if (localImageView != null)
          localImageView.setVisibility(8);
      }
    }

    public void cP()
    {
      jO.setVisibility(8);
    }

    public void setAlpha(float paramFloat)
    {
      super.setAlpha(paramFloat);
      Iterator localIterator = jN.iterator();
      while (localIterator.hasNext())
        e.a((ImageView)localIterator.next(), paramFloat);
    }
  }

  public static class e extends r.f
  {
    public final TextNoteView jP;
    private final View jQ;
    private final TextView jR;
    private final ImageView jS;
    private final ImageView jT;
    private final ImageView jU;
    private final ImageView jV;

    public e(View paramView)
    {
      super();
      jP = ((TextNoteView)paramView.findViewById(2131493075));
      jQ = jH.findViewById(2131493265);
      jR = ((TextView)jH.findViewById(2131493271));
      jS = ((ImageView)jH.findViewById(2131493270));
      jT = ((ImageView)jH.findViewById(2131493268));
      jU = ((ImageView)jH.findViewById(2131493266));
      jV = ((ImageView)jH.findViewById(2131493267));
    }

    public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, Drawable paramDrawable, int paramInt, boolean paramBoolean3)
    {
      jQ.setVisibility(0);
      if (jU != null)
        jU.setVisibility(paramInt);
      if (jV != null)
      {
        ImageView localImageView = jV;
        if (paramBoolean3)
        {
          paramInt = 0;
          localImageView.setVisibility(paramInt);
        }
      }
      else
      {
        if (jR != null)
        {
          if (TextUtils.isEmpty(paramString))
            break label157;
          jR.setText(paramString);
          jR.setVisibility(0);
          label82: if (!paramBoolean1)
            break label169;
          jR.setTypeface(null, 2);
        }
        label95: if (jT != null)
        {
          paramString = jT;
          if (!paramBoolean2)
            break label180;
        }
      }
      label157: label169: label180: for (paramInt = 0; ; paramInt = 8)
      {
        paramString.setVisibility(paramInt);
        if (jS != null)
        {
          if (paramDrawable == null)
            break label187;
          jS.setImageDrawable(paramDrawable);
          jS.setVisibility(0);
        }
        return;
        paramInt = 8;
        break;
        jR.setVisibility(8);
        break label82;
        jR.setTypeface(null);
        break label95;
      }
      label187: jS.setVisibility(8);
    }

    public void cQ()
    {
      jQ.setVisibility(8);
    }

    public void setAlpha(float paramFloat)
    {
      super.setAlpha(paramFloat);
      if (jP != null)
        jP.setAlpha(paramFloat);
      jR.setAlpha(paramFloat);
      e.a(jS, paramFloat);
      e.a(jT, paramFloat);
    }
  }

  public static class f extends r.a
  {
    public final TextView jW;
    public View jX;
    public View jY;
    public Note jZ;
    private final View ka;

    public f(View paramView)
    {
      super();
      jW = ((TextView)paramView.findViewById(2131492986));
      ka = jH.findViewById(2131493087);
    }

    public void a(Context paramContext, c paramc, String paramString1, String paramString2, String paramString3)
    {
      if (jX == null)
      {
        jX = ((ViewStub)jH.findViewById(2131493112)).inflate();
        jI.setMinimumHeight((int)jX.getContext().getResources().getDimension(2131427525));
        ImageView localImageView = (ImageView)jX.findViewById(2131493118);
        paramc.a(paramString2, o.O(paramContext).getName(), localImageView);
        paramContext = (TextView)jX.findViewById(2131493119);
        if (TextUtils.isEmpty(paramString1))
          break label172;
        paramContext.setVisibility(0);
        paramContext.setText(paramString1);
        label108: paramContext = (TextView)jX.findViewById(2131493120);
        if (TextUtils.isEmpty(paramString3))
          break label181;
        paramContext.setVisibility(0);
        paramContext.setText(paramString3);
      }
      while (true)
      {
        jX.setBackgroundDrawable(d.bu(jZ.iz().getKey()));
        return;
        jX.setVisibility(0);
        break;
        label172: paramContext.setVisibility(8);
        break label108;
        label181: paramContext.setVisibility(8);
      }
    }

    public void a(Context paramContext, c paramc, List<Sharee> paramList)
    {
      ka.setVisibility(0);
      ImageView[] arrayOfImageView = new ImageView[5];
      arrayOfImageView[0] = ((ImageView)ka.findViewById(2131493088));
      arrayOfImageView[1] = ((ImageView)ka.findViewById(2131493089));
      arrayOfImageView[2] = ((ImageView)ka.findViewById(2131493090));
      arrayOfImageView[3] = ((ImageView)ka.findViewById(2131493091));
      arrayOfImageView[4] = ((ImageView)ka.findViewById(2131493092));
      int j = arrayOfImageView.length;
      int k = paramList.size();
      int i = 0;
      if (i < j)
      {
        if (i < k)
        {
          arrayOfImageView[i].setVisibility(0);
          paramc.a(((Sharee)paramList.get(i)).getEmail(), o.O(paramContext).getName(), arrayOfImageView[i]);
        }
        while (true)
        {
          i += 1;
          break;
          arrayOfImageView[i].setVisibility(8);
        }
      }
      paramc = (TextView)ka.findViewById(2131493093);
      if (k > 5)
      {
        arrayOfImageView[(j - 1)].setVisibility(8);
        paramc.setText(paramContext.getResources().getString(2131231346, new Object[] { Integer.valueOf(k + 1 - 5) }));
        paramc.setVisibility(0);
        return;
      }
      paramc.setVisibility(8);
    }

    public void ah(int paramInt)
    {
      if (jY == null)
        jY = ((ViewStub)jH.findViewById(2131493114)).inflate();
      while (true)
      {
        ((TextView)jH.findViewById(2131493117)).setText(paramInt);
        return;
        jY.setVisibility(0);
      }
    }

    public void cR()
    {
      if (jY != null)
        jY.setVisibility(8);
    }

    public void cS()
    {
      if (jX != null)
      {
        jX.setVisibility(8);
        jI.setMinimumHeight((int)jX.getContext().getResources().getDimension(2131427524));
      }
    }

    public void cT()
    {
      ka.setVisibility(8);
    }

    public void setAlpha(float paramFloat)
    {
      super.setAlpha(paramFloat);
      jW.setAlpha(paramFloat);
    }
  }
}