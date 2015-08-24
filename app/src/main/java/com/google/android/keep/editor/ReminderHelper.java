package com.google.android.keep.editor;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.calendarcommon2.EventRecurrence;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.reminders.model.Recurrence;
import com.google.android.gsf.GservicesValue;
import com.google.android.keep.U;
import com.google.android.keep.f;
import com.google.android.keep.model.BaseReminder;
import com.google.android.keep.model.BaseReminder.ReminderType;
import com.google.android.keep.model.Location;
import com.google.android.keep.model.LocationReminder;
import com.google.android.keep.model.TimeReminder;
import com.google.android.keep.model.TimeReminder.TimePeriod;
import com.google.android.keep.model.s;
import com.google.android.keep.model.y;
import com.google.android.keep.provider.i.c;
import com.google.android.keep.task.TaskHelper;
import com.google.android.keep.ui.KeepRecurrencePickerDialog.b;
import com.google.android.keep.ui.ReminderSpinner;
import com.google.android.keep.ui.ReminderSpinner.a;
import com.google.android.keep.ui.k.a;
import com.google.android.keep.util.A;
import com.google.android.keep.util.Config;
import com.google.android.keep.util.KeepTime;
import com.google.android.keep.util.a;
import com.google.android.keep.util.h;
import com.google.android.keep.util.o;
import com.google.android.keep.util.r;
import com.google.android.keep.util.x;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class ReminderHelper
  implements View.OnTouchListener, com.google.android.keep.location.i.a<com.google.android.keep.location.g>, KeepRecurrencePickerDialog.b, ReminderSpinner.a, com.google.android.keep.ui.i.a, k.a
{
  private boolean de;
  private KeepTime fq;
  private final Activity mActivity;
  private final View nA;
  private final View nB;
  private final View nC;
  private final TextView nD;
  private final View nE;
  private final View nF;
  private final View nG;
  private final ReminderSpinner nH;
  private final ReminderSpinner nI;
  private final ReminderSpinner nJ;
  private final ReminderSpinner nK;
  private final ReminderSpinner nL;
  private final ViewStub nM;
  private View nN;
  private ImageView nO;
  private TextView nP;
  private g nQ;
  private c nR;
  private final TextView nS;
  private final View[] nT;
  private final List<h> nU = Lists.newArrayList();
  private final List<a> nV = Lists.newArrayList();
  private final List<j> nW = Lists.newArrayList();
  private final List<e> nX = Lists.newArrayList();
  private final List<b> nY = Lists.newArrayList();
  private f<a> nZ;
  private final int nt;
  private final int nu;
  private final int nv;
  private final int nw;
  private final Fragment nx;
  private final s ny;
  private final d nz;
  private final View.OnClickListener oA = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (((Boolean)Config.Pl.get()).booleanValue())
        x.a(ReminderHelper.b(ReminderHelper.this), ReminderHelper.r(ReminderHelper.this));
      while (true)
      {
        ReminderHelper.e(ReminderHelper.this, 2131230947);
        return;
        if ((ReminderHelper.r(ReminderHelper.this) == null) || (ReminderHelper.r(ReminderHelper.this).getType() == 1) || (ReminderHelper.r(ReminderHelper.this).getType() == 2))
          x.b(ReminderHelper.b(ReminderHelper.this), null, null);
        else
          x.b(ReminderHelper.b(ReminderHelper.this), ReminderHelper.r(ReminderHelper.this).r(ReminderHelper.a(ReminderHelper.this)), ReminderHelper.r(ReminderHelper.this).hY());
      }
    }
  };
  private f<j> oa;
  private f<e> ob;
  private f<b> oc;
  private KeepTime od;
  private KeepTime oe;
  private KeepTime of;
  private KeepTime og;
  private a oh;
  private boolean oi;
  private EventRecurrence oj;
  private String ok;
  private String ol;
  private String om;
  private Location on;
  private boolean oo;
  private String op;
  private int oq;
  private long or;
  private int os;
  private int ot;
  private int ou;
  private int ov;
  private BaseReminder.ReminderType ow;
  private BaseReminder.ReminderType ox = BaseReminder.ReminderType.uH;
  private final View.OnClickListener oy = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (A.U(ReminderHelper.a(ReminderHelper.this)))
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            if (ReminderHelper.b(ReminderHelper.this).isVisible())
              ReminderHelper.c(ReminderHelper.this).performClick();
          }
        }
        , 200L);
      if (ReminderHelper.d(ReminderHelper.this) == BaseReminder.ReminderType.uG)
      {
        ReminderHelper.a(ReminderHelper.this, ReminderHelper.e(ReminderHelper.this));
        ReminderHelper.a(ReminderHelper.this, ReminderHelper.DateType.oM.ordinal() - 1);
        ReminderHelper.g(ReminderHelper.this).cf(ReminderHelper.f(ReminderHelper.this));
        ReminderHelper.b(ReminderHelper.this, TimeReminder.TimePeriod.zJ.ordinal() - 1);
        ReminderHelper.i(ReminderHelper.this).cf(ReminderHelper.h(ReminderHelper.this));
        ReminderHelper.c(ReminderHelper.this, ReminderHelper.RecurrenceType.oW.ordinal());
        ReminderHelper.k(ReminderHelper.this).cf(ReminderHelper.j(ReminderHelper.this));
        ReminderHelper.a(ReminderHelper.this, (ReminderHelper.a)ReminderHelper.l(ReminderHelper.this).get(ReminderHelper.f(ReminderHelper.this)), (ReminderHelper.j)ReminderHelper.m(ReminderHelper.this).get(ReminderHelper.h(ReminderHelper.this)));
        if (ReminderHelper.d(ReminderHelper.this) == BaseReminder.ReminderType.uI)
        {
          TaskHelper.a(ReminderHelper.a(ReminderHelper.this), o.O(ReminderHelper.a(ReminderHelper.this)), ReminderHelper.n(ReminderHelper.this));
          ReminderHelper.d(ReminderHelper.this, -1);
          ReminderHelper.a(ReminderHelper.this, false);
        }
      }
      com.google.android.keep.util.e.B(paramAnonymousView);
      ReminderHelper.o(ReminderHelper.this).setText(2131231203);
      ReminderHelper.p(ReminderHelper.this);
      ReminderHelper.e(ReminderHelper.this, 2131230926);
    }
  };
  private final View.OnClickListener oz = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      ReminderHelper.q(ReminderHelper.this);
      a.a(paramAnonymousView, paramAnonymousView.getResources().getString(2131231241));
      ReminderHelper.e(ReminderHelper.this, 2131230927);
    }
  };

  public ReminderHelper(Fragment paramFragment, d paramd, View paramView, s params)
  {
    nx = paramFragment;
    mActivity = paramFragment.getActivity();
    ny = params;
    nz = paramd;
    nA = paramView;
    nB = nA.findViewById(2131493194);
    nC = nA.findViewById(2131493195);
    nD = ((TextView)nC.findViewById(2131493196));
    nE = nC.findViewById(2131493197);
    nt = U.kI();
    nu = U.kJ();
    nv = U.kK();
    nw = U.kL();
    nF = paramView.findViewById(2131493198);
    nG = nF.findViewById(2131493204);
    nH = ((ReminderSpinner)nF.findViewById(2131493199));
    nI = ((ReminderSpinner)nF.findViewById(2131493200));
    nJ = ((ReminderSpinner)nF.findViewById(2131493201));
    nK = ((ReminderSpinner)nF.findViewById(2131493205));
    nL = ((ReminderSpinner)nF.findViewById(2131493202));
    nS = ((TextView)nF.findViewById(2131493203));
    nM = ((ViewStub)paramView.findViewById(2131493206));
    nT = new View[] { nH, nI, nJ, nK, nL, nS };
    ow = BaseReminder.ReminderType.uG;
    ez();
    eA();
    x.a(nx, this, this);
  }

  private void F(boolean paramBoolean)
  {
    int i = 0;
    eE();
    View localView;
    switch (6.oD[ow.ordinal()])
    {
    default:
      localView = nE;
      if (!paramBoolean)
        break;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      localView.setVisibility(i);
      return;
      nC.setVisibility(8);
      nF.setVisibility(0);
      nH.cf(BaseReminder.ReminderType.uH.ordinal() - 1);
      nI.setVisibility(0);
      nJ.setVisibility(0);
      nK.setVisibility(0);
      nL.setVisibility(8);
      nS.setVisibility(8);
      break;
      nC.setVisibility(8);
      nF.setVisibility(0);
      nH.cf(BaseReminder.ReminderType.uI.ordinal() - 1);
      nI.setVisibility(8);
      nJ.setVisibility(8);
      nK.setVisibility(8);
      nL.setVisibility(8);
      nS.setVisibility(0);
      break;
      nC.setVisibility(0);
      nF.setVisibility(8);
      break;
      i = 8;
    }
  }

  private int a(BaseReminder.ReminderType paramReminderType)
  {
    switch (6.oD[paramReminderType.ordinal()])
    {
    default:
      throw new IllegalArgumentException("No icon for reminder type: " + paramReminderType.toString());
    case 2:
      return 2130837693;
    case 1:
    }
    return 2130837696;
  }

  private void a(DateType paramDateType, TimeReminder.TimePeriod paramTimePeriod)
  {
    eM();
    int i = 0;
    while (i < nV.size())
    {
      a locala = (a)nV.get(i);
      if ((locala.oH == paramDateType) && (nI.getSelectedItem() != locala))
      {
        nI.cf(i);
        os = i;
      }
      i += 1;
    }
    eN();
    i = 0;
    while (i < nW.size())
    {
      paramDateType = (j)nW.get(i);
      if ((paramDateType.pg == paramTimePeriod) && (nJ.getSelectedItem() != paramDateType))
      {
        nJ.cf(i);
        ot = i;
      }
      i += 1;
    }
  }

  private void a(RecurrenceType paramRecurrenceType)
  {
    eO();
    int i = 0;
    while (i < nX.size())
    {
      e locale = (e)nX.get(i);
      if ((locale.oV == paramRecurrenceType) && (nK.getSelectedItem() != locale))
      {
        nK.cf(i);
        ou = i;
      }
      i += 1;
    }
  }

  private void a(a parama)
  {
    a(parama, null);
  }

  private void a(a parama, j paramj)
  {
    if (parama != null)
    {
      fq.year = parama.year;
      fq.month = parama.month;
      fq.monthDay = parama.monthDay;
      fq.on();
      eM();
    }
    if (paramj != null)
    {
      fq.hour = paramj.hour;
      fq.minute = paramj.minute;
      fq.second = 0;
      fq.on();
      eN();
    }
    if (nz != null)
      nz.ev();
  }

  private void a(j paramj)
  {
    a(null, paramj);
  }

  private void a(KeepTime paramKeepTime, TimeReminder.TimePeriod paramTimePeriod)
  {
    ow = BaseReminder.ReminderType.uH;
    switch (6.oE[paramTimePeriod.ordinal()])
    {
    default:
      if (paramTimePeriod != TimeReminder.TimePeriod.zI)
      {
        paramKeepTime.minute = 0;
        paramKeepTime.second = 0;
      }
      fq = new KeepTime(paramKeepTime);
      fq.switchTimezone(KeepTime.getCurrentTimezone());
      if (DateUtils.isToday(fq.op()))
        eK();
      break;
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      if (!oo)
        break label196;
      ow = BaseReminder.ReminderType.uG;
      ox = BaseReminder.ReminderType.uH;
      F(true);
      nD.setText(com.google.android.keep.util.g.b(mActivity, fq));
      return;
      paramKeepTime.hour = nt;
      break;
      paramKeepTime.hour = nu;
      break;
      paramKeepTime.hour = nv;
      break;
      paramKeepTime.hour = nw;
      break;
      eJ();
    }
    label196: eF();
    a(b(paramKeepTime), paramTimePeriod);
  }

  private EventRecurrence aA(int paramInt)
  {
    EventRecurrence localEventRecurrence = new EventRecurrence();
    localEventRecurrence.freq = paramInt;
    return localEventRecurrence;
  }

  private void at(int paramInt)
  {
    int j = nT.length;
    Animator[] arrayOfAnimator = new Animator[j];
    int i = 0;
    if (i < j)
    {
      Object localObject = nT[i];
      if (((View)localObject).getId() == paramInt);
      for (localObject = f.a((View)localObject, null); ; localObject = f.a((View)localObject, null, 0.3F))
      {
        arrayOfAnimator[i] = localObject;
        i += 1;
        break;
      }
    }
    f.playTogether(arrayOfAnimator);
  }

  private void au(int paramInt)
  {
    ow = ((h)nU.get(paramInt)).pd;
    eF();
    switch (6.oD[ow.ordinal()])
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      if (nz != null)
        nz.ev();
      return;
      az(2131230928);
      continue;
      az(2131230944);
      if (on == null)
        nS.performClick();
    }
  }

  private void av(int paramInt)
  {
    if (paramInt + 1 == nV.size())
    {
      x.a(nx, fq, this);
      az(2131230932);
      return;
    }
    eE();
    os = paramInt;
    switch (6.oF[((a)nV.get(paramInt)).oH.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      a((a)nV.get(paramInt));
      return;
      az(2131230929);
      eK();
      eI();
      continue;
      az(2131230930);
      eJ();
      continue;
      az(2131230931);
      eJ();
    }
  }

  private void aw(int paramInt)
  {
    if (paramInt + 1 == nW.size())
    {
      x.a(nx, fq, this);
      az(2131230937);
      return;
    }
    eE();
    ot = paramInt;
    switch (6.oE[((j)nW.get(paramInt)).pg.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      a((j)nW.get(paramInt));
      return;
      az(2131230933);
      continue;
      az(2131230934);
      continue;
      az(2131230935);
      continue;
      az(2131230936);
    }
  }

  private void ax(int paramInt)
  {
    if (paramInt + 1 == nX.size())
    {
      x.a(nx, fq, oj, this);
      az(2131230943);
    }
    while (true)
    {
      return;
      eE();
      ou = paramInt;
      switch (6.oG[((e)nX.get(paramInt)).oV.ordinal()])
      {
      default:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
      while (nz != null)
      {
        nz.ev();
        return;
        az(2131230938);
        continue;
        az(2131230939);
        continue;
        az(2131230940);
        continue;
        az(2131230941);
        continue;
        az(2131230942);
      }
    }
  }

  private void ay(int paramInt)
  {
    eE();
    int i = b.a((b)nY.get(paramInt));
    switch (i)
    {
    default:
      return;
    case 1:
      ov = paramInt;
      on = new Location(i, ok);
      az(2131230945);
      eE();
      return;
    case 2:
      ov = paramInt;
      on = new Location(i, ol);
      az(2131230946);
      eE();
      return;
    case 3:
    }
    String str = b.b((b)nY.get(nY.size() - 1));
    if ((om.equals(str)) || (on == null))
      x.b(nx, null, null);
    while (true)
    {
      az(2131230947);
      return;
      x.b(nx, on.r(mActivity), on.hY());
    }
  }

  private void az(int paramInt)
  {
    if (ny != null)
      ny.n(paramInt, 2131231014);
  }

  private DateType b(KeepTime paramKeepTime)
  {
    if ((paramKeepTime.year == oe.year) && (paramKeepTime.yearDay == oe.yearDay))
      return DateType.oL;
    if ((paramKeepTime.year == of.year) && (paramKeepTime.yearDay == of.yearDay))
      return DateType.oM;
    if ((paramKeepTime.year == og.year) && (paramKeepTime.yearDay == og.yearDay))
      return DateType.oN;
    return DateType.oK;
  }

  private void b(Location paramLocation)
  {
    ow = BaseReminder.ReminderType.uI;
    e(paramLocation);
    eF();
    c(paramLocation);
  }

  private void c(Location paramLocation)
  {
    if (!oo)
      return;
    ow = BaseReminder.ReminderType.uG;
    ox = BaseReminder.ReminderType.uI;
    F(true);
    paramLocation = paramLocation.r(mActivity);
    if ((oo) && (or > 0L))
    {
      KeepTime localKeepTime = new KeepTime(or);
      nD.setText(com.google.android.keep.util.g.a(mActivity, localKeepTime, paramLocation));
      return;
    }
    nD.setText(mActivity.getString(2131231205, new Object[] { paramLocation }));
  }

  private void e(Location paramLocation)
  {
    on = paramLocation;
    nS.setTextAppearance(nS.getContext(), 2131558879);
    nS.setText(paramLocation.r(mActivity));
  }

  private void eA()
  {
    eB();
    nQ = new g(mActivity, nU);
    nH.setAdapter(nQ);
    nH.setOnTouchListener(this);
    nH.a(this);
    eC();
    nZ = new f(mActivity, nV);
    nI.setAdapter(nZ);
    nI.setOnTouchListener(this);
    nI.a(this);
    oa = new f(mActivity, nW);
    nJ.setAdapter(oa);
    nJ.setOnTouchListener(this);
    nJ.a(this);
    ob = new f(mActivity, nX);
    nK.setAdapter(ob);
    nK.setOnTouchListener(this);
    nK.a(this);
    eD();
    oc = new f(mActivity, nY);
    nL.setAdapter(oc);
    nL.setOnTouchListener(this);
    nL.a(this);
    ov = 0;
  }

  private void eB()
  {
    nU.clear();
    nU.add(new k(2131492882, 2131231207, 2130837696));
    nR = new c(2131492883, 2131231208, 2130837693, 2131231209, 2130837733);
    nU.add(nR);
    new AsyncTask()
    {
      protected Void doInBackground(Void[] paramAnonymousArrayOfVoid)
      {
        if (h.a(ReminderHelper.a(ReminderHelper.this).getContentResolver(), i.c.CONTENT_URI, "_count", "state=5", null).intValue() > 0)
        {
          ReminderHelper.s(ReminderHelper.this).G(true);
          ReminderHelper.t(ReminderHelper.this).notifyDataSetChanged();
        }
        return null;
      }
    }
    .execute(new Void[0]);
  }

  private void eC()
  {
    od = new KeepTime();
    oe = new KeepTime(od);
    oe.hour = 0;
    oe.minute = 0;
    oe.second = 0;
    oe.on();
    of = new KeepTime(oe);
    KeepTime localKeepTime = of;
    localKeepTime.monthDay += 1;
    of.on();
    og = new KeepTime(oe);
    localKeepTime = og;
    localKeepTime.monthDay += 7;
    og.on();
    fq = new KeepTime(of);
    fq.hour = nt;
    fq.on();
    nV.clear();
    oh = new a(2131492884, mActivity, od, DateType.oL);
    nV.add(oh);
    nV.add(new a(2131492885, mActivity, od, DateType.oM));
    nV.add(new a(2131492886, mActivity, od, DateType.oN));
    nV.add(new a(2131492887, mActivity, od, DateType.oK));
    nW.clear();
    nW.add(new j(2131492888, mActivity, TimeReminder.TimePeriod.zJ));
    nW.add(new j(2131492889, mActivity, TimeReminder.TimePeriod.zK));
    nW.add(new j(2131492890, mActivity, TimeReminder.TimePeriod.zL));
    nW.add(new j(2131492891, mActivity, TimeReminder.TimePeriod.zM));
    nW.add(new j(2131492892, mActivity, fq, 2131231224));
    nX.clear();
    nX.add(new e(2131492893, mActivity, RecurrenceType.oW, null, 2131231226));
    nX.add(new e(2131492894, mActivity, RecurrenceType.oX, aA(4), 2131231227));
    nX.add(new e(2131492895, mActivity, RecurrenceType.oY, aA(5), 2131231228));
    nX.add(new e(2131492896, mActivity, RecurrenceType.oZ, aA(6), 2131231229));
    nX.add(new e(2131492897, mActivity, RecurrenceType.pa, aA(7), 2131231230));
    nX.add(new e(2131492898, mActivity, RecurrenceType.pb, oj, 2131231231));
  }

  private void eD()
  {
    ok = mActivity.getString(2131231233);
    ol = mActivity.getString(2131231234);
    om = mActivity.getString(2131231235);
    on = null;
    nY.clear();
    nY.add(new b(2131492899, 1, ok, ok));
    nY.add(new b(2131492900, 2, ol, ol));
    nY.add(new b(2131492901, 3, om, om));
  }

  private void eE()
  {
    int j = nT.length;
    Animator[] arrayOfAnimator = new Animator[j];
    int i = 0;
    while (i < j)
    {
      arrayOfAnimator[i] = f.a(nT[i], null);
      i += 1;
    }
    f.playTogether(arrayOfAnimator);
  }

  private void eF()
  {
    F(false);
  }

  private void eG()
  {
    ow = BaseReminder.ReminderType.uG;
    nD.setText(2131231203);
    eF();
  }

  private void eH()
  {
    eG();
    if (nz != null)
      nz.ew();
  }

  private void eI()
  {
    KeepTime localKeepTime = new KeepTime();
    if (fq.oq() > localKeepTime.oq())
      break label25;
    label25: 
    while (3600000L * TimeReminder.TimePeriod.c(ex()) > localKeepTime.oq())
      return;
    int k = 1;
    int i = 0;
    while (true)
    {
      int j = k;
      if (i < nW.size())
      {
        j localj = (j)nW.get(i);
        if (localj.hour > localKeepTime.hour)
        {
          a(localj);
          nJ.cf(i);
          ot = i;
          j = 0;
        }
      }
      else
      {
        if (j == 0)
          break;
        k = localKeepTime.hour + 1;
        j = localKeepTime.minute;
        i = k;
        if (k > 23)
        {
          i = 23;
          j = 59;
        }
        h(i, j);
        return;
      }
      i += 1;
    }
  }

  private void eJ()
  {
    Iterator localIterator = nW.iterator();
    while (localIterator.hasNext())
      ((j)localIterator.next()).setEnabled(true);
  }

  private void eK()
  {
    KeepTime localKeepTime = new KeepTime();
    Iterator localIterator = nW.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if (localj.hour <= localKeepTime.hour)
        localj.setEnabled(false);
    }
  }

  private void eM()
  {
    int i = nV.size() - 1;
    if (i < 0)
      return;
    nZ.remove(nV.get(i));
    nZ.add(new a(2131492887, mActivity, fq, DateType.oK));
  }

  private void eN()
  {
    int i = nW.size() - 1;
    if (i < 0)
      return;
    oa.remove(nW.get(i));
    oa.add(new j(2131492892, mActivity, fq, 2131231224));
  }

  private void eO()
  {
    int i = nX.size() - 1;
    if (i < 0)
      return;
    ob.remove(nX.get(i));
    ob.add(new e(2131492898, mActivity, RecurrenceType.pb, oj, 2131231231));
  }

  private TimeReminder.TimePeriod ex()
  {
    return ((j)nW.get(ot)).pg;
  }

  private int ey()
  {
    TimeReminder.TimePeriod localTimePeriod = ex();
    if (localTimePeriod == TimeReminder.TimePeriod.zI)
      return 0;
    return TimeReminder.TimePeriod.b(localTimePeriod);
  }

  private void ez()
  {
    eF();
    nC.setOnClickListener(oy);
    nE.setOnClickListener(oz);
    nG.setOnClickListener(oz);
    nS.setOnClickListener(oA);
  }

  private String h(Context paramContext)
  {
    switch (6.oD[ow.ordinal()])
    {
    default:
      return null;
    case 1:
      return com.google.android.keep.util.g.a(paramContext, fq, ex());
    case 2:
    }
    return on.r(mActivity);
  }

  public void B(boolean paramBoolean)
  {
    if (de == paramBoolean)
      return;
    de = paramBoolean;
    if (nN == null)
    {
      nN = nA.findViewById(2131493207);
      if (nN == null)
      {
        nN = nM.inflate();
        nO = ((ImageView)nN.findViewById(2131493208));
        nP = ((TextView)nN.findViewById(2131493209));
      }
    }
    if (de)
    {
      nB.setVisibility(8);
      if (oi)
      {
        nN.setVisibility(0);
        nO.setImageResource(a(BaseReminder.ReminderType.uH));
        nP.setText(mActivity.getString(2131231244));
        return;
      }
      if (ow != BaseReminder.ReminderType.uG)
      {
        nN.setVisibility(0);
        nO.setImageResource(a(ow));
        nP.setText(h(mActivity));
        return;
      }
      nN.setVisibility(8);
      return;
    }
    nB.setVisibility(0);
    nN.setVisibility(8);
  }

  public void a(Context paramContext, com.google.android.keep.location.g paramg)
  {
    r.a("Keep", "Location: " + paramg, new Object[0]);
    new com.google.android.keep.location.e(paramContext)
    {
      protected void c(List<Location> paramAnonymousList)
      {
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
          d((Location)paramAnonymousList.get(0));
      }
    }
    .execute(new com.google.android.keep.location.g[] { paramg });
  }

  public void a(EventRecurrence paramEventRecurrence)
  {
    eE();
    if (paramEventRecurrence != null)
    {
      ou = (nX.size() - 1);
      oj = paramEventRecurrence;
      eO();
    }
    while (true)
    {
      nK.cf(ou);
      if (nz != null)
        nz.ev();
      return;
      ou = 0;
    }
  }

  public void a(BaseReminder paramBaseReminder)
  {
    if (paramBaseReminder == null)
    {
      op = null;
      eG();
    }
    while (true)
    {
      return;
      op = paramBaseReminder.gq();
      switch (paramBaseReminder.getType())
      {
      default:
        return;
      case 0:
      case 1:
      }
      try
      {
        paramBaseReminder = (TimeReminder)paramBaseReminder;
        oi = paramBaseReminder.jq();
        if (oi)
        {
          F(true);
          nD.setText(mActivity.getString(2131231244));
          return;
        }
        TimeReminder.TimePeriod localTimePeriod = TimeReminder.TimePeriod.bm(paramBaseReminder.jo());
        a(new KeepTime(paramBaseReminder.jp()), localTimePeriod);
        paramBaseReminder = paramBaseReminder.getRecurrence();
        if (paramBaseReminder != null)
        {
          oj = com.google.android.keep.model.g.a(paramBaseReminder);
          a(y.d(oj));
          return;
          try
          {
            nI.cf(DateType.oM.ordinal() - 1);
            nJ.cf(TimeReminder.TimePeriod.zJ.ordinal() - 1);
            nK.cf(RecurrenceType.oW.ordinal());
            a(((LocationReminder)paramBaseReminder).hZ());
            return;
          }
          catch (ClassCastException paramBaseReminder)
          {
          }
        }
      }
      catch (ClassCastException paramBaseReminder)
      {
      }
    }
  }

  void a(Location paramLocation)
  {
    b(paramLocation);
  }

  public void a(boolean paramBoolean, int paramInt, long paramLong)
  {
    oo = paramBoolean;
    oq = paramInt;
    or = paramLong;
    if (oq != 5)
      nR.G(false);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    eE();
    os = (nV.size() - 1);
    fq.year = paramInt1;
    fq.month = paramInt2;
    fq.monthDay = paramInt3;
    fq.on();
    eM();
    DateType localDateType = b(fq);
    paramInt1 = 0;
    if (paramInt1 < nV.size())
    {
      a locala = (a)nV.get(paramInt1);
      if (locala.oH != localDateType)
        break label168;
      if (locala != nI.getSelectedItem())
      {
        nI.cf(paramInt1);
        os = paramInt1;
      }
    }
    if (DateUtils.isToday(fq.op()))
    {
      eK();
      eI();
    }
    while (true)
    {
      if (nz != null)
        nz.ev();
      return;
      label168: paramInt1 += 1;
      break;
      eJ();
    }
  }

  public void b(Place paramPlace)
  {
    r.a("Keep", "Place: " + paramPlace, new Object[0]);
    d(new Location(paramPlace));
  }

  public void bQ()
  {
    eE();
    nI.cf(os);
  }

  public void bR()
  {
    eE();
    nJ.cf(ot);
  }

  public void bp()
  {
    eE();
    if (on != null)
      ow = BaseReminder.ReminderType.uI;
    while (true)
    {
      eF();
      return;
      if (fq != null)
        ow = BaseReminder.ReminderType.uH;
      else
        ow = BaseReminder.ReminderType.uG;
    }
  }

  public void d(Location paramLocation)
  {
    eE();
    ov = (nY.size() - 1);
    e(paramLocation);
    if ((ow != BaseReminder.ReminderType.uI) && (on != null))
    {
      ow = BaseReminder.ReminderType.uI;
      eF();
    }
    if (nz != null)
      nz.ev();
  }

  public void eL()
  {
    eE();
    nK.cf(ou);
  }

  public void h(int paramInt1, int paramInt2)
  {
    eE();
    ot = (nW.size() - 1);
    fq.hour = paramInt1;
    fq.minute = paramInt2;
    fq.second = 0;
    fq.oo();
    eN();
    KeepTime localKeepTime = new KeepTime();
    if (fq.op() < localKeepTime.op())
    {
      if ((fq.hour >= localKeepTime.hour) && ((fq.hour != localKeepTime.hour) || (fq.minute >= localKeepTime.minute)))
        break label181;
      b(localKeepTime.year, localKeepTime.month, localKeepTime.monthDay + 1);
    }
    while (true)
    {
      ot = (nW.size() - 1);
      nJ.cf(ot);
      if (nz != null)
        nz.ev();
      return;
      label181: b(localKeepTime.year, localKeepTime.month, localKeepTime.monthDay);
    }
  }

  public BaseReminder k(long paramLong)
  {
    switch (6.oD[ow.ordinal()])
    {
    default:
      return null;
    case 1:
      if (oi)
        return new TimeReminder(paramLong, null);
      int i = fq.jm();
      long l = fq.oq();
      Object localObject = (e)ob.getItem(ou);
      j localj = (j)oa.getItem(ot);
      localObject = y.a(fq, localj.pg, ((e)localObject).oV, oj);
      return new TimeReminder(paramLong, null, i, l, ey(), oo, or, (Recurrence)localObject);
    case 2:
    }
    if (on == null)
      return null;
    return new LocationReminder(paramLong, on);
  }

  public void m(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 2131493203:
    case 2131493204:
    default:
      return;
    case 2131493199:
      au(paramInt2);
      return;
    case 2131493200:
      av(paramInt2);
      return;
    case 2131493201:
      aw(paramInt2);
      return;
    case 2131493205:
      ax(paramInt2);
      return;
    case 2131493202:
    }
    ay(paramInt2);
  }

  public void onClose()
  {
    eE();
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
      at(paramView.getId());
    return false;
  }

  static enum DateType
  {
  }

  public static enum RecurrenceType
  {
  }

  static class a extends ReminderHelper.i
  {
    final int month;
    final int monthDay;
    final ReminderHelper.DateType oH;
    private final String oI;
    private final String oJ;
    final int year;

    a(int paramInt, Context paramContext, KeepTime paramKeepTime, ReminderHelper.DateType paramDateType)
    {
      super();
      oH = paramDateType;
      KeepTime localKeepTime = new KeepTime(paramKeepTime);
      switch (ReminderHelper.6.oF[oH.ordinal()])
      {
      default:
        throw new IllegalArgumentException("Unknown DateType: " + paramDateType);
      case 1:
        localKeepTime.on();
        oI = paramContext.getString(2131231210);
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        year = localKeepTime.year;
        month = localKeepTime.month;
        monthDay = localKeepTime.monthDay;
        if (paramDateType != ReminderHelper.DateType.oK)
          break;
        oJ = i(paramContext);
        return;
        localKeepTime.monthDay += 1;
        localKeepTime.on();
        oI = paramContext.getString(2131231211);
        continue;
        localKeepTime.monthDay += 7;
        localKeepTime.on();
        oI = a(paramContext, localKeepTime);
        continue;
        localKeepTime.year = paramKeepTime.year;
        localKeepTime.month = paramKeepTime.month;
        localKeepTime.monthDay = paramKeepTime.monthDay;
        localKeepTime.on();
        oI = paramContext.getString(2131231219);
      }
      oJ = oI;
    }

    private String a(Context paramContext, KeepTime paramKeepTime)
    {
      switch (paramKeepTime.weekDay)
      {
      default:
        return null;
      case 0:
        return paramContext.getString(2131231218);
      case 1:
        return paramContext.getString(2131231212);
      case 2:
        return paramContext.getString(2131231213);
      case 3:
        return paramContext.getString(2131231214);
      case 4:
        return paramContext.getString(2131231215);
      case 5:
        return paramContext.getString(2131231216);
      case 6:
      }
      return paramContext.getString(2131231217);
    }

    private String i(Context paramContext)
    {
      KeepTime localKeepTime = new KeepTime();
      localKeepTime.set(0, 0, 0, monthDay, month, year);
      return DateUtils.formatDateTime(paramContext, localKeepTime.op(), 16);
    }

    public String eP()
    {
      return oI;
    }

    public String eQ()
    {
      return oJ;
    }
  }

  private class b extends ReminderHelper.i
  {
    private final int mType;
    private final String oI;
    private final String oJ;

    b(int paramInt1, int paramString1, String paramString2, String arg5)
    {
      super();
      mType = paramString1;
      oJ = paramString2;
      Object localObject;
      oI = localObject;
    }

    public String eP()
    {
      return oI;
    }

    public String eQ()
    {
      return oJ;
    }
  }

  private static class c extends ReminderHelper.h
  {
    private final int oP;
    private final int oQ;
    private final int oR;
    private final int oS;
    private boolean oT;
    private final float oU = 0.5F;

    c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      super(BaseReminder.ReminderType.uI);
      oP = paramInt2;
      oQ = paramInt3;
      oR = paramInt4;
      oS = paramInt5;
      oT = false;
    }

    public void G(boolean paramBoolean)
    {
      oT = paramBoolean;
    }

    public int eR()
    {
      if (oT)
        return oR;
      return oP;
    }

    public float[] eS()
    {
      if (oT)
        return new float[] { 0.5F, 0.5F };
      return null;
    }

    public int getIcon()
    {
      if (oT)
        return oS;
      return oQ;
    }
  }

  public static abstract interface d
  {
    public abstract void ev();

    public abstract void ew();
  }

  private static class e extends ReminderHelper.i
  {
    private final String oI;
    private String oJ;
    final ReminderHelper.RecurrenceType oV;

    e(int paramInt1, Context paramContext, ReminderHelper.RecurrenceType paramRecurrenceType, EventRecurrence paramEventRecurrence, int paramInt2)
    {
      super();
      paramContext = paramContext.getResources();
      oV = paramRecurrenceType;
      oI = paramContext.getString(paramInt2);
      if ((oV == ReminderHelper.RecurrenceType.oW) || (paramEventRecurrence == null))
      {
        oJ = oI;
        return;
      }
      oJ = x.a(paramContext, paramEventRecurrence);
    }

    public String eP()
    {
      return oI;
    }

    public String eQ()
    {
      return oJ;
    }
  }

  private static class f<T extends ReminderHelper.i> extends ArrayAdapter<T>
  {
    f(Context paramContext, List<T> paramList)
    {
      super(2130968698, 2131493145, paramList);
      setDropDownViewResource(2130968697);
    }

    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = super.getDropDownView(paramInt, null, paramViewGroup);
      paramViewGroup = (TextView)paramView.findViewById(2131493145);
      ReminderHelper.i locali = (ReminderHelper.i)getItem(paramInt);
      paramViewGroup.setText(locali.eP());
      TextView localTextView = (TextView)paramView.findViewById(2131493224);
      Object localObject = locali.eU();
      if (!TextUtils.isEmpty((CharSequence)localObject))
        localTextView.setText((CharSequence)localObject);
      localObject = paramView.getResources();
      if (locali.isEnabled())
      {
        paramViewGroup.setTextColor(((Resources)localObject).getColor(2131296375));
        localTextView.setTextColor(((Resources)localObject).getColor(2131296377));
      }
      while (true)
      {
        paramView.setBackgroundResource(locali.eT());
        paramView.setId(locali.id);
        return paramView;
        paramInt = ((Resources)localObject).getColor(2131296412);
        paramViewGroup.setTextColor(paramInt);
        localTextView.setTextColor(paramInt);
      }
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if ((paramViewGroup instanceof AdapterView))
        paramInt = ((AdapterView)paramViewGroup).getSelectedItemPosition();
      return super.getView(paramInt, paramView, paramViewGroup);
    }

    public boolean isEnabled(int paramInt)
    {
      return ((ReminderHelper.i)getItem(paramInt)).pf;
    }
  }

  private static class g extends ArrayAdapter<ReminderHelper.h>
  {
    protected final LayoutInflater mInflater;

    g(Context paramContext, List<ReminderHelper.h> paramList)
    {
      super(2130968692, 2131493145, paramList);
      mInflater = LayoutInflater.from(paramContext);
      setDropDownViewResource(2130968691);
    }

    private void a(ReminderHelper.h paramh, View paramView)
    {
      ((TextView)paramView.findViewById(2131493145)).setText(paramh.eR());
    }

    private void b(ReminderHelper.h paramh, View paramView)
    {
      paramView = (ImageView)paramView.findViewById(2131492985);
      paramView.setImageResource(paramh.getIcon());
      paramh = paramh.eS();
      if (paramh != null)
      {
        paramView.setScaleX(paramh[0]);
        paramView.setScaleY(paramh[1]);
      }
    }

    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
        paramView = mInflater.inflate(2130968691, paramViewGroup, false);
      while (true)
      {
        paramViewGroup = (ReminderHelper.h)getItem(paramInt);
        b(paramViewGroup, paramView);
        a(paramViewGroup, paramView);
        paramView.setId(paramViewGroup.id);
        return paramView;
      }
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
        paramView = mInflater.inflate(2130968692, paramViewGroup, false);
      while (true)
      {
        b((ReminderHelper.h)getItem(paramInt), paramView);
        return paramView;
      }
    }
  }

  private static abstract class h
  {
    public final int id;
    public final BaseReminder.ReminderType pd;

    public h(int paramInt, BaseReminder.ReminderType paramReminderType)
    {
      id = paramInt;
      pd = paramReminderType;
    }

    public abstract int eR();

    public float[] eS()
    {
      return null;
    }

    public abstract int getIcon();
  }

  private static abstract class i
  {
    public final int id;
    private int pe = 2130837619;
    public boolean pf = true;

    public i(int paramInt)
    {
      id = paramInt;
    }

    public abstract String eP();

    public abstract String eQ();

    public int eT()
    {
      return pe;
    }

    public String eU()
    {
      return null;
    }

    public boolean isEnabled()
    {
      return pf;
    }

    public void setEnabled(boolean paramBoolean)
    {
      pf = paramBoolean;
    }

    public final String toString()
    {
      return eQ();
    }
  }

  static class j extends ReminderHelper.i
  {
    final int hour;
    final int minute;
    private final String oI;
    private final String oJ;
    final TimeReminder.TimePeriod pg;
    private final String ph;

    j(int paramInt, Context paramContext, TimeReminder.TimePeriod paramTimePeriod)
    {
      super();
      pg = paramTimePeriod;
      switch (ReminderHelper.6.oE[paramTimePeriod.ordinal()])
      {
      default:
        throw new IllegalArgumentException("TimePeriod not supported: " + paramTimePeriod);
      case 1:
        hour = U.kI();
        minute = 0;
        oI = paramContext.getString(2131231220);
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        oJ = oI;
        ph = j(paramContext);
        return;
        hour = U.kJ();
        minute = 0;
        oI = paramContext.getString(2131231221);
        continue;
        hour = U.kK();
        minute = 0;
        oI = paramContext.getString(2131231222);
        continue;
        hour = U.kL();
        minute = 0;
        oI = paramContext.getString(2131231223);
      }
    }

    j(int paramInt1, Context paramContext, KeepTime paramKeepTime, int paramInt2)
    {
      super();
      pg = TimeReminder.TimePeriod.zI;
      hour = paramKeepTime.hour;
      minute = paramKeepTime.minute;
      oJ = j(paramContext);
      oI = paramContext.getString(paramInt2);
      ph = null;
    }

    private String j(Context paramContext)
    {
      KeepTime localKeepTime = new KeepTime();
      localKeepTime.hour = hour;
      localKeepTime.minute = minute;
      localKeepTime.second = 0;
      localKeepTime.on();
      return DateUtils.formatDateTime(paramContext, localKeepTime.op(), 1);
    }

    public String eP()
    {
      return oI;
    }

    public String eQ()
    {
      return oJ;
    }

    public String eU()
    {
      return ph;
    }
  }

  private static class k extends ReminderHelper.h
  {
    private final int mIcon;
    private final int pi;

    k(int paramInt1, int paramInt2, int paramInt3)
    {
      super(BaseReminder.ReminderType.uH);
      pi = paramInt2;
      mIcon = paramInt3;
    }

    public int eR()
    {
      return pi;
    }

    public int getIcon()
    {
      return mIcon;
    }
  }
}