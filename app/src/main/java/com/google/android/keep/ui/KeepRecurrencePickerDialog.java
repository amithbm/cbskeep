package com.google.android.keep.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.Log;
import android.util.TimeFormatException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TableLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.android.calendarcommon2.EventRecurrence;
import com.android.recurrencepicker.RecurrencePickerDialog;
import com.google.android.keep.activities.KeepApplication;
import com.google.android.keep.util.e;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;

public class KeepRecurrencePickerDialog extends DialogFragment
  implements View.OnClickListener, AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener, i.a
{
  public static final String TAG = RecurrencePickerDialog.class.getSimpleName();
  private static final int[] mFreqModelToEventRecurrence = { 4, 5, 6, 7 };
  private DialogFragment JL;
  private RecurrenceModel JM = new RecurrenceModel();
  private a JN;
  private int JO = e.getFirstDayOfWeek();
  public b JP;
  private final int[] TIME_DAY_TO_CALENDAR_DAY = { 1, 2, 3, 4, 5, 6, 7 };
  private Button mDone;
  private EditText mEndCount;
  private String mEndCountLabel;
  private String mEndDateLabel;
  private TextView mEndDateTextView;
  private String mEndNeverStr;
  private Spinner mEndSpinner;
  private ArrayList<CharSequence> mEndSpinnerArray = new ArrayList(3);
  private Spinner mFreqSpinner;
  private boolean mHidePostEndCount;
  private EditText mInterval;
  private TextView mIntervalPostText;
  private TextView mIntervalPreText;
  private int mIntervalResId = -1;
  private boolean mIsWeeklyOnly = false;
  private LinearLayout mMainLayout;
  private LinearLayout mMonthGroup;
  private String mMonthRepeatByDayOfWeekStr;
  private String[][] mMonthRepeatByDayOfWeekStrs;
  private RadioGroup mMonthRepeatByRadioGroup;
  private int mNumDaysInMonth;
  private TextView mPostEndCount;
  private EventRecurrence mRecurrence = new EventRecurrence();
  private RadioButton mRepeatMonthlyByLastDayOfMonth;
  private RadioButton mRepeatMonthlyByNthDayOfMonth;
  private RadioButton mRepeatMonthlyByNthDayOfWeek;
  private Switch mRepeatSwitch;
  private TextView mRepeatText;
  private Resources mResources;
  private Time mTime = new Time();
  private View mView;
  private ToggleButton[] mWeekByDayButtons = new ToggleButton[7];
  private LinearLayout mWeekGroup;
  private LinearLayout mWeekGroup2;

  public static KeepRecurrencePickerDialog a(Bundle paramBundle, b paramb)
  {
    KeepRecurrencePickerDialog localKeepRecurrencePickerDialog = new KeepRecurrencePickerDialog();
    localKeepRecurrencePickerDialog.setArguments(paramBundle);
    localKeepRecurrencePickerDialog.a(paramb);
    return localKeepRecurrencePickerDialog;
  }

  private static void a(EventRecurrence paramEventRecurrence, RecurrenceModel paramRecurrenceModel)
  {
    switch (freq)
    {
    default:
      throw new IllegalStateException("freq=" + freq);
    case 4:
      paramRecurrenceModel.freq = 0;
    case 6:
    case 7:
    case 5:
    }
    while (true)
    {
      if (interval > 0)
        paramRecurrenceModel.interval = interval;
      paramRecurrenceModel.endCount = count;
      if (paramRecurrenceModel.endCount > 0)
        paramRecurrenceModel.end = 2;
      if (!TextUtils.isEmpty(until))
      {
        if (paramRecurrenceModel.endDate == null)
          paramRecurrenceModel.endDate = new Time();
        try
        {
          if (paramRecurrenceModel.endDate.parse(until))
            paramRecurrenceModel.endDate.switchTimezone(TimeZone.getDefault().getID());
          if ((paramRecurrenceModel.end == 2) && (paramRecurrenceModel.endDate != null))
          {
            throw new IllegalStateException("freq=" + freq);
            paramRecurrenceModel.freq = 2;
            continue;
            paramRecurrenceModel.freq = 3;
            continue;
            paramRecurrenceModel.freq = 1;
          }
        }
        catch (TimeFormatException localTimeFormatException)
        {
          while (true)
            paramRecurrenceModel.endDate = null;
          paramRecurrenceModel.end = 1;
        }
      }
    }
    Arrays.fill(paramRecurrenceModel.weeklyByDayOfWeek, false);
    if (bydayCount > 0)
    {
      int j = 0;
      int i = 0;
      while (i < bydayCount)
      {
        int m = EventRecurrence.day2TimeDay(byday[i]);
        paramRecurrenceModel.weeklyByDayOfWeek[m] = true;
        int k = j;
        if (paramRecurrenceModel.freq == 2)
        {
          k = j;
          if (isSupportedMonthlyByNthDayOfWeek(bydayNum[i]))
          {
            paramRecurrenceModel.monthlyByDayOfWeek = m;
            paramRecurrenceModel.monthlyByNthDayOfWeek = bydayNum[i];
            paramRecurrenceModel.monthlyRepeat = 1;
            k = j + 1;
          }
        }
        i += 1;
        j = k;
      }
      if (paramRecurrenceModel.freq == 2)
      {
        if (bydayCount != 1)
          throw new IllegalStateException("Can handle only 1 byDayOfWeek in monthly");
        if (j != 1)
          throw new IllegalStateException("Didn't specify which nth day of week to repeat for a monthly");
      }
    }
    if (paramRecurrenceModel.freq == 2)
    {
      if (bymonthdayCount != 1)
        break label447;
      if (paramRecurrenceModel.monthlyRepeat == 1)
        throw new IllegalStateException("Can handle only by monthday or by nth day of week, not both");
      paramRecurrenceModel.monthlyByMonthDay = bymonthday[0];
      paramRecurrenceModel.monthlyRepeat = 0;
    }
    label447: 
    while (bymonthCount <= 1)
      return;
    throw new IllegalStateException("Can handle only one bymonthday");
  }

  private static void a(RecurrenceModel paramRecurrenceModel, EventRecurrence paramEventRecurrence)
  {
    if (recurrenceState == 0)
      throw new IllegalStateException("There's no recurrence");
    paramEventRecurrence.freq = mFreqModelToEventRecurrence[freq];
    if (interval <= 1)
    {
      paramEventRecurrence.interval = 0;
      switch (end)
      {
      default:
        paramEventRecurrence.count = 0;
        paramEventRecurrence.until = null;
        label78: paramEventRecurrence.bydayCount = 0;
        paramEventRecurrence.bymonthdayCount = 0;
        switch (freq)
        {
        default:
        case 2:
        case 1:
        }
        break;
      case 1:
      case 2:
      }
    }
    while (true)
    {
      if (canHandleRecurrenceRule(paramEventRecurrence))
        return;
      throw new IllegalStateException("UI generated recurrence that it can't handle. ER:" + paramEventRecurrence.toString() + " Model: " + paramRecurrenceModel.toString());
      paramEventRecurrence.interval = interval;
      break;
      Object localObject;
      if (endDate != null)
      {
        endDate.switchTimezone("UTC");
        if (endDate.allDay)
        {
          localObject = endDate;
          Time localTime = endDate;
          endDate.second = 0;
          localTime.minute = 0;
          ((Time)localObject).hour = 0;
        }
        endDate.normalize(false);
        paramEventRecurrence.until = endDate.format2445();
        paramEventRecurrence.count = 0;
        break label78;
      }
      throw new IllegalStateException("end = END_BY_DATE but endDate is null");
      paramEventRecurrence.count = endCount;
      paramEventRecurrence.until = null;
      if (paramEventRecurrence.count > 0)
        break label78;
      throw new IllegalStateException("count is " + paramEventRecurrence.count);
      if (monthlyRepeat == 0)
      {
        if ((monthlyByMonthDay > 0) || (monthlyByMonthDay == -1))
        {
          if ((paramEventRecurrence.bymonthday == null) || (paramEventRecurrence.bymonthdayCount < 1))
            paramEventRecurrence.bymonthday = new int[1];
          paramEventRecurrence.bymonthday[0] = monthlyByMonthDay;
          paramEventRecurrence.bymonthdayCount = 1;
        }
      }
      else if (monthlyRepeat == 1)
      {
        if (!isSupportedMonthlyByNthDayOfWeek(monthlyByNthDayOfWeek))
          throw new IllegalStateException("month repeat by nth week but n is " + monthlyByNthDayOfWeek);
        if ((paramEventRecurrence.bydayCount < 1) || (paramEventRecurrence.byday == null) || (paramEventRecurrence.bydayNum == null))
        {
          paramEventRecurrence.byday = new int[1];
          paramEventRecurrence.bydayNum = new int[1];
        }
        paramEventRecurrence.bydayCount = 1;
        paramEventRecurrence.byday[0] = EventRecurrence.timeDay2Day(monthlyByDayOfWeek);
        paramEventRecurrence.bydayNum[0] = monthlyByNthDayOfWeek;
        continue;
        int i = 0;
        int j = 0;
        int k;
        while (j < 7)
        {
          k = i;
          if (weeklyByDayOfWeek[j] != 0)
            k = i + 1;
          j += 1;
          i = k;
        }
        if ((paramEventRecurrence.bydayCount < i) || (paramEventRecurrence.byday == null) || (paramEventRecurrence.bydayNum == null))
        {
          paramEventRecurrence.byday = new int[i];
          paramEventRecurrence.bydayNum = new int[i];
        }
        paramEventRecurrence.bydayCount = i;
        j = 6;
        while (j >= 0)
        {
          k = i;
          if (weeklyByDayOfWeek[j] != 0)
          {
            localObject = paramEventRecurrence.bydayNum;
            k = i - 1;
            localObject[k] = 0;
            paramEventRecurrence.byday[k] = EventRecurrence.timeDay2Day(j);
          }
          j -= 1;
          i = k;
        }
      }
    }
  }

  public static boolean canHandleRecurrenceRule(EventRecurrence paramEventRecurrence)
  {
    switch (freq)
    {
    default:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    int j;
    do
    {
      do
        return false;
      while ((count > 0) && (!TextUtils.isEmpty(until)));
      j = 0;
      int i = 0;
      while (i < bydayCount)
      {
        int k = j;
        if (isSupportedMonthlyByNthDayOfWeek(bydayNum[i]))
          k = j + 1;
        i += 1;
        j = k;
      }
    }
    while ((j > 1) || ((j > 0) && (freq != 6)) || (bymonthdayCount > 1) || ((freq == 6) && ((bydayCount > 1) || ((bydayCount > 0) && (bymonthdayCount > 0)))));
    return true;
  }

  private DialogFragment e(int paramInt1, int paramInt2, int paramInt3)
  {
    if (KeepApplication.aq())
      return s.c(this, paramInt1, paramInt2, paramInt3);
    i locali = i.a(this, paramInt1, paramInt2, paramInt3);
    Calendar localCalendar = Calendar.getInstance();
    locali.setMinDate(localCalendar);
    locali.setYearRange(localCalendar.get(1), 2036);
    return locali;
  }

  private void initMonthlyOnWeekDay()
  {
    JM.monthlyByNthDayOfWeek = ((mTime.monthDay + 6) / 7);
    if (mTime.monthDay + 7 > mNumDaysInMonth)
      JM.monthlyByNthDayOfWeek = -1;
    JM.monthlyByDayOfWeek = mTime.weekDay;
  }

  private void initUi(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: invokevirtual 416	com/google/android/keep/ui/KeepRecurrencePickerDialog:getResources	()Landroid/content/res/Resources;
    //   5: putfield 418	com/google/android/keep/ui/KeepRecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   8: aload_0
    //   9: aload_1
    //   10: ldc_w 419
    //   13: aload_2
    //   14: iconst_1
    //   15: invokevirtual 425	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   18: putfield 427	com/google/android/keep/ui/KeepRecurrencePickerDialog:mView	Landroid/view/View;
    //   21: aload_0
    //   22: invokespecial 430	com/google/android/keep/ui/KeepRecurrencePickerDialog:initializeViews	()V
    //   25: aload_0
    //   26: getfield 148	com/google/android/keep/ui/KeepRecurrencePickerDialog:mIsWeeklyOnly	Z
    //   29: ifeq +7 -> 36
    //   32: aload_0
    //   33: invokespecial 433	com/google/android/keep/ui/KeepRecurrencePickerDialog:showWeeklyOnlyUi	()V
    //   36: aload_0
    //   37: getfield 435	com/google/android/keep/ui/KeepRecurrencePickerDialog:mRepeatSwitch	Landroid/widget/Switch;
    //   40: astore_1
    //   41: aload_0
    //   42: getfield 131	com/google/android/keep/ui/KeepRecurrencePickerDialog:JM	Lcom/google/android/keep/ui/KeepRecurrencePickerDialog$RecurrenceModel;
    //   45: getfield 293	com/google/android/keep/ui/KeepRecurrencePickerDialog$RecurrenceModel:recurrenceState	I
    //   48: iconst_1
    //   49: if_icmpne +557 -> 606
    //   52: iconst_1
    //   53: istore 8
    //   55: aload_1
    //   56: iload 8
    //   58: invokevirtual 441	android/widget/Switch:setChecked	(Z)V
    //   61: aload_0
    //   62: getfield 435	com/google/android/keep/ui/KeepRecurrencePickerDialog:mRepeatSwitch	Landroid/widget/Switch;
    //   65: new 16	com/google/android/keep/ui/KeepRecurrencePickerDialog$1
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 443	com/google/android/keep/ui/KeepRecurrencePickerDialog$1:<init>	(Lcom/google/android/keep/ui/KeepRecurrencePickerDialog;)V
    //   73: invokevirtual 447	android/widget/Switch:setOnCheckedChangeListener	(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    //   76: aload_0
    //   77: getfield 449	com/google/android/keep/ui/KeepRecurrencePickerDialog:mFreqSpinner	Landroid/widget/Spinner;
    //   80: aload_0
    //   81: invokevirtual 455	android/widget/Spinner:setOnItemSelectedListener	(Landroid/widget/AdapterView$OnItemSelectedListener;)V
    //   84: aload_0
    //   85: invokevirtual 459	com/google/android/keep/ui/KeepRecurrencePickerDialog:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   88: ldc_w 460
    //   91: ldc_w 461
    //   94: invokestatic 467	android/widget/ArrayAdapter:createFromResource	(Landroid/content/Context;II)Landroid/widget/ArrayAdapter;
    //   97: astore_1
    //   98: aload_1
    //   99: ldc_w 461
    //   102: invokevirtual 470	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   105: aload_0
    //   106: getfield 449	com/google/android/keep/ui/KeepRecurrencePickerDialog:mFreqSpinner	Landroid/widget/Spinner;
    //   109: aload_1
    //   110: invokevirtual 474	android/widget/Spinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   113: aload_0
    //   114: getfield 386	com/google/android/keep/ui/KeepRecurrencePickerDialog:mInterval	Landroid/widget/EditText;
    //   117: new 18	com/google/android/keep/ui/KeepRecurrencePickerDialog$2
    //   120: dup
    //   121: aload_0
    //   122: iconst_1
    //   123: iconst_1
    //   124: bipush 99
    //   126: invokespecial 477	com/google/android/keep/ui/KeepRecurrencePickerDialog$2:<init>	(Lcom/google/android/keep/ui/KeepRecurrencePickerDialog;III)V
    //   129: invokevirtual 483	android/widget/EditText:addTextChangedListener	(Landroid/text/TextWatcher;)V
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 418	com/google/android/keep/ui/KeepRecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   137: ldc_w 484
    //   140: invokevirtual 490	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   143: putfield 492	com/google/android/keep/ui/KeepRecurrencePickerDialog:mEndNeverStr	Ljava/lang/String;
    //   146: aload_0
    //   147: aload_0
    //   148: getfield 418	com/google/android/keep/ui/KeepRecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   151: ldc_w 493
    //   154: invokevirtual 490	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   157: putfield 495	com/google/android/keep/ui/KeepRecurrencePickerDialog:mEndDateLabel	Ljava/lang/String;
    //   160: aload_0
    //   161: aload_0
    //   162: getfield 418	com/google/android/keep/ui/KeepRecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   165: ldc_w 496
    //   168: invokevirtual 490	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   171: putfield 498	com/google/android/keep/ui/KeepRecurrencePickerDialog:mEndCountLabel	Ljava/lang/String;
    //   174: aload_0
    //   175: getfield 142	com/google/android/keep/ui/KeepRecurrencePickerDialog:mEndSpinnerArray	Ljava/util/ArrayList;
    //   178: aload_0
    //   179: getfield 492	com/google/android/keep/ui/KeepRecurrencePickerDialog:mEndNeverStr	Ljava/lang/String;
    //   182: invokevirtual 502	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   185: pop
    //   186: aload_0
    //   187: getfield 142	com/google/android/keep/ui/KeepRecurrencePickerDialog:mEndSpinnerArray	Ljava/util/ArrayList;
    //   190: aload_0
    //   191: getfield 495	com/google/android/keep/ui/KeepRecurrencePickerDialog:mEndDateLabel	Ljava/lang/String;
    //   194: invokevirtual 502	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   197: pop
    //   198: aload_0
    //   199: getfield 142	com/google/android/keep/ui/KeepRecurrencePickerDialog:mEndSpinnerArray	Ljava/util/ArrayList;
    //   202: aload_0
    //   203: getfield 498	com/google/android/keep/ui/KeepRecurrencePickerDialog:mEndCountLabel	Ljava/lang/String;
    //   206: invokevirtual 502	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   209: pop
    //   210: aload_0
    //   211: getfield 401	com/google/android/keep/ui/KeepRecurrencePickerDialog:mEndSpinner	Landroid/widget/Spinner;
    //   214: aload_0
    //   215: invokevirtual 455	android/widget/Spinner:setOnItemSelectedListener	(Landroid/widget/AdapterView$OnItemSelectedListener;)V
    //   218: aload_0
    //   219: new 27	com/google/android/keep/ui/KeepRecurrencePickerDialog$a
    //   222: dup
    //   223: aload_0
    //   224: aload_0
    //   225: invokevirtual 459	com/google/android/keep/ui/KeepRecurrencePickerDialog:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   228: aload_0
    //   229: getfield 142	com/google/android/keep/ui/KeepRecurrencePickerDialog:mEndSpinnerArray	Ljava/util/ArrayList;
    //   232: ldc_w 461
    //   235: ldc_w 503
    //   238: invokespecial 506	com/google/android/keep/ui/KeepRecurrencePickerDialog$a:<init>	(Lcom/google/android/keep/ui/KeepRecurrencePickerDialog;Landroid/content/Context;Ljava/util/ArrayList;II)V
    //   241: putfield 508	com/google/android/keep/ui/KeepRecurrencePickerDialog:JN	Lcom/google/android/keep/ui/KeepRecurrencePickerDialog$a;
    //   244: aload_0
    //   245: getfield 508	com/google/android/keep/ui/KeepRecurrencePickerDialog:JN	Lcom/google/android/keep/ui/KeepRecurrencePickerDialog$a;
    //   248: ldc_w 461
    //   251: invokevirtual 509	com/google/android/keep/ui/KeepRecurrencePickerDialog$a:setDropDownViewResource	(I)V
    //   254: aload_0
    //   255: getfield 401	com/google/android/keep/ui/KeepRecurrencePickerDialog:mEndSpinner	Landroid/widget/Spinner;
    //   258: aload_0
    //   259: getfield 508	com/google/android/keep/ui/KeepRecurrencePickerDialog:JN	Lcom/google/android/keep/ui/KeepRecurrencePickerDialog$a;
    //   262: invokevirtual 474	android/widget/Spinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   265: aload_0
    //   266: getfield 397	com/google/android/keep/ui/KeepRecurrencePickerDialog:mEndCount	Landroid/widget/EditText;
    //   269: new 20	com/google/android/keep/ui/KeepRecurrencePickerDialog$3
    //   272: dup
    //   273: aload_0
    //   274: iconst_1
    //   275: iconst_5
    //   276: sipush 730
    //   279: invokespecial 510	com/google/android/keep/ui/KeepRecurrencePickerDialog$3:<init>	(Lcom/google/android/keep/ui/KeepRecurrencePickerDialog;III)V
    //   282: invokevirtual 483	android/widget/EditText:addTextChangedListener	(Landroid/text/TextWatcher;)V
    //   285: aload_0
    //   286: getfield 512	com/google/android/keep/ui/KeepRecurrencePickerDialog:mEndDateTextView	Landroid/widget/TextView;
    //   289: aload_0
    //   290: invokevirtual 518	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   293: aload_0
    //   294: getfield 131	com/google/android/keep/ui/KeepRecurrencePickerDialog:JM	Lcom/google/android/keep/ui/KeepRecurrencePickerDialog$RecurrenceModel;
    //   297: getfield 217	com/google/android/keep/ui/KeepRecurrencePickerDialog$RecurrenceModel:endDate	Landroid/text/format/Time;
    //   300: ifnonnull +72 -> 372
    //   303: aload_0
    //   304: getfield 131	com/google/android/keep/ui/KeepRecurrencePickerDialog:JM	Lcom/google/android/keep/ui/KeepRecurrencePickerDialog$RecurrenceModel;
    //   307: new 125	android/text/format/Time
    //   310: dup
    //   311: aload_0
    //   312: getfield 128	com/google/android/keep/ui/KeepRecurrencePickerDialog:mTime	Landroid/text/format/Time;
    //   315: invokespecial 521	android/text/format/Time:<init>	(Landroid/text/format/Time;)V
    //   318: putfield 217	com/google/android/keep/ui/KeepRecurrencePickerDialog$RecurrenceModel:endDate	Landroid/text/format/Time;
    //   321: aload_0
    //   322: getfield 131	com/google/android/keep/ui/KeepRecurrencePickerDialog:JM	Lcom/google/android/keep/ui/KeepRecurrencePickerDialog$RecurrenceModel;
    //   325: getfield 192	com/google/android/keep/ui/KeepRecurrencePickerDialog$RecurrenceModel:freq	I
    //   328: tableswitch	default:+32 -> 360, 0:+284->612, 1:+284->612, 2:+305->633, 3:+326->654
    //   361: getfield 131	com/google/android/keep/ui/KeepRecurrencePickerDialog:JM	Lcom/google/android/keep/ui/KeepRecurrencePickerDialog$RecurrenceModel;
    //   364: getfield 217	com/google/android/keep/ui/KeepRecurrencePickerDialog$RecurrenceModel:endDate	Landroid/text/format/Time;
    //   367: iconst_0
    //   368: invokevirtual 323	android/text/format/Time:normalize	(Z)J
    //   371: pop2
    //   372: new 523	java/text/DateFormatSymbols
    //   375: dup
    //   376: invokespecial 524	java/text/DateFormatSymbols:<init>	()V
    //   379: invokevirtual 528	java/text/DateFormatSymbols:getWeekdays	()[Ljava/lang/String;
    //   382: pop
    //   383: aload_0
    //   384: bipush 7
    //   386: anewarray 530	[Ljava/lang/String;
    //   389: putfield 532	com/google/android/keep/ui/KeepRecurrencePickerDialog:mMonthRepeatByDayOfWeekStrs	[[Ljava/lang/String;
    //   392: aload_0
    //   393: getfield 532	com/google/android/keep/ui/KeepRecurrencePickerDialog:mMonthRepeatByDayOfWeekStrs	[[Ljava/lang/String;
    //   396: iconst_0
    //   397: aload_0
    //   398: getfield 418	com/google/android/keep/ui/KeepRecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   401: ldc_w 533
    //   404: invokevirtual 537	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   407: aastore
    //   408: aload_0
    //   409: getfield 532	com/google/android/keep/ui/KeepRecurrencePickerDialog:mMonthRepeatByDayOfWeekStrs	[[Ljava/lang/String;
    //   412: iconst_1
    //   413: aload_0
    //   414: getfield 418	com/google/android/keep/ui/KeepRecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   417: ldc_w 538
    //   420: invokevirtual 537	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   423: aastore
    //   424: aload_0
    //   425: getfield 532	com/google/android/keep/ui/KeepRecurrencePickerDialog:mMonthRepeatByDayOfWeekStrs	[[Ljava/lang/String;
    //   428: iconst_2
    //   429: aload_0
    //   430: getfield 418	com/google/android/keep/ui/KeepRecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   433: ldc_w 539
    //   436: invokevirtual 537	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   439: aastore
    //   440: aload_0
    //   441: getfield 532	com/google/android/keep/ui/KeepRecurrencePickerDialog:mMonthRepeatByDayOfWeekStrs	[[Ljava/lang/String;
    //   444: iconst_3
    //   445: aload_0
    //   446: getfield 418	com/google/android/keep/ui/KeepRecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   449: ldc_w 540
    //   452: invokevirtual 537	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   455: aastore
    //   456: aload_0
    //   457: getfield 532	com/google/android/keep/ui/KeepRecurrencePickerDialog:mMonthRepeatByDayOfWeekStrs	[[Ljava/lang/String;
    //   460: iconst_4
    //   461: aload_0
    //   462: getfield 418	com/google/android/keep/ui/KeepRecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   465: ldc_w 541
    //   468: invokevirtual 537	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   471: aastore
    //   472: aload_0
    //   473: getfield 532	com/google/android/keep/ui/KeepRecurrencePickerDialog:mMonthRepeatByDayOfWeekStrs	[[Ljava/lang/String;
    //   476: iconst_5
    //   477: aload_0
    //   478: getfield 418	com/google/android/keep/ui/KeepRecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   481: ldc_w 542
    //   484: invokevirtual 537	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   487: aastore
    //   488: aload_0
    //   489: getfield 532	com/google/android/keep/ui/KeepRecurrencePickerDialog:mMonthRepeatByDayOfWeekStrs	[[Ljava/lang/String;
    //   492: bipush 6
    //   494: aload_0
    //   495: getfield 418	com/google/android/keep/ui/KeepRecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   498: ldc_w 543
    //   501: invokevirtual 537	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   504: aastore
    //   505: aload_0
    //   506: getfield 156	com/google/android/keep/ui/KeepRecurrencePickerDialog:JO	I
    //   509: istore_3
    //   510: new 523	java/text/DateFormatSymbols
    //   513: dup
    //   514: invokespecial 524	java/text/DateFormatSymbols:<init>	()V
    //   517: invokevirtual 546	java/text/DateFormatSymbols:getShortWeekdays	()[Ljava/lang/String;
    //   520: astore_1
    //   521: aload_0
    //   522: getfield 418	com/google/android/keep/ui/KeepRecurrencePickerDialog:mResources	Landroid/content/res/Resources;
    //   525: invokevirtual 550	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   528: getfield 555	android/content/res/Configuration:screenWidthDp	I
    //   531: sipush 450
    //   534: if_icmple +141 -> 675
    //   537: bipush 7
    //   539: istore 5
    //   541: iconst_0
    //   542: istore 4
    //   544: aload_0
    //   545: getfield 557	com/google/android/keep/ui/KeepRecurrencePickerDialog:mWeekGroup2	Landroid/widget/LinearLayout;
    //   548: bipush 8
    //   550: invokevirtual 562	android/widget/LinearLayout:setVisibility	(I)V
    //   553: aload_0
    //   554: getfield 557	com/google/android/keep/ui/KeepRecurrencePickerDialog:mWeekGroup2	Landroid/widget/LinearLayout;
    //   557: iconst_3
    //   558: invokevirtual 566	android/widget/LinearLayout:getChildAt	(I)Landroid/view/View;
    //   561: bipush 8
    //   563: invokevirtual 569	android/view/View:setVisibility	(I)V
    //   566: iconst_0
    //   567: istore 6
    //   569: iload 6
    //   571: bipush 7
    //   573: if_icmpge +213 -> 786
    //   576: iload 6
    //   578: iload 5
    //   580: if_icmplt +124 -> 704
    //   583: aload_0
    //   584: getfield 571	com/google/android/keep/ui/KeepRecurrencePickerDialog:mWeekGroup	Landroid/widget/LinearLayout;
    //   587: iload 6
    //   589: invokevirtual 566	android/widget/LinearLayout:getChildAt	(I)Landroid/view/View;
    //   592: bipush 8
    //   594: invokevirtual 569	android/view/View:setVisibility	(I)V
    //   597: iload 6
    //   599: iconst_1
    //   600: iadd
    //   601: istore 6
    //   603: goto -34 -> 569
    //   606: iconst_0
    //   607: istore 8
    //   609: goto -554 -> 55
    //   612: aload_0
    //   613: getfield 131	com/google/android/keep/ui/KeepRecurrencePickerDialog:JM	Lcom/google/android/keep/ui/KeepRecurrencePickerDialog$RecurrenceModel;
    //   616: getfield 217	com/google/android/keep/ui/KeepRecurrencePickerDialog$RecurrenceModel:endDate	Landroid/text/format/Time;
    //   619: astore_1
    //   620: aload_1
    //   621: aload_1
    //   622: getfield 574	android/text/format/Time:month	I
    //   625: iconst_1
    //   626: iadd
    //   627: putfield 574	android/text/format/Time:month	I
    //   630: goto -270 -> 360
    //   633: aload_0
    //   634: getfield 131	com/google/android/keep/ui/KeepRecurrencePickerDialog:JM	Lcom/google/android/keep/ui/KeepRecurrencePickerDialog$RecurrenceModel;
    //   637: getfield 217	com/google/android/keep/ui/KeepRecurrencePickerDialog$RecurrenceModel:endDate	Landroid/text/format/Time;
    //   640: astore_1
    //   641: aload_1
    //   642: aload_1
    //   643: getfield 574	android/text/format/Time:month	I
    //   646: iconst_3
    //   647: iadd
    //   648: putfield 574	android/text/format/Time:month	I
    //   651: goto -291 -> 360
    //   654: aload_0
    //   655: getfield 131	com/google/android/keep/ui/KeepRecurrencePickerDialog:JM	Lcom/google/android/keep/ui/KeepRecurrencePickerDialog$RecurrenceModel;
    //   658: getfield 217	com/google/android/keep/ui/KeepRecurrencePickerDialog$RecurrenceModel:endDate	Landroid/text/format/Time;
    //   661: astore_1
    //   662: aload_1
    //   663: aload_1
    //   664: getfield 577	android/text/format/Time:year	I
    //   667: iconst_3
    //   668: iadd
    //   669: putfield 577	android/text/format/Time:year	I
    //   672: goto -312 -> 360
    //   675: iconst_4
    //   676: istore 5
    //   678: iconst_3
    //   679: istore 4
    //   681: aload_0
    //   682: getfield 557	com/google/android/keep/ui/KeepRecurrencePickerDialog:mWeekGroup2	Landroid/widget/LinearLayout;
    //   685: iconst_0
    //   686: invokevirtual 562	android/widget/LinearLayout:setVisibility	(I)V
    //   689: aload_0
    //   690: getfield 557	com/google/android/keep/ui/KeepRecurrencePickerDialog:mWeekGroup2	Landroid/widget/LinearLayout;
    //   693: iconst_3
    //   694: invokevirtual 566	android/widget/LinearLayout:getChildAt	(I)Landroid/view/View;
    //   697: iconst_4
    //   698: invokevirtual 569	android/view/View:setVisibility	(I)V
    //   701: goto -135 -> 566
    //   704: aload_0
    //   705: getfield 146	com/google/android/keep/ui/KeepRecurrencePickerDialog:mWeekByDayButtons	[Landroid/widget/ToggleButton;
    //   708: iload_3
    //   709: aload_0
    //   710: getfield 571	com/google/android/keep/ui/KeepRecurrencePickerDialog:mWeekGroup	Landroid/widget/LinearLayout;
    //   713: iload 6
    //   715: invokevirtual 566	android/widget/LinearLayout:getChildAt	(I)Landroid/view/View;
    //   718: checkcast 144	android/widget/ToggleButton
    //   721: aastore
    //   722: aload_0
    //   723: getfield 146	com/google/android/keep/ui/KeepRecurrencePickerDialog:mWeekByDayButtons	[Landroid/widget/ToggleButton;
    //   726: iload_3
    //   727: aaload
    //   728: aload_1
    //   729: aload_0
    //   730: getfield 133	com/google/android/keep/ui/KeepRecurrencePickerDialog:TIME_DAY_TO_CALENDAR_DAY	[I
    //   733: iload_3
    //   734: iaload
    //   735: aaload
    //   736: invokevirtual 581	android/widget/ToggleButton:setTextOff	(Ljava/lang/CharSequence;)V
    //   739: aload_0
    //   740: getfield 146	com/google/android/keep/ui/KeepRecurrencePickerDialog:mWeekByDayButtons	[Landroid/widget/ToggleButton;
    //   743: iload_3
    //   744: aaload
    //   745: aload_1
    //   746: aload_0
    //   747: getfield 133	com/google/android/keep/ui/KeepRecurrencePickerDialog:TIME_DAY_TO_CALENDAR_DAY	[I
    //   750: iload_3
    //   751: iaload
    //   752: aaload
    //   753: invokevirtual 584	android/widget/ToggleButton:setTextOn	(Ljava/lang/CharSequence;)V
    //   756: aload_0
    //   757: getfield 146	com/google/android/keep/ui/KeepRecurrencePickerDialog:mWeekByDayButtons	[Landroid/widget/ToggleButton;
    //   760: iload_3
    //   761: aaload
    //   762: aload_0
    //   763: invokevirtual 585	android/widget/ToggleButton:setOnCheckedChangeListener	(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    //   766: iload_3
    //   767: iconst_1
    //   768: iadd
    //   769: istore 7
    //   771: iload 7
    //   773: istore_3
    //   774: iload 7
    //   776: bipush 7
    //   778: if_icmplt -181 -> 597
    //   781: iconst_0
    //   782: istore_3
    //   783: goto -186 -> 597
    //   786: iconst_0
    //   787: istore 5
    //   789: iload 5
    //   791: iconst_3
    //   792: if_icmpge +115 -> 907
    //   795: iload 5
    //   797: iload 4
    //   799: if_icmplt +26 -> 825
    //   802: aload_0
    //   803: getfield 557	com/google/android/keep/ui/KeepRecurrencePickerDialog:mWeekGroup2	Landroid/widget/LinearLayout;
    //   806: iload 5
    //   808: invokevirtual 566	android/widget/LinearLayout:getChildAt	(I)Landroid/view/View;
    //   811: bipush 8
    //   813: invokevirtual 569	android/view/View:setVisibility	(I)V
    //   816: iload 5
    //   818: iconst_1
    //   819: iadd
    //   820: istore 5
    //   822: goto -33 -> 789
    //   825: aload_0
    //   826: getfield 146	com/google/android/keep/ui/KeepRecurrencePickerDialog:mWeekByDayButtons	[Landroid/widget/ToggleButton;
    //   829: iload_3
    //   830: aload_0
    //   831: getfield 557	com/google/android/keep/ui/KeepRecurrencePickerDialog:mWeekGroup2	Landroid/widget/LinearLayout;
    //   834: iload 5
    //   836: invokevirtual 566	android/widget/LinearLayout:getChildAt	(I)Landroid/view/View;
    //   839: checkcast 144	android/widget/ToggleButton
    //   842: aastore
    //   843: aload_0
    //   844: getfield 146	com/google/android/keep/ui/KeepRecurrencePickerDialog:mWeekByDayButtons	[Landroid/widget/ToggleButton;
    //   847: iload_3
    //   848: aaload
    //   849: aload_1
    //   850: aload_0
    //   851: getfield 133	com/google/android/keep/ui/KeepRecurrencePickerDialog:TIME_DAY_TO_CALENDAR_DAY	[I
    //   854: iload_3
    //   855: iaload
    //   856: aaload
    //   857: invokevirtual 581	android/widget/ToggleButton:setTextOff	(Ljava/lang/CharSequence;)V
    //   860: aload_0
    //   861: getfield 146	com/google/android/keep/ui/KeepRecurrencePickerDialog:mWeekByDayButtons	[Landroid/widget/ToggleButton;
    //   864: iload_3
    //   865: aaload
    //   866: aload_1
    //   867: aload_0
    //   868: getfield 133	com/google/android/keep/ui/KeepRecurrencePickerDialog:TIME_DAY_TO_CALENDAR_DAY	[I
    //   871: iload_3
    //   872: iaload
    //   873: aaload
    //   874: invokevirtual 584	android/widget/ToggleButton:setTextOn	(Ljava/lang/CharSequence;)V
    //   877: aload_0
    //   878: getfield 146	com/google/android/keep/ui/KeepRecurrencePickerDialog:mWeekByDayButtons	[Landroid/widget/ToggleButton;
    //   881: iload_3
    //   882: aaload
    //   883: aload_0
    //   884: invokevirtual 585	android/widget/ToggleButton:setOnCheckedChangeListener	(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    //   887: iload_3
    //   888: iconst_1
    //   889: iadd
    //   890: istore 6
    //   892: iload 6
    //   894: istore_3
    //   895: iload 6
    //   897: bipush 7
    //   899: if_icmplt -83 -> 816
    //   902: iconst_0
    //   903: istore_3
    //   904: goto -88 -> 816
    //   907: aload_0
    //   908: getfield 587	com/google/android/keep/ui/KeepRecurrencePickerDialog:mMonthRepeatByRadioGroup	Landroid/widget/RadioGroup;
    //   911: aload_0
    //   912: invokevirtual 592	android/widget/RadioGroup:setOnCheckedChangeListener	(Landroid/widget/RadioGroup$OnCheckedChangeListener;)V
    //   915: aload_0
    //   916: getfield 128	com/google/android/keep/ui/KeepRecurrencePickerDialog:mTime	Landroid/text/format/Time;
    //   919: getfield 405	android/text/format/Time:monthDay	I
    //   922: aload_0
    //   923: getfield 407	com/google/android/keep/ui/KeepRecurrencePickerDialog:mNumDaysInMonth	I
    //   926: if_icmpeq +12 -> 938
    //   929: aload_0
    //   930: getfield 594	com/google/android/keep/ui/KeepRecurrencePickerDialog:mRepeatMonthlyByLastDayOfMonth	Landroid/widget/RadioButton;
    //   933: bipush 8
    //   935: invokevirtual 597	android/widget/RadioButton:setVisibility	(I)V
    //   938: aload_0
    //   939: getfield 599	com/google/android/keep/ui/KeepRecurrencePickerDialog:mDone	Landroid/widget/Button;
    //   942: aload_0
    //   943: invokevirtual 602	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   946: aload_0
    //   947: invokespecial 346	com/google/android/keep/ui/KeepRecurrencePickerDialog:togglePickerOptions	()V
    //   950: aload_0
    //   951: invokevirtual 605	com/google/android/keep/ui/KeepRecurrencePickerDialog:updateDialog	()V
    //   954: return
  }

  private void initializeViews()
  {
    mMainLayout = ((LinearLayout)mView.findViewById(2131493302));
    mRepeatText = ((TextView)mView.findViewById(2131493304));
    mRepeatSwitch = ((Switch)mView.findViewById(2131493305));
    mFreqSpinner = ((Spinner)mView.findViewById(2131493303));
    mInterval = ((EditText)mView.findViewById(2131493309));
    mIntervalPreText = ((TextView)mView.findViewById(2131493308));
    mIntervalPostText = ((TextView)mView.findViewById(2131493310));
    mEndSpinner = ((Spinner)mView.findViewById(2131493318));
    mEndCount = ((EditText)mView.findViewById(2131493319));
    mPostEndCount = ((TextView)mView.findViewById(2131493320));
    mEndDateTextView = ((TextView)mView.findViewById(2131493321));
    mWeekGroup = ((LinearLayout)mView.findViewById(2131493311));
    mWeekGroup2 = ((LinearLayout)mView.findViewById(2131493312));
    mMonthGroup = ((LinearLayout)mView.findViewById(2131493313));
    mMonthRepeatByRadioGroup = ((RadioGroup)mView.findViewById(2131493313));
    mRepeatMonthlyByNthDayOfWeek = ((RadioButton)mView.findViewById(2131493315));
    mRepeatMonthlyByNthDayOfMonth = ((RadioButton)mView.findViewById(2131493314));
    mRepeatMonthlyByLastDayOfMonth = ((RadioButton)mView.findViewById(2131493316));
    mDone = ((Button)mView.findViewById(2131493137));
  }

  public static boolean isSupportedMonthlyByNthDayOfWeek(int paramInt)
  {
    return ((paramInt > 0) && (paramInt <= 5)) || (paramInt == -1);
  }

  private void showWeeklyOnlyUi()
  {
    mRepeatText.setVisibility(0);
    mMainLayout.getLayoutParams().height = -2;
    mFreqSpinner.setVisibility(8);
    mInterval.setVisibility(8);
    mIntervalPreText.setVisibility(8);
    mIntervalPostText.setVisibility(8);
    mEndSpinner.setVisibility(8);
    mEndCount.setVisibility(8);
    mPostEndCount.setVisibility(8);
    mEndDateTextView.setVisibility(8);
    mMonthGroup.setVisibility(8);
    mMonthRepeatByRadioGroup.setVisibility(8);
    mRepeatMonthlyByNthDayOfWeek.setVisibility(8);
    mRepeatMonthlyByNthDayOfMonth.setVisibility(8);
    mRepeatMonthlyByLastDayOfMonth.setVisibility(8);
  }

  private void togglePickerOptions()
  {
    if (JM.recurrenceState == 0)
    {
      mFreqSpinner.setEnabled(false);
      mEndSpinner.setEnabled(false);
      mIntervalPreText.setEnabled(false);
      mInterval.setEnabled(false);
      mIntervalPostText.setEnabled(false);
      mMonthRepeatByRadioGroup.setEnabled(false);
      mEndCount.setEnabled(false);
      mPostEndCount.setEnabled(false);
      mEndDateTextView.setEnabled(false);
      mRepeatMonthlyByNthDayOfWeek.setEnabled(false);
      mRepeatMonthlyByNthDayOfMonth.setEnabled(false);
      mRepeatMonthlyByLastDayOfMonth.setEnabled(false);
      arrayOfToggleButton = mWeekByDayButtons;
      j = arrayOfToggleButton.length;
      i = 0;
      while (i < j)
      {
        arrayOfToggleButton[i].setEnabled(false);
        i += 1;
      }
    }
    mView.findViewById(2131493306).setEnabled(true);
    mFreqSpinner.setEnabled(true);
    mEndSpinner.setEnabled(true);
    mIntervalPreText.setEnabled(true);
    mInterval.setEnabled(true);
    mIntervalPostText.setEnabled(true);
    mMonthRepeatByRadioGroup.setEnabled(true);
    mEndCount.setEnabled(true);
    mPostEndCount.setEnabled(true);
    mEndDateTextView.setEnabled(true);
    mRepeatMonthlyByNthDayOfWeek.setEnabled(true);
    mRepeatMonthlyByNthDayOfMonth.setEnabled(true);
    mRepeatMonthlyByLastDayOfMonth.setEnabled(true);
    ToggleButton[] arrayOfToggleButton = mWeekByDayButtons;
    int j = arrayOfToggleButton.length;
    int i = 0;
    while (i < j)
    {
      arrayOfToggleButton[i].setEnabled(true);
      i += 1;
    }
    updateDoneButtonState();
  }

  private void updateDoneButtonState()
  {
    if (JM.recurrenceState == 0)
    {
      mDone.setEnabled(true);
      return;
    }
    if (mInterval.getText().toString().length() == 0)
    {
      mDone.setEnabled(false);
      return;
    }
    if ((mEndCount.getVisibility() == 0) && (mEndCount.getText().toString().length() == 0))
    {
      mDone.setEnabled(false);
      return;
    }
    if (JM.freq == 1)
    {
      ToggleButton[] arrayOfToggleButton = mWeekByDayButtons;
      int j = arrayOfToggleButton.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfToggleButton[i].isChecked())
        {
          mDone.setEnabled(true);
          return;
        }
        i += 1;
      }
      mDone.setEnabled(false);
      return;
    }
    mDone.setEnabled(true);
  }

  private void updateEndCountText()
  {
    String str = mResources.getQuantityString(2131755008, JM.endCount);
    int i = str.indexOf("%d");
    if (i != -1)
    {
      if (i == 0)
        Log.e(TAG, "No text to put in to recurrence's end spinner.");
    }
    else
      return;
    int j = "%d".length();
    mPostEndCount.setText(str.substring(i + j, str.length()).trim());
  }

  private void updateIntervalText()
  {
    if (mIntervalResId == -1);
    String str;
    int i;
    do
    {
      return;
      str = mResources.getQuantityString(mIntervalResId, JM.interval);
      i = str.indexOf("%d");
    }
    while (i == -1);
    int j = "%d".length();
    mIntervalPostText.setText(str.substring(i + j, str.length()).trim());
    mIntervalPreText.setText(str.substring(0, i).trim());
  }

  public void a(b paramb)
  {
    JP = paramb;
  }

  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (JM.endDate == null)
    {
      JM.endDate = new Time(mTime.timezone);
      Time localTime1 = JM.endDate;
      Time localTime2 = JM.endDate;
      JM.endDate.second = 0;
      localTime2.minute = 0;
      localTime1.hour = 0;
    }
    JM.endDate.year = paramInt1;
    JM.endDate.month = paramInt2;
    JM.endDate.monthDay = paramInt3;
    JM.endDate.normalize(false);
    updateDialog();
  }

  public void bQ()
  {
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    JL = ((DialogFragment)getFragmentManager().findFragmentByTag("tag_date_picker_frag"));
    if ((JL instanceof i))
      ((i)JL).a(this);
    while (!(JL instanceof s))
      return;
    ((s)JL).b(this);
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    if (JP != null)
      JP.eL();
  }

  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = -1;
    int i = 0;
    while (i < 7)
    {
      int k = j;
      if (j == -1)
      {
        k = j;
        if (paramCompoundButton == mWeekByDayButtons[i])
        {
          k = i;
          JM.weeklyByDayOfWeek[i] = paramBoolean;
        }
      }
      i += 1;
      j = k;
    }
    updateDialog();
  }

  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (paramInt == 2131493314)
    {
      JM.monthlyRepeat = 0;
      JM.monthlyByMonthDay = mTime.monthDay;
    }
    while (true)
    {
      updateDialog();
      return;
      if (paramInt == 2131493316)
      {
        JM.monthlyRepeat = 0;
        JM.monthlyByMonthDay = -1;
      }
      else if (paramInt == 2131493315)
      {
        JM.monthlyRepeat = 1;
      }
    }
  }

  public void onClick(View paramView)
  {
    if (mEndDateTextView == paramView)
    {
      if (JL != null)
        JL.dismiss();
      JL = e(JM.endDate.year, JM.endDate.month, JM.endDate.monthDay);
      JL.show(getFragmentManager(), "tag_date_picker_frag");
    }
    while (mDone != paramView)
      return;
    if (JM.recurrenceState == 0);
    for (paramView = null; ; paramView = mRecurrence.toString())
    {
      onRecurrenceSet(paramView);
      dismiss();
      return;
      a(JM, mRecurrence);
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    mRecurrence.wkst = EventRecurrence.timeDay2Day(JO);
    getDialog().getWindow().requestFeature(1);
    boolean bool2 = false;
    Object localObject;
    boolean bool1;
    if (paramBundle != null)
    {
      localObject = (RecurrenceModel)paramBundle.get("bundle_model");
      if (localObject != null)
        JM = ((RecurrenceModel)localObject);
      bool1 = paramBundle.getBoolean("bundle_end_count_has_focus");
      mIsWeeklyOnly = paramBundle.getBoolean("weekly_only_view");
    }
    while (true)
    {
      initUi(paramLayoutInflater, paramViewGroup);
      if (bool1)
        mEndCount.requestFocus();
      return mView;
      paramBundle = getArguments();
      if (paramBundle != null)
      {
        mTime.set(paramBundle.getLong("bundle_event_start_time"));
        localObject = paramBundle.getString("bundle_event_time_zone");
        if (!TextUtils.isEmpty((CharSequence)localObject))
          mTime.timezone = ((String)localObject);
        mTime.normalize(false);
        localObject = Calendar.getInstance();
        ((Calendar)localObject).set(1, mTime.year);
        ((Calendar)localObject).set(2, mTime.month);
        mNumDaysInMonth = ((Calendar)localObject).getActualMaximum(5);
        JM.weeklyByDayOfWeek[mTime.weekDay] = true;
        paramBundle = paramBundle.getString("bundle_event_rrule");
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramBundle))
        {
          JM.recurrenceState = 1;
          mRecurrence.parse(paramBundle);
          a(mRecurrence, JM);
          if (mRecurrence.bydayCount == 0)
          {
            JM.weeklyByDayOfWeek[mTime.weekDay] = true;
            bool1 = bool2;
          }
          else
          {
            bool1 = bool2;
            if (mRecurrence.bydayCount == 1)
            {
              bool1 = bool2;
              if (mRecurrence.freq == 6)
              {
                initMonthlyOnWeekDay();
                bool1 = bool2;
              }
            }
          }
        }
      }
      else
      {
        mTime.setToNow();
        bool1 = bool2;
      }
    }
  }

  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 0;
    if (paramAdapterView == mFreqSpinner)
      JM.freq = paramInt;
    while (paramAdapterView != mEndSpinner)
    {
      updateDialog();
      return;
    }
    switch (paramInt)
    {
    default:
      label60: paramAdapterView = mEndCount;
      if (JM.end == 2)
      {
        paramInt = 0;
        label78: paramAdapterView.setVisibility(paramInt);
        paramAdapterView = mEndDateTextView;
        if (JM.end != 1)
          break label228;
        paramInt = 0;
        label101: paramAdapterView.setVisibility(paramInt);
        paramAdapterView = mPostEndCount;
        if ((JM.end != 2) || (mHidePostEndCount))
          break label234;
      }
      break;
    case 0:
    case 1:
    case 2:
    }
    label228: label234: for (paramInt = i; ; paramInt = 8)
    {
      paramAdapterView.setVisibility(paramInt);
      break;
      JM.end = 0;
      break label60;
      JM.end = 1;
      break label60;
      JM.end = 2;
      if (JM.endCount <= 1)
        JM.endCount = 1;
      while (true)
      {
        updateEndCountText();
        break;
        if (JM.endCount > 730)
          JM.endCount = 730;
      }
      paramInt = 8;
      break label78;
      paramInt = 8;
      break label101;
    }
  }

  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
  }

  public void onRecurrenceSet(String paramString)
  {
    if (JP != null)
    {
      EventRecurrence localEventRecurrence = null;
      if (!TextUtils.isEmpty(paramString))
      {
        localEventRecurrence = new EventRecurrence();
        localEventRecurrence.parse(paramString);
      }
      JP.a(localEventRecurrence);
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("bundle_model", JM);
    if (mEndCount.hasFocus())
      paramBundle.putBoolean("bundle_end_count_has_focus", true);
    if (mIsWeeklyOnly)
      paramBundle.putBoolean("weekly_only_view", true);
  }

  public void updateDialog()
  {
    int j = 8;
    Object localObject = Integer.toString(JM.interval);
    if (!((String)localObject).equals(mInterval.getText().toString()))
      mInterval.setText((CharSequence)localObject);
    mFreqSpinner.setSelection(JM.freq);
    localObject = mWeekGroup;
    int i;
    if (JM.freq == 1)
    {
      i = 0;
      ((LinearLayout)localObject).setVisibility(i);
      localObject = mWeekGroup2;
      if (JM.freq != 1)
        break label230;
      i = 0;
      label94: ((LinearLayout)localObject).setVisibility(i);
      localObject = mMonthGroup;
      i = j;
      if (JM.freq == 2)
        i = 0;
      ((LinearLayout)localObject).setVisibility(i);
      switch (JM.freq)
      {
      default:
        label160: updateIntervalText();
        updateDoneButtonState();
        mEndSpinner.setSelection(JM.end);
        if (JM.end == 1)
        {
          localObject = DateUtils.formatDateTime(getActivity(), JM.endDate.toMillis(false), 131072);
          mEndDateTextView.setText((CharSequence)localObject);
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    label230: 
    do
    {
      do
      {
        return;
        i = 8;
        break;
        i = 8;
        break label94;
        mIntervalResId = 2131755009;
        break label160;
        mIntervalResId = 2131755010;
        i = 0;
        while (i < 7)
        {
          mWeekByDayButtons[i].setChecked(JM.weeklyByDayOfWeek[i]);
          i += 1;
        }
        mIntervalResId = 2131755011;
        if (JM.monthlyRepeat == 0)
          if (JM.monthlyByMonthDay == -1)
          {
            mMonthRepeatByRadioGroup.check(2131493316);
            if (mMonthRepeatByDayOfWeekStr != null)
              break label160;
            if (JM.monthlyByNthDayOfWeek == 0)
              initMonthlyOnWeekDay();
            localObject = mMonthRepeatByDayOfWeekStrs[JM.monthlyByDayOfWeek];
            if (JM.monthlyByNthDayOfWeek >= 0)
              break label430;
          }
        for (i = 5; ; i = JM.monthlyByNthDayOfWeek)
        {
          mMonthRepeatByDayOfWeekStr = localObject[(i - 1)];
          mRepeatMonthlyByNthDayOfWeek.setText(mMonthRepeatByDayOfWeekStr);
          break;
          mMonthRepeatByRadioGroup.check(2131493314);
          break label324;
          if (JM.monthlyRepeat != 1)
            break label324;
          mMonthRepeatByRadioGroup.check(2131493315);
          break label324;
        }
        mIntervalResId = 2131755012;
        break label160;
      }
      while (JM.end != 2);
      localObject = Integer.toString(JM.endCount);
    }
    while (((String)localObject).equals(mEndCount.getText().toString()));
    label324: mEndCount.setText((CharSequence)localObject);
    label430:
  }

  private static class RecurrenceModel
    implements Parcelable
  {
    public static final Parcelable.Creator<RecurrenceModel> CREATOR = new Parcelable.Creator()
    {
      public KeepRecurrencePickerDialog.RecurrenceModel[] bT(int paramAnonymousInt)
      {
        return new KeepRecurrencePickerDialog.RecurrenceModel[paramAnonymousInt];
      }

      public KeepRecurrencePickerDialog.RecurrenceModel w(Parcel paramAnonymousParcel)
      {
        KeepRecurrencePickerDialog.RecurrenceModel localRecurrenceModel = new KeepRecurrencePickerDialog.RecurrenceModel();
        localRecurrenceModel.freq = paramAnonymousParcel.readInt();
        localRecurrenceModel.interval = paramAnonymousParcel.readInt();
        localRecurrenceModel.end = paramAnonymousParcel.readInt();
        localRecurrenceModel.endDate.year = paramAnonymousParcel.readInt();
        localRecurrenceModel.endDate.month = paramAnonymousParcel.readInt();
        localRecurrenceModel.endDate.monthDay = paramAnonymousParcel.readInt();
        localRecurrenceModel.endCount = paramAnonymousParcel.readInt();
        localRecurrenceModel.weeklyByDayOfWeek = new boolean[7];
        paramAnonymousParcel.readBooleanArray(localRecurrenceModel.weeklyByDayOfWeek);
        localRecurrenceModel.monthlyRepeat = paramAnonymousParcel.readInt();
        localRecurrenceModel.monthlyByMonthDay = paramAnonymousParcel.readInt();
        localRecurrenceModel.monthlyByDayOfWeek = paramAnonymousParcel.readInt();
        localRecurrenceModel.monthlyByNthDayOfWeek = paramAnonymousParcel.readInt();
        localRecurrenceModel.recurrenceState = paramAnonymousParcel.readInt();
        return localRecurrenceModel;
      }
    };
    int end;
    int endCount = 5;
    Time endDate;
    int freq = 1;
    int interval = 1;
    int monthlyByDayOfWeek;
    int monthlyByMonthDay;
    int monthlyByNthDayOfWeek;
    int monthlyRepeat;
    int recurrenceState;
    boolean[] weeklyByDayOfWeek = new boolean[7];

    public int describeContents()
    {
      return 0;
    }

    public String toString()
    {
      return "Model [freq=" + freq + ", interval=" + interval + ", end=" + end + ", endDate=" + endDate + ", endCount=" + endCount + ", weeklyByDayOfWeek=" + Arrays.toString(weeklyByDayOfWeek) + ", monthlyRepeat=" + monthlyRepeat + ", monthlyByMonthDay=" + monthlyByMonthDay + ", monthlyByDayOfWeek=" + monthlyByDayOfWeek + ", monthlyByNthDayOfWeek=" + monthlyByNthDayOfWeek + "]";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(freq);
      paramParcel.writeInt(interval);
      paramParcel.writeInt(end);
      paramParcel.writeInt(endDate.year);
      paramParcel.writeInt(endDate.month);
      paramParcel.writeInt(endDate.monthDay);
      paramParcel.writeInt(endCount);
      paramParcel.writeBooleanArray(weeklyByDayOfWeek);
      paramParcel.writeInt(monthlyRepeat);
      paramParcel.writeInt(monthlyByMonthDay);
      paramParcel.writeInt(monthlyByDayOfWeek);
      paramParcel.writeInt(monthlyByNthDayOfWeek);
      paramParcel.writeInt(recurrenceState);
    }
  }

  private class a extends ArrayAdapter<CharSequence>
  {
    final String END_COUNT_MARKER = "%d";
    final String END_DATE_MARKER = "%s";
    private String mEndDateString;
    private LayoutInflater mInflater;
    private int mItemResourceId;
    private ArrayList<CharSequence> mStrings;
    private int mTextResourceId;
    private boolean mUseFormStrings;

    public a(ArrayList<CharSequence> paramInt1, int paramInt2, int arg4)
    {
      super(i, paramInt2);
      mInflater = LayoutInflater.from(paramInt1);
      mItemResourceId = i;
      int j;
      mTextResourceId = j;
      mStrings = paramInt2;
      mEndDateString = getResources().getString(2131230796);
      if (mEndDateString.indexOf("%s") <= 0)
        mUseFormStrings = true;
      while (true)
      {
        if (mUseFormStrings)
          KeepRecurrencePickerDialog.i(KeepRecurrencePickerDialog.this).setLayoutParams(new TableLayout.LayoutParams(0, -2, 1.0F));
        return;
        if (getResources().getQuantityString(2131755008, 1).indexOf("%d") <= 0)
          mUseFormStrings = true;
      }
    }

    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
        paramView = mInflater.inflate(mItemResourceId, paramViewGroup, false);
      while (true)
      {
        ((TextView)paramView.findViewById(2131493322)).setText((CharSequence)mStrings.get(paramInt));
        return paramView;
      }
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      TextView localTextView;
      if (paramView == null)
      {
        paramView = mInflater.inflate(mTextResourceId, paramViewGroup, false);
        localTextView = (TextView)paramView.findViewById(2131493322);
        switch (paramInt)
        {
        default:
          paramViewGroup = null;
        case 0:
        case 1:
        case 2:
        }
      }
      String str;
      int i;
      do
      {
        do
        {
          return paramViewGroup;
          break;
          localTextView.setText((CharSequence)mStrings.get(0));
          return paramView;
          paramInt = mEndDateString.indexOf("%s");
          paramViewGroup = paramView;
        }
        while (paramInt == -1);
        if ((mUseFormStrings) || (paramInt == 0))
        {
          localTextView.setText(KeepRecurrencePickerDialog.j(KeepRecurrencePickerDialog.this));
          return paramView;
        }
        localTextView.setText(mEndDateString.substring(0, paramInt).trim());
        return paramView;
        str = KeepRecurrencePickerDialog.k(KeepRecurrencePickerDialog.this).getQuantityString(2131755008, KeepRecurrencePickerDialog.b(KeepRecurrencePickerDialog.this).endCount);
        i = str.indexOf("%d");
        paramViewGroup = paramView;
      }
      while (i == -1);
      if ((mUseFormStrings) || (i == 0))
      {
        localTextView.setText(KeepRecurrencePickerDialog.l(KeepRecurrencePickerDialog.this));
        KeepRecurrencePickerDialog.m(KeepRecurrencePickerDialog.this).setVisibility(8);
        KeepRecurrencePickerDialog.a(KeepRecurrencePickerDialog.this, true);
        return paramView;
      }
      paramInt = "%d".length();
      KeepRecurrencePickerDialog.m(KeepRecurrencePickerDialog.this).setText(str.substring(i + paramInt, str.length()).trim());
      if (KeepRecurrencePickerDialog.b(KeepRecurrencePickerDialog.this).end == 2)
        KeepRecurrencePickerDialog.m(KeepRecurrencePickerDialog.this).setVisibility(0);
      paramInt = i;
      if (str.charAt(i - 1) == ' ')
        paramInt = i - 1;
      localTextView.setText(str.substring(0, paramInt).trim());
      return paramView;
    }
  }

  public static abstract interface b
  {
    public abstract void a(EventRecurrence paramEventRecurrence);

    public abstract void eL();
  }

  class c
    implements TextWatcher
  {
    private int mDefault;
    private int mMax;
    private int mMin;

    public c(int paramInt1, int paramInt2, int arg4)
    {
      mMin = paramInt1;
      int i;
      mMax = i;
      mDefault = paramInt2;
    }

    public void afterTextChanged(Editable paramEditable)
    {
      int j = 0;
      try
      {
        i = Integer.parseInt(paramEditable.toString());
        if (i < mMin)
        {
          k = mMin;
          j = 1;
          if (j != 0)
          {
            paramEditable.clear();
            paramEditable.append(Integer.toString(k));
          }
          KeepRecurrencePickerDialog.a(KeepRecurrencePickerDialog.this);
          onChange(k);
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        while (true)
        {
          int i = mDefault;
          continue;
          int k = i;
          if (i > mMax)
          {
            j = 1;
            k = mMax;
          }
        }
      }
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
    }

    void onChange(int paramInt)
    {
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
    }
  }
}