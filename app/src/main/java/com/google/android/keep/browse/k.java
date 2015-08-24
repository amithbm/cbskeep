package com.google.android.keep.browse;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.model.A;
import com.google.android.keep.model.Alert;
import com.google.android.keep.model.BaseReminder;
import com.google.android.keep.model.ColorMap;
import com.google.android.keep.model.ColorMap.ColorPair;
import com.google.android.keep.model.Label;
import com.google.android.keep.model.ModelEventDispatcher.EventType;
import com.google.android.keep.model.ModelEventDispatcher.a;
import com.google.android.keep.model.ModelEventDispatcher.b;
import com.google.android.keep.model.Note;
import com.google.android.keep.model.Sharee;
import com.google.android.keep.model.TimeReminder;
import com.google.android.keep.model.TreeEntity.TreeEntityType;
import com.google.android.keep.model.TreeEntitySettings;
import com.google.android.keep.model.j;
import com.google.android.keep.model.l;
import com.google.android.keep.model.m;
import com.google.android.keep.model.r;
import com.google.android.keep.ui.IndexListItem;
import com.google.android.keep.ui.LabelLayout;
import com.google.android.keep.ui.SgvAnimationHelper.TranslationAnimationType;
import com.google.android.keep.ui.StaggeredGridView.b;
import com.google.android.keep.ui.c;
import com.google.android.keep.util.B;
import com.google.android.keep.util.D;
import com.google.android.keep.util.t;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class k extends g<Note>
  implements ModelEventDispatcher.b
{
  private static int hN = -1;
  private static Integer hO = null;
  private static Drawable hR = null;
  private static Drawable hS = null;
  private static Drawable hT = null;
  private static Drawable hU = null;
  private static Drawable hV = null;
  private final c eF;
  protected final com.google.android.keep.model.o fg;
  protected l fh = null;
  private boolean hA;
  protected boolean hB;
  private long hC = -1L;
  private int hD = -1;
  private int hE;
  private final LruCache<Long, a> hF;
  private final ArrayMap<Long, r.f> hG;
  private final ArrayMap<Long, Note> hH;
  private int hI = 0;
  private int hJ = 0;
  private int hK = 0;
  private int hL = 0;
  private int hM = 0;
  private int hP;
  private LayoutTransition hQ = null;
  private final HashMap<Long, SgvAnimationHelper.TranslationAnimationType> hW = new HashMap();
  private boolean hX = false;
  private r hY = null;
  private A hZ;
  private Cursor hv = null;
  private boolean hw;
  protected final p hx;
  private boolean hy = false;
  private boolean hz = false;
  private com.google.android.keep.model.a ia;
  private ViewPropertyAnimator ib;
  private final VelocityTracker mVelocityTracker;

  public k(Context paramContext, com.google.android.keep.p paramp, Cursor paramCursor, p paramp1, c paramc)
  {
    super(paramContext, paramCursor, Note.tu, Note.tv, Note.uW, true);
    fg = new com.google.android.keep.model.o(paramContext, this, paramp);
    hY = ((r)fg.e(r.class));
    fh = ((l)fg.e(l.class));
    hZ = ((A)fg.e(A.class));
    ia = ((com.google.android.keep.model.a)fg.e(com.google.android.keep.model.a.class));
    hx = paramp1;
    hF = new LruCache(100);
    hG = new ArrayMap();
    hH = new ArrayMap();
    paramContext = paramContext.getResources();
    if (hN == -1)
      hN = paramContext.getInteger(2131361812);
    if (!hy);
    for (boolean bool = true; ; bool = false)
    {
      hw = bool;
      if (hO == null)
        hO = Integer.valueOf(paramContext.getColor(2131296375));
      hP = 0;
      mVelocityTracker = VelocityTracker.obtain();
      eF = paramc;
      return;
    }
  }

  private SgvAnimationHelper.TranslationAnimationType T(int paramInt)
  {
    Object localObject = (Note)F(paramInt);
    if ((!w(paramInt)) && (localObject != null))
    {
      long l = ((Note)localObject).getId();
      if (hW.get(Long.valueOf(l)) != null)
      {
        localObject = (SgvAnimationHelper.TranslationAnimationType)hW.get(Long.valueOf(l));
        hW.remove(Long.valueOf(l));
        return localObject;
      }
    }
    return SgvAnimationHelper.TranslationAnimationType.Mv;
  }

  private View.OnLongClickListener a(final Note paramNote, final int paramInt)
  {
    return new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        if ((!k.a(k.this)) || (!k.b(k.this)))
          return false;
        r.f localf = (r.f)paramAnonymousView.getTag();
        if ((k.c(k.this)) && (!hB) && (getCount() > 1) && (R(paramInt)));
        for (int i = 1; ; i = 0)
        {
          boolean bool = k.a(k.this, localf);
          if (!hB)
          {
            hB = true;
            k.a(k.this, paramNote, localf);
            hx.bO();
          }
          k.a(k.this, localf.jZ, bool);
          if (i != 0)
          {
            if (!paramAnonymousView.startDrag(null, new View.DragShadowBuilder(), null, 0))
              break;
            k.a(k.this, paramNote.getId());
            k.b(k.this, paramInt);
            k.a(k.this, localf, false);
            k.a(k.this, paramNote, localf);
            localf.jH.setBackgroundResource(2130837631);
            localf.jH.setVisibility(4);
          }
          hx.e(paramNote.getId());
          return true;
        }
      }
    };
  }

  private View a(View paramView, ViewGroup paramViewGroup, int paramInt)
  {
    D.bO("NoteAdapter_getPlaceholderView");
    Object localObject = paramView;
    paramView = (View)localObject;
    if (localObject == null)
      paramView = mInflater.inflate(2130968616, paramViewGroup, false);
    localObject = (StaggeredGridView.b)paramView.getLayoutParams();
    paramViewGroup = (ViewGroup)localObject;
    if (localObject == null)
      paramViewGroup = new StaggeredGridView.b(hE);
    paramViewGroup.height = hE;
    paramViewGroup.width = paramInt;
    paramView.setLayoutParams(paramViewGroup);
    D.ot();
    return paramView;
  }

  private String a(Note paramNote, r.e parame, String paramString, int paramInt)
  {
    long l = paramNote.getId();
    int i = c(l, paramString);
    TextNoteView localTextNoteView = parame.jP;
    boolean bool;
    if ((hX) && (!paramNote.ij()))
    {
      bool = true;
      localTextNoteView.r(bool);
      parame.jP.setTextColor(hO.intValue());
      paramNote = t.a(mContext, paramNote, hZ);
      if (TextUtils.isEmpty(paramNote))
        break label120;
      parame.jP.a(paramNote, i, paramInt);
      parame.jP.setVisibility(0);
    }
    while (true)
    {
      a(l, paramString, parame.jP.cI());
      return paramNote;
      bool = false;
      break;
      label120: parame.jP.setText(null);
      parame.jP.setVisibility(8);
    }
  }

  private List<Sharee> a(Note paramNote)
  {
    ArrayList localArrayList = new ArrayList();
    String str = com.google.android.keep.util.o.O(mContext).getName();
    paramNote = paramNote.iq();
    if (paramNote != null)
    {
      int j = paramNote.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramNote[i];
        if (TextUtils.equals(localObject.getEmail(), str));
        while (true)
        {
          i += 1;
          break;
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }

  private void a(long paramLong, String paramString, int paramInt)
  {
    a locala2 = (a)hF.get(Long.valueOf(paramLong));
    a locala1 = locala2;
    if (locala2 == null)
      locala1 = new a();
    locala1.ij = paramInt;
    if (!TextUtils.isEmpty(paramString));
    for (long l = paramString.hashCode(); ; l = 0L)
    {
      locala1.ii = l;
      hF.put(Long.valueOf(paramLong), locala1);
      return;
    }
  }

  private void a(r.c paramc, m[] paramArrayOfm, boolean paramBoolean)
  {
    Resources localResources = mContext.getResources();
    int i1 = (int)localResources.getDimension(2131427528);
    localResources.getDimension(2131427528);
    int k;
    IndexListItem[] arrayOfIndexListItem;
    int i2;
    int j;
    int m;
    if (paramArrayOfm == null)
    {
      k = 0;
      arrayOfIndexListItem = new IndexListItem[10];
      arrayOfIndexListItem[0] = ((IndexListItem)paramc.jI.findViewById(2131493076));
      arrayOfIndexListItem[1] = ((IndexListItem)paramc.jI.findViewById(2131493077));
      arrayOfIndexListItem[2] = ((IndexListItem)paramc.jI.findViewById(2131493078));
      arrayOfIndexListItem[3] = ((IndexListItem)paramc.jI.findViewById(2131493079));
      arrayOfIndexListItem[4] = ((IndexListItem)paramc.jI.findViewById(2131493080));
      arrayOfIndexListItem[5] = ((IndexListItem)paramc.jI.findViewById(2131493081));
      arrayOfIndexListItem[6] = ((IndexListItem)paramc.jI.findViewById(2131493082));
      arrayOfIndexListItem[7] = ((IndexListItem)paramc.jI.findViewById(2131493083));
      arrayOfIndexListItem[8] = ((IndexListItem)paramc.jI.findViewById(2131493084));
      arrayOfIndexListItem[9] = ((IndexListItem)paramc.jI.findViewById(2131493085));
      i2 = arrayOfIndexListItem.length;
      i = 0;
      j = 0;
      m = 0;
    }
    m localm;
    IndexListItem localIndexListItem;
    while (true)
    {
      if ((j >= k) || (i == i2))
      {
        j = i;
        while (j < i2)
        {
          arrayOfIndexListItem[j].setVisibility(8);
          j += 1;
        }
        k = paramArrayOfm.length;
        break;
      }
      localm = paramArrayOfm[j];
      localIndexListItem = arrayOfIndexListItem[i];
      if (localIndexListItem == null)
        break label401;
      if ((!paramBoolean) || (!localm.hz()))
        break label324;
      m = 1;
      j += 1;
    }
    label324: localIndexListItem.setVisibility(0);
    if (hX)
    {
      n = localResources.getInteger(2131361814);
      label347: localIndexListItem.f(localm.getText(), n);
      localIndexListItem.setChecked(localm.hz());
      if (i + 1 != k)
        break label429;
    }
    label401: label429: for (int n = i1; ; n = 0)
    {
      localIndexListItem.setPadding(localIndexListItem.getPaddingLeft(), i1, localIndexListItem.getPaddingRight(), n);
      j += 1;
      i += 1;
      break;
      n = localResources.getInteger(2131361813);
      break label347;
    }
    if (paramc.jL != null)
    {
      paramc = paramc.jL;
      if ((m == 0) && (i >= k))
        break label469;
    }
    label469: for (int i = 0; ; i = 8)
    {
      paramc.setVisibility(i);
      return;
    }
  }

  private void a(r.e parame)
  {
    if (KeepApplication.al())
    {
      if (hQ == null)
      {
        hQ = new LayoutTransition();
        if (Build.VERSION.SDK_INT >= 16)
          hQ.disableTransitionType(3);
      }
      parame.jI.setLayoutTransition(hQ);
    }
  }

  private void a(final r.f paramf)
  {
    LayoutTransition localLayoutTransition = paramf.jI.getLayoutTransition();
    if ((localLayoutTransition != null) && (localLayoutTransition.isRunning()) && (!paramf.jZ.js()))
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(null, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator.setDuration(localLayoutTransition.getDuration(2));
      localObjectAnimator.setStartDelay(localLayoutTransition.getStartDelay(2));
      localObjectAnimator.setInterpolator(localLayoutTransition.getInterpolator(2));
      localObjectAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          paramf.setAlpha(1.0F);
        }
      });
      localLayoutTransition.setAnimator(2, localObjectAnimator);
    }
  }

  private void a(r.f paramf, Note paramNote, final int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 589	com/google/android/keep/browse/r$f:jH	Landroid/view/View;
    //   4: aload_0
    //   5: aload_2
    //   6: invokespecial 592	com/google/android/keep/browse/k:b	(Lcom/google/android/keep/model/Note;)Landroid/view/View$OnClickListener;
    //   9: invokevirtual 596	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   12: aload_1
    //   13: getfield 589	com/google/android/keep/browse/r$f:jH	Landroid/view/View;
    //   16: aload_0
    //   17: aload_2
    //   18: iload_3
    //   19: invokespecial 598	com/google/android/keep/browse/k:a	(Lcom/google/android/keep/model/Note;I)Landroid/view/View$OnLongClickListener;
    //   22: invokevirtual 602	android/view/View:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   25: aload_1
    //   26: getfield 605	com/google/android/keep/browse/r$f:jJ	Landroid/view/View;
    //   29: aload_2
    //   30: invokevirtual 242	com/google/android/keep/model/Note:getId	()J
    //   33: invokestatic 247	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   36: invokevirtual 609	android/view/View:setTag	(Ljava/lang/Object;)V
    //   39: aload_1
    //   40: getfield 605	com/google/android/keep/browse/r$f:jJ	Landroid/view/View;
    //   43: aload_0
    //   44: aload_1
    //   45: getfield 589	com/google/android/keep/browse/r$f:jH	Landroid/view/View;
    //   48: aload_2
    //   49: invokespecial 612	com/google/android/keep/browse/k:b	(Landroid/view/View;Lcom/google/android/keep/model/Note;)Landroid/view/View$OnKeyListener;
    //   52: invokevirtual 616	android/view/View:setOnKeyListener	(Landroid/view/View$OnKeyListener;)V
    //   55: new 11	com/google/android/keep/browse/k$2
    //   58: dup
    //   59: aload_0
    //   60: iload_3
    //   61: invokespecial 619	com/google/android/keep/browse/k$2:<init>	(Lcom/google/android/keep/browse/k;I)V
    //   64: astore 5
    //   66: aload_1
    //   67: getfield 589	com/google/android/keep/browse/r$f:jH	Landroid/view/View;
    //   70: astore 6
    //   72: aload_0
    //   73: getfield 345	com/google/android/keep/browse/k:mContext	Landroid/content/Context;
    //   76: astore 7
    //   78: aload_1
    //   79: getfield 589	com/google/android/keep/browse/r$f:jH	Landroid/view/View;
    //   82: astore_1
    //   83: aload_0
    //   84: getfield 226	com/google/android/keep/browse/k:mVelocityTracker	Landroid/view/VelocityTracker;
    //   87: astore 8
    //   89: aload_0
    //   90: getfield 120	com/google/android/keep/browse/k:hy	Z
    //   93: ifeq +35 -> 128
    //   96: aload_2
    //   97: invokevirtual 622	com/google/android/keep/model/Note:jr	()Z
    //   100: ifne +28 -> 128
    //   103: iconst_1
    //   104: istore 4
    //   106: aload 6
    //   108: new 624	com/google/android/keep/browse/q
    //   111: dup
    //   112: aload 7
    //   114: aload_1
    //   115: aload 5
    //   117: aload 8
    //   119: iload 4
    //   121: invokespecial 627	com/google/android/keep/browse/q:<init>	(Landroid/content/Context;Landroid/view/View;Lcom/google/android/keep/browse/q$a;Landroid/view/VelocityTracker;Z)V
    //   124: invokevirtual 631	android/view/View:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   127: return
    //   128: iconst_0
    //   129: istore 4
    //   131: goto -25 -> 106
  }

  private void a(r.f paramf, String paramString)
  {
    String str1 = paramString;
    Note localNote = paramf.jZ;
    Object localObject;
    if (localNote.getId() == hC)
    {
      paramf.jH.setVisibility(4);
      paramf.jI.setBackgroundColor(localNote.iz().getValue());
      a(paramf);
      if (localNote.iE())
        break label244;
      localObject = localNote.io();
      paramString = str1;
      if (localObject != null)
      {
        paramString = mContext.getString(2131231294, new Object[] { ((Sharee)localObject).getDisplayName() });
        if (localNote.iy() == null)
          break label234;
        str1 = com.google.android.keep.util.g.i(mContext, localNote.iy().longValue());
        paramf.a(mContext, eF, paramString, ((Sharee)localObject).getEmail(), str1);
      }
      label141: if (!localNote.in())
        break label481;
      paramf.ah(2131231287);
      paramString = mContext.getResources().getString(2131231287);
    }
    while (true)
    {
      if (!TextUtils.isEmpty(paramString))
        paramf.jH.setContentDescription(paramString);
      a(localNote, paramf);
      a(paramf, hG.containsKey(Long.valueOf(localNote.getId())));
      return;
      paramf.jH.setBackgroundResource(2130837746);
      paramf.jH.setVisibility(0);
      break;
      label234: paramf.cS();
      paramString = str1;
      break label141;
      label244: if ((localNote.ip()) && (localNote.getLastModifierEmail() != null))
      {
        long l1;
        String str2;
        if (localNote.ix() == null)
        {
          l1 = 0L;
          long l2 = localNote.getChangesSeenTimestamp();
          str2 = localNote.getLastModifierEmail();
          localObject = str2;
          Sharee[] arrayOfSharee = localNote.iq();
          int j = arrayOfSharee.length;
          i = 0;
          paramString = (String)localObject;
          if (i < j)
          {
            paramString = arrayOfSharee[i];
            if (!TextUtils.equals(paramString.getEmail(), str2))
              break label449;
            paramString = paramString.getDisplayName();
          }
          if ((!B.k(l1, l2)) || (TextUtils.isEmpty(paramString)) || (TextUtils.equals(str2, com.google.android.keep.util.o.O(mContext).getName())))
            break label456;
        }
        for (int i = 1; ; i = 0)
        {
          if (i == 0)
            break label461;
          str1 = com.google.android.keep.util.g.i(mContext, localNote.ix().longValue());
          str1 = mContext.getString(2131231156, new Object[] { str1 });
          paramf.a(mContext, eF, paramString, str2, str1);
          paramString = str1;
          break;
          l1 = localNote.ix().longValue();
          break label271;
          i += 1;
          break label303;
        }
        paramf.cS();
        paramString = str1;
        break label141;
      }
      label271: label303: label449: label456: label461: paramf.cS();
      paramString = str1;
      break label141;
      label481: if (b(localNote.getId(), "AB"))
      {
        paramf.ah(2131231191);
        paramString = mContext.getResources().getString(2131231191);
      }
      else
      {
        paramf.cR();
      }
    }
  }

  private void a(r.f paramf, boolean paramBoolean)
  {
    if (paramf == null)
      return;
    long l;
    if (hA)
    {
      l = paramf.jZ.getId();
      if (!paramBoolean)
        break label50;
      b(paramf.jZ, paramf);
    }
    while (true)
    {
      paramf.jH.setActivated(paramBoolean);
      paramf.jH.setPressed(paramBoolean);
      return;
      label50: f(l);
    }
  }

  private void a(Note paramNote, int paramInt, r.d paramd)
  {
    int k = 1;
    BaseReminder localBaseReminder = hZ.c(paramNote);
    int i;
    if ((TextUtils.isEmpty(paramNote.getTitle())) && (!paramNote.ii()) && (localBaseReminder == null) && (paramInt != ColorMap.gO().getValue()))
    {
      i = 1;
      j = i;
      if (paramNote.ir() == TreeEntity.TreeEntityType.zP)
        if (paramNote.im() != null)
          break label97;
    }
    label97: for (int j = k; ; j = 0)
    {
      j = i & j;
      if (j == 0)
        break label103;
      paramd.ag(paramInt);
      return;
      i = 0;
      break;
    }
    label103: paramd.cP();
  }

  private void a(Note paramNote, r.d paramd, int paramInt)
  {
    paramd.cO();
    long[] arrayOfLong = paramNote.ik();
    if ((arrayOfLong == null) || (arrayOfLong.length == 0))
      return;
    int j = paramInt - (paramd.jH.getPaddingLeft() + paramd.jH.getPaddingRight());
    int k = paramNote.il() % 3;
    paramInt = 0;
    label51: float f1;
    ImageView localImageView2;
    float f2;
    ImageView localImageView1;
    if (paramInt < arrayOfLong.length)
    {
      f1 = j;
      if (paramInt >= k)
        break label221;
      localImageView2 = paramd.af(paramInt);
      if (k != 1)
        break label167;
      if (arrayOfLong.length != 1)
        break label151;
      f2 = j * 0.66F;
      localImageView1 = localImageView2;
    }
    label102: float f4;
    label151: label167: float f3;
    while (true)
    {
      if (localImageView1 != null)
      {
        r.d.a(localImageView1, (int)f1, (int)f2);
        com.google.android.keep.x.fV().a(mContext, localImageView1, paramNote.x(arrayOfLong[paramInt]));
        localImageView1.setVisibility(0);
      }
      paramInt += 1;
      break label51;
      break;
      f2 = j * 0.5F;
      localImageView1 = localImageView2;
      continue;
      f4 = j / k;
      f3 = f4;
      f2 = f3;
      localImageView1 = localImageView2;
      f1 = f4;
      if (paramInt == k - 1)
      {
        f1 = f4 + j % k;
        f2 = f3;
        localImageView1 = localImageView2;
      }
    }
    label221: if (k == 0);
    for (int i = 0; ; i = 3 - k)
    {
      i = paramInt + i;
      if (i >= paramd.cN())
        break;
      localImageView2 = paramd.af(i);
      f4 = j / 3;
      f3 = f4;
      f2 = f3;
      localImageView1 = localImageView2;
      f1 = f4;
      if (paramInt != 2)
        break label102;
      f1 = f4 + j % 3;
      f2 = f3;
      localImageView1 = localImageView2;
      break label102;
    }
  }

  private void a(Note paramNote, r.f paramf)
  {
    if ((paramNote.ip()) && (!c(paramf)))
    {
      paramf.a(mContext, eF, a(paramNote));
      return;
    }
    paramf.cT();
  }

  private void a(Note paramNote, boolean paramBoolean)
  {
    int k = 1;
    int j = 1;
    int m;
    if (paramNote.in())
    {
      m = hK;
      if (paramBoolean)
      {
        i = 1;
        hK = (i + m);
      }
    }
    else
    {
      if (!paramNote.jr())
        break label113;
      m = hI;
      if (!paramBoolean)
        break label108;
      i = 1;
      label52: hI = (i + m);
      if (paramNote.iD())
        break label146;
      k = hL;
      if (!paramBoolean)
        break label141;
      i = j;
      hL = (k + i);
    }
    label108: label113: 
    while (!paramNote.ip())
      while (true)
      {
        hx.a(paramNote.getId(), paramBoolean);
        return;
        i = -1;
        break;
        i = -1;
        break label52;
        m = hJ;
        if (paramBoolean);
        for (i = 1; ; i = -1)
        {
          hJ = (i + m);
          break;
        }
        i = -1;
      }
    label141: label146: j = hM;
    if (paramBoolean);
    for (int i = k; ; i = -1)
    {
      hM = (j + i);
      break;
    }
  }

  private boolean a(long paramLong, String paramString)
  {
    return hY.a(paramLong, paramString, Boolean.valueOf(true));
  }

  private boolean a(Note paramNote, r.e parame, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    BaseReminder localBaseReminder = hZ.c(paramNote);
    boolean bool2 = a(paramNote.getId(), "AB");
    int j;
    boolean bool1;
    label77: int i;
    if ((localBaseReminder != null) && (!paramNote.js()))
    {
      j = 1;
      bool1 = false;
      if (j != 0)
      {
        String str = com.google.android.keep.util.x.b(mContext, localBaseReminder);
        if (!localBaseReminder.gK())
          break label162;
        localObject1 = cw();
        bool1 = localBaseReminder.gK();
        localObject2 = localObject1;
        localObject1 = str;
      }
      if ((!paramBoolean1) || (paramBoolean2))
        break label258;
      if (!paramNote.ij())
        break label251;
      i = 4;
    }
    while (true)
    {
      if (((!bool2) && (j == 0) && (!paramNote.ii())) || (c(parame)))
        break label264;
      parame.a((String)localObject1, bool1, paramNote.ii(), localObject2, i, bool2);
      return true;
      j = 0;
      break;
      label162: localObject1 = (Alert)ia.G(localBaseReminder.gq());
      if (localBaseReminder.getType() == 1)
      {
        if ((localObject1 != null) && (((Alert)localObject1).getState() == 5));
        for (bool1 = true; ; bool1 = false)
        {
          localObject1 = q(bool1);
          break;
        }
      }
      if (((TimeReminder)localBaseReminder).getRecurrence() != null)
      {
        localObject1 = cv();
        break label77;
      }
      localObject1 = cu();
      break label77;
      label251: i = 8;
      continue;
      label258: i = 0;
    }
    label264: parame.cQ();
    return false;
  }

  private View.OnClickListener b(final Note paramNote)
  {
    return new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (k.a(k.this))
          k.a(k.this, paramAnonymousView, paramNote);
      }
    };
  }

  private View.OnKeyListener b(final View paramView, final Note paramNote)
  {
    return new View.OnKeyListener()
    {
      public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousInt == 66))
        {
          k.a(k.this, paramView, paramNote);
          return true;
        }
        return false;
      }
    };
  }

  private void b(r.f paramf)
  {
    if (paramf == null)
      return;
    paramf.jH.setOnClickListener(null);
    paramf.jH.setOnLongClickListener(null);
    paramf.jH.setOnDragListener(null);
    paramf.jH.setOnTouchListener(null);
    paramf.jJ.setOnKeyListener(null);
  }

  private void b(Note paramNote, r.f paramf)
  {
    hH.put(Long.valueOf(paramNote.getId()), paramNote);
    hG.put(Long.valueOf(paramNote.getId()), paramf);
  }

  private boolean b(long paramLong, String paramString)
  {
    return hY.a(paramLong, paramString, Boolean.valueOf(false));
  }

  private int c(long paramLong, String paramString)
  {
    a locala;
    if (hF.get(Long.valueOf(paramLong)) == null)
    {
      locala = new a();
      if (TextUtils.isEmpty(paramString))
        break label76;
    }
    label76: for (paramLong = paramString.hashCode(); ; paramLong = 0L)
    {
      if ((locala == null) || (paramLong != locala.ii))
        break label81;
      return locala.ij;
      locala = (a)hF.get(Long.valueOf(paramLong));
      break;
    }
    label81: return -1;
  }

  private void c(View paramView, Note paramNote)
  {
    if ((hB) && (hA))
    {
      a(paramNote, d((r.f)paramView.getTag()));
      return;
    }
    hx.a(paramView, paramNote);
  }

  private boolean c(r.f paramf)
  {
    return ((paramf.jX != null) && (paramf.jX.getVisibility() == 0)) || ((paramf.jY != null) && (paramf.jY.getVisibility() == 0));
  }

  private Drawable cu()
  {
    if (hR == null)
      hR = mContext.getResources().getDrawable(2130837696);
    return hR;
  }

  private Drawable cv()
  {
    if (hS == null)
      hS = mContext.getResources().getDrawable(2130837695);
    return hS;
  }

  private Drawable cw()
  {
    if (hU == null)
      hU = mContext.getResources().getDrawable(2130837691);
    return hU;
  }

  private void cx()
  {
    int i = 0;
    Object localObject = hH.values().iterator();
    while (((Iterator)localObject).hasNext())
      if ((Note)((Iterator)localObject).next() == null)
        i = 1;
    if (i == 0);
    while (true)
    {
      return;
      int j = getCount();
      i = 0;
      while (i < j)
      {
        localObject = Long.valueOf(getItemId(i));
        if ((hH.containsKey(localObject)) && (hH.get(localObject) == null))
          hH.put(localObject, F(i));
        i += 1;
      }
      localObject = hH.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject).next();
        if (hH.get(localLong) == null)
          f(localLong.longValue());
      }
    }
  }

  private boolean d(r.f paramf)
  {
    boolean bool = false;
    if ((paramf == null) || (!hA))
      return false;
    long l = paramf.jZ.getId();
    if (hG.get(Long.valueOf(l)) == null)
      bool = true;
    a(paramf, bool);
    return bool;
  }

  private void f(long paramLong)
  {
    hH.remove(Long.valueOf(paramLong));
    hG.remove(Long.valueOf(paramLong));
  }

  private Drawable q(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (hV == null)
        hV = mContext.getResources().getDrawable(2130837733);
      return hV;
    }
    if (hT == null)
      hT = mContext.getResources().getDrawable(2130837693);
    return hT;
  }

  public SgvAnimationHelper.TranslationAnimationType L(int paramInt)
  {
    return T(paramInt);
  }

  public int Q(int paramInt)
  {
    if (w(paramInt))
      return hN;
    TreeEntity.TreeEntityType localTreeEntityType = ((Note)F(paramInt)).ir();
    if ((localTreeEntityType == TreeEntity.TreeEntityType.zP) || (localTreeEntityType == TreeEntity.TreeEntityType.zO))
      return hN;
    throw new IllegalStateException("Invalid type " + localTreeEntityType);
  }

  public boolean R(int paramInt)
  {
    return (hz) && (!w(paramInt));
  }

  public BitmapDrawable a(int paramInt, View paramView)
  {
    if (paramView == null)
      return null;
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(localBitmap));
    return new BitmapDrawable(mContext.getResources(), localBitmap);
  }

  public View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    int i = getItemViewType(paramInt1);
    switch (i)
    {
    default:
      throw new IllegalStateException("Invalid item view type " + i);
    case 0:
      return b(paramInt1, paramView, paramViewGroup, paramInt2);
    case 1:
      return c(paramInt1, paramView, paramViewGroup, paramInt2);
    case 2:
      return d(paramInt1, paramView, paramViewGroup, paramInt2);
    case 3:
    }
    return a(paramView, paramViewGroup, paramInt2);
  }

  public void a(long paramLong, SgvAnimationHelper.TranslationAnimationType paramTranslationAnimationType)
  {
    hW.put(Long.valueOf(paramLong), paramTranslationAnimationType);
  }

  public void a(View paramView, int paramInt)
  {
    if (paramView == null)
      throw new IllegalArgumentException("View cannot be null");
    switch (paramInt)
    {
    default:
      return;
    case 0:
      hE = paramView.getMeasuredHeight();
      hP = hD;
      return;
    case 1:
    case 2:
    }
    paramView = (r.f)paramView.getTag();
    if (paramView != null)
      a(paramView, null);
    hC = -1L;
    hD = -1;
  }

  protected void a(View paramView, ArrayList<Label> paramArrayList)
  {
    LabelLayout localLabelLayout2 = (LabelLayout)paramView.findViewById(2131493098);
    LabelLayout localLabelLayout1 = localLabelLayout2;
    if (localLabelLayout2 == null)
      localLabelLayout1 = (LabelLayout)((ViewStub)paramView.findViewById(2131493097)).inflate();
    if (localLabelLayout1 != null)
      localLabelLayout1.d(paramArrayList);
  }

  public void a(ModelEventDispatcher.a parama)
  {
    if (!fg.ih())
      return;
    if (hv != null)
    {
      super.changeCursor(hv);
      hP = 0;
      hv = null;
      return;
    }
    notifyDataSetChanged();
  }

  public void a(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0) || (!hA));
    while (true)
    {
      return;
      hB = true;
      hw = true;
      hI = paramInt1;
      hJ = paramInt2;
      hK = paramInt3;
      hL = paramInt4;
      hM = paramInt5;
      hG.clear();
      hx.bO();
      paramInt2 = paramArrayOfLong.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        long l = paramArrayOfLong[paramInt1];
        hG.put(Long.valueOf(l), null);
        hH.put(Long.valueOf(l), null);
        hx.a(l, true);
        paramInt1 += 1;
      }
    }
  }

  public View b(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    D.bO("NoteAdapter_getTextNoteView");
    Object localObject2 = paramView;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = mInflater.inflate(2130968619, paramViewGroup, false);
      ((View)localObject1).setTag(new r.e((View)localObject1));
    }
    paramViewGroup = (r.e)((View)localObject1).getTag();
    a(paramViewGroup);
    if (paramView != null)
      b(paramViewGroup);
    paramView = (Note)F(paramInt1);
    long l = paramView.getId();
    paramViewGroup.jZ = paramView;
    localObject2 = paramView.getTitle();
    boolean bool1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramViewGroup.jW.setText((CharSequence)localObject2);
      paramViewGroup.jW.setVisibility(0);
      a(paramView, paramViewGroup, paramView.getDescription(), paramInt2);
      a(paramViewGroup, paramView, paramInt1);
      if (paramViewGroup.jH.isActivated())
        d.b((View)localObject1, l);
      ArrayList localArrayList = fh.v(l);
      a(paramViewGroup, com.google.android.keep.util.a.a(mContext, paramView, a(paramView), localArrayList));
      a((View)localObject1, localArrayList);
      if ((!TextUtils.isEmpty(paramViewGroup.jP.getText())) || (!TextUtils.isEmpty((CharSequence)localObject2)))
        break label268;
      bool1 = true;
      label220: if (localArrayList.size() <= 0)
        break label274;
    }
    label268: label274: for (boolean bool2 = true; ; bool2 = false)
    {
      a(paramView, paramViewGroup, bool1, bool2);
      D.ot();
      return localObject1;
      paramViewGroup.jW.setText(null);
      paramViewGroup.jW.setVisibility(8);
      break;
      bool1 = false;
      break label220;
    }
  }

  public List<ModelEventDispatcher.EventType> bI()
  {
    return ImmutableList.of(ModelEventDispatcher.EventType.wJ, ModelEventDispatcher.EventType.wF, ModelEventDispatcher.EventType.wK, ModelEventDispatcher.EventType.wL, ModelEventDispatcher.EventType.wX, ModelEventDispatcher.EventType.wV, ModelEventDispatcher.EventType.wU, ModelEventDispatcher.EventType.xo, ModelEventDispatcher.EventType.wY, ModelEventDispatcher.EventType.wZ, ModelEventDispatcher.EventType.wI);
  }

  public void bT()
  {
    if (ib != null)
    {
      ib.cancel();
      ib = null;
    }
  }

  public void bf()
  {
    hB = false;
    Iterator localIterator = new HashSet(hG.keySet()).iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      r.f localf = (r.f)hG.get(Long.valueOf(l));
      if ((localf != null) && (localf.jZ != null) && (localf.jZ.getId() == l))
        a(localf, false);
    }
    hG.clear();
    hH.clear();
    hI = 0;
    hJ = 0;
    hK = 0;
    hL = 0;
    hM = 0;
  }

  public long[] bg()
  {
    if ((hB) && (hA))
    {
      long[] arrayOfLong2 = new long[hG.size()];
      int i = 0;
      Iterator localIterator = hG.keySet().iterator();
      while (true)
      {
        arrayOfLong1 = arrayOfLong2;
        if (!localIterator.hasNext())
          break;
        arrayOfLong2[i] = ((Long)localIterator.next()).longValue();
        i += 1;
      }
    }
    long[] arrayOfLong1 = null;
    return arrayOfLong1;
  }

  public int bh()
  {
    return hI;
  }

  public int bi()
  {
    return hJ;
  }

  public int bj()
  {
    return hK;
  }

  public int bk()
  {
    return hL;
  }

  public int bl()
  {
    return hM;
  }

  public Note[] bm()
  {
    if ((hB) && (hA))
    {
      cx();
      Note[] arrayOfNote2 = new Note[hH.size()];
      int i = 0;
      Iterator localIterator = hH.values().iterator();
      while (true)
      {
        arrayOfNote1 = arrayOfNote2;
        if (!localIterator.hasNext())
          break;
        arrayOfNote2[i] = ((Note)localIterator.next());
        i += 1;
      }
    }
    Note[] arrayOfNote1 = null;
    return arrayOfNote1;
  }

  public View c(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    D.bO("NoteAdapter_getPhotoNoteView");
    Object localObject2 = paramView;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = mInflater.inflate(2130968615, paramViewGroup, false);
      ((View)localObject1).setTag(new r.d((View)localObject1));
    }
    paramViewGroup = (r.d)((View)localObject1).getTag();
    a(paramViewGroup);
    if (paramView != null)
      b(paramViewGroup);
    paramView = (Note)F(paramInt1);
    long l = getItemId(paramInt1);
    paramViewGroup.jZ = paramView;
    localObject2 = paramView.getTitle();
    label172: boolean bool1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramViewGroup.jW.setText((CharSequence)localObject2);
      paramViewGroup.jW.setVisibility(0);
      int i = paramView.iz().getValue();
      Object localObject3 = paramView.getDescription();
      a(paramView, paramViewGroup, (String)localObject3, paramInt2);
      Resources localResources = mContext.getResources();
      if (!TextUtils.isEmpty((CharSequence)localObject3))
        break label383;
      a(paramView, i, paramViewGroup);
      a(paramView, paramViewGroup, paramInt2);
      i = 0;
      paramInt2 = i;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramInt2 = i;
        if (TextUtils.isEmpty((CharSequence)localObject3))
          paramInt2 = (int)localResources.getDimension(2131427521);
      }
      paramViewGroup.jW.setPadding(paramViewGroup.jW.getPaddingLeft(), paramViewGroup.jW.getPaddingTop(), paramViewGroup.jW.getPaddingRight(), paramInt2);
      a(paramViewGroup, paramView, paramInt1);
      if (paramViewGroup.jH.isActivated())
        d.b((View)localObject1, l);
      localObject3 = fh.v(l);
      a(paramViewGroup, com.google.android.keep.util.a.a(mContext, paramView, a(paramView), (List)localObject3));
      a((View)localObject1, (ArrayList)localObject3);
      if ((!TextUtils.isEmpty(paramViewGroup.jP.getText())) || (!TextUtils.isEmpty((CharSequence)localObject2)))
        break label390;
      bool1 = true;
      label335: if (((ArrayList)localObject3).size() <= 0)
        break label396;
    }
    label390: label396: for (boolean bool2 = true; ; bool2 = false)
    {
      a(paramView, paramViewGroup, bool1, bool2);
      D.ot();
      return localObject1;
      paramViewGroup.jW.setText(null);
      paramViewGroup.jW.setVisibility(8);
      break;
      label383: paramViewGroup.cP();
      break label172;
      bool1 = false;
      break label335;
    }
  }

  public void changeCursor(Cursor paramCursor)
  {
    bT();
    if (!fg.ih())
    {
      hv = paramCursor;
      return;
    }
    super.changeCursor(paramCursor);
    hP = 0;
    hv = null;
  }

  public int cp()
  {
    return hP;
  }

  public View d(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    D.bO("NoteAdapter_getIndexListView");
    Object localObject2 = paramView;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = mInflater.inflate(2130968612, paramViewGroup, false);
      ((View)localObject1).setTag(new r.c((View)localObject1));
    }
    paramViewGroup = (r.c)((View)localObject1).getTag();
    a(paramViewGroup);
    if (paramView != null)
      b(paramViewGroup);
    localObject2 = (Note)F(paramInt1);
    long l = getItemId(paramInt1);
    int k = ((Note)localObject2).iz().getValue();
    int i;
    Object localObject3;
    int j;
    label140: label167: label217: label247: boolean bool1;
    if (!TextUtils.isEmpty(((Note)localObject2).getTitle()))
    {
      i = 1;
      paramViewGroup.jZ = ((Note)localObject2);
      a((Note)localObject2, paramViewGroup, paramInt2);
      localObject3 = ((Note)localObject2).im();
      if (localObject3 != null)
        break label403;
      j = 0;
      a((Note)localObject2, k, paramViewGroup);
      paramView = null;
      if (j != 0)
        break label411;
      paramView = a((Note)localObject2, paramViewGroup, null, paramInt2);
      if (i == 0)
        break label429;
      paramViewGroup.jW.setText(((Note)localObject2).getTitle());
      paramViewGroup.jW.setVisibility(0);
      Object localObject4 = mContext.getResources();
      if (j != 0)
        break label423;
      paramInt2 = (int)((Resources)localObject4).getDimension(2131427528);
      paramViewGroup.jW.setPadding(paramViewGroup.jW.getPaddingLeft(), paramViewGroup.jW.getPaddingTop(), paramViewGroup.jW.getPaddingRight(), paramInt2);
      localObject4 = ((Note)localObject2).iA();
      if ((!((TreeEntitySettings)localObject4).jz()) || (((TreeEntitySettings)localObject4).ei()))
        break label441;
      bool1 = true;
      label273: a(paramViewGroup, (m[])localObject3, bool1);
      a(paramViewGroup, (Note)localObject2, paramInt1);
      if (paramViewGroup.jH.isActivated())
        d.b((View)localObject1, l);
      localObject3 = fh.v(l);
      a(paramViewGroup, com.google.android.keep.util.a.a(mContext, (Note)localObject2, a((Note)localObject2), (List)localObject3));
      a((View)localObject1, (ArrayList)localObject3);
      if ((i != 0) || (j != 0) || (!TextUtils.isEmpty(paramView)))
        break label447;
      bool1 = true;
      label368: if (((ArrayList)localObject3).size() <= 0)
        break label453;
    }
    label403: label411: label423: label429: label441: label447: label453: for (boolean bool2 = true; ; bool2 = false)
    {
      a((Note)localObject2, paramViewGroup, bool1, bool2);
      D.ot();
      return localObject1;
      i = 0;
      break;
      j = localObject3.length;
      break label140;
      paramViewGroup.jP.setVisibility(8);
      break label167;
      paramInt2 = 0;
      break label217;
      paramViewGroup.jW.setVisibility(8);
      break label247;
      bool1 = false;
      break label273;
      bool1 = false;
      break label368;
    }
  }

  protected Note d(Cursor paramCursor)
  {
    return Note.p(paramCursor);
  }

  public void f(boolean paramBoolean)
  {
    hX = paramBoolean;
  }

  public int getItemViewType(int paramInt)
  {
    if (w(paramInt))
      return 3;
    Note localNote = (Note)F(paramInt);
    TreeEntity.TreeEntityType localTreeEntityType = localNote.ir();
    if (localTreeEntityType == TreeEntity.TreeEntityType.zP)
      return 2;
    if (localTreeEntityType == TreeEntity.TreeEntityType.zO)
    {
      if (localNote.ij())
        return 1;
      return 0;
    }
    throw new IllegalStateException("Invalid type " + localTreeEntityType);
  }

  public int getViewTypeCount()
  {
    return 5;
  }

  public void n(boolean paramBoolean)
  {
    hz = paramBoolean;
  }

  public void o(boolean paramBoolean)
  {
    hy = paramBoolean;
  }

  public void p(boolean paramBoolean)
  {
    hA = paramBoolean;
  }

  public void v(int paramInt)
  {
    if (paramInt < hP)
      hP = paramInt;
    gZ.j(hD, paramInt);
    hD = paramInt;
  }

  public boolean w(int paramInt)
  {
    long l = getItemId(paramInt);
    if ((hC >= 0L) && (hC == l))
    {
      hD = paramInt;
      return true;
    }
    return false;
  }

  private static class a
  {
    protected long ii = 0L;
    protected int ij = -1;
  }

  private class b
    implements q.a
  {
    private b()
    {
    }

    public void a(ViewPropertyAnimator paramViewPropertyAnimator)
    {
      k.a(k.this, paramViewPropertyAnimator);
    }

    public void bP()
    {
      hx.bP();
    }

    public void bT()
    {
      if (k.d(k.this) != null)
      {
        k.d(k.this).cancel();
        k.a(k.this, null);
      }
    }

    public void bU()
    {
      k.a(k.this, null);
    }

    public boolean bV()
    {
      return !hB;
    }

    public void h(View paramView)
    {
      paramView = ((r.f)paramView.getTag()).jZ;
      hx.a(paramView);
    }

    public void l(boolean paramBoolean)
    {
      k.a(k.this, paramBoolean);
    }
  }
}