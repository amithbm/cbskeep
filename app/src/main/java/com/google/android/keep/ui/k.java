package com.google.android.keep.ui;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.android.datetimepicker.HapticFeedbackController;
import com.android.datetimepicker.Utils;
import com.android.datetimepicker.time.RadialPickerLayout;
import com.android.datetimepicker.time.RadialPickerLayout.OnValueSelectedListener;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class k extends DialogFragment
  implements RadialPickerLayout.OnValueSelectedListener
{
  private a JR;
  private TextView JS;
  private TextView JT;
  private TextView JU;
  private TextView JV;
  private TextView JW;
  private TextView JX;
  private View JY;
  private RadialPickerLayout JZ;
  private boolean Ka;
  private int Kb;
  private int Kc;
  private boolean Kd;
  private char Ke;
  private String Kf;
  private String Kg;
  private boolean Kh;
  private ArrayList<Integer> Ki;
  private c Kj;
  private int Kk;
  private int Kl;
  private String Km;
  private String Kn;
  private String Ko;
  private String Kp;
  private String mAmText;
  private HapticFeedbackController mHapticFeedbackController;
  private boolean mIs24HourMode;
  private String mPmText;
  private int mSelectedColor;
  private int mUnselectedColor;

  public static k a(a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    k localk = new k();
    localk.b(parama, paramInt1, paramInt2, paramBoolean);
    return localk;
  }

  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    JZ.setCurrentItemShowing(paramInt, paramBoolean1);
    int i;
    Object localObject;
    if (paramInt == 0)
    {
      int j = JZ.getHours();
      i = j;
      if (!mIs24HourMode)
        i = j % 12;
      JZ.setContentDescription(Km + ": " + i);
      if (paramBoolean3)
        Utils.tryAccessibilityAnnounce(JZ, Kn);
      localObject = JT;
      if (paramInt != 0)
        break label230;
      i = mSelectedColor;
      label106: if (paramInt != 1)
        break label239;
    }
    label230: label239: for (paramInt = mSelectedColor; ; paramInt = mUnselectedColor)
    {
      JT.setTextColor(i);
      JV.setTextColor(paramInt);
      localObject = Utils.getPulseAnimator((View)localObject, 0.85F, 1.1F);
      if (paramBoolean2)
        ((ObjectAnimator)localObject).setStartDelay(300L);
      ((ObjectAnimator)localObject).start();
      return;
      i = JZ.getMinutes();
      JZ.setContentDescription(Ko + ": " + i);
      if (paramBoolean3)
        Utils.tryAccessibilityAnnounce(JZ, Kp);
      localObject = JV;
      break;
      i = mUnselectedColor;
      break label106;
    }
  }

  private int[] a(Boolean[] paramArrayOfBoolean)
  {
    int i = -1;
    int k = 1;
    int m = i;
    int j = k;
    if (!mIs24HourMode)
    {
      m = i;
      j = k;
      if (mj())
      {
        j = ((Integer)Ki.get(Ki.size() - 1)).intValue();
        if (j != bZ(0))
          break label148;
        i = 0;
        j = 2;
        m = i;
      }
    }
    int i1 = -1;
    int i2 = -1;
    int n = j;
    label79: if (n <= Ki.size())
    {
      int i3 = bY(((Integer)Ki.get(Ki.size() - n)).intValue());
      if (n == j)
      {
        k = i3;
        i = i2;
      }
      while (true)
      {
        n += 1;
        i2 = i;
        i1 = k;
        break label79;
        if (j != bZ(1))
          break;
        i = 1;
        break;
        if (n == j + 1)
        {
          i1 += i3 * 10;
          i = i2;
          k = i1;
          if (paramArrayOfBoolean != null)
          {
            i = i2;
            k = i1;
            if (i3 == 0)
            {
              paramArrayOfBoolean[1] = Boolean.valueOf(true);
              i = i2;
              k = i1;
            }
          }
        }
        else if (n == j + 2)
        {
          i = i3;
          k = i1;
        }
        else
        {
          i = i2;
          k = i1;
          if (n == j + 3)
          {
            i2 += i3 * 10;
            i = i2;
            k = i1;
            if (paramArrayOfBoolean != null)
            {
              i = i2;
              k = i1;
              if (i3 == 0)
              {
                paramArrayOfBoolean[0] = Boolean.valueOf(true);
                i = i2;
                k = i1;
              }
            }
          }
        }
      }
    }
    label148: return new int[] { i2, i1, m };
  }

  private void aE(boolean paramBoolean)
  {
    Kh = false;
    if (!Ki.isEmpty())
    {
      int[] arrayOfInt = a(null);
      JZ.setTime(arrayOfInt[0], arrayOfInt[1]);
      if (!mIs24HourMode)
        JZ.setAmOrPm(arrayOfInt[2]);
      Ki.clear();
    }
    if (paramBoolean)
    {
      updateDisplay(false);
      JZ.trySettingInputEnabled(true);
    }
  }

  private void bU(int paramInt)
  {
    if (paramInt == 0)
    {
      JX.setText(mAmText);
      Utils.tryAccessibilityAnnounce(JZ, mAmText);
      JY.setContentDescription(mAmText);
      return;
    }
    if (paramInt == 1)
    {
      JX.setText(mPmText);
      Utils.tryAccessibilityAnnounce(JZ, mPmText);
      JY.setContentDescription(mPmText);
      return;
    }
    JX.setText(Kf);
  }

  private boolean bV(int paramInt)
  {
    if ((paramInt == 111) || (paramInt == 4))
      dismiss();
    label105: 
    do
    {
      do
      {
        do
        {
          return true;
          if (paramInt != 61)
            break;
          if (!Kh)
            break label174;
        }
        while (!mj());
        aE(true);
        return true;
        if (paramInt != 66)
          break label105;
        if (!Kh)
          break;
      }
      while (!mj());
      aE(false);
      if (JR != null)
        JR.h(JZ.getHours(), JZ.getMinutes());
      dismiss();
      return true;
      if (paramInt == 67)
        if ((Kh) && (!Ki.isEmpty()))
        {
          paramInt = mk();
          if (paramInt != bZ(0))
            break label176;
          str = mAmText;
          Utils.tryAccessibilityAnnounce(JZ, String.format(Kg, new Object[] { str }));
          updateDisplay(true);
        }
      while ((paramInt != 7) && (paramInt != 8) && (paramInt != 9) && (paramInt != 10) && (paramInt != 11) && (paramInt != 12) && (paramInt != 13) && (paramInt != 14) && (paramInt != 15) && (paramInt != 16) && ((mIs24HourMode) || ((paramInt != bZ(0)) && (paramInt != bZ(1)))))
        while (true)
        {
          String str;
          return false;
          if (paramInt == bZ(1))
            str = mPmText;
          else
            str = String.format("%d", new Object[] { Integer.valueOf(bY(paramInt)) });
        }
      if (!Kh)
      {
        if (JZ == null)
        {
          Log.e("TimePickerDialog", "Unable to initiate keyboard mode, TimePicker was null.");
          return true;
        }
        Ki.clear();
        bW(paramInt);
        return true;
      }
    }
    while (!bX(paramInt));
    label174: label176: updateDisplay(false);
    return true;
  }

  private void bW(int paramInt)
  {
    if ((JZ.trySettingInputEnabled(false)) && ((paramInt == -1) || (bX(paramInt))))
    {
      Kh = true;
      JS.setEnabled(false);
      updateDisplay(false);
    }
  }

  private boolean bX(int paramInt)
  {
    if (((mIs24HourMode) && (Ki.size() == 4)) || ((!mIs24HourMode) && (mj())))
      return false;
    Ki.add(Integer.valueOf(paramInt));
    if (!mi())
    {
      mk();
      return false;
    }
    paramInt = bY(paramInt);
    Utils.tryAccessibilityAnnounce(JZ, String.format("%d", new Object[] { Integer.valueOf(paramInt) }));
    if (mj())
    {
      if ((!mIs24HourMode) && (Ki.size() <= 3))
      {
        Ki.add(Ki.size() - 1, Integer.valueOf(7));
        Ki.add(Ki.size() - 1, Integer.valueOf(7));
      }
      JS.setEnabled(true);
    }
    return true;
  }

  private static int bY(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return -1;
    case 7:
      return 0;
    case 8:
      return 1;
    case 9:
      return 2;
    case 10:
      return 3;
    case 11:
      return 4;
    case 12:
      return 5;
    case 13:
      return 6;
    case 14:
      return 7;
    case 15:
      return 8;
    case 16:
    }
    return 9;
  }

  private int bZ(int paramInt)
  {
    int m = -1;
    int k;
    if ((Kk == -1) || (Kl == -1))
    {
      Object localObject = KeyCharacterMap.load(-1);
      k = 0;
      if (k < Math.max(mAmText.length(), mPmText.length()))
      {
        int i = mAmText.toLowerCase(Locale.getDefault()).charAt(k);
        int j = mPmText.toLowerCase(Locale.getDefault()).charAt(k);
        if (i == j)
          break label165;
        localObject = ((KeyCharacterMap)localObject).getEvents(new char[] { i, j });
        if ((localObject == null) || (localObject.length != 4))
          break label152;
        Kk = localObject[0].getKeyCode();
        Kl = localObject[2].getKeyCode();
      }
    }
    label139: if (paramInt == 0)
      k = Kk;
    label152: label165: 
    do
    {
      return k;
      Log.e("TimePickerDialog", "Unable to find keycodes for AM and PM.");
      break label139;
      k += 1;
      break;
      k = m;
    }
    while (paramInt != 1);
    return Kl;
  }

  private void f(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (mIs24HourMode)
      localObject = "%02d";
    while (true)
    {
      localObject = String.format((String)localObject, new Object[] { Integer.valueOf(paramInt) });
      JT.setText((CharSequence)localObject);
      JU.setText((CharSequence)localObject);
      if (paramBoolean)
        Utils.tryAccessibilityAnnounce(JZ, (CharSequence)localObject);
      return;
      String str = "%d";
      int i = paramInt % 12;
      localObject = str;
      paramInt = i;
      if (i == 0)
      {
        paramInt = 12;
        localObject = str;
      }
    }
  }

  private boolean mi()
  {
    Object localObject = Kj;
    Iterator localIterator = Ki.iterator();
    while (localIterator.hasNext())
    {
      c localc = ((c)localObject).cb(((Integer)localIterator.next()).intValue());
      localObject = localc;
      if (localc == null)
        return false;
    }
    return true;
  }

  private boolean mj()
  {
    boolean bool = false;
    if (mIs24HourMode)
    {
      int[] arrayOfInt = a(null);
      return (arrayOfInt[0] >= 0) && (arrayOfInt[1] >= 0) && (arrayOfInt[1] < 60);
    }
    if ((Ki.contains(Integer.valueOf(bZ(0)))) || (Ki.contains(Integer.valueOf(bZ(1)))))
      bool = true;
    return bool;
  }

  private int mk()
  {
    int i = ((Integer)Ki.remove(Ki.size() - 1)).intValue();
    if (!mj())
      JS.setEnabled(false);
    return i;
  }

  private void ml()
  {
    Kj = new c(new int[0]);
    if (mIs24HourMode)
    {
      localc1 = new c(new int[] { 7, 8, 9, 10, 11, 12 });
      localc2 = new c(new int[] { 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 });
      localc1.a(localc2);
      localc3 = new c(new int[] { 7, 8 });
      Kj.a(localc3);
      localc4 = new c(new int[] { 7, 8, 9, 10, 11, 12 });
      localc3.a(localc4);
      localc4.a(localc1);
      localc4.a(new c(new int[] { 13, 14, 15, 16 }));
      localc4 = new c(new int[] { 13, 14, 15, 16 });
      localc3.a(localc4);
      localc4.a(localc1);
      localc3 = new c(new int[] { 9 });
      Kj.a(localc3);
      localc4 = new c(new int[] { 7, 8, 9, 10 });
      localc3.a(localc4);
      localc4.a(localc1);
      localc4 = new c(new int[] { 11, 12 });
      localc3.a(localc4);
      localc4.a(localc2);
      localc2 = new c(new int[] { 10, 11, 12, 13, 14, 15, 16 });
      Kj.a(localc2);
      localc2.a(localc1);
      return;
    }
    c localc1 = new c(new int[] { bZ(0), bZ(1) });
    c localc2 = new c(new int[] { 8 });
    Kj.a(localc2);
    localc2.a(localc1);
    c localc3 = new c(new int[] { 7, 8, 9 });
    localc2.a(localc3);
    localc3.a(localc1);
    c localc4 = new c(new int[] { 7, 8, 9, 10, 11, 12 });
    localc3.a(localc4);
    localc4.a(localc1);
    c localc5 = new c(new int[] { 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 });
    localc4.a(localc5);
    localc5.a(localc1);
    localc4 = new c(new int[] { 13, 14, 15, 16 });
    localc3.a(localc4);
    localc4.a(localc1);
    localc3 = new c(new int[] { 10, 11, 12 });
    localc2.a(localc3);
    localc2 = new c(new int[] { 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 });
    localc3.a(localc2);
    localc2.a(localc1);
    localc3 = new c(new int[] { 9, 10, 11, 12, 13, 14, 15, 16 });
    Kj.a(localc3);
    localc3.a(localc1);
    localc2 = new c(new int[] { 7, 8, 9, 10, 11, 12 });
    localc3.a(localc2);
    localc3 = new c(new int[] { 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 });
    localc2.a(localc3);
    localc3.a(localc1);
  }

  private void setMinute(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 60)
      i = 0;
    String str = String.format(Locale.getDefault(), "%02d", new Object[] { Integer.valueOf(i) });
    Utils.tryAccessibilityAnnounce(JZ, str);
    JV.setText(str);
    JW.setText(str);
  }

  private void updateDisplay(boolean paramBoolean)
  {
    if ((!paramBoolean) && (Ki.isEmpty()))
    {
      int i = JZ.getHours();
      int j = JZ.getMinutes();
      f(i, true);
      setMinute(j);
      if (!mIs24HourMode)
        if (i >= 12)
          break label84;
      label84: for (i = 0; ; i = 1)
      {
        bU(i);
        a(JZ.getCurrentItemShowing(), true, true, true);
        JS.setEnabled(true);
        return;
      }
    }
    Object localObject = new Boolean[2];
    localObject[0] = Boolean.valueOf(false);
    localObject[1] = Boolean.valueOf(false);
    int[] arrayOfInt = a((Boolean[])localObject);
    String str;
    if (localObject[0].booleanValue())
    {
      str = "%02d";
      label134: if (!localObject[1].booleanValue())
        break label259;
      localObject = "%02d";
      label149: if (arrayOfInt[0] != -1)
        break label267;
      str = Kf;
      label163: if (arrayOfInt[1] != -1)
        break label300;
    }
    label259: label267: label300: for (localObject = Kf; ; localObject = String.format((String)localObject, new Object[] { Integer.valueOf(arrayOfInt[1]) }).replace(' ', Ke))
    {
      JT.setText(str);
      JU.setText(str);
      JT.setTextColor(mUnselectedColor);
      JV.setText((CharSequence)localObject);
      JW.setText((CharSequence)localObject);
      JV.setTextColor(mUnselectedColor);
      if (mIs24HourMode)
        break;
      bU(arrayOfInt[2]);
      return;
      str = "%2d";
      break label134;
      localObject = "%2d";
      break label149;
      str = String.format(str, new Object[] { Integer.valueOf(arrayOfInt[0]) }).replace(' ', Ke);
      break label163;
    }
  }

  public void a(a parama)
  {
    JR = parama;
  }

  public void b(a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    JR = parama;
    Kb = paramInt1;
    Kc = paramInt2;
    mIs24HourMode = paramBoolean;
    Kh = false;
    Kd = false;
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    if (JR != null)
      JR.bR();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((paramBundle != null) && (paramBundle.containsKey("hour_of_day")) && (paramBundle.containsKey("minute")) && (paramBundle.containsKey("is_24_hour_view")))
    {
      Kb = paramBundle.getInt("hour_of_day");
      Kc = paramBundle.getInt("minute");
      mIs24HourMode = paramBundle.getBoolean("is_24_hour_view");
      Kh = paramBundle.getBoolean("in_kb_mode");
      Kd = paramBundle.getBoolean("dark_theme");
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getDialog().getWindow().requestFeature(1);
    View localView = paramLayoutInflater.inflate(2130968765, null);
    paramLayoutInflater = new b(null);
    localView.findViewById(2131493385).setOnKeyListener(paramLayoutInflater);
    paramViewGroup = getResources();
    Km = paramViewGroup.getString(2131230818);
    Kn = paramViewGroup.getString(2131230820);
    Ko = paramViewGroup.getString(2131230819);
    Kp = paramViewGroup.getString(2131230821);
    label127: int j;
    label616: int i1;
    int i3;
    int k;
    int n;
    int m;
    if (Kd)
    {
      i = 2131296363;
      mSelectedColor = paramViewGroup.getColor(i);
      if (!Kd)
        break label902;
      i = 2131296346;
      mUnselectedColor = paramViewGroup.getColor(i);
      JT = ((TextView)localView.findViewById(2131493380));
      JT.setOnKeyListener(paramLayoutInflater);
      JU = ((TextView)localView.findViewById(2131493378));
      JW = ((TextView)localView.findViewById(2131493381));
      JV = ((TextView)localView.findViewById(2131493382));
      JV.setOnKeyListener(paramLayoutInflater);
      JX = ((TextView)localView.findViewById(2131493384));
      JX.setOnKeyListener(paramLayoutInflater);
      String[] arrayOfString = new DateFormatSymbols().getAmPmStrings();
      mAmText = arrayOfString[0];
      mPmText = arrayOfString[1];
      mHapticFeedbackController = new HapticFeedbackController(getActivity());
      JZ = ((RadialPickerLayout)localView.findViewById(2131493387));
      JZ.setOnValueSelectedListener(this);
      JZ.setOnKeyListener(paramLayoutInflater);
      JZ.initialize(getActivity(), mHapticFeedbackController, Kb, Kc, mIs24HourMode);
      j = 0;
      i = j;
      if (paramBundle != null)
      {
        i = j;
        if (paramBundle.containsKey("current_item_showing"))
          i = paramBundle.getInt("current_item_showing");
      }
      a(i, false, true, true);
      JZ.invalidate();
      JT.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          k.a(k.this, 0, true, false, true);
          tryVibrate();
        }
      });
      JV.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          k.a(k.this, 1, true, false, true);
          tryVibrate();
        }
      });
      JS = ((TextView)localView.findViewById(2131493389));
      JS.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if ((k.a(k.this)) && (k.b(k.this)))
            k.a(k.this, false);
          while (true)
          {
            if (k.c(k.this) != null)
              k.c(k.this).h(k.d(k.this).getHours(), k.d(k.this).getMinutes());
            dismiss();
            return;
            tryVibrate();
          }
        }
      });
      JS.setOnKeyListener(paramLayoutInflater);
      JY = localView.findViewById(2131493383);
      if (!mIs24HourMode)
        break label910;
      JX.setVisibility(8);
      paramLayoutInflater = new RelativeLayout.LayoutParams(-2, -2);
      paramLayoutInflater.addRule(13);
      ((TextView)localView.findViewById(2131493379)).setLayoutParams(paramLayoutInflater);
      Ka = true;
      f(Kb, true);
      setMinute(Kc);
      Kf = paramViewGroup.getString(2131230828);
      Kg = paramViewGroup.getString(2131230827);
      Ke = Kf.charAt(0);
      Kl = -1;
      Kk = -1;
      ml();
      if (!Kh)
        break label960;
      Ki = paramBundle.getIntegerArrayList("typed_times");
      bW(-1);
      JT.invalidate();
      i = paramViewGroup.getColor(2131296346);
      i1 = paramViewGroup.getColor(2131296347);
      i3 = paramViewGroup.getColor(2131296348);
      j = paramViewGroup.getColor(2131296352);
      paramLayoutInflater = paramViewGroup.getColorStateList(2131296481);
      k = paramViewGroup.getColor(2131296366);
      int i2 = paramViewGroup.getColor(2131296365);
      int i4 = paramViewGroup.getColor(2131296367);
      paramViewGroup = paramViewGroup.getColorStateList(2131296482);
      n = 2130837610;
      paramBundle = localView.findViewById(2131493386);
      if (!Kd)
        break label981;
      m = k;
      label720: paramBundle.setBackgroundColor(m);
      paramBundle = localView.findViewById(2131493376);
      if (!Kd)
        break label988;
      label742: paramBundle.setBackgroundColor(k);
      paramBundle = (TextView)localView.findViewById(2131493379);
      if (!Kd)
        break label995;
      k = i;
      label771: paramBundle.setTextColor(k);
      paramBundle = (TextView)localView.findViewById(2131493384);
      if (!Kd)
        break label1002;
      label796: paramBundle.setTextColor(i);
      paramBundle = localView.findViewById(2131493388);
      if (!Kd)
        break label1009;
      i = i4;
      label822: paramBundle.setBackgroundColor(i);
      paramBundle = JS;
      if (!Kd)
        break label1016;
      paramLayoutInflater = paramViewGroup;
      label842: paramBundle.setTextColor(paramLayoutInflater);
      paramLayoutInflater = JZ;
      if (!Kd)
        break label1019;
      i = i2;
      label863: paramLayoutInflater.setBackgroundColor(i);
      paramLayoutInflater = JS;
      if (!Kd)
        break label1026;
    }
    label1026: for (int i = n; ; i = 2130837609)
    {
      paramLayoutInflater.setBackgroundResource(i);
      return localView;
      i = 2131296354;
      break;
      label902: i = 2131296352;
      break label127;
      label910: JX.setVisibility(0);
      if (Kb < 12);
      for (i = 0; ; i = 1)
      {
        bU(i);
        JY.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            tryVibrate();
            int j = k.d(k.this).getIsCurrentlyAmOrPm();
            int i;
            if (j == 0)
              i = 1;
            while (true)
            {
              k.a(k.this, i);
              k.d(k.this).setAmOrPm(i);
              return;
              i = j;
              if (j == 1)
                i = 0;
            }
          }
        });
        break;
      }
      label960: if (Ki != null)
        break label616;
      Ki = new ArrayList();
      break label616;
      label981: m = i;
      break label720;
      label988: k = i;
      break label742;
      label995: k = j;
      break label771;
      label1002: i = j;
      break label796;
      label1009: i = i3;
      break label822;
      label1016: break label842;
      label1019: i = i1;
      break label863;
    }
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if (JR != null)
      JR.bR();
  }

  public void onPause()
  {
    super.onPause();
    mHapticFeedbackController.stop();
  }

  public void onResume()
  {
    super.onResume();
    mHapticFeedbackController.start();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (JZ != null)
    {
      paramBundle.putInt("hour_of_day", JZ.getHours());
      paramBundle.putInt("minute", JZ.getMinutes());
      paramBundle.putBoolean("is_24_hour_view", mIs24HourMode);
      paramBundle.putInt("current_item_showing", JZ.getCurrentItemShowing());
      paramBundle.putBoolean("in_kb_mode", Kh);
      if (Kh)
        paramBundle.putIntegerArrayList("typed_times", Ki);
      paramBundle.putBoolean("dark_theme", Kd);
    }
  }

  public void onValueSelected(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 0)
    {
      f(paramInt2, false);
      String str = String.format("%d", new Object[] { Integer.valueOf(paramInt2) });
      if ((Ka) && (paramBoolean))
      {
        a(1, true, true, false);
        str = str + ". " + Kp;
        Utils.tryAccessibilityAnnounce(JZ, str);
      }
    }
    do
    {
      return;
      JZ.setContentDescription(Km + ": " + paramInt2);
      break;
      if (paramInt1 == 1)
      {
        setMinute(paramInt2);
        JZ.setContentDescription(Ko + ": " + paramInt2);
        return;
      }
      if (paramInt1 == 2)
      {
        bU(paramInt2);
        return;
      }
    }
    while (paramInt1 != 3);
    if (!mj())
      Ki.clear();
    aE(true);
  }

  public void q(int paramInt1, int paramInt2)
  {
    Kb = paramInt1;
    Kc = paramInt2;
    Kh = false;
  }

  public void tryVibrate()
  {
    mHapticFeedbackController.tryVibrate();
  }

  public static abstract interface a
  {
    public abstract void bR();

    public abstract void h(int paramInt1, int paramInt2);
  }

  private class b
    implements View.OnKeyListener
  {
    private b()
    {
    }

    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      if (paramKeyEvent.getAction() == 1)
        return k.b(k.this, paramInt);
      return false;
    }
  }

  private class c
  {
    private int[] Kr;
    private ArrayList<c> Ks;

    public c(int[] arg2)
    {
      Object localObject;
      Kr = localObject;
      Ks = new ArrayList();
    }

    public void a(c paramc)
    {
      Ks.add(paramc);
    }

    public boolean ca(int paramInt)
    {
      int i = 0;
      while (i < Kr.length)
      {
        if (Kr[i] == paramInt)
          return true;
        i += 1;
      }
      return false;
    }

    public c cb(int paramInt)
    {
      if (Ks == null)
        return null;
      Iterator localIterator = Ks.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.ca(paramInt))
          return localc;
      }
      return null;
    }
  }
}